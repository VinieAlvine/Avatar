package myMachineDialogue

import library._
import implementations._
import org.junit.Assert._
import org.junit.Test

class TestMyMachineDialogue {
  // initialisation des objets sous test
  val m = MyMachineDialogue
  //m.reinit

  //AnalyseMessage.extraireMotCle ne renvoit pas l'endroit
  
  // tests F1
  @Test
  def testMairieRennesF1_1 {
    assertEquals(List("L'adresse de Mairie de Rennes est : Place de la Mairie"), m.test(List("Je cherche la Mairie")))
  }

  @Test
  def testMairieRennesF1_2 {
    assertEquals(List("L'adresse de Gare SNCF est : 19 Place de la Gare"), m.test(List("Je cherche la Gare")))
  }

  @Test
  def testMairieRennesF1_3 {
    assertEquals(List("L'adresse de Théâtre La Paillette est : 2 Rue du Pré de Bris"), m.test(List("Je cherche Théâtre La Paillette")))
  }

  @Test
  def testMairieRennesF1_4 {
    assertEquals(List("L'adresse de Théâtre National de Bretagne est : 1 Rue Saint-Hélier"), m.test(List("Je cherche le Théâtre National de Bretagne")))
  }

  @Test
  def testMairieRennesF1_5 {
    assertEquals(List("Je ne comprends pas votre demande"), m.test(List("Je cherche le Théâtre")))
  }

  @Test
  def testMairieRennesF1_6 {
    assertEquals(List("Je ne comprends pas votre demande"), m.test(List("Je cherche")))
  }

  @Test
  def testMairieRennesF1_7 {
    assertEquals(List("Je ne comprends pas votre demande"), m.test(List("")))
  }

  @Test
  def testMairieRennesF1_8 {
    assertEquals(List("Je ne comprends pas votre demande"), m.test(List("Je cherche la Mairie et la Gare")))
  }

  @Test
  def testMairieRennesF1_9 {
    assertEquals(List("L'adresse de Mairie de Rennes est : Place de la Mairie"), m.test(List("Je cherche l'hotel de ville")))
  }

}