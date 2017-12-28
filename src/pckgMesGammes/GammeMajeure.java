package pckgMesGammes;




import pckgMesGammes.Gamme;

class GammeMajeure extends Gamme {
  
    /**
     * constante qui donne les intervalles a respecter entre chaque note pour construire une gamme majeure
     */
  public static final double[] SCHEMA_MAJEUR={1, 1, 0.5, 1, 1, 1, 0.5};
  
  /**
   * constructeur
   * @param void
   * @return void
   */
  public GammeMajeure(String fondamentale){
      //on calcule les notes de la gamme en fonction de la fondamentale
      //trouver la note correspondant a la fondamentale
      
  }
  
  /**
   * renvoie un tableau de note correspondant à la gamme, a recuperer dans le constructeur de la gamme enfant
   * @return Note[] tableau de notes
   */
  public Note[] calcule_gamme() {
      Note[] notes={};
      return notes;
  }

}
