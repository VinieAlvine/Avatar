package implementations.mylanguages

import library._

object Italian extends LangueAbst {
  
  override def getName(): String = "italiano"
  
  override def getHello(): String = "buongiorno!"
  
  override def getGoodLanguage() = "Parli italiano?"
  
  override def getQuestion(): String = "Va bene, qual è la tua richiesta?"
  
  override def getIDK(): String = "No capisco"
  
  override def getGoodAnswer(endroit: String, adresse: String): String = "Die adresse von " +endroit+ " ist : " + adresse
  
  override def getListPolite(): List[String] = List("buongiorno","ciao","salve","buon","pomeriggio","buonasera","incantato")
  
  override def getListSearch(): List[String] = List("dove","trova","cerco","cercando")
  
  override def getListExpression(): List[String] = List("si","no")

  override def getPropositionMessage(nbr: Int): String = "Ho "+nbr+" risposte"
	
  override def getPropositionQuestion(): String = "Qual è la vostra scelta?"
}