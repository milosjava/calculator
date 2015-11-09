package calculator

import org.scalatest.FunSuite

/**
 * Created by Milos Grubjesic (milosjava@gmail.com) on 11/7/15.
 * Test conversion from inflix to postfix notation
 */
class ShuntingYardSpec extends FunSuite{


  //alias
  def toPostfix (str : String)  :String = ShuntingYard.infixToPostfix(TokenParser.getTokens(str))


  test("check postfix notation"){


    assert("5 6 + "== toPostfix("5+6"))

    assert("0 5 - 6 + "== toPostfix("-5+6"))

    assert("0 5 - 0 6 - + "== toPostfix("-5 + (-6)"))

    assert("5 0 6 - + "== toPostfix("5 + (-6)"))

    assert("3 0 1 - * "== toPostfix("3*(-1)"))

    assert("0 5 - 0 + "== toPostfix("-5 + 0"))

    assert("0 1 - 1.0000 + "== toPostfix("-1 + 1.0000"))

    assert("0 1987.50 - 1987 + "== toPostfix("-1987.50 + 1987"))

    assert("34.999 1.0 + "== toPostfix("34.999 + 1.0"))

    assert("10 9.9999 + "== toPostfix("10 + 9.9999"))

    assert("10 L "== toPostfix("log10"))

    assert("10 L "== toPostfix("log(10)"))

    assert("0 L "== toPostfix("log0"))

    assert("1 L "== toPostfix("log1"))

    assert("1.1 L "== toPostfix("log1.1"))

    assert("2 4 1 - + 5 * "== toPostfix("(2+(4-1))*5"))

    assert("6 L 12 5 + * 2 / 34.2 - "== toPostfix("log6*(12+5)/2-34.2"))

    assert("123456789 210987654 - "== toPostfix("123456789 - 210987654"))

    assert("100000000 300000000 + "== toPostfix("100000000 + 300000000"))

    assert("6 2 * 8 + "== toPostfix("6 * 2 + 8"))

    assert("1500 2000 * "== toPostfix("1500 * 2000"))

    assert("0 2000 * "== toPostfix("0 * 2000"))

    assert("1 500 * "== toPostfix("1 * 500"))

    assert("1.1 10 * "== toPostfix("1.1 * 10 "))

    assert("0 1 67 * - "== toPostfix("-1 * 67"))

    assert("0.133 1.212 * "== toPostfix("0.133 * 1.212"))

    assert("0 1.212 8 * - "== toPostfix("-1.212 * 8"))

    assert("1.23456789 2.10987654 * "== toPostfix("1.23456789 * 2.10987654"))

    assert("0 6 * 6 * "== toPostfix("0 * 6 * 6"))

    assert("1500 2000 / "== toPostfix("1500 / 2000"))

    assert("0 2000 / "== toPostfix("0 / 2000"))

    assert("0 1500 2000 / - "== toPostfix("-1500 / 2000"))

    assert("0 3.123 5 / - "== toPostfix("-3.123 / 5 "))

    assert("4.21 3 / "== toPostfix("4.21 / 3 "))

    assert("10 3.123 / "== toPostfix("10 / 3.123 "))

    assert("1500 0 / "== toPostfix("1500 / 0  "))

    assert("543 2 2 - / "== toPostfix("543 / (2-2)  "))

    assert("5 7 + 2 * "== toPostfix("( 5 + 7 ) * 2"))

    assert("5 7 2 / + "== toPostfix("5 + 7 / 2"))

    assert("4 22 + 3 * "== toPostfix("(4+22)*3"))

    assert("4 22 + 3 * "== toPostfix("(4+22)*3"))

  }

}
