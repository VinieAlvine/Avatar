package implementations

import library._

object MyHamming extends Hamming {
  
   /** compare la distance de ressemblance entre deux mots et récupère la différence
   *  @param couple le couple avec le mot écrit par l'utilisateur et un mot de la bdd
   *  @result la différence de ressemblance par caractère entre les deux mots
   */
  def distance( motMess:String,motCle: String): Int = {
    var Hdistance : Int = -1
    if(motMess.length-motCle.length==0)  Hdistance = calculDistance(motMess,motCle)
    
    else if((motMess.length-motCle.length)== -1){
      var listmotPossible = combinaison(motMess)
      for(m <- listmotPossible ){
        if(calculDistance(m,motCle)==1)  Hdistance=calculDistance(m,motCle)
        }
          }
    else if((motMess.length-motCle.length)== 1){
      var listmotPossible = combinaison(motCle)
      for(m <- listmotPossible ){
        if(calculDistance(motMess,m)==1)  Hdistance=calculDistance(motMess,m)
        }
          }
     Hdistance
   
}
  
   /** compare la distance de ressemblance entre deux mots et récupère la différence
   *  @param couple le couple avec le mot écrit par l'utilisateur et un mot de la bdd
   *  @result la différence de ressemblance par caractère entre les deux mots
   */  
      def calculDistance( motMess:String,motCle: String):Int = {
        var Hdistance : Int = 0
        var i:Int =0
         while(i< motMess.length()){
              if(motMess.charAt(i)!=motCle.charAt(i)){
                Hdistance+=1  
                }
              
              i+=1
              }
        Hdistance
      }
  
      /* détermination des combinaisons possible d'un mot avec "*" */
       def combinaison(mot:String):List[String]  ={
        /* une lettre manquante*/
          var cp :Int=0
          var motcomb: List[String]=List()/* liste des combinaisons possible de motMess avec "*" */
          /*le nombre de combinaisons possible = mot.length()+1*/
          /*"*" est au début du mot*/
          motcomb = motcomb:+("*"+mot)
           /*"*" est à la fin mot*/
          motcomb = motcomb:+(mot+"*") 
         
          /* "*" entre le debut et la fin ie (de la position 1 à mot.length()-1)*/
         /* (mot.length()-1) combinaisons restente*/
          
          while(cp<=mot.length()-2){
            motcomb = motcomb:+ (mot.substring(0,cp+1)+"*"+mot.substring(cp+1))
            cp+=1
          }
    motcomb
    
  }
   
    
}
  



 