package calculator

import org.scalatest.FunSuite

/**
  * Created by Milos Grubjesic (milosjava@gmail.com) on 11/3/15.
  */
class TokenParserSpec extends FunSuite {


  test("test token parser"){


    var res = TokenParser.getTokens("12+5")

    assert(Array[String]("12","+","5").deep == res.deep)


    res = TokenParser.getTokens("log6*(12+5)/2-34.2")

    assert(Array("L","6","*","(","12","+","5",")","/","2","-","34.2").deep == res.deep)


    res = TokenParser.getTokens("6*4")

    assert(Array("6","*","4").deep == res.deep)

    res = TokenParser.getTokens("1   +    2")

    assert(Array("1","+","2").deep == res.deep)


    res = TokenParser.getTokens("3-78.92")

    assert(Array("3","-","78.92").deep == res.deep)


    res = TokenParser.getTokens("10   *2")

    assert(Array("10","*","2").deep == res.deep)


  }

}
