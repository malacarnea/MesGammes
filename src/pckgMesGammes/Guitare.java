package pckgMesGammes;

import java.util.LinkedHashMap;

class Guitare extends Instrument {

    /**
     * nombre de fretes sur guitare
     */
    public static final int NB_FRETES_GUITARE = 13;
    /**
     * nombre de cordes sur guitare
     */
    public static final int NB_CORDES_GUITARE = 6;
    /**
     * constante qui donne la hauteur d'une case dans le tableau
     */
    public static final int GUITARE_CELL_HEIGHT = 30;
    /**
     * constante qui donne la largeur d'une case dans le tableau
     */
    public static final int GUITARE_CELL_WIDTH = 75;

    /**
     * constante qui definit les images correspondant a chaque case de la
     * guitare
     */
    public static final String[][] GUITARE_IMAGES = {
        {TETE, CORDE, CORDE, CORDE, CORDE, CORDE, CORDE, CORDE, CORDE, CORDE, CORDE, CORDE, CORDE},
        {TETE, CORDE, CORDE, CORDE, CORDE, CORDE, CORDE, CORDE, CORDE, CORDE, CORDE, CORDE, CLOU},
        {TETE, CORDE, CORDE, DEMI_CLOU_DOWN, CORDE, DEMI_CLOU_DOWN, CORDE, DEMI_CLOU_DOWN, CORDE, DEMI_CLOU_DOWN, CORDE, CORDE, CORDE},
        {TETE, CORDE, CORDE, DEMI_CLOU_UP, CORDE, DEMI_CLOU_UP, CORDE, DEMI_CLOU_UP, CORDE, DEMI_CLOU_UP, CORDE, CORDE, CORDE},
        {TETE, CORDE, CORDE, CORDE, CORDE, CORDE, CORDE, CORDE, CORDE, CORDE, CORDE, CORDE, CLOU},
        {TETE, CORDE, CORDE, CORDE, CORDE, CORDE, CORDE, CORDE, CORDE, CORDE, CORDE, CORDE, CORDE}};
    /**
     * tableau avec nonm et notes des differents Tunning (accordage guitare)
     */
    public static final LinkedHashMap<String, String> TUNNING_GUITARE = new LinkedHashMap<String, String>() {
        {
            put("STANDARD", "E A D G B E");
            put("HALF_STEP_DOWN", "Eb Ab Db Gb Bb Eb");
            put("FULL_STEP_DOWN", "D G C F A D");
            put("HALF_STEP_UP", "F A# D# G# C F");
            put("DROP_C", "C G C F A D");
            put("DROP_D", "D A D G B E");
            put("DROP_C#", "C# A D G B E");
            put("DROP_B", "B Gb B E Ab Db");
            put("DROP_A", "A E A D Gb B");
            put("CELTE", "D A D G A D");
            put("OPEN_C", "C G C G C E");
            put("OPEN_D", "D A D F# A D");
            put("OPEN_E", "E B E G# B E");
            put("OPEN_F", "F A C F C F");
            put("OPEN_G", "D G D G B D");
            put("OPEN_A", "E A E A C# E");
        }
    };

    /**
     * constructeur de base d'une guitare, construit le tableau contenant toutes
     * les notes du manche
     */
    public Guitare() {
        super(NB_CORDES_GUITARE, NB_FRETES_GUITARE);
        this.init_instrum("STANDARD");
    }

    /**
     * constructeur de base d'une guitare, construit le tableau contenant toutes
     * les notes du manche en fonction du tunning passe en parametre
     *
     * @param String tunning
     */
    public Guitare(String tunning) {
        super(NB_CORDES_GUITARE, NB_FRETES_GUITARE);
        this.init_instrum(tunning);
    }

    /**
     * constructeur d'une guitare selon une gamme, construit le tableau
     * contenant toutes les notes de la gamme sur le manche
     *
     * @param Gamme gamme
     * @param String tunning
     */
    public Guitare(Gamme gamme, String tunning) {
        //on initialise notes_instrum avec init_guitare puis on va alimenter gamme_instrum
        //en fonction de la gamme et de notes_instrum
        super(NB_CORDES_GUITARE, NB_FRETES_GUITARE);
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
        this.set_tunning();
        //on se base sur le tunning standard
        String[] tunning_std = this.tunning.get(tunning).split(" ");
        //inverser le tableau
        for (int i = 0; i < tunning_std.length / 2; i++) {
            String temp = tunning_std[i];
            tunning_std[i] = tunning_std[tunning_std.length - i - 1];
            tunning_std[tunning_std.length - i - 1] = temp;
        }
        //on cree un tableau de Note de longueur NB_FRETES_GUITARE
        //parcours à l'envers pour afficher les notes dans le bon ordre
        for (int l = this.ligne_instrum - 1; l >= 0; l--) {
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
        this.instrument_cell_width = GUITARE_CELL_WIDTH;
        this.instrument_cell_height = GUITARE_CELL_HEIGHT;
        this.instrument_images = GUITARE_IMAGES;
    }

    @Override
    public void set_tunning() {
        this.tunning = TUNNING_GUITARE;
    }

    //    public get_positions_accord(Accord accord) {
//    }
    @Override
    public String toString() {
        return "----------- GUITARE ---------\n" + super.toString();
    }

    public static void main(String args[]) {
//        Gamme g = new Gamme("G", "MAJEUR");
//        Piano p = new Piano(g);
        Guitare g = new Guitare(new Gamme("G", "MAJEUR"), "HALF_STEP_DOWN");

        System.out.println(g);
        System.out.println(g.getNoteGammeAtPos(4, 1));
    }

}
