package library

trait AnalyseMessage {
  
  /** récupère le string si existant associé au mot clé saisi
   * @param m la chaîne de caractère saisie (ou mot clé saisi)
   * @result le string correspondant à m ou si rien ne correspond, ne renvoie rien
   */
  def extraireMotCle(m: String): Option[String]
  
}