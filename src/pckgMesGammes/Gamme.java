
package pckgMesGammes;

import java.util.Hashtable;

abstract class Gamme {
   /**
   * tableau des notes de la gamme
   */
  protected Hashtable <String, Note> notes_gamme;
  public static final  String[] DEGRES= {"Degré I", "Degré II", "Degré III", "Degré IV", "Degré V", "Degré VI", "Degré VII"};
  /**
   * renvoie un tableau de note correspondant à la gamme, a recuperer dans le constructeur de la gamme enfant
   */
  public abstract Note[] calcule_gamme() ;

  

  /**
   * ajoute une note dans le tableau de la gamme [I, II, III, IV...], on compte le nombre d'elements dans notes_gamme et on ajoute 
   */
  public void add_note_gamme(Note note, String degre) {
      notes_gamme.put(degre, note);
  }

  public final Hashtable getNotes_gamme() {
    return notes_gamme;
  }

  public void setNotes_gamme(Hashtable table) {
    notes_gamme=table;
  }

}
