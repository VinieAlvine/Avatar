package implementations.MyUI.panels

import scala.swing.BoxPanel
import java.awt.Color
import scala.swing.GridPanel
import scala.swing.Panel
import scala.swing.Label
import scala.swing.Orientation
import scala.swing.Panel
import java.awt.Color
import scala.swing.Component
import java.awt.Dimension
import scala.swing.Swing
import scala.swing.BorderPanel

class RobotPanel(text: String) extends Panel {

  private val robotColor = Color.ORANGE

  private val boxName = new BorderPanel {
    background = robotColor
    border = Swing.EmptyBorder(10, 10, 10, 10);
    add(new Label("Idéfix votre messager") {
      foreground = Color.WHITE
    }, BorderPanel.Position.Center)
  }

  private val message = new Label(text) {
    foreground = Color.BLACK
    border = Swing.EmptyBorder(10, 10, 10, 10);
  }

  private val gd = new BoxPanel(Orientation.Horizontal) {
    background = Color.WHITE
    contents += boxName
    contents += message
  }

  peer.setOpaque(false)
  private val myContents = (new Content += gd)
  override def contents = myContents
}