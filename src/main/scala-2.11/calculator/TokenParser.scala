package calculator

import com.typesafe.scalalogging.LazyLogging

import scala.util.matching.Regex

/**
  * Created by Milos Grubjesic (milosjava@gmail.com) on 11/5/15.
  */
object TokenParser extends LazyLogging  {


  /**
    * Transforms free calculation entry string to tokens through regex
    * @param str
    * @return
    */
  def getTokens(str: String): Array[String] = {

    //replace internaly log with L for easier handling
    var replacedStr = str.replaceAll("log","L")

    //make sure - is binary operation by adding 0 if necessary
    replacedStr = replacedStr.replaceAll("\\(-","\\(0-")

    //regex pattern matching for + - * / L Integer and Double
    val reg = new Regex("[+()*\\/-]|L|x|=|[0-9]*\\.?[0-9]+")

    var resp = reg.findAllIn(replacedStr).toArray

    //if nothing was caught , seems its empty or just junk
    if(resp.length==0){
      return Array()
    }

    //if starts with -  add 0 so it looks like -5+2   -> 0-5+2
    if(resp(0)=="-"){
      resp = "0"+:resp
    }

    //return tokens
    return resp

  }

}
