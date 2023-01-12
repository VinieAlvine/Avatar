package myAnalyseMessage
import org.junit.Assert._
import org.junit.Test 
import implementations._
class TestMyAnalyseMessage {
   @Test
  def Testextraitmocle{
   assertEquals(Some("Théâtre La Paillette"),MyAnalyseMessage.extraireMotCle("Paillette"))
   assertEquals(Some("Théâtre National de Bretagne"),MyAnalyseMessage.extraireMotCle("Bretagne"))
    assertEquals(Some("Théâtre National de Bretagne"),MyAnalyseMessage.extraireMotCle("TNB"))
     assertEquals(None,MyAnalyseMessage.extraireMotCle("avatar"))
   assertEquals(None,MyAnalyseMessage.extraireMotCle("Théâtre")) 
   assertEquals(Some("Mairie de Rennes"),MyAnalyseMessage.extraireMotCle("mairi"))
    assertEquals(Some("Mairie de Rennes"),MyAnalyseMessage.extraireMotCle("mairia"))
     assertEquals(Some("Mairie de Rennes"),MyAnalyseMessage.extraireMotCle("hotel"))
     assertEquals(Some("Mairie de Rennes"),MyAnalyseMessage.extraireMotCle("otel"))
   
  }
   @Test
   def Testtestmotcle(){
     assertEquals("Théâtre La Paillette",MyAnalyseMessage.testmotMessage("Paillette"))
    assertEquals("Théâtre La Paillette",MyAnalyseMessage.testmotMessage("aillette"))
    assertEquals("Théâtre La Paillette",MyAnalyseMessage.testmotMessage("Paillettep"))
   }
   
   /*@Test fonctionnels POUR F1 F2 F3 puis déplacé dans LangueAbst
   def TestEstFormulePolitesse() {
     assertEquals(true,MyAnalyseMessage.estFormulePolitesse("Bonjour je cherche la mairie"))
      assertEquals(true,MyAnalyseMessage.estFormulePolitesse("Bonjou je cherche la mairie"))
     assertEquals(true,MyAnalyseMessage.estFormulePolitesse("Salut je cherche la mairie"))
          assertEquals(true,MyAnalyseMessage.estFormulePolitesse("Salutp je cherche la mairie"))
     assertEquals(true,MyAnalyseMessage.estFormulePolitesse("Bonsoir je cherche la mairie"))
     assertEquals(true,MyAnalyseMessage.estFormulePolitesse("Bonsoip je cherche la mairie"))
     assertEquals(false,MyAnalyseMessage.estFormulePolitesse("je cherche la mairie"))
   }
   @Test
   def TestEstFormulePolitesse2() {
     assertEquals(false,MyAnalyseMessage.estFormulePolitesse("je cherche la mairie"))
   }
   * 
   */
   @Test
   def TestingoreAccent() {
     assertEquals("elephant",MyAnalyseMessage.ingoreAccent("éléphant"))
      assertEquals("theatre",MyAnalyseMessage.ingoreAccent("théatre"))
   }
   
  
}