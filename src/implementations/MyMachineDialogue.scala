package implementations

import library._
import machine.MachineDialogue
import implementations._
import implementations.mylanguages._

object MyMachineDialogue extends MachineDialogue {
  val charList: List[Char] = List('?', '!', ',', '/', '.', '§', ';', ''', ':', '-', '_', '|', '"')
  val listOfLanguages = List(Francais, German, Italian, Anglais, Espagnol)
  var countLanguage = 0

  var currentLanguage: Language = Francais
  var languageAsked: Language = Francais

  /**
   * envoi d'une requête à la machine et récupération de sa réponse
   *  @param s la requête
   *  @result la liste de réponses
   */

  def ask(s: String): List[String] = {
    var resultat: List[String] = List()
    val list = formatString(s).split(" ").toList
    var stringRes = ""

    if (languageAsked != currentLanguage) {
      for (el <- list) {
        if (languageAsked.getListExpression()(0).toUpperCase().equals(el.toUpperCase())) {
          currentLanguage = languageAsked
          stringRes = currentLanguage.getQuestion()
          return resultat :+ stringRes
        }
      }
    }

    if (checkLanguage(list) != currentLanguage) {
      languageAsked = checkLanguage(list)
      stringRes = checkLanguage(list).getGoodLanguage()
      return resultat :+ stringRes
    }

    if (contientPolitesse(list)) resultat = resultat :+ (currentLanguage.getHello())

    if (getFirstMotCle(list) != "") {
      //stringRes += "L'adresse de " + getFirstMotCle(list) + " est : "
      //stringRes += opToString(MyBDD.obtenirAdresse(getFirstMotCle(list)))

      val adresse = opToString(MyBDD.obtenirAdresse(getFirstMotCle(list)))
      stringRes += currentLanguage.getGoodAnswer(getFirstMotCle(list), adresse)

      resultat = resultat :+ stringRes
    } else if (!contientPolitesse(list) || (list.size > 1)) {
      stringRes == ""
      resultat = resultat :+ (currentLanguage.getIDK())
    }
    
     /*if (!checkExpression(list)) {
        if (countLanguage >= 4) countLanguage = 0
        else countLanguage += 1
        stringRes = listOfLanguages(countLanguage).getGoodLanguage()
        return resultat :+ stringRes
      }*/
    
    resultat
  }

  def formatString(s: String): String = {
    var res = ""
    for (el <- s.toCharArray()) {
      if (!charList.contains(el)) res += el
    }
    res
  }

  def checkLanguage(l: List[String]): Language = {
    for (el <- l) {
      for (language <- listOfLanguages) {
        if (language.getListPolite().map(mot => mot.toUpperCase()).contains(el.toUpperCase()) ||
          language.getName().toUpperCase().equals(el.toUpperCase()) ||
          language.getListSearch().map(mot => mot.toUpperCase()).contains(el.toUpperCase()) //||
          /*language.getListExpression().map(mot => mot.toUpperCase()).contains(el.toUpperCase())*/ ) {
          return language
        }
      }
    }
    currentLanguage
  }

  def checkExpression(l: List[String]): Boolean = {
    for (el <- l) {
      if (currentLanguage.getListSearch().map(mot => mot.toUpperCase()).contains(el.toUpperCase()) ||
        currentLanguage.getListPolite().map(mot => mot.toUpperCase()).contains(el.toUpperCase()) ||
        currentLanguage.getName().toUpperCase().equals(el.toUpperCase()) ||
        currentLanguage.getListExpression().map(mot => mot.toUpperCase()).contains(el.toUpperCase())) {
        return true
      }
    }
    false
  }

  def contientPolitesse(l: List[String]): Boolean = {
    for (el <- l) {
      if (currentLanguage.estFormulePolitesse(el)) return true
    }
    false
  }

  def getFirstMotCle(l: List[String]): String = {
    for (el <- l) {
      if (MyAnalyseMessage.extraireMotCle(el) != None) return opToString(MyAnalyseMessage.extraireMotCle(el))
    }
    ""
  }

  /* Conversion en string
 * @param s
 *
 *
 * */
  def opToString(s: Option[String]): String = {
    s match {
      case None    => ""
      case Some(e) => e
    }
  }

  // Pour la partie test par le client
  /** réinitialisation de l'avatar */

  def reinit = {}

  /**
   * test de l'avatar
   *  @param l une liste de requête
   *  @return la liste des réponses produites par l'avatar
   */

  def test(l: List[String]): List[String] = {
    var res: List[String] = List()
    for (i <- l) {
      res = ask(i) ++ res
    }
    res
  }
}