package myMachineDialogue

import library._
import implementations._
import org.junit.Assert._
import org.junit.Test

class TestMyMachineDialogueF3 {
  // initialisation des objets sous test
  val m = MyMachineDialogue
  //m.reinit

  //tests F3
  @Test
  def testMairieRennesF3_1 {
    assertEquals(List("Bonjour L'adresse de Mairie de Rennes est : Place de la Mairie"), m.test(List("salut je cherche la Mairie")))
  }

  @Test
  def testMairieRennesF3_2 {
    assertEquals(List("Bonjour L'adresse de Mairie de Rennes est : Place de la Mairie"), m.test(List("bonjoor je cherche la Mairie")))
  }

  @Test
  def testMairieRennesF3_3 {
    assertEquals(List("L'adresse de Mairie de Rennes est : Place de la Mairie"), m.test(List("bonjeer je cherche la Mairie")))
  }

  @Test
  def testMairieRennesF3_4 {
    assertEquals(List("Bonjour"), m.test(List("Bonjour")))
  }

  @Test
  def testMairieRennesF3_5 {
    assertEquals(List("Bonjour Je ne comprends pas votre demande"), m.test(List("Bonjour, comment tu t'appelles")))
  }

  @Test
  def testMairieRennesF3_6 {
    assertEquals(List("Bonjour L'adresse de Mairie de Rennes est : Place de la Mairie"), m.test(List("Bonjour Bonjour je cherche la Mairie")))
  }

  @Test
  def testMairieRennesF3_7 {
    assertEquals(List("Bonjour"), m.test(List("Bonsoir")))
  }

  @Test
  def testMairieRennesF3_8 {
    assertEquals(List("Bonjour"), m.test(List("Salut")))
  }

}