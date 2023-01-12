package myHamming
import org.junit.Assert._
import org.junit.Test 
import implementations._

class TestHamming {
  @Test
  def TestHdistance{
    assertEquals(-1,MyHamming.distance("bonjour","mairie"))
     assertEquals(0,MyHamming.distance("mairie","mairie"))
     
  }
  
  @Test
  def Testcalculdistance{
    assertEquals(0,MyHamming.calculDistance("mairie","mairie"))
    assertEquals(1,MyHamming.distance("mairia","mairie"))
    assertEquals(4,MyHamming.distance("papa","lili"))
     
  }
  @Test
  def Testcombinaison{}
  
}