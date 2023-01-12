package library

import scala.swing.SimpleSwingApplication
import scala.swing.MainFrame
import implementations.MyUI.MyUI

object App extends SimpleSwingApplication {
  
  /*Lance le programme en affichant l'interface graphique*/
  def top : MainFrame = new MyUI
  
}