package implementations.MyUI.panels

import scala.swing.BoxPanel
import scala.swing.Orientation
import java.awt.Color
import scala.swing.ScrollPane
import java.awt.Dimension
import scala.swing.Swing
import scala.swing.TextField
import scala.swing.BorderPanel
import scala.swing.Alignment
import implementations.MyMachineDialogue
import implementations.MyUI.UserField
import scala.swing.Label

class MessagePanel extends ScrollPane {
  
	val darkColorUI = new Color(52, 73, 94)
	
  private val dimMin = new Dimension(700, 500)
  private val dimMax = new Dimension(700, 570)

  /*Liste de message (tests)*/
  private var listMsg: List[String] = List()
  def getListMsg(): List[String] = listMsg

  /*Boxpanel principal : boîte de messages*/
  private var bp = new BoxPanel(Orientation.Vertical) {
	  peer.setOpaque(false)
    contents += addRobotMessage("Bonjour à vous ! *Wouf* *Wouf*")
    contents += addRobotMessage("Je suis Idéfix ! Comment puis-je vous aider ?")
  }

  def addRobotMessage(message: String): BorderPanel = {
    new BorderPanel {
    	peer.setOpaque(false)
      add(new RobotPanel(message), BorderPanel.Position.West)
    }
  }
  
  def addUserMessage(message: String): BorderPanel = {
    new BorderPanel {
    	peer.setOpaque(false)
      add(new UserPanel(message), BorderPanel.Position.East)
    }
  }
  
  /*Ajouter un message dans la liste et actualise la boîte*/
  def addMessage(message: String) {
    val list: List[String] = message :: Nil
    listMsg = listMsg ++ list
    //println(listMsg.toString)

    bp.contents += addUserMessage(message)
    for (el <- MyMachineDialogue.ask(message)){
      bp.contents += addRobotMessage(el)
    }
    //bp.contents += addRobotMessage(message)
    
  }

  def executeMessage(userField: UserField) {
    if (userField.text.isEmpty()) return
    
    if (!checkMessageTooLong(userField)) addMessage(userField.text)
    else bp.contents += addRobotMessage("Votre message doit faire 85 caractères maximum !")
    userField.text = ""
    userField.userUpCount = -1
    
    revalidate()

    var scrollBar = verticalScrollBar
    Swing.onEDT(scrollBar.peer.setValue(scrollBar.peer.getMaximum))
  }
  
  def checkMessageTooLong(userField: UserField): Boolean = {
    (userField.text.size > 85)
  }

  border = Swing.EmptyBorder
  
  contents = new BorderPanel {
    add(bp, BorderPanel.Position.North)
    background_=(darkColorUI)
  }
  
  preferredSize = dimMin
  minimumSize_=(dimMin)
  maximumSize_=(dimMax)
}