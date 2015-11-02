package calculator

/**
 * Created by Milos Grubjesic (milosjava@gmail.com) on 10/29/15.
 */

import javafx.scene.image.Image

import scalafx.Includes._
import scalafx.application.JFXApp
import scalafx.scene.Scene
import scalafx.scene.control.TextField
import scalafx.scene.paint.Color
import scalafx.scene.shape.Rectangle

object CalculatorGUI extends JFXApp {

  stage = new JFXApp.PrimaryStage {
    title.value = "TopTal - Calculator"
    //todo see how to set icon
    //icons += new Image("calculator/calculator-icon.png")

    //due to the fact that we don't have more detailed gui preference request -> gui look&feel are similar
    // to calculator app from ubuntu
    width = 300
    height = 250
    centerOnScreen()
    scene = new Scene  {
      fill = Color.rgb(242,241,240)
      val text = new TextField

      text.prefHeight = 60
      text.prefWidth = 290

      text.layoutX = 5
      text.layoutY = 5


      //todo limit text in the input field

      content = List(text)

    }

  }

}