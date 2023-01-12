package implementations

import library._
import scala.io.Source
object MyBDD extends BDD {

  var myMap: Map[List[String], String] = Map()
  val source = scala.io.Source.fromFile("doc/DonneesInitiales.txt").getLines.toList

  loadMap()

  def loadMap() = {
    for (el <- source) { //Pour chaque ligne de la source
      var ligne = el.split(";").toList //Liste des mots de la ligne
      var listEndroits: List[String] = List() //Liste des endroits de la ligne
      //println(ligne)
      for (elLine <- ligne) { //pour chaque élements de la ligne
        if (elLine != ligne(1)) listEndroits = listEndroits :+ elLine //Si c'est pas adresse, j'ajoute dans la listEndroits
        }
      myMap = myMap + (listEndroits -> ligne(1)) //J'ajoute [listEndroits avec l'adresse] à la map
    }
  }

  def getMyMap(): Map[List[String], String] = {
    myMap
  }

  /** récupération de l'ensemble des endroits de la BDD
   * @result la liste des endroits contenus dans la BDD
   */
  def obtenirEndroits: List[List[String]] = {
    myMap.keySet.toList
  }
  
   /** récupération de l'adresses selon le mot clé en entré
    *  @param endroit un string mot clé 
   * @result les adresses possibles contenus dans la BDD
   */
  def obtenirAdresse(endroit: String): Option[String] = {
    for ((listEndroits, adresse) <- myMap) {
      if (listEndroits.contains(endroit)) return Some(adresse)
    }
    None
  }

}