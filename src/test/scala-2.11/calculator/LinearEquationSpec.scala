package calculator

import org.scalatest.FunSuite

/**
  * Created by Milos Grubjesic (milosjava@gmail.com) on 11/9/15.
  */
class LinearEquationSpec extends FunSuite {


  test("linear equations"){


    var x = LinearEquation.solver("2*x+0.5=1")

    assert(x=="0.25")


    x = LinearEquation.solver("2*x=1")

    assert(x=="0.5")

    x = LinearEquation.solver("2*x=9+1")

    assert(x=="5.0")


    x = LinearEquation.solver("2*x=x+3")

    assert(x=="3.0")


    x = LinearEquation.solver("2*x+1=x+1")

    assert(x=="0.0")


    x = LinearEquation.solver("(2+8)*x=10")

    assert(x=="1.0")


    x = LinearEquation.solver("2*(2+8)*x=10")

    assert(x=="0.5")


    //now try with Double

    x = LinearEquation.solver("3.25 * x = 100")

    assert(x=="30.76923076923077")


    x = LinearEquation.solver("(0.11 + 2*x)+4 = 87.22")

    assert(x=="41.555")


    x = LinearEquation.solver("3*x=((((")

    assert(x=="Bad expression")


  }

}
