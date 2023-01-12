package implementations.mylanguages

import library._

object Anglais extends LangueAbst {
  
  override def getName(): String = "english"
  
  override def getHello(): String = "Hello!"
  
  override def getGoodLanguage(): String = "Do you speak english?"
  
  override def getQuestion(): String = "OK, what is your query?"
  
  override def getIDK(): String = "I do not understand"
  
  override def getGoodAnswer(endroit: String, adresse: String) = "The adress of " +endroit+ " is : " + adresse
  
  override def getListPolite(): List[String] = List("Hi","Hello", "morning","evening", "afternoon","hey")
  
  override def getListSearch(): List[String] = List("seek","seeking","search","searching","look","looking","where", "find")
  
  override def getListExpression(): List[String] = List("yes","no")

  override def getPropositionMessage(nbr: Int): String = "I found "+nbr+" answers"
	
  override def getPropositionQuestion(): String = "What is your choice?"
	
}