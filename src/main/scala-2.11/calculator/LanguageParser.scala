package calculator

/**
  * Created by Milos Grubjesic (milosjava@gmail.com) on 11/3/15.
  */
object LanguageParser {


  //todo check border cases  e.g. divided by zero etc...
  //Division by zero is undefined

  def parser(input : String) :String = {

    //todo change logs

    var tokens = TokenParser.getTokens(input)


    if(tokens.contains("x") && tokens.contains("=")) {
      return LinearEquation.solver(input)
    }

//    println("tok:")
//    tokens.foreach(println)

    var postfix = ShuntingYard.infixToPostfix(tokens)

//    println("post:")
    //println(postfix)

    //println("assert(\""+postfix+"\"== toPostfix(\""+input+"\"))")


    //return postfix

    val res =  rpn(postfix)

    //if result is infinite , there was division by zero
    if(res.isInfinite){
      return("error")
    }


    if(res == res.floor){
      return res.toInt.toString
    }

    return res.toString


  }



  def rpn(str: String) :Double= {

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


    //todo error handling
    str.split(' ').foreach(token =>
      stack.push(
        if (ops2.contains(token)) {
          ops2(token)(stack.pop, stack.pop)
        }
        else {
          if (ops1.contains(token)) {
            ops1(token)(stack.pop)
          }else  parse(token)

        }

      ))

    stack.pop

  }

  def parse = java.lang.Double.parseDouble _



}
