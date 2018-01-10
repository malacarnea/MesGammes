package pckgMesGammes;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map.Entry;
import java.util.Objects;
import static pckgMesGammes.Gamme.CHROMATIQUE_DO;

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
     * tableau qui denifit la correspondance entre la note anglaise et la note
     * française
     */
    public static final LinkedHashMap<String, String> TRADUCTION_NOTES = new LinkedHashMap<String, String>() {
        {
            put("C", "Do");
            put("D", "Ré");
            put("E", "Mi");
            put("F", "Fa");
            put("G", "Sol");
            put("A", "La");
            put("B", "Si");
        }
    };

    /**
     * tableau qui denifit la couleur des notes
     */
    public static final LinkedHashMap<String, ArrayList<String>> COULEUR_NOTES = new LinkedHashMap<String, ArrayList<String>>() {
        {
            put("ROUGE", new ArrayList() {
                {
                    add("C");
                    add("B#");
                }
            });
            put("VIOLET", new ArrayList() {
                {
                    add("C#");
                    add("Db");
                }
            });
            put("VERT", new ArrayList() {
                {
                    add("D");
                }
            });
            put("JAUNE", new ArrayList() {
                {
                    add("D#");
                    add("Eb");
                }
            });
            put("BLEU", new ArrayList() {
                {
                    add("E");
                }
            });
            put("ROSE", new ArrayList() {
                {
                    add("E#");
                    add("F");
                }
            });
            put("ORANGE", new ArrayList() {
                {
                    add("F#");
                    add("Gb");
                }
            });
            put("BLEU_CIEL", new ArrayList() {
                {
                    add("G");
                }
            });
            put("MARRON", new ArrayList() {
                {
                    add("G#");
                    add("Ab");
                }
            });
            put("VERT_CLAIR", new ArrayList() {
                {
                    add("A");
                }
            });
            put("GRIS", new ArrayList() {
                {
                    add("A#");
                    add("Bb");
                }
            });
            put("BLANC", new ArrayList() {
                {
                    add("B");
                    add("Cb");
                }
            });
        }
    };

    /**
     * *************************************************************************
     */
    /**
     * ****************** COnstructeurs ****************************************
     */
    /**
     * *************************************************************************
     */
    /**
     * constructeur
     *
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
     * *************************************************************************
     */
    /**
     * ************************ Getters ****************************************
     */
    /**
     * *************************************************************************
     */
    /**
     * getter de nom_fr
     *
     * @return String nom_fr
     */
    public String get_nom_fr() {
        return nom_fr;
    }

    /**
     * getter de nom_e
     *
     * @return String nom_e
     */
    public String get_nom_e() {
        return nom_e;
    }

    /**
     * getter de couleur
     *
     * @return String couleur
     */
    public String get_couleur() {
        return couleur;
    }

    /**
     * getter de nom_fr
     *
     * @return String nom_fr
     */
    public double get_ton_gamme() {
        return ton_gamme;
    }

    /**
     * *************************************************************************
     */
    /**
     * ************************ Setters ****************************************
     */
    /**
     * *************************************************************************
     */

    /**
     * setter de ton_gamme
     *
     * @param ton_gamme double
     */
    public void set_ton_gamme(double ton_gamme) {
        this.ton_gamme = ton_gamme;
    }

    /**
     * setter de nom_fr
     *
     * @param nom_fr String
     */
    public void set_nom_fr(String nom_fr) {
        this.nom_fr = nom_fr;
    }

    /**
     * setter de nom_e
     *
     * @param nom_e String
     */
    public void set_nom_e(String nom_e) {
        this.nom_e = nom_e;
    }

    /**
     * setter de couleur
     *
     * @param couleur String
     */
    public void set_couleur(String couleur) {
        this.couleur = couleur;
    }

    /**
     * *************************************************************************
     */
    /**
     * *********************** Methodes ****************************************
     */
    /**
     * *************************************************************************
     */
    /**
     * modifie la note recherchee en fonction de son nom anglais pour que ce
     * soit plus simple a chercher
     *
     * @param note String en anglais
     */
    public void note_by_nom(String note) {
        double key = 0;
        ArrayList<String> value = null;
        boolean found = false;
        //on cree un iterateur pour parcourir le hashMap DEGRES_NOTES qui nous renvoie les couples <ton, tableau<>>
        for (Iterator i = CHROMATIQUE_DO.entrySet().iterator(); i.hasNext() && !found;) {
            //recuperer l'element courant
            Entry<Double, ArrayList<String>> entry = (Entry<Double, ArrayList<String>>) i.next();
            //sa cle
            key = (double) entry.getKey();
            //sa valeur (le tableau <"nom_e", "nom_fr", "couleur">)
            value = (ArrayList<String>) entry.getValue();
            //on regarde si ce tableau contient la note recherchee
            if (value.contains(note)) {
                found = true;
            }
        }
        //comme les derniers key et value contiennent forcement les valeurs de la note recherchee, on met a jour les attributs avec les valeurs trouvees
        this.set_ton_gamme(key);
        this.set_nom_e(note);
        this.set_nom_fr(this.search_nom_fr(note));
        this.set_couleur(this.search_couleur(note));
    }

    /**
     * fonction qui permet de rechercher dans le tableau TRADUCTION_NOTES le nom
     * français de la note passee en parametre
     *
     * @param String nom_e
     * @return String nom_fr
     */
    public String search_nom_fr(String nom_e) {
        //gerer le diese et le bemol, on sait qu'il faut chercher le premier caractere
        String toSrch = nom_e.substring(0, 1);
        Iterator it = TRADUCTION_NOTES.entrySet().iterator();
        String note = "";
        String fr = "";
        while (it.hasNext() && !note.equals(toSrch)) {
            Entry entry = (Entry) it.next();
            note = (String) entry.getKey();
            fr = (String) entry.getValue();
        }
        //rajouter les caracteres qu'on a enleve
        return fr.concat(nom_e.substring(1));
    }

    /**
     * fonction qui permet de rechercher dans le tableau COULEUR_NOTES la
     * couleur correspondant a la note anglaise passee en parametre
     *
     * @param String nom_e
     * @return String couleur
     */
    public String search_couleur(String nom_e) {
        Iterator it = COULEUR_NOTES.entrySet().iterator();
        String color = "";
        ArrayList<String> list = null;
        boolean find = false;
        while (it.hasNext() && !find) {
            Entry entry = (Entry) it.next();
            color = (String) entry.getKey();
            list = (ArrayList<String>) entry.getValue();
            if (list.contains(nom_e)) {
                find = true;
            }
        }
        return color;
    }

    /**
     * fonction qui renvoie la valeur du ton superieur pour la note courante en
     * prenant en compte les octaves
     *
     * @return double
     */
    public double ton_sup() {
        return (this.ton_gamme + TON) % TONS_OCTAVE;
    }

    /**
     * fonction qui renvoie la valeur du ton inferieur pour la note courante en
     * prenant en compte les octaves
     *
     * @return double
     */
    public double ton_inf() {
        return (this.ton_gamme - TON + TONS_OCTAVE) % TONS_OCTAVE;
    }

    /**
     * fonction qui renvoie la valeur du demiton superieur pour la note courante
     * en prenant en compte les octaves
     *
     * @return double
     */
    public double demi_ton_sup() {
        return (this.ton_gamme + DEMI_TON) % TONS_OCTAVE;
    }

    /**
     * fonction qui renvoie la valeur du demi ton inferieur pour la note
     * courante en prenant en compte les octaves
     *
     * @return double
     */
    public double demi_ton_inf() {
        return (this.ton_gamme - DEMI_TON + TONS_OCTAVE) % TONS_OCTAVE;
    }

    @Override
    public String toString() {
        String res = "---------- NOTE ----------"
                + "\nEN : " + this.nom_e
                + "\nF : " + this.nom_fr
                + "\nTON : " + this.ton_gamme
                + "\nCouleur : " + this.couleur
                + "\n-----------------------------";
        return res;
    }

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 31 * hash + Objects.hashCode(this.nom_fr);
        hash = 31 * hash + Objects.hashCode(this.nom_e);
        hash = 31 * hash + Objects.hashCode(this.couleur);
        hash = 31 * hash + (int) (Double.doubleToLongBits(this.ton_gamme) ^ (Double.doubleToLongBits(this.ton_gamme) >>> 32));
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Note other = (Note) obj;
        if (Double.doubleToLongBits(this.ton_gamme) != Double.doubleToLongBits(other.ton_gamme)) {
            return false;
        }
        if (!Objects.equals(this.nom_fr, other.nom_fr)) {
            return false;
        }
        if (!Objects.equals(this.nom_e, other.nom_e)) {
            return false;
        }
        if (!Objects.equals(this.couleur, other.couleur)) {
            return false;
        }
        return true;
    }

    public static void main(String args[]) {
        Note note = new Note("G#");
        System.err.println(note);
    }

}
