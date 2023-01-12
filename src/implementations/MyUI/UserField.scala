package implementations.MyUI

import scala.swing._
import java.awt.Color
import scala.collection.mutable.Buffer
import scala.swing.event.KeyPressed
import scala.swing.event.Key
import implementations.MyUI.panels.MessagePanel

class UserField(msgPanel: MessagePanel) extends TextField {

  val darkColorUI = new Color(44, 62, 80)
  var hasWritedText = false
  var userUpCount: Int = -1

  background = Color.WHITE
  foreground = darkColorUI
  text = "Ecrivez votre message ici ! (85 caractères max)"
  columns = 50
  border = Swing.EmptyBorder
  onKeyEnter()
  

  def onKeyEnter() {
    listenTo(keys)
    var pressedKeys = Buffer[Key.Value]()
    reactions += {
      case KeyPressed(_, key, _, _) =>
        pressedKeys += key
        if (!hasWritedText) {
          text = ""
          hasWritedText = true
        }
        if (pressedKeys contains (Key.Enter)) {
          if (!hasWritedText) return
          msgPanel.executeMessage(this)
        } else if (pressedKeys contains (Key.Escape)) {
          text = ""
          userUpCount = -1
        } else if (pressedKeys contains (Key.Up)) {
          text = getPreviousMessage()
        } else if (pressedKeys contains (Key.Down)) {
          text = getNextMessage()
        } else userUpCount = -1
        pressedKeys.clear()
    }
  }

  def getPreviousMessage(): String = {
    if (msgPanel.getListMsg().isEmpty) return ""
    if (userUpCount >= -1 && userUpCount < msgPanel.getListMsg().size - 1) {
      userUpCount += 1
    }
    return getOldMessage()
  }

  def getNextMessage(): String = {
    if (msgPanel.getListMsg().isEmpty) return ""
    if (userUpCount > 0 && userUpCount < msgPanel.getListMsg().size) {
      userUpCount -= 1
      return getOldMessage()
    } else if (userUpCount == 0) userUpCount = -1
    return ""
  }

  def getOldMessage(): String = {
    //println(userUpCount)
    if (userUpCount < msgPanel.getListMsg().size)
      return msgPanel.getListMsg()(msgPanel.getListMsg().size - userUpCount - 1)
    else return msgPanel.getListMsg()(0)
  }
}