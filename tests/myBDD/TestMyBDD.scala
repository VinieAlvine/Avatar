package myBDD

import org.junit.Test
import org.junit.Assert._
import implementations._

class TestBDD {
// @Test 
// def test1(){
//   assertEquals(Some("Place de la Marie"),MyBDD.obtenirAdresse("Mairie de Rennes"))
// }
  
  @Test 
 def test1(){
   assertNotEquals(List(),MyBDD.obtenirEndroits);
 }
    @Test 
 def test2(){
   assertEquals(List("Mairie de Rennes","Théâtre La Paillette","Théâtre National de Bretagne","Gare SNCF"),MyBDD.obtenirEndroits);
 }
       @Test 
 def test3(){
   assertEquals(Some("Place de la Mairie"),MyBDD.obtenirAdresse("Mairie de Rennes"));
 }
              @Test 
 def test4(){
   assertEquals(Some("2 Rue du Pré de Bris"),MyBDD.obtenirAdresse("Théâtre La Paillette"));
 }
                     @Test 
 def test5(){
   assertEquals(Some("1 Rue Saint-Hélier"),MyBDD.obtenirAdresse("Théâtre National de Bretagne"));
 }       
       
 def test7(){
   assertEquals(None,MyBDD.obtenirAdresse("Mairie de Rennesssssss"));
 }
             
}