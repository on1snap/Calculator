import scala.collection.mutable.{ArrayBuffer, ListBuffer}
import scala.swing._

object Calculator extends SimpleSwingApplication {
  def math(double: Double, string:String, double1: Double): Double = {
    string match {
      case "+" => double + double1
      case "-" => double - double1
      case "*" => double * double1
      case "/" => double / double1
      case "%" => double % double1
      case "^" => scala.math.pow(double, double1)
    }
  }
  def top = new MainFrame {
    title = "Calculator"
    val display = new TextField {
      columns = 40
      editable = false
      text = ""
    }
    val buttons = new GridPanel(8, 4) {
      val holder = new ArrayBuffer[String]().empty
      var head = ListBuffer.empty[String]
      var tail = ListBuffer.empty[String]

      contents ++= Seq(
        Button("7") {
          display.text += "7"
          val split = display.text.split("[+\\-*/]")
          println(split)
          if (split.length > 1) {
            head += split(0)
            head = head.reverse
            holder += "+"
            tail += split(1)
            tail = tail.reverse
          }
        },
        Button("Clear") {
          display.text =""
        },
        Button("8") {
          display.text += "8"
          val split = display.text.split("[+\\-*/]")

          if (split.length > 1) {
            head += split(0)
            head = head.reverse
            holder += "+"
            tail += split(1)
            tail = tail.reverse
          }
        },
        Button("9") {
          display.text += "9"
          val split = display.text.split("[+\\-*/]")
          if (split.length > 1) {
            head += split(0)
            head = head.reverse
            holder += "+"
            tail += split(1)
            tail = tail.reverse
          }
        },
        Button("/") {
          display.text += "/"
          holder += "/"
        },
        Button("4") {
          display.text += "4"
          val split = display.text.split("[+\\-*/]")
          if (split.length > 1) {
            head += split(0)
            head = head.reverse
            holder += "+"
            tail += split(1)
            tail = tail.reverse
          }
        },
        Button("5") {
          display.text += "5"
          val split = display.text.split("[+\\-*/]")
          if (split.length > 1) {
            head += split(0)
            head = head.reverse
            holder += "+"
            tail += split(1)
            tail = tail.reverse
          }
        },
        Button("6") {
          display.text += "6"
          val split = display.text.split("[+\\-*/]")
          if (split.length > 1) {
            head += split(0)
            head = head.reverse
            holder += "+"
            tail += split(1)
            tail = tail.reverse
          }
        },
        Button("*") {
          display.text += "*"
          holder += "*"
        },
        Button("1") {
          display.text += "1"
          val split = display.text.split("[+\\-*/]")
          if (split.length > 1) {
            head += split(0)
            head = head.reverse
            holder += "+"
            tail += split(1)
            tail = tail.reverse
            println(head,tail,holder)
          }
        },
        Button("2") {
          display.text += "2"
          val split = display.text.split("[+\\-*/]")
          if (split.length > 1) {
            head += split(0)
            head = head.reverse
            holder += "+"
            tail += split(1)
            tail = tail.reverse
            println(head,tail,holder)
          }
        },
        Button("3") {
          display.text += "3"
          val split = display.text.split("[+\\-*/]")
          if (split.length > 1) {
            head += split(0)
            head = head.reverse
            holder += "+"
            tail += split(1)
            tail = tail.reverse
          }
        },
        Button("0") {
          display.text += "0"
          val split = display.text.split("[+\\-*/]")
          if (split.length > 1) {
            head += split(0)
            head = head.reverse
            holder += "+"
            tail += split(1)
            tail = tail.reverse
          }
        },
        Button(".") {
          display.text += "."
        },
        Button("=") {
          val double = if (head.nonEmpty) head.head.toDouble else 0.0
          val string = if (holder.nonEmpty) holder.head else "ERROR"
          val double1 = if (tail.nonEmpty) tail.head.toDouble else 0.0
          val compute = math(double, string, double1).toString
          println(compute)
          display.text = compute
          holder += string
          head.clear()
          tail.clear()
          holder.clear()
        },
        Button("+") {
          display.text += "+"
          val split = display.text.split("\\+")
          if (split.length > 1) {
            head += split(0)
            head = head.reverse
            tail += split(1)
            tail = tail.reverse
          }
        },
        Button("-") {
          display.text += "-"
          val split = display.text.split("-")
          if (split.length > 1) {
            head += split(0)
            head = head.reverse
            tail += split(1)
            tail = tail.reverse
          }
        }
      )
    }
    contents = new BorderPanel {
      add(display, BorderPanel.Position.North)
      add(buttons, BorderPanel.Position.Center)
    }
    size = new Dimension(800, 600)
  }

}
