
package pckgMesGammes;
import java.util.Hashtable;
import java.util.ArrayList;
class Note {
    
     /**
   * nom de la note (Do, Ré, Mi...)
   */
  private String nom_fr;
   /**
   * note en notation standard (C, D, E...)
   */
  private String nom_e;
  /**
   * couleur associee a la note
   */
  private String couleur;

  /**
   * ton de la note dans la gamme de Do majeur de base
   */
  private double ton_gamme;

  /**
   * constante qui definie la valeur d'un ton
   */
  public static final double TON = 1;

  /**
   * constante definissant la valeur d'un demi_ton
   */
  public static final double DEMI_TON = 0.5;
  /**
   * tableau de forme ["standard"=>"note"] qui contient les notes de Do à Si avec les dieses/bemols indexees de 0 à 11 
   */
  public static final Hashtable<Double, ArrayList<String>> DEGRES_NOTES=new Hashtable<Double, ArrayList<String>>(){
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
   * renvoie la note recherchee en fonction de son nom
   */
  public Note note_by_nom(String note) {
      Note rslt;
      return rslt;
  }

  /**
   * renvoie la note correspondant au ton recherche
   */
  public Note note_by_ton_gamme(double ton) {
  }

  public final String getCouleur() {
    return couleur;
  }

  public final double getTon_gamme() {
    return ton_gamme;
  }

  public void setCouleur(String value) {
    couleur = value;
  }

  public void setTon_gamme(double value) {
    ton_gamme = value;
  }

}
