package pckgMesGammes;

import java.util.LinkedHashMap;

class Basse extends Instrument {
    /**
     * nombre de fretes sur guitare
     */
    public static final int NB_FRETES_BASSE = 13;
    /**
     * nombre de cordes sur guitare
     */
    public static final int NB_CORDES_BASSE = 4;
    /**
     * tableau avec nonm et notes des differents Tunning (accordage guitare)
     */
    public static final LinkedHashMap<String, String> TUNNING_BASSE = new LinkedHashMap<String, String>() {
        {
            put("STANDARD", "E A D G");
            put("HALF_STEP_DOWN", "Eb Ab Db Gb");
            put("FULL_STEP_DOWN", "D G C F");
            put("DROP_C", "C A D G");
            put("DROP_D", "D A D G");
            put("5_STRING_ISH", "B E A D");
           
        }
    };

    /**
     * constructeur de base d'une guitare, construit le tableau contenant toutes
     * les notes du manche
     */
    public Basse() {
        super(NB_CORDES_BASSE, NB_FRETES_BASSE);
        this.init_instrum("STANDARD");
    }

    /**
     * constructeur de base d'une guitare, construit le tableau contenant toutes
     * les notes du manche en fonction du tunning passe en parametre
     * @param String tunning
     */
    public Basse(String tunning) {
        super(NB_CORDES_BASSE, NB_FRETES_BASSE);
        this.init_instrum(tunning);
    }

    /**
     * constructeur d'une guitare selon une gamme, construit le tableau
     * contenant toutes les notes de la gamme sur le manche
     *
     * @param Gamme gamme
     * @param String tunning
     */
    public Basse(Gamme gamme, String tunning) {
        //on initialise notes_instrum avec init_guitare puis on va alimenter gamme_instrum
        //en fonction de la gamme et de notes_instrum
        super(NB_CORDES_BASSE, NB_FRETES_BASSE);
        this.init_instrum(tunning);
        this.ajuste_note_instrum(gamme);
        this.gamme_on_instrum(gamme);
        //copier des notes de notes_instrum sur gamme_instrum en eliminant celles qui ne se trouvent pas sur la gamme
        

    }

    /**
     * fonction qui permet d'initialiser une guitare en fonction du tunning
     */
    @Override
    public void init_instrum(String tunning) {
        //on se base sur le tunning standard
        String[] tunning_std = new StringBuilder(TUNNING_BASSE.get(tunning)).reverse().toString().split(" ");
        //on cree un tableau de Note de longueur NB_FRETES_BASSE
        for (int l = 0; l < this.ligne_instrum; l++) {
            //on cree les notes pour une corde en fonction des notes du tunning
            Note base = new Note(tunning_std[l]);
            int i = 0;
            do {
                Note note = new Note(base.get_nom_e());
                this.notes_instrum[l][i] = note;
                //chercher la note qui est un demi ton au dessus de la note precedente
                double ton = base.demi_ton_sup();
                //on prend la premiere note correspondant au ton dans la gamme chromatique
                base.note_by_nom(Gamme.CHROMATIQUE_DO.get(ton).get(0));
                i++;
            } while (i < this.taille_instrum);
        }

    }
    
    

   

    //    public get_positions_accord(Accord accord) {
//    }
    @Override
    public String toString() {
        return "----------- BASSE ---------\n" + super.toString();
    }

    public static void main(String args[]) {
//        Gamme g = new Gamme("G", "MAJEUR");
//        Piano p = new Piano(g);
        Basse g = new Basse(new Gamme("G", "MAJEUR"),"STANDARD");
        System.out.println(g);
    }

}
