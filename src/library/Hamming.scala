package library

trait Hamming {
  
  /** compare la distance de ressemblance entre deux mots et récupère la différence
   *  @param couple le couple avec le mot écrit par l'utilisateur et un mot de la bdd
   *  @result la différence de ressemblance par caractère entre les deux mots
   */
  def distance(motCle:String,motMess: String): Int
  
}