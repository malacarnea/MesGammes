
package pckgMesGammes;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Hashtable;

abstract class Gamme {
   /**
   * tableau des notes de la gamme
   */
  protected HashMap <String, Note> notes_gamme;
  public static final  String[] DEGRES= {"Degré I", "Degré II", "Degré III", "Degré IV", "Degré V", "Degré VI", "Degré VII"};
  
   /**
   * tableau de forme <ton note, ArrayList<"nom_e", "nom_fr", "couleur">>qui contient les notes de Do à Si avec les dieses/bemols indexees de 0 à 11 
   */
  public static final HashMap<Double, ArrayList<String>> GAMME_DO=new HashMap<Double, ArrayList<String>>(){
    {
        put(new Double(0),new ArrayList(){{add("C"); add("Do");add("0x000000");}});
        put(new Double(0.5),new ArrayList(){{add("C#/Db"); add("Do#/Réb");add("0x000000");}});
        put(new Double(1),new ArrayList(){{add("D"); add("Ré");add("0x000000");}});
        put(new Double(1.5),new ArrayList(){{add("D#/Eb"); add("Ré#/Mib");add("0x000000");}});
        put(new Double(2),new ArrayList(){{add("E"); add("Mi");add("0x000000");}});
        put(new Double(2.5),new ArrayList(){{add("F"); add("Fa");add("0x000000");}});
        put(new Double(3),new ArrayList(){{add("F#/Gb"); add("Fa#/Solb");add("0x000000");}});
        put(new Double(3.5),new ArrayList(){{add("G"); add("Sol");add("0x000000");}});  
        put(new Double(4),new ArrayList(){{add("G#/Ab"); add("Sol#/Lab");add("0x000000");}});
        put(new Double(4.5),new ArrayList(){{add("A"); add("La");add("0x000000");}});
        put(new Double(5),new ArrayList(){{add("A#/Bb"); add("La#/Sib");add("0x000000");}});
        put(new Double(5.5),new ArrayList(){{add("B"); add("Si");add("0x000000");}});
    }
  };
  
  /**
   * renvoie un tableau de note correspondant à la gamme, a recuperer dans le constructeur de la gamme enfant
   */
  public abstract void calcule_gamme(Note fondamentale) ;

  

  /**
   * ajoute une note dans le tableau de la gamme [I, II, III, IV...], on compte le nombre d'elements dans notes_gamme et on ajoute 
   * @param String degre
   * @param Note note
   */
  public void add_note_gamme(String degre, Note note) {
      notes_gamme.put(degre, note);
  }

  public final HashMap get_notes_gamme() {
    return notes_gamme;
  }

  public void set_notes_gamme(HashMap table) {
    notes_gamme=table;
  }
      @Override
    public String toString() {
        String toReturn="";
        for(int i=0; i<DEGRES.length; i++){
            Note note=this.notes_gamme.get(DEGRES[i]);
            toReturn+="\n**** "+DEGRES[i]+" ****\n"+note;
        }
        
        return toReturn+"\n";
    }

}
