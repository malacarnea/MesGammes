
package pckgMesGammes;
import pckgMesGammes.Gamme;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Map.Entry;
import static pckgMesGammes.Gamme.GAMME_DO;
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
     * constante definissant la valeur d'une octave en tons
     */
    public static final double TONS_OCTAVE = 6.0;

    /**
     * constante definissant la valeur d'un index nom_e
     */
    public static final int IDX_NOM_E = 0;
    /**
     * constante definissant la valeur d'un index nom_fr
     */
    public static final int IDX_NOM_FR = 1;
    /**
     * constante definissant la valeur d'un index nom_couleur
     */
    public static final int IDX_COULEUR = 2;
  
 
  /****************************************************************************/
  /******************** COnstructeurs *****************************************/
  /****************************************************************************/
    /**
     * constructeur
     * @param nom_fr string
     * @param nom_e string
     * @param couleur string
     * @param ton_gamme double
     */
    public Note(String nom_fr, String nom_e, String couleur, double ton_gamme) {
        this.set_couleur(couleur);
        this.set_nom_e(nom_e);
        this.set_nom_fr(nom_fr);
        this.set_ton_gamme(ton_gamme);
    }

    /**
     * constructeur avec le nom anglais
     *
     * @param nom_e string
     */
    public Note(String nom_e) {
        this.note_by_nom(nom_e);
    }

    /**
     * constructeur avec le ton
     *
     * @param ton double
     */
    public Note(Double ton) {
        this.note_by_ton_gamme(ton);
    }
  /****************************************************************************/
  /************************** Getters *****************************************/
  /****************************************************************************/
    /**
     * getter de nom_fr
     * @return String nom_fr
     */
    public String get_nom_fr() {
        return nom_fr;
    }
    
     /**
     * getter de nom_e
     * @return String nom_e
     */
    public String get_nom_e() {
        return nom_e;
    }
    
     /**
     * getter de couleur
     * @return String couleur
     */
    public String get_couleur() {
        return couleur;
    }
    
     /**
     * getter de nom_fr
     * @return String nom_fr
     */
    public double get_ton_gamme() {
        return ton_gamme;
    }
    /****************************************************************************/
  /************************** Setters *****************************************/
  /****************************************************************************/
    
     /**
     * setter de ton_gamme
     * @param ton_gamme double
     */
    public void set_ton_gamme(double ton_gamme) {
        this.ton_gamme = ton_gamme;
    }

     /**
     * setter de nom_fr
     * @param nom_fr String
     */
    public void set_nom_fr(String nom_fr) {
        this.nom_fr = nom_fr;
    }
     /**
     * setter de nom_e
     * @param nom_e String
     */
    public void set_nom_e(String nom_e) {
        this.nom_e = nom_e;
    }
    /**
     * setter de couleur
     * @param couleur String
     */
    public void set_couleur(String couleur) {
        this.couleur = couleur;
    }
    
  /****************************************************************************/
  /************************* Methodes *****************************************/
  /****************************************************************************/
  /**
   * modifie la note recherchee en fonction de son nom anglais pour que ce soit plus simple a chercher
   * @param note String en anglais
   */
  public void note_by_nom(String note) {
     double key=0;
     ArrayList<String> value=null;
     boolean found=false;
     //on cree un iterateur pour parcourir le hashMap DEGRES_NOTES qui nous renvoie les couples <ton, tableau<>>
     for( Iterator i= GAMME_DO.entrySet().iterator();i.hasNext()&&!found;){
         //recuperer l'element courant
        Entry<Double, ArrayList<String>> entry= (Entry<Double, ArrayList<String>>) i.next();
        //sa cle
        key=(double) entry.getKey();
        //sa valeur (le tableau <"nom_e", "nom_fr", "couleur">)
        value=(ArrayList<String>)entry.getValue();
        //on regarde si ce tableau contient la note recherchee
        if(value.contains(note)){
            found=true;
        }
     }
     //comme les derniers key et value contiennent forcement les valeurs de la note recherchee, on met a jour les attributs avec les valeurs trouvees
     this.set_ton_gamme(key);
     this.set_nom_e(value.get(IDX_NOM_E));
     this.set_nom_fr(value.get(IDX_NOM_FR));
     this.set_couleur(value.get(IDX_COULEUR));
  }
  

  /**
   * modifie la note correspondant au ton recherche
   * @param double ton
   */
  public void note_by_ton_gamme(double ton) {
      //petite operéation pour etre sur de ne pas sortir du tableau de notes
      double myTon=ton%TONS_OCTAVE;
      ArrayList<String> find=GAMME_DO.get(myTon);
      this.set_couleur(find.get(IDX_COULEUR));
      this.set_nom_e(find.get(IDX_NOM_E));
      this.set_nom_fr(find.get(IDX_NOM_FR));
      this.set_ton_gamme(myTon);
  }
  
  /**
   * fonction qui renvoie la valeur du ton superieur pour la note courante en prenant en compte les octaves
   * @return double
   */
  public double ton_sup(){
      return (this.ton_gamme+TON)%TONS_OCTAVE;
  }
  
  /**
   * fonction qui renvoie la valeur du ton inferieur pour la note courante en prenant en compte les octaves
   * @return double
   */
  public double ton_inf(){
      return (this.ton_gamme-TON+TONS_OCTAVE)%TONS_OCTAVE;
  }

    /**
   * fonction qui renvoie la valeur du  demiton superieur pour la note courante en prenant en compte les octaves
   * @return double
   */
  public double demi_ton_sup(){
      return (this.ton_gamme+DEMI_TON)%TONS_OCTAVE;
  }
  
  /**
   * fonction qui renvoie la valeur du demi ton inferieur pour la note courante en prenant en compte les octaves
   * @return double
   */
  public double demi_ton_inf(){
      return (this.ton_gamme-DEMI_TON+TONS_OCTAVE)%TONS_OCTAVE;
  }

  
  @Override
    public String toString() {
        String res="---------- NOTE ----------"
                + "\nF : "+this.nom_e+
                "\nEN : "+this.nom_fr+
                "\nTON : "+this.ton_gamme+
                "\nCouleur : "+this.couleur+
                "\n-----------------------------";
        return res;
    }
    
    public static void main(String args[]) {
        Note note=new Note(6.0);
        System.out.println(note);
        double sup=note.demi_ton_sup();
        double inf=note.demi_ton_inf();
        Note s=new Note(sup);
        Note i=new Note(inf);
        System.out.println("ton sup : "+ s);
        System.out.println("ton inf : "+ i);
    }

}
