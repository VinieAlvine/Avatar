package implementations.mylanguages

import library._ 

object German extends LangueAbst {
  
  override def getName(): String = "deutsch"
  
  override def getHello(): String = "hallo!"
  
  override def getGoodLanguage() = "Sprechen Sie deutsch?"
  
  override def getQuestion(): String = "okay, was ist Ihr wunsch?"
  
  override def getIDK(): String = "Ich verstehe nicht"
  
  override def getGoodAnswer(endroit: String, adresse: String): String = "Die adresse von " +endroit+ " ist : " + adresse
  
  override def getListPolite(): List[String] = List("hallo","guten","morgen","tag","abend")
  
  override def getListSearch(): List[String] = List("wo","ist","suche","suchen")
  
  override def getListExpression(): List[String] = List("ja","nein")

  override def getPropositionMessage(nbr: Int): String = "Ich habe "+nbr+" Antworten"
	
  override def getPropositionQuestion(): String = "Was ist Ihre Wahl?"
	

}