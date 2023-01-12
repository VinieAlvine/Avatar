package library

trait BDD {
  
  /** récupération de l'ensemble des endroits de la BDD
   * @result la liste des endroits contenus dans la BDD
   */
  def obtenirEndroits: List[List[String]]
  
   /** récupération de l'adresses selon le mot clé en entré
    *  @param endroit un string mot clé 
   * @result les adresses possibles contenus dans la BDD
   */
  def obtenirAdresse(endroit: String): Option[String]
}