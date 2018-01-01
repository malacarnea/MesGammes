
package pckgMesGammes;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.Map.Entry;
import java.util.TreeMap;

class Gamme {
    /**
     * tableau des notes de la gamme
     */
    protected TreeMap<String, Note> notes_gamme;
    /**
     * premiere note de la gamme
     */
    protected Note fondamentale;

    
    /**
     * mode de la gamme (majeur, mineur...)
     */
    protected String mode;
    /**
     * tableau qui definit les tags Degré X
     */
    public static final String[] DEGRES = {"Degré I", "Degré II", "Degré III", "Degré IV", "Degré V", "Degré VI", "Degré VII"};
    /**
     * constante qui donne les intervalles a respecter entre chaque note pour
     * construire une gamme majeure
     */
    public static final double[] SCHEMA_MAJEUR = {1.0, 1.0, 0.5, 1.0, 1.0, 1.0, 0.5};
    /**
     * constante qui donne les intervalles a respecter entre chaque note pour
     * construire une gamme mineure naturelle
     */
    public static final double[] SCHEMA_MINEUR = {1.0, 0.5, 1.0, 1.0, 0.5, 1.0, 1.0};
    /**
     * definition des modes de gammes
     */
    public static final String[] MODES_GAMMES = {"MAJEUR", "MINEUR"};
    
   /**
   * tableau de forme <ton note, ArrayList<"nom_e", "nom_fr", "couleur">>qui contient les notes de Do à Si avec les dieses/bemols indexees de 0 à 11 
   * on utilise un treeMap pour que les tons restent triés
   */
  public static final TreeMap<Double, ArrayList<String>> CHROMATIQUE_DO=new TreeMap<Double, ArrayList<String>>(){
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
   * tableau de forme <ton note, ArrayList<"nom_e", "nom_fr", "couleur">>qui contient les notes de Do à Si avec les dieses/bemols indexees de 0 à 11 
   * on utilise un treeMap pour que les tons restent triés
   */
  public static final TreeMap<String, ArrayList<String>> LISTE_NOTES=new TreeMap<String, ArrayList<String>>(){
    {
        put("C",new ArrayList(){{ add("Do");add("0x000000");}});
        put("C#",new ArrayList(){{ add("Do#");add("0x000000");}});
        put("Db",new ArrayList(){{ add("Réb");add("0x000000");}});
        put("D",new ArrayList(){{ add("Ré");add("0x000000");}});
        put("D#",new ArrayList(){{ add("Ré#");add("0x000000");}});
        put("Eb",new ArrayList(){{ add("Mib");add("0x000000");}});
      
    }
  };
  public static final String[] DIESES={"F", "C", "G", "D", "A", "E", "B"};
  
/********************************************************************************************************************/
    /**
     * constructeur
     *
     * @param void
     * @return void
     */
    public Gamme(String fondamentale, String mode) {
        //on calcule les notes de la gamme en fonction de la fondamentale
        //trouver la note correspondant a la fondamentale
        this.notes_gamme = new TreeMap<>();
        this.mode=mode;
        //creer 2 notes a partir de la chaine en param, une pour garder en memoire la fondamentale, une qu'on va modifier pour construire la gamme 
        this.fondamentale=new Note(fondamentale);
        Note note = new Note(fondamentale);
        double[] schema={};
        switch(mode){
            case "MAJEUR":
                schema=SCHEMA_MAJEUR;
                break;
            case "MINEUR":
                schema=SCHEMA_MINEUR;
                break;
        }
        //calcule de la gamme
        this.calcule_gamme(note, schema);
    }
    
    /**
     * getter de fondamentale
     * @return Note
     */
    public Note get_fondamentale() {
        return fondamentale;
    }

    /**
     * getter de mode
     * @retrun String
     */
    public String get_mode() {
        return mode;
    }
    
    public final TreeMap get_notes_gamme() {
        return notes_gamme;
    }

    public void set_notes_gamme(TreeMap table) {
        notes_gamme = table;
    }

    /**
     * setter de mode
     * @param fondamentale Note
     */
    public void set_fondamentale(Note fondamentale) {
        this.fondamentale = fondamentale;
    }
    /**
     * setter de mode
     * @param mode String
     */
    public void set_mode(String mode) {
        this.mode = mode;
    }
    
    /*****************************Methodes *************************************/
    /**
     * renvoie un tableau de note correspondant à la gamme, a recuperer dans le
     * constructeur de la gamme enfant
     */
    public void calcule_gamme(Note note, double[] schema) {
          for(int i=0; i<DEGRES.length; i++){
          //ajouter note au tableau de la gamme
          this.add_note_gamme(DEGRES[i], new Note(note.get_ton_gamme()));
          double c_ton=note.get_ton_gamme()+schema[i];
          //on modifie la note courante en fonction du ton dans le tableau
          note.note_by_ton_gamme(c_ton);
      }
    }

    /**
     * ajoute une note dans le tableau de la gamme [I, II, III, IV...], on
     * compte le nombre d'elements dans notes_gamme et on ajoute
     *
     * @param String degre
     * @param Note note
     */
    public void add_note_gamme(String degre, Note note) {
        notes_gamme.put(degre, note);
    }

    /**
     * fonction qui renvoie la liste des notes de la gamme chromatique
     * @return String[]
     */
    public static String[] note_chromatique_do(){
        Iterator it=CHROMATIQUE_DO.entrySet().iterator();
        int size=CHROMATIQUE_DO.size();
        String res[]=new String[size];
        int cpt=0;
        while(it.hasNext()){
            Entry<Double, ArrayList<String>> entry= (Entry<Double, ArrayList<String>>) it.next();
            res[cpt]= entry.getValue().get(Note.IDX_NOM_E);
            cpt++;
        }
        return res;
    }

    @Override
    public String toString() {
        String toReturn = "/*************** GAMME "+this.fondamentale.get_nom_fr()+" "+this.mode+" ******************/\n";
        for (String degre: DEGRES) {
            Note note = this.notes_gamme.get(degre);
            toReturn += "\n**** " + degre + " ****\n" + note;
        }

        return toReturn + "\n";
    }
    public static void main(String args[]){
//        Gamme g=new Gamme("A", "MINEUR");
        for(String s:Gamme.note_chromatique_do()){
             System.out.println(s+", ");
        }
       
    }
}
