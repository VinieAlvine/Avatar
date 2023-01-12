package implementations.MyUI

import scala.swing._
import event._
import implementations.MyUI.panels.MessagePanel
import java.awt.Color

class SendButton(basePanel: Panel, userField: UserField, msgPanel: MessagePanel) extends Button {

  val darkColorUI2 = new Color(116, 123, 182)

  text = "Envoyer votre message"
  background_=(darkColorUI2)
  foreground_=(Color.WHITE)
  border_=(Swing.EmptyBorder(10))

  reactions += {
    case ButtonClicked(_) => {
      if (userField.hasWritedText) msgPanel.executeMessage(userField)
    }
  }

}