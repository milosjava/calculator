package calculator

import com.typesafe.scalalogging._

import scala.util.Try

/**
  * Created by Milos Grubjesic (milosjava@gmail.com) on 11/3/15.
  */
object Calculator extends LazyLogging  {




  def calculate(input : String) :String = {


    var tokens = TokenParser.getTokens(input)


    if(tokens.contains("x") && tokens.contains("=")) {
      return LinearEquation.solver(input)
    }

    var postfix = ShuntingYard.infixToPostfix(tokens)


    val res =  rpn(postfix)


    if(res == "Malformed" | res == "error"){
      return (res)
    }

    var numericRes = res.toDouble

    if(numericRes == numericRes.floor){
      logger.debug(input+" -> "+numericRes.toInt.toString)
      return numericRes.toInt.toString
    }

    logger.debug(input+" -> "+numericRes.toString)
    return numericRes.toString


  }



  def rpn(str: String) :String= {

    //binary operation
    val ops2 = Map(
      "+" -> ((_: Double) + (_: Double)),
      "*" -> ((_: Double) * (_: Double)),
      "-" -> ((x: Double, y: Double) => y - x),
      "/" -> ((x: Double, y: Double) => y / x)
    )

    //unary operations
    val ops1 = Map(
      "L" -> ((x: Double) =>math.log10(x))
    )

    val stack = new scala.collection.mutable.Stack[Double]


    var err = Try(str.split(' ').foreach(token =>
      stack.push(
        if (ops2.contains(token)) {
          ops2(token)(stack.pop, stack.pop)
        }
        else {
          if (ops1.contains(token)) {
            ops1(token)(stack.pop)
          }else  parse(token)

        }

      )))

    if(err.isSuccess!=true){
      logger.debug(str+" -> Malformed")
      return "Malformed"
    }

    var res = stack.pop

    if(res.isInfinite){
      logger.debug(str+" -> error")
      return "error"
    }

    //this can happen in malformed request like 78log6
    if(stack.isEmpty != true){
      logger.debug(str+" -> Malformed")
      return "Malformed"
    }

    //number to string
    res.toString

  }

  //parse double - creates double from token string
  def parse = java.lang.Double.parseDouble _



}
