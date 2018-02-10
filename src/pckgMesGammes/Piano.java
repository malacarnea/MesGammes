package pckgMesGammes;


class Piano extends Instrument {

    /**
     * taille du piano
     */
    public static final int NB_TOUCHES = 13;
    /**
     * nombre de lignes tab piano
     */
    public static final int LIGNE_PIANO = 1;
    
    /**
     * constante d'entier qui definit la largeur d'une case dans le tableau affichant graphiquement la basse
     */
    public static final int PIANO_CELL_WIDTH=75;
    /**
     * constante d'entier qui definit la hauteur d'une case dans le tableau affichant graphiquement la basse
     */
    public static final int PIANO_CELL_HEIGHT=180;
    
     /**
     *constante qui definit les images correspondant a chaque case de la basse
     */
    public static final String[][] PIANO_IMAGES={
    {BLANCHE_DIESE, NOIRE, BLANCHE, NOIRE, BLANCHE_BEMOL, BLANCHE_DIESE, NOIRE, BLANCHE, NOIRE, BLANCHE, NOIRE, BLANCHE_BEMOL, BLANCHE_DIESE}};
    
    /**
     * constructeur de base sans parametres, affichage des dieses
     */
    public Piano() {
        super(LIGNE_PIANO, NB_TOUCHES);
        this.init_instrum(null);
    }

    /**
     * constructeur de base sans parametres, affichage des dieses
     * @param Gamme gamme
     */
    public Piano(Gamme gamme) {
        super(LIGNE_PIANO, NB_TOUCHES);
        this.init_instrum(null);
        this.ajuste_note_instrum(gamme);
        this.gamme_on_instrum(gamme);
    }

    @Override
    public void init_instrum(String tunning) {
       //on cree un tableau de Note de longueur NB_TOUCHEs
        for (int l = 0; l < this.ligne_instrum; l++) {
            for (int i = 0; i < this.taille_instrum; i++) {
                //on cree une nouvelle note en fonction la gamme chromatique
                double ton = (i / 2.0) % Note.TONS_OCTAVE;
                Note note = new Note(Gamme.CHROMATIQUE_DO.get(ton).get(0));
                this.notes_instrum[l][i] = note;
                //on insere cette nouvelle note a notes_instrum en veillant a faire des modulo
            }
        }
         this.instrument_cell_width=PIANO_CELL_WIDTH;
        this.instrument_cell_height=PIANO_CELL_HEIGHT;
        this.instrument_images=PIANO_IMAGES;
    }

    @Override
    public void set_tunning() {
      this.tunning=null;
    }

    
    
    @Override
    public String toString() {
        return "----------- Piano ---------\n" + super.toString();
    }

    
   

    public static void main(String args[]) {
        Gamme g = new Gamme("G", "MAJEUR");
        Piano p = new Piano(g);
//        Piano p=new Piano();
        System.out.println(p);
    }

}
