package pckgMesGammes;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.Map.Entry;

final class Piano extends Instrument {

    /**
     * liste des notes du piano
     */
    protected Note[] notes_piano;
    protected Note[] gamme_piano;
    protected Note[] accord_piano;
    public static final int NB_TOUCHES = 61;

    /**
     * constructeur de base sans parametres, affichage des dieses
     */
    public Piano() {
        //utiliser COULEUR_NOTES pour creer un tableau notes_piano de base
        //on cree un tableau de Note de longueur NB_TOUCHEs
        notes_piano = new Note[NB_TOUCHES];
        for (int i = 0; i < NB_TOUCHES; i++) {
            //on cree une nouvelle note en fonction de la premiere note trouvee dans COULEUR_NOTES apres chaque cle
            double ton = (i / 2.0) % Note.TONS_OCTAVE;
            Note note = new Note(Gamme.CHROMATIQUE_DO.get(ton).get(0));
            notes_piano[i] = note;
            //on insere cette nouvelle note a notes_piano en veillant a faire des modulo
        }
        gamme_piano = new Note[0];
        accord_piano = new Note[0];

    }

    /**
     * constructeur de base sans parametres, affichage des dieses
     */
    public Piano(Gamme gamme) {
        //utiliser COULEUR_NOTES pour creer un tableau notes_piano de base
        //on cree un tableau de Note de longueur NB_TOUCHEs
        notes_piano = new Note[NB_TOUCHES];
        gamme_piano = new Note[NB_TOUCHES];
        this.gamme_on_instrum(gamme);

        accord_piano = new Note[0];

    }

    public Note[] getNotes_piano() {
        return notes_piano;
    }

    public void setNotes_piano(Note[] notes_piano) {
        this.notes_piano = notes_piano;
    }

    public Note[] getGamme_piano() {
        return gamme_piano;
    }

    public void setGamme_piano(Note[] gamme_piano) {
        this.gamme_piano = gamme_piano;
    }

    public Note[] getAccord_piano() {
        return accord_piano;
    }

    public void setAccord_piano(Note[] accord_piano) {
        this.accord_piano = accord_piano;
    }

    @Override
    public void gamme_on_instrum(Gamme gamme) {
         for (int i = 0; i < NB_TOUCHES; i++) {
            //on cree une nouvelle note en fonction de la premiere note trouvee dans COULEUR_NOTES apres chaque cle
            double ton = (i / 2.0) % Note.TONS_OCTAVE;
            //parcourir la gamme et voir si les notes de la gamme chromatique sont dessus
            ArrayList<String> toSrch = Gamme.CHROMATIQUE_DO.get(ton);
            Iterator it = gamme.get_notes_gamme().entrySet().iterator();
            boolean find = false;
            while (it.hasNext() && !find) {
                Entry entry = (Entry) it.next();
                Note note_gamme = (Note) entry.getValue();
                if (toSrch.contains(note_gamme.get_nom_e())) {
                    notes_piano[i] = new Note(note_gamme.get_nom_e());
                    gamme_piano[i] = new Note(note_gamme.get_nom_e());
                    find = true;
                } else {
                    notes_piano[i] = new Note(toSrch.get(0));
                    gamme_piano[i] = null;
                }

            }

            //on insere cette nouvelle note a notes_piano en veillant a faire des modulo
        }
    }

    @Override
    public String toString() {
        String res = "";
        if (notes_piano.length > 0) {
            res += "Notes Piano :\n";
            for (Note note : notes_piano) {
                res += (note != null) ? note.get_nom_e() : "0";
                res += ", ";
            }
            res += "\n";
        }
        if (gamme_piano.length > 0) {
            res += "Notes Piano :\n";
            for (Note note : gamme_piano) {
                res += (note != null) ? note.get_nom_e() : "0";
                res += ", ";
            }
            res += "\n";
        }
        if (accord_piano.length > 0) {
            res += "Notes Piano :\n";
            for (Note note : accord_piano) {
                res += (note != null) ? note.get_nom_e() : "0";
                res += ", ";
            }
            res += "\n";
        }
        return res;
    }

    public static void main(String args[]) {
        Gamme g = new Gamme("G", "MAJEUR");
        Piano p = new Piano(g);
        System.out.println(p);
    }

}
