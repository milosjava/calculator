package calculator

/**
 * Created by Milos Grubjesic (milosjava@gmail.com) on 10/29/15.
 */

import javafx.scene.image.Image

import scalafx.Includes._
import scalafx.application.JFXApp
import scalafx.scene.Scene
import scalafx.scene.control.{Button, TextField}
import scalafx.scene.layout.{BorderPane, GridPane}
import scalafx.scene.paint.Color
import scalafx.scene.shape.Rectangle
import scalafx.scene.text.Font

object CalculatorGUI extends JFXApp {

  stage = new JFXApp.PrimaryStage {
    title.value = "TopTal - Calculator"

    //really no need to resize it I guess
    resizable = false

    //todo see how to set icon
    //icons += new Image("calculator/calculator-icon.png")

    //due to the fact that we don't have more detailed gui preference request -> gui look&feel are similar
    // to calculator app from ubuntu
    width = 300
    height = 250
    centerOnScreen()
    scene = new Scene  {


      fill = Color.rgb(242,241,240) //RGB numbers same as calculator in ubuntu


      val text = new TextField

      text.prefHeight = 60
      text.prefWidth = 290

      text.layoutX = 5
      text.layoutY = 5

      //set inout font  and size
      text.setFont(Font.font("Serif", 22))

      //now add pane
      val pane = new GridPane

      pane.setHgap(10)
      pane.setVgap(10)

      //define buttons - numbers
      val button1 = new Button("1")
      val button2 = new Button("2")
      val button3 = new Button("3")
      val button4 = new Button("4")
      val button5 = new Button("5")
      val button6 = new Button("6")
      val button7 = new Button("7")
      val button8 = new Button("8")
      val button9 = new Button("9")

      val divide  = new Button("/")
      val plus  = new Button("+")
      val minus  = new Button("-")
      val floatPoint  = new Button(".")
      val startGroup  = new Button("(")
      val endGroup  = new Button(")")
      val equals  = new Button("=")
      val X  = new Button("X")
      val multiply = new Button("*")
      val delete = new Button("C")
      val log = new Button("log")

      val calculate = new Button("CALC")


      //define buttons - operations



      //add buttons to pane and position them in the grid
      pane.add(button1,1,0)
      pane.add(button2,2,0)
      pane.add(button3,3,0)
      pane.add(button4,1,1)

      pane.setLayoutY(80)

      //create content
      content = List(text,pane)

    }

  }

}