package calculator

import com.typesafe.scalalogging.LazyLogging

import scala.util.Try

/**
  * Created by Milos Grubjesic (milosjava@gmail.com) on 11/7/15.
  */
object ShuntingYard extends LazyLogging  {


  /**
    * Transforms inflix notation to postfix notation
    * @param infix array of tokens
    * @return postfix notation
    */
  def infixToPostfix(infix: Array[String]): String = {

    val ops: String = "-+/*L"
    val sb: StringBuilder = new StringBuilder

    val s = new scala.collection.mutable.Stack[Integer]

    //loop through tokens
    for (token <- infix) {

      //check if empty
      if (!token.isEmpty){

        //get the first char
        val c: Char = token.charAt(0)

        //lookup to see is it operation
        val idx: Int = ops.indexOf(c)


        if (idx != -1) {
          if (s.isEmpty) {

            //push operation to stack
            s.push(idx)
          }
          else {

            //flag for while loop
            var shouldContinue = true

            //if operations stack not empty process
            while (!s.isEmpty && shouldContinue) {

              //deal with precedence of operations
              val prec2: Int = s.top/2
              val prec1: Int = idx/2

              //if operation 2 precedes op1 then append to resulting string
              if (prec2 > prec1 || (prec2 == prec1 && c != 'L')) sb.append(ops.charAt(s.pop)).append(' ')
              else shouldContinue = false //ok so it can exit while loop
            }
            s.push(idx)
          }
        }

          //is it parenthesis  , - 40 is just code for parenthesis
        else if (c == '(') {
          s.push(-40)
        }
        else if (c == ')') {
          val err = Try {
            while (s.top != -40) sb.append(ops.charAt(s.pop)).append(' ')
            s.pop
          }

          if(err.isFailure==true) return ""
        }
        else {
          sb.append(token).append(' ')
        }
      }
    }

    while (!s.isEmpty) {
      val err = Try {sb.append(ops.charAt(s.pop)).append(' ')}
      if(err.isFailure==true) return ""
    }

    //finally here's result
    return sb.toString
  }


}

