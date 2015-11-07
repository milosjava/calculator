package calculator

/**
  * Created by Milos Grubjesic (milosjava@gmail.com) on 10/29/15.
  */

import javafx.scene.image.Image

import scalafx.Includes._
import scalafx.application.JFXApp
import scalafx.event.ActionEvent
import scalafx.scene.Scene
import scalafx.scene.control.{Tooltip, Button, TextField}
import scalafx.scene.layout.{BorderPane, GridPane}
import scalafx.scene.paint.Color
import scalafx.scene.shape.Rectangle
import scalafx.scene.text.Font


/**
  * Main ScalaFX class. Implements calculator GUI
  */
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

      //set the sizes
      text.prefHeight = 60
      text.prefWidth = 290

      text.layoutX = 5
      text.layoutY = 5


      //set input font  and size
      text.setFont(Font.font("Serif", 22))

      //now add pane
      val pane = new GridPane

      pane.setHgap(5)
      pane.setVgap(5)


      //define buttons - numbers
      val button0 = new Button("0")
      val button1 = new Button("1")
      val button2 = new Button("2")
      val button3 = new Button("3")
      val button4 = new Button("4")
      val button5 = new Button("5")
      val button6 = new Button("6")
      val button7 = new Button("7")
      val button8 = new Button("8")
      val button9 = new Button("9")

      //define buttons - operations, tooltips

      val divide  = new Button{text = "/";tooltip = "Divide"}
      val plus  = new Button{text = "+";tooltip = "Add"}
      val minus  = new Button{text = "-";tooltip = "Subtract"}
      val floatPoint  = new Button(".")
      val startGroup  = new Button{text = "(";tooltip = "Start Group"}
      val endGroup  = new Button{text = ")";tooltip = "End Group"}
      val equals  = new Button{text = "=";tooltip = "Equals for Linear Equation"}
      val X  = new Button{text = "x";tooltip = "Variable for Linear Equation"}
      val multiply = new Button{text = "*";tooltip = "Multiply"}
      val clearDisplay = new Button{text = "C"; tooltip = "Clear Screen"}
      val log = new Button{text = "log";tooltip = "Logarithm"}
      val calculate = new Button{text = "GO!";tooltip = "Calculate Result"}


      //set buttons szie

      val buttonWidth = 54

      button7.prefWidth = buttonWidth
      button8.prefWidth = buttonWidth
      button9.prefWidth = buttonWidth
      divide.prefWidth = buttonWidth
      multiply.prefWidth = buttonWidth


      button4.prefWidth = buttonWidth
      button5.prefWidth = buttonWidth
      button6.prefWidth = buttonWidth
      plus.prefWidth = buttonWidth
      minus.prefWidth = buttonWidth

      button3.prefWidth = buttonWidth
      button2.prefWidth = buttonWidth
      button1.prefWidth = buttonWidth
      startGroup.prefWidth = buttonWidth
      endGroup.prefWidth = buttonWidth

      button0.prefWidth = buttonWidth
      floatPoint.prefWidth = buttonWidth
      equals.prefWidth = buttonWidth
      X.prefWidth = buttonWidth
      log.prefWidth = buttonWidth


      clearDisplay.prefWidth = buttonWidth
      calculate.prefWidth = buttonWidth

      //todo set that cursor moves in text field

      //set actions
      clearDisplay.onAction  = (e: ActionEvent) => {
        text.text = ""
      }

      button0.onAction  = (e: ActionEvent) => {
        text.text = text.text.value + "0"
        //text.positionCaret(text.getCaretPosition()+1)
      }

      button1.onAction  = (e: ActionEvent) => {
        text.text = text.text.value + "1"
      }

      button2.onAction  = (e: ActionEvent) => {
        text.text = text.text.apply + "2"
      }

      button3.onAction  = (e: ActionEvent) => {
        text.text = text.text.value + "3"
      }

      button4.onAction  = (e: ActionEvent) => {
        text.text = text.text.value + "4"
      }

      button5.onAction  = (e: ActionEvent) => {
        text.text = text.text.value + "5"
      }

      button6.onAction  = (e: ActionEvent) => {
        text.text = text.text.value + "6"
      }

      button7.onAction  = (e: ActionEvent) => {
        text.text = text.text.value + "7"
      }


      button8.onAction  = (e: ActionEvent) => {
        text.text = text.text.value + "8"
      }

      button9.onAction  = (e: ActionEvent) => {
        text.text = text.text.value + "9"
      }


      divide.onAction  = (e: ActionEvent) => {
        text.text = text.text.value + "/"
      }

      multiply.onAction  = (e: ActionEvent) => {
        text.text = text.text.value + "*"
      }

      plus.onAction  = (e: ActionEvent) => {
        text.text = text.text.value + "+"
      }

      minus.onAction  = (e: ActionEvent) => {
        text.text = text.text.value + "-"
      }

      equals.onAction  = (e: ActionEvent) => {
        text.text = text.text.value + "="
      }

      X.onAction  = (e: ActionEvent) => {
        text.text = text.text.value + "x"
      }

      log.onAction  = (e: ActionEvent) => {
        text.text = text.text.value + "log"
      }

      floatPoint.onAction  = (e: ActionEvent) => {
        text.text = text.text.value + "."
      }

      startGroup.onAction  = (e: ActionEvent) => {
        text.text = text.text.value + "("
      }

      endGroup.onAction  = (e: ActionEvent) => {
        text.text = text.text.value + ")"
      }


      calculate.onAction  = (e: ActionEvent) => {

        var calculatedValue = Calculator.calculate(text.text.value)
        text.text = calculatedValue
      }


      //add buttons to pane and position them in the grid
      //#1 row
      pane.add(button7,1,0)
      pane.add(button8,2,0)
      pane.add(button9,3,0)
      pane.add(divide,4,0)
      pane.add(multiply,5,0)

      //#2 row

      pane.add(button4,1,1)
      pane.add(button5,2,1)
      pane.add(button6,3,1)
      pane.add(plus,4,1)
      pane.add(minus,5,1)

      //#3 row

      pane.add(button3,1,2)
      pane.add(button2,2,2)
      pane.add(button1,3,2)
      pane.add(startGroup,4,2)
      pane.add(endGroup,5,2)


      //#4 row

      pane.add(button0,1,3)
      pane.add(floatPoint,2,3)
      pane.add(equals,3,3)
      pane.add(X ,4,3)
      pane.add(log,5,3)


      //#5 row
      pane.add(clearDisplay,1,4)
      pane.add(calculate,2,4)

      //position grid pane
      pane.setLayoutY(80)

      //create content
      content = List(text,pane)

    }

  }

}