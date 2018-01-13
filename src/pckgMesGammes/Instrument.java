package pckgMesGammes;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.Map;

abstract class Instrument {

    /**
     * tableau contenant la representation de toutes les notes d'un instrument
     */
    protected Note[][] notes_instrum;
    /**
     * tableau contenant la representation des notes d'une gamme pour un
     * instrument
     */
    protected Note[][] gamme_instrum;
    /**
     * tableau contenant la representation des notes d'un accord sur un
     * instrument
     */
    protected Note[][] accord_instrum;
    /**
     * nombre de lignes du tableau
     */
    protected int ligne_instrum;
    /**
     * taille instrument
     */
    protected int taille_instrum;
    
    
    /**
     * coonstante qui definit la liste des instruments disponibles
     */
    public static final String[] INTRUMENTS={"Piano", "Guitare", "Basse"};
    
    /**
     * constructeur
     */
    public Instrument() {
        notes_instrum = new Note[0][0];
        gamme_instrum = new Note[0][0];
        accord_instrum = new Note[0][0];
        ligne_instrum = 0;
        taille_instrum = 0;
    }

    public Instrument(int ligne, int colonne) {
        notes_instrum = new Note[ligne][colonne];
        gamme_instrum = new Note[ligne][colonne];
        accord_instrum = new Note[ligne][colonne];
        ligne_instrum = ligne;
        taille_instrum = colonne;
    }

    /**
     * fonction qui ajuste les notes sur notes_instrum en fonction des notes sur
     * la gamme
     *
     * @param Gamme gamme
     */
    public void ajuste_note_instrum(Gamme gamme) {
        for (int j = 0; j < this.ligne_instrum; j++) {
            for (int i = 0; i < this.taille_instrum; i++) {
                //recuperation du ton de la note courante
                double ton = notes_instrum[j][i].get_ton_gamme();
                //parcourir la gamme et voir si les notes de la gamme chromatique sont dessus
                ArrayList<String> toSrch = Gamme.CHROMATIQUE_DO.get(ton);
                Iterator it = gamme.get_notes_gamme().entrySet().iterator();
                boolean find = false;
                while (it.hasNext() && !find) {
                    Map.Entry entry = (Map.Entry) it.next();
                    Note note_gamme = (Note) entry.getValue();
                    if (toSrch.contains(note_gamme.get_nom_e())) {
                        notes_instrum[j][i] = new Note(note_gamme.get_nom_e());
                        find = true;
                    } else {
                        notes_instrum[j][i] = new Note(toSrch.get(0));
                    }

                }
            }
        }
    }

    /**
     * methode qui ajoute les notes d'une gamme sur un instrument
     *
     * @param Gamme gamme
     */
    public void gamme_on_instrum(Gamme gamme) {
        for (int l = 0; l < this.ligne_instrum; l++) {
            for (int c = 0; c < this.taille_instrum; c++) {
                if (gamme.is_note_in_gamme(this.notes_instrum[l][c])) {
                    this.gamme_instrum[l][c] = new Note(this.notes_instrum[l][c].get_nom_e());
                } else {
                    this.gamme_instrum[l][c] = null;
                }
            }
        }
    }

    /**
     * fonction qui permet d'initialiser une guitare en fonction du tunning
     *
     * @param String tunning
     */
    public abstract void init_instrum(String tunning);

    @Override
    public String toString() {
        String res = "";
        if (notes_instrum.length > 0) {
            res += "Notes :\n";
            for (Note[] notes : notes_instrum) {
                for (Note note : notes) {
                    res += (note != null) ? note.get_nom_e() : "0";
                    res += ", ";
                }
                res += "\n";
            }

        }
        if (gamme_instrum.length > 0) {
            res += "Gamme :\n";
            for (Note[] notes : gamme_instrum) {
                for (Note note : notes) {
                    res += (note != null) ? note.get_nom_e() : "0";
                    res += ", ";
                }
                res += "\n";
            }

        }
        if (accord_instrum.length > 0) {
            res += "Accord :\n";
            for (Note[] notes : accord_instrum) {
                for (Note note : notes) {
                    res += (note != null) ? note.get_nom_e() : "0";
                    res += ", ";
                }
                res += "\n";
            }

        }
        return res;
    }
//    public abstract void accord_on_instrum(Accord accord);

}
