
package pckgMesGammes;

import java.util.HashMap;
import pckgMesGammes.Gamme;
import static pckgMesGammes.Gamme.DEGRES;

class GammeMineure extends Gamme {
    
       /**
     * constante qui donne les intervalles a respecter entre chaque note pour construire une gamme majeure
     */
  public static final double[] SCHEMA_MINEUR={1, 0.5, 1, 1, 0.5, 1, 1};
    
     /**
   * constructeur
   * @param void
   * @return void
   */
  public GammeMineure(String fondamentale){
      //on calcule les notes de la gamme en fonction de la fondamentale
      //trouver la note correspondant a la fondamentale
      this.notes_gamme=new HashMap<String, Note>();
      Note note=new Note(fondamentale);
      this.calcule_gamme(note);
      
  }
  /**
   * renvoie un tableau de note correspondant à la gamme, a recuperer dans le constructeur de la gamme enfant
   */
   public void calcule_gamme(Note fondamentale) {
       for(int i=0; i<DEGRES.length; i++){
          //ajouter note au tableau de la gamme
          double c_ton=fondamentale.get_ton_gamme();
          this.add_note_gamme(DEGRES[i], new Note(c_ton));
          //on modifie la note courante en fonction du ton dans le tableau
          //case ton ou demi ton
          fondamentale.note_by_ton_gamme(SCHEMA_MINEUR[i]);
          
      }
  }
   
    public String toString(){
       String toReturn="#####  GAMME MINEURE  #####\n";
       toReturn+=super.toString();
       return toReturn;
   }
    
    public static void main(String args[]){
        GammeMineure gm=new GammeMineure("D");
        System.out.println(gm);
    }
}
