package calculator

import org.scalatest.FunSuite

/**
 * Created by Milos Grubjesic (milosjava@gmail.com) on 11/3/15.
 */
class LanguageParserSpec extends FunSuite{


  test("various calculations"){

    //addition and subtraction - Integers
    assert(LanguageParser.parser("5+6")=="11")

    assert(LanguageParser.parser("-5+6")=="1")

    assert(LanguageParser.parser("-5 + (-6)")=="-11")

    assert(LanguageParser.parser("5 + (-6)")=="-1")

    assert(LanguageParser.parser("3*(-1)")=="-3")

    assert(LanguageParser.parser("-5 + 0")=="-5")


    //integer and float
    assert(LanguageParser.parser("-1 + 1.0000")=="0")

    assert(LanguageParser.parser("-1987.50 + 1987")=="-0.5")


    //float numbers
    assert(LanguageParser.parser("34.999 + 1.0")=="35.999")

    //integer and float
    assert(LanguageParser.parser("10 + 9.9999")=="19.9999")

    //log
    assert(LanguageParser.parser("log10")=="1")

    assert(LanguageParser.parser("log(10)")=="1")

    assert(LanguageParser.parser("log0") == "error")

    assert(LanguageParser.parser("log1") == "0")

    assert(LanguageParser.parser("log1.1") =="0.04139268515822508")


    //combined
    assert(LanguageParser.parser("(2+(4-1))*5")=="25")

    assert(LanguageParser.parser("log6*(12+5)/2-34.2")=="-27.58571437173903")


    //big numbers
    assert(LanguageParser.parser("123456789 - 210987654")=="-87530865")

    assert(LanguageParser.parser("100000000 + 300000000")=="400000000")


    //multiplication ,combined

    assert(LanguageParser.parser("6 * 2 + 8")=="20")

    assert(LanguageParser.parser("1500 * 2000")=="3000000")

    assert(LanguageParser.parser("0 * 2000")=="0")

    assert(LanguageParser.parser("1 * 500")=="500")

    assert(LanguageParser.parser("1.1 * 10 ")=="11")

    assert(LanguageParser.parser("-1 * 67")=="-67")

    assert(LanguageParser.parser("0.133 * 1.212")=="0.161196")

    assert(LanguageParser.parser("-1.212 * 8")=="-9.696")

    assert(LanguageParser.parser("1.23456789 * 2.10987654")=="2.6047858281483007")

    assert(LanguageParser.parser("0 * 6 * 6")=="0")


    //division

    assert(LanguageParser.parser("1500 / 2000")=="0.75")

    assert(LanguageParser.parser("0 / 2000")=="0")

    assert(LanguageParser.parser("-1500 / 2000")=="-0.75")

    assert(LanguageParser.parser("-3.123 / 5 ")=="-0.6246")

    assert(LanguageParser.parser("4.21 / 3 ")=="1.4033333333333333")

    assert(LanguageParser.parser("10 / 3.123 ")=="3.202049311559398")

    assert(LanguageParser.parser("1500 / 0  ") == "error")

    assert(LanguageParser.parser("543 / (2-2)  ") == "error")




  }

}
