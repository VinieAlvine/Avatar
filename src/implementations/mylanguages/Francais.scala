package implementations.mylanguages

import library._
import implementations.MyHamming

object Francais extends LangueAbst {
  
  override def getName(): String = "francais"
  
  override def getHello(): String = "Bonjour"
  
  override def getGoodLanguage() = "Parlez-vous français?"
  
  override def getQuestion(): String = "D'accord, quelle est votre demande?"
  
  override def getIDK(): String = "Je ne comprends pas votre demande"
  
  override def getGoodAnswer(endroit: String, adresse: String): String = "L'adresse de " +endroit+ " est : " + adresse
  
  override def getListPolite(): List[String] = List("bonjour","salut", "bonsoir")
    
  override def getListSearch(): List[String] = List("recherche","cherche","ou","est","donc","trouve","trouver")
  
  override def getListExpression(): List[String] = List("oui","non")
  
  override def getPropositionMessage(nbr: Int): String = "J'ai" +nbr+ "réponses possibles"
	
	override def getPropositionQuestion(): String = "Quel est votre choix?"
	
}