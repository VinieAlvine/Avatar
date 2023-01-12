package implementations

import library._

object MyAnalyseMessage extends AnalyseMessage {

  def testmotMessage(mot: String): String = {
    var motcle: String = ""
    var listmotcleB = MyBDD.getMyMap().keys
    for (listmot <- listmotcleB) {
      for (m <- listmot) {
        if (MyHamming.distance(ingoreAccent(mot).toUpperCase(), ingoreAccent(m).toUpperCase()) == 0 || MyHamming.distance(ingoreAccent(mot).toUpperCase(), ingoreAccent(m).toUpperCase()) == 1) motcle = motcle + listmot(0)
      }
    }
    motcle
    
    //Ajouter test propositions
  }

  /**
   * remplace la chaîne de charactère par la même avec les accents enlevés
   * @param mot la chaîne de caractère saisie (ou mot clé saisi)
   * @result le string correspondant à mot en enlevant les accents des lettres
   */

  def ingoreAccent(mot: String): String = {
    var mot2 = mot
    var mot1: String = ""
    var exp = Map("à" -> "a", "â" -> "a", "ä" -> "a", "é" -> "e", "è" -> "e", "ê" -> "e", "ë" -> "e", "ï" -> "i", "î" -> "i", "ô" -> "o", "ö" -> "o", "ù" -> "u", "û" -> "u", "ü" -> "u", "ÿ" -> "y", "ç" -> "c")
    var listmotaccent = exp.keys
    var listmot = mot.split("").toList
    for (e <- listmot) {
      for (u <- listmotaccent)
        if (e == u) mot2 = mot2.replace(e, exp(u))
    }
    mot2
  }

  /**
   * récupère le string si existant associé au mot clé saisi
   * @param m la chaîne de caractère saisie (ou mot clé saisi)
   * @result le string correspondant à m ou si rien ne correspond, ne renvoie rien
   */

  def extraireMotCle(mot: String): Option[String] = {
    var motcle = testmotMessage(mot)
    if (motcle != "") Some(motcle)
    else None

  }

  /**
   * vérification afin de savoir si la chaîne de caractère est une formule de politesse
   * @param m la chaîne de caractère saisie
   * @result un booléen : vrai si m est une formule de politesse, sinon faux
   */

  def getPropositions(mot: String): Map[String, String] = {
    Map()
  }
}