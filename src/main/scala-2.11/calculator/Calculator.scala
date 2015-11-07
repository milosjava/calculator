package calculator

import com.typesafe.scalalogging._

import scala.util.Try

/**
  * Created by Milos Grubjesic (milosjava@gmail.com) on 11/3/15.
  */
object Calculator extends LazyLogging  {


  /**
    * Recieves input parameters and gets result from either calculator
    * or linear equation solver
    * @param input input string e.g. 6+5 , 2*x+4= 0 etc..
    * @return string value
    */
  def calculate(input : String) :String = {

    //transfrom input to array of tokens
    var tokens = TokenParser.getTokens(input)

    //in case its linear equation pass handling to appropriate method
    if(tokens.contains("x") && tokens.contains("=")) {
      return LinearEquation.solver(input)
    }

    //transform to postfix notation
    var postfix = ShuntingYard.infixToPostfix(tokens)

    //get the result
    val res =  rpn(postfix)

    //if error print error message
    if(res == "Malformed" | res == "error"){
      return (res)
    }

    //transform return value to be easy to read  e.g.  1.0  will be just 1
    var numericRes = res.toDouble

    if(numericRes == numericRes.floor){
      logger.debug(input+" -> "+numericRes.toInt.toString)
      return numericRes.toInt.toString
    }

    logger.debug(input+" -> "+numericRes.toString)
    return numericRes.toString


  }


  /**
    * Calculates the value of postfix notation
    * @param str input postfix expression
    * @return calculated string value
    */
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


    val err = Try(str.split(' ').foreach(token =>
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
