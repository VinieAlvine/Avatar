package implementations.mylanguages

import library._

object Espagnol extends LangueAbst {
  
  override def getName(): String = "espanol"
  
  override def getHello(): String = "hola!"
  
  override def getGoodLanguage() = "Hablas español?"
  
  override def getQuestion(): String = "Está bien, cuál es tu petición?"
  
  override def getIDK(): String = "No comprendo"
  
  override def getGoodAnswer(endroit: String, adresse: String): String = "La dirección de " +endroit+ " es : " + adresse
  
  override def getListPolite(): List[String] = List("hola","buenos","dias")
  
  override def getListSearch(): List[String] = List("donde","esta","busco","buscando")
  
  override def getListExpression(): List[String] = List("si","no")
  
  override def getPropositionMessage(nbr: Int): String = "Tengo "+nbr+" opciones"
	
  override def getPropositionQuestion(): String = "Cuál es su elección?"
	

}