package myMachineDialogue

import library._
import implementations._
import org.junit.Assert._
import org.junit.Test

class TestMyMachineDialogueF2 {
  // initialisation des objets sous test
  val m = MyMachineDialogue
  //m.reinit

  //tests F2
  @Test
  def testMairieRennesF2_1 {
    assertEquals(List("L'adresse de Mairie de Rennes est : Place de la Mairie"), m.test(List("Mairie")))
  }

  @Test
  def testMairieRennesF2_2 {
    assertEquals(List("L'adresse de Mairie de Rennes est : Place de la Mairie"), m.test(List("je cherche la mairie")))
  }

  @Test
  def testMairieRennesF2_3 {
    assertEquals(List("L'adresse de Mairie de Rennes est : Place de la Mairie"), m.test(List("JE CHERCHE LA MAIRIE")))
  }

  @Test
  def testMairieRennesF2_4 {
    assertEquals(List("L'adresse de Théâtre La Paillette est : 2 Rue du Pré de Bris"), m.test(List("Je cherche le théâtre la paillette")))
  }

  @Test
  def testMairieRennesF2_5 {
    assertEquals(List("L'adresse de Mairie de Rennes est : Place de la Mairie"), m.test(List("hotl de valle")))
  }

  @Test
  def testMairieRennesF2_6 {
    assertEquals(List("Je ne comprends pas votre demande"), m.test(List("l'hot de ville")))
  }

  @Test
  def testMairieRennesF2_7 {
    assertEquals(List("L'adresse de Mairie de Rennes est : Place de la Mairie"), m.test(List("l'hotel de ville")))
  }

  @Test
  def testMairieRennesF2_8 {
    assertEquals(List("L'adresse de Mairie de Rennes est : Place de la Mairie"), m.test(List("hotel ville")))
  }

  @Test
  def testMairieRennesF2_9 {
    assertEquals(List("L'adresse de Mairie de Rennes est : Place de la Mairie"), m.test(List("hotell de vill")))
  }

  @Test
  def testMairieRennesF2_10 {
    assertEquals(List("L'adresse de Mairie de Rennes est : Place de la Mairie"), m.test(List("maire")))
  }

}