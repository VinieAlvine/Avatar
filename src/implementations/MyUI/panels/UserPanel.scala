package implementations.MyUI.panels

import scala.swing.BoxPanel
import java.awt.Color
import scala.swing.GridPanel
import scala.swing.Panel
import scala.swing.Label
import scala.swing.Orientation
import java.awt.Dimension
import scala.swing.Swing
import scala.swing.BorderPanel

class UserPanel(text: String) extends Panel {
  
  private val userColor = new Color(52, 152, 219)

  private val boxName = new BorderPanel {    
    background = userColor
    border = Swing.EmptyBorder(10, 10, 10, 10);
    add(new Label("Vous") {
      foreground = Color.WHITE
    }, BorderPanel.Position.Center)
  }

  private val message = new Label(text) {
    foreground = Color.BLACK
    border = Swing.EmptyBorder(10, 10, 10, 10);
  }

  private val gd = new BoxPanel(Orientation.Horizontal) {
    background = Color.WHITE
    contents += message
    contents += boxName
  }

  peer.setOpaque(false)
  private val myContents = (new Content += gd)
  override def contents = myContents

}