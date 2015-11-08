package calculator

import org.scalatest.FunSuite

/**
 * Created by Milos Grubjesic (milosjava@gmail.com) on 11/3/15.
 */
class CalculatorSpec extends FunSuite{


  test("various calculations"){

    //addition and subtraction - Integers
    assert(Calculator.calculate("5+6")=="11")

    assert(Calculator.calculate("-5+6")=="1")

    assert(Calculator.calculate("-5 + (-6)")=="-11")

    assert(Calculator.calculate("5 + (-6)")=="-1")

    assert(Calculator.calculate("3*(-1)")=="-3")

    assert(Calculator.calculate("-5 + 0")=="-5")


    //integer and float
    assert(Calculator.calculate("-1 + 1.0000")=="0")

    assert(Calculator.calculate("-1987.50 + 1987")=="-0.5")


    //float numbers
    assert(Calculator.calculate("34.999 + 1.0")=="35.999")

    //integer and float
    assert(Calculator.calculate("10 + 9.9999")=="19.9999")

    //log
    assert(Calculator.calculate("log10")=="1")

    assert(Calculator.calculate("log(10)")=="1")

    assert(Calculator.calculate("log0") == "error")

    assert(Calculator.calculate("log1") == "0")

    assert(Calculator.calculate("log1.1") =="0.04139268515822508")

    assert(Calculator.calculate("log3.2") =="0.505149978319906")



    //combined
    assert(Calculator.calculate("(2+(4-1))*5")=="25")

    assert(Calculator.calculate("log6*(12+5)/2-34.2")=="-27.58571437173903")


    //big numbers
    assert(Calculator.calculate("123456789 - 210987654")=="-8.7530865E7")

    assert(Calculator.calculate("100000000 + 300000000")=="4E8")


    //multiplication ,combined

    assert(Calculator.calculate("6 * 2 + 8")=="20")

    assert(Calculator.calculate("1500 * 2000")=="3000000")

    assert(Calculator.calculate("0 * 2000")=="0")

    assert(Calculator.calculate("1 * 500")=="500")

    assert(Calculator.calculate("1.1 * 10 ")=="11")

    assert(Calculator.calculate("-1 * 67")=="-67")

    assert(Calculator.calculate("0.133 * 1.212")=="0.161196")

    assert(Calculator.calculate("-1.212 * 8")=="-9.696")

    assert(Calculator.calculate("1.23456789 * 2.10987654")=="2.6047858281483007")

    assert(Calculator.calculate("0 * 6 * 6")=="0")


    //division

    assert(Calculator.calculate("1500 / 2000")=="0.75")

    assert(Calculator.calculate("0 / 2000")=="0")

    assert(Calculator.calculate("-1500 / 2000")=="-0.75")

    assert(Calculator.calculate("-3.123 / 5 ")=="-0.6246")

    assert(Calculator.calculate("4.21 / 3 ")=="1.4033333333333333")

    assert(Calculator.calculate("10 / 3.123 ")=="3.202049311559398")


    //various

    assert(Calculator.calculate("85+96*(1-log6)")=="106.29747996317022")


    //errors

    assert(Calculator.calculate("//(**//")=="Malformed")

    assert(Calculator.calculate("5log6")=="Malformed")

    assert(Calculator.calculate("()")=="Malformed")

    assert(Calculator.calculate("qwerty")=="")

    assert(Calculator.calculate("1((")=="Malformed")

    assert(Calculator.calculate("96+9/")=="Malformed")

    assert(Calculator.calculate("loglogloglog")=="Malformed")

    assert(Calculator.calculate("3215+++")=="Malformed")

    assert(Calculator.calculate("1500 / 0  ") == "error")

    assert(Calculator.calculate("543 / (2-2)  ") == "error")






  }

}
