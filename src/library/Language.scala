package library

trait Language {
  
	def getName(): String 
	
  def getHello(): String 
  
  def getGoodLanguage(): String
  
  def getQuestion(): String 
  
  def getGoodAnswer(endroit: String, adresse: String): String
  
  def getIDK(): String
  
  def getListPolite(): List[String] 
  
	def estFormulePolitesse(message: String): Boolean
	
  def getListSearch(): List[String]
  
  def getListExpression(): List[String] 
	
  def getPropositionMessage(nbr: Int): String //J'ai x réponses possibles
	
	def getPropositionQuestion(): String //Quel est votre choix
	
  
}