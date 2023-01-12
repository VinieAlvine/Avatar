package implementations.mylanguages

import library._
import implementations.MyHamming

abstract class LangueAbst extends Language {
  
  def estFormulePolitesse(message: String): Boolean = {
    var ok: Boolean = false
    val lForm = getListPolite().map(mot => mot.toUpperCase())
    lForm.contains(message.toUpperCase())
    var listMessage = message.toUpperCase.split(" ").toList
    for (m <- listMessage) {
      for (f <- lForm) {
        if (MyHamming.distance(m, f) == 0 || (MyHamming.distance(m, f) == 1 && m.length() > 1)) ok = true
      }
    }
    ok
  }
  
  def getGoodAnswer(endroit: String,adresse: String): String
  
  def getGoodLanguage(): String
  
  def getHello(): String
  
  def getIDK(): String
  
  def getListExpression(): List[String]
  
  def getListPolite(): List[String]
  
  def getListSearch(): List[String]
  
  def getName(): String
  
  def getPropositionMessage(nbr: Int): String
  
  def getPropositionQuestion(): String
  
  def getQuestion(): String
  
}