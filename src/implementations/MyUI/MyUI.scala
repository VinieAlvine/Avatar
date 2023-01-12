package implementations.MyUI

import library._
import java.awt.Dimension
import scala.swing._
import java.awt.Color
import implementations.MyUI.panels.RobotPanel
import implementations.MyUI.panels.UserPanel
import implementations.MyUI.panels.MessagePanel
import implementations._
import javax.swing.WindowConstants
import scala.swing.event.KeyPressed
import scala.collection.mutable.Buffer
import scala.swing.event.Key
import javax.swing.border.EmptyBorder
import scala.swing.event.ButtonClicked
import java.awt.event.ActionListener
import javax.swing.ImageIcon
import java.awt.Image

class MyUI extends MainFrame {

  val darkColorUI = new Color(44, 62, 80)
  val darkColorUI2 = new Color(116, 123, 182)

  private val msgPanel = new MessagePanel
  private val userField = new UserField(msgPanel)

  val boxTitle = new BorderPanel {
    peer.setOpaque(false)
    
    add(new BoxPanel(Orientation.Horizontal) {
      peer.setOpaque(false)
      contents += new Label("Idéfix - ChatBox intéractive".toUpperCase()) {
        
        /*val iconUI = new ImageIcon(this.getClass.getResource("img/icon.png"))
        var verifIcon = new ImageIcon(iconUI.getImage().getScaledInstance(50, 50, Image.SCALE_DEFAULT))
        icon = verifIcon*/
        
        foreground_=(Color.WHITE)
        border = Swing.EmptyBorder(10)
      }
    }, BorderPanel.Position.West)
    
    add(new BoxPanel(Orientation.Horizontal) {
      peer.setOpaque(false)
      /*contents += new Button("_") {
        background_=(darkColorUI)
        foreground_=(Color.WHITE)
        border = Swing.EmptyBorder(10)
      }
      contents += new Button("S") {
        background_=(darkColorUI)
        foreground_=(Color.WHITE)
        border = Swing.EmptyBorder(10)
        reactions += {
          case ButtonClicked(_) => {

          }
        }
      }*/
      contents += new Button("X") {
        background_=(darkColorUI)
        foreground_=(Color.WHITE)
        border = Swing.EmptyBorder(10)
        reactions += {
          case ButtonClicked(_) => {
            close()
          }
        }
      }
    }, BorderPanel.Position.East)
  }

  private var basePanel = new BoxPanel(Orientation.Vertical) {
    background_=(darkColorUI)
    foreground_=(Color.WHITE)
    contents += boxTitle
    contents += msgPanel
    contents += new BorderPanel {
      peer.setOpaque(false)
      add(userField, BorderPanel.Position.Center)
      add(new SendButton(this, userField, msgPanel) {
        background_=(darkColorUI)
      }, BorderPanel.Position.East)
    }
  }

  title = "Avatar Application!"
  preferredSize = new Dimension(700, 600)
  peer.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE)
  peer.setUndecorated(true)
  peer.setResizable(true)

  contents = basePanel

  peer.setLocationRelativeTo(null)

}