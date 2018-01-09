
package pckgMesGammes;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map.Entry;
import java.util.TreeMap;
import static pckgMesGammes.Note.TONS_OCTAVE;

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
    protected Armure armure;
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
   * tableau de forme <ton note, ArrayList<"nom_e", "nom_fr", "couleur">>qui contient les notes de Do à Si avec les dieses/bemols indexees de 0 à 11
   * on utilise un treeMap pour que les tons restent triés
   */
  public static final TreeMap<Double, ArrayList<String>> CHROMATIQUE_DO=new TreeMap<Double, ArrayList<String>>(){
    {
        put(new Double(0),new ArrayList(){{add("C");add("B#");}});
        put(new Double(0.5),new ArrayList(){{add("C#"); add("Db");}});
        put(new Double(1),new ArrayList(){{add("D");}});
        put(new Double(1.5),new ArrayList(){{add("D#"); add("Eb");}});
        put(new Double(2),new ArrayList(){{add("E");add("Fb");}});
        put(new Double(2.5),new ArrayList(){{add("F");add("E#");}});
        put(new Double(3),new ArrayList(){{add("F#"); add("Gb");}});
        put(new Double(3.5),new ArrayList(){{add("G"); }});
        put(new Double(4),new ArrayList(){{add("G#"); add("Ab");}});
        put(new Double(4.5),new ArrayList(){{add("A");}});
        put(new Double(5),new ArrayList(){{add("A#"); add("Bb");}});
        put(new Double(5.5),new ArrayList(){{add("B");add("Cb");}});
    }
  };

   /**
   * tableau de forme <mode, <armure,<note, img>>> mode : string, note:le nom de la note en anglais, armure: un entier
   * qui donne le nombre de dieses si positif et le nombre de bemols si negatif, img:adresse de l'image representant l'armure (cle de sol)
   * définit les modes des gammes et les toniques qu'on peut trouver dedans
   */
    public static final TreeMap<String, LinkedHashMap<String, Armure>> MODES_GAMMES = new TreeMap<String, LinkedHashMap<String, Armure>>() {
        {
            put("MAJEUR", new LinkedHashMap() {
                {  
                    put("C", new Armure("#", 0));
                    put("G", new Armure("#", 1));
                    put("D", new Armure("#", 2));
                    put("A", new Armure("#", 3));
                    put("E", new Armure("#", 4));
                    put("B", new Armure("#", 5));
                    put("F#", new Armure("#", 6));
                    put("C#", new Armure("#", 7));
                    put("Cb", new Armure("b", 7));
                    put("Gb", new Armure("b", 6));
                    put("Db", new Armure("b", 5));
                    put("Ab", new Armure("b", 4));
                    put("Eb", new Armure("b", 3));
                    put("Bb", new Armure("b", 2));
                    put("F", new Armure("b", 1));
                }
            });
             put("MINEUR", new LinkedHashMap() {
                {
                    put("A", new Armure("#", 0));
                    put("E", new Armure("#", 1));
                    put("B", new Armure("#", 2));
                    put("F#", new Armure("#", 3));
                    put("C#", new Armure("#", 4));
                    put("G#", new Armure("#", 5));
                    put("D#", new Armure("#", 6));
                    put("A#", new Armure("#", 7));
                    put("Ab", new Armure("b", 7));
                    put("Eb", new Armure("b", 6));
                    put("Bb", new Armure("b", 5));
                    put("F", new Armure("b", 4));
                    put("C", new Armure("b", 3));
                    put("G", new Armure("b", 2));
                    put("D", new Armure("b", 1));
                }
            });
        }
    };

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
        this.armure=MODES_GAMMES.get(mode).get(fondamentale);
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
    public final void calcule_gamme(Note note, double[] schema) {
        for (int i = 0; i < DEGRES.length; i++) {
            //ajouter note au tableau de la gamme
            this.add_note_gamme(DEGRES[i], new Note(note.get_nom_e()));
            double c_ton = note.get_ton_gamme() + schema[i];
            //on modifie la note courante en fonction du ton dans le tableau
            this.note_by_ton_gamme(c_ton, note);
        }
    }
    /**
   * modifie la note correspondant au ton recherche
   * @param double ton
   */
  public void note_by_ton_gamme(double ton, Note note) {
      //petite operéation pour etre sur de ne pas sortir du tableau de notes
      double myTon=ton%TONS_OCTAVE;
      String newNote="";
      ArrayList<String> notes=CHROMATIQUE_DO.get(myTon);
      //ici il faut verifier laquelle des notes recuperees dans CHROMATIQUE_DO 
      //si une des notes est dans l'armure, on l'ajoute a la gamme, sinon on regarde celle qui n'a pas d'alteration
      for(String laNote:notes){
          if(this.armure.is_in_armure(laNote)){
              newNote=laNote;
          }else{
              if(laNote.length()==1){
                newNote=laNote;
              }
          }
      }
      note.note_by_nom(newNote);
      
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
     * fonction qui renvoie la liste des modes de gamme possibles
     * @return String[]
     */
    public static String[] modes_gamme(){
        Iterator it=MODES_GAMMES.entrySet().iterator();
        int size=MODES_GAMMES.size();
        String res[]=new String[size];
        int cpt=0;
        while(it.hasNext()){
            Entry<String, TreeMap<String, ArrayList<String>>> entry= (Entry<String, TreeMap<String, ArrayList<String>>>) it.next();
            res[cpt]= entry.getKey();
            cpt++;
        }
        return res;
    }
    
    /**
     * fonction qui renvoie la liste des notes possibles pour un mode pour alimenter les
     * listes deroulantes de notes
     * @param String mode
     * @return String[]
     */
    public static String[] bases_mode(String mode){
         Iterator it=MODES_GAMMES.get(mode).entrySet().iterator();
        int size=MODES_GAMMES.get(mode).size();
        String res[]=new String[size];
        int cpt=0;
        while(it.hasNext()){
            Entry<String, ArrayList<String>> entry= (Entry<String, ArrayList<String>>) it.next();
            res[cpt]= entry.getKey();
            cpt++;
        }
        return res;
    }
    
    /**
     * fonction qui recupere les armures a partir de la gamme majeure pour alimenter la liste deroulante
     * du GUI
     * @return String[]
     */
    public static String[] armures_choices(){
        Iterator it=MODES_GAMMES.get("MAJEUR").entrySet().iterator();
        String[] res=new String[MODES_GAMMES.get("MAJEUR").size()];
        int i=0;
        while(it.hasNext()){
            Entry entry=(Entry) it.next();
            Armure armure=(Armure) entry.getValue();
            res[i]=armure.getNb_alte()+" "+armure.getAlteration();
            i++;
        }
        return res;
    }
    /**
     * fonction qui renvoie la note correspondante a l'armure et au mode passes en param
     * @param String mode de la gamme
     * @param Armure armureToSrch
     * @return String
     */
    public static String find_note_by_armure(String mode, Armure armureToSrch) {
        String note = "";
        //maintenant, on recherche la note (string) correspondant à l'armure selectionnee
        Iterator it = Gamme.MODES_GAMMES.get(mode).entrySet().iterator();
        boolean find = false;
        while (it.hasNext() && !find) {
            Entry entry = (Entry) it.next();
            note = (String) entry.getKey();
            Armure armureTemp = (Armure) entry.getValue();
            find = armureToSrch.equals(armureTemp);
        }
        return note;
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
        Gamme g=new Gamme("G", "MAJEUR");
        String note=Gamme.find_note_by_armure("MINEUR", new Armure("#", 3));
       System.out.println(note);

    }
}
