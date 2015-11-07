package calculator

import scala.util.matching.Regex

/**
  * Created by Milos Grubjesic (milosjava@gmail.com) on 11/5/15.
  */
object TokenParser {

  //todo add ScalaDoc

  def getTokens(str: String): Array[String] = {

    var replacedStr = str.replaceAll("log","L")

    replacedStr = replacedStr.replaceAll("\\(-","\\(0-")

    //println(replacedStr)

    //decided to go with regex pattern matching
    val reg = new Regex("[+()*\\/-]|L|x|=|[0-9]*\\.?[0-9]+")

    var resp = reg.findAllIn(replacedStr).toArray


    //if strat with -  add 0 so it looks like -5+2   -> 0-5+2
    if(resp(0)=="-"){

      resp = "0"+:resp
    }



    return resp

  }

}
