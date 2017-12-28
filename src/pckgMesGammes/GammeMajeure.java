package pckgMesGammes;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map.Entry;
import pckgMesGammes.Gamme;

class GammeMajeure extends Gamme {
  
    /**
     * constante qui donne les intervalles a respecter entre chaque note pour construire une gamme majeure
     */
  public static final double[] SCHEMA_MAJEUR={1.0, 1.0, 0.5, 1.0, 1.0, 1.0, 0.5};
  
  /**
   * constructeur
   * @param void
   * @return void
   */
  public GammeMajeure(String fondamentale){
      //on calcule les notes de la gamme en fonction de la fondamentale
      //trouver la note correspondant a la fondamentale
      this.notes_gamme=new HashMap<String, Note>();
      Note note=new Note(fondamentale);
     this.calcule_gamme(note);
  }
  
  /**
   * renvoie un tableau de note correspondant à la gamme, a recuperer dans le constructeur de la gamme enfant
   * @return Note[] tableau de notes
   */
  public void calcule_gamme(Note fondamentale) {
       for(int i=0; i<DEGRES.length; i++){
          //ajouter note au tableau de la gamme
          this.add_note_gamme(DEGRES[i], new Note(fondamentale.get_ton_gamme()));
          double c_ton=fondamentale.get_ton_gamme()+SCHEMA_MAJEUR[i];
          //on modifie la note courante en fonction du ton dans le tableau
          fondamentale.note_by_ton_gamme(c_ton);
      }
  }

   public String toString(){
       String toReturn="#####  GAMME MAJEURE  #####\n";
       toReturn+=super.toString();
       return toReturn;
   }
    
    public static void main(String args[]){
        GammeMajeure gm=new GammeMajeure("G");
        System.out.println(gm);
    }
    
}
