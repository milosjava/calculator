package calculator

import scala.util.Try

/**
  * Created by Milos Grubjesic (milosjava@gmail.com) on 11/7/15.
  */
object LinearEquation {


  def solver(equation : String): String = {


    //first find left and right

    val equalsSign = equation.indexOf("=")

    //get left side
    val leftPart = equation.substring(0,equalsSign)

    //get right side
    val rightPart = equation.substring(equalsSign+1)

    //do the right side
    val leftTokens = TokenParser.getTokens(leftPart)

    //get right tokens
    val rightTokens = TokenParser.getTokens(rightPart)

    //transform both sides to postfix
    var leftPostfix = ShuntingYard.infixToPostfix(leftTokens)

    var rightPostfix = ShuntingYard.infixToPostfix(rightTokens)


    //evaluate both sides!
    var leftParams = evaluator(leftPostfix)

    if(leftParams(0) == -1 & leftParams(1) == -1){
      return "Bad expression"
    }

    var rightParams = evaluator(rightPostfix)


    if(rightParams(0) == -1 & rightParams(1) == -1){
      return "Bad expression"
    }

    //get the response :
    //Given: m1*x + b1 = m2*x + b2,
    // Final result x =  ( b2 - b1 ) / ( m1 - m2 )

    val resp =  (rightParams(1) - leftParams(1)) / (leftParams(0) - rightParams(0))

    //return string result
    resp.toString

  }


  /**
    * Transforms expression to mx+b form for simple linear equations. + and * supported
    * @param str postfix expression of  equation
    * @return return m and b coefficients
    */
  def evaluator(str: String) :Array[Double]= {


    //use stack for evaluating
    val stack = new scala.collection.mutable.Stack[Array[Double]]


    val err = Try(str.split(' ').foreach(token =>

      stack.push(


        if(token == "x"){
          //just X
          Array(1,0)   // x = 1x+0  coeff :  (1,0)

        }else{
          //just number
          if(token != "x" & token!="+" & token != "*"){
            Array(0,token.toDouble)   // e.g.  2 = 0x+2   coeff (0,2)
          }else{

            //operation!
            if(token == "+"){
              //addition

              var first = stack.pop
              var second = stack.pop

              Array(first(0) + second(0),first(1) + second(1))
            }else{
              //multiply
              var first = stack.pop
              var second = stack.pop

              //multiply rules
              if(first(0)==0 & second(0)==0){
                Array(0,first(1) * second(1))
              }else{
                if(first(0)>0){
                  Array(first(0) * second(1),first(1) * second(1))
                }else{
                  Array(first(1) * second(0),first(1) * second(1))
                }
              }

            }

          }
        }
      ))
    )

    //in case of error
    if(err.isFailure){
      return Array(-1d,-1d)
    }

    var res = stack.pop

    return res


  }


}

