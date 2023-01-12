package implementations

import library.BDD
import scala.xml.XML

object MyBDDXml extends BDD {
  private val databaseXML = XML.loadFile("lib/vAr.xml")

  //On récupère les noms des endroits
  def getLieu: List[String] = {
    val names = (databaseXML \ "organization" \ "name")
    val addresses = (databaseXML \ "organization" \ "addresses")
    val city = (addresses \ "address" \ "city") text
    //a(0).text.toString()
    var res: List[String] = List()

    if (city.equalsIgnoreCase("Rennes")) {
      for (i <- 0 to names.length - 1) {
        res = res :+ names(i).text.toString()
      }
    }
    res
  }
  
  def getEndroit: List[String] = {
    var res: List[String] = List()
    
    val children = (databaseXML \ "answer" \\ "data" \\ "organization" \\ "addresses" \\ "address")
    children.foreach(child => { if (((child \\ "city") text).equalsIgnoreCase("Rennes"))
      res = res ++ List(child \\ "name" text)
    })
    res
  }
  
  def getAdresse2: List[String] = {
    var res: List[String] = List()
    
    val children = (databaseXML \ "answer" \\ "data" \\ "organization" \ "addresses" \ "address")
    children.foreach(child => { if (((child \\ "city") text).equalsIgnoreCase("Rennes"))
      (child \\ "street" \ "number") text match {
      case "" => res = res ++ List((child \\ "street" \\ "name").text)
      case _ => res = res ++ List(((child \\ "street" \\ "number").text) + "	, " + ((child \\ "street" \\ "name").text))
    }
    })
    res
  }



  //On forme une MAP avec ces nouvelles données
  def createDB(): Map[List[String], String] = {
    val names = getEndroit
    val addresses = getAdresse2
    var db: Map[List[String], String] = Map()

    for (i <- 0 to addresses.length - 1) {
      db = db + (List(names(i)) -> addresses(i))
    }
    db
  }

  def getMyMap(): Map[List[String], String] = {
    createDB()
  }

  def obtenirAdresse(endroit: String): Option[String] = ???

  def obtenirEndroits: List[List[String]] = ???
}