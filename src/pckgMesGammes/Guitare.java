package pckgMesGammes;

import java.util.LinkedHashMap;
import javax.swing.JTable;
import javax.swing.table.TableColumn;

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
    public static final int HEIGHT_CELL_GUITARE=30;
    /**
     * constante qui donne la largeur d'une case dans le tableau
     */
    public static final int WIDTH_CELL_GUITARE=75;
    /**
     * constante qui donne l'image de la tete de la guitare
     */
    public static final String TETE="/pckgMesGammes/img/tete.png";
    /**
     * constante qui donne l'image d'une corde normale
     */
    public static final String CORDE="/pckgMesGammes/img/GuitareString.png";
    /**
     * constante qui donne le chemin de l'image du clou entier sur la guitare
     */
    public static final String CLOU="/pckgMesGammes/img/clou.png";
    /**
     * constante qui donne le chemin de l'image du demi clou haut sur la guitare
     */
    public static final String DEMI_CLOU_UP="/pckgMesGammes/img/clouUp.png";
    /**
     * constante qui donne le chemin de l'image du demi clou bas sur la guitare
     */
    public static final String DEMI_CLOU_DOWN="/pckgMesGammes/img/clouDown.png";
    
    /**
     *constante qui definit les images correspondant a chaque case de la guitare
     */
    public static final String[][] GUITARE_IMAGES={
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
        //on se base sur le tunning standard
        String[] tunning_std = new StringBuilder(TUNNING_GUITARE.get(tunning)).reverse().toString().split(" ");
        //on cree un tableau de Note de longueur NB_FRETES_GUITARE
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
    /**
     * @description methode qui permet de dessiner graphiquement une guitare sur le JTable en parametre
     * @param table JTable
     */
    public void drawGuitareGamme(JTable table) {
        int height = 0, width = 0;
        
        height = HEIGHT_CELL_GUITARE;
        width= WIDTH_CELL_GUITARE;
        GuitareTableModel model = new GuitareTableModel(this);
        table.setModel(model);
        //le but ici, c'est de parcourir le tableau modelisant la guitare en Note
        //on se refere au tableau contenant les images de base de la guitare et on 
        //modifie le CellReferer en fonction de la Note
        //etant donné que le cellReferer fonctionne pour toute une colonne, on regarde simplement les colonnes
        //et on modifira à chaque fois le TableColumn
       
        for( int i=0;i<this.taille_instrum; i++){
            Note[] notesCol=new Note[this.ligne_instrum];
            String[] imgCol=new String[this.ligne_instrum];
            for(int j=0; j<this.ligne_instrum; j++){
                notesCol[j]=this.getNoteGammeAtPos(j, i);
                imgCol[j]=GUITARE_IMAGES[j][i];
            }
               //cellRenderer
               NoteCellRenderer ncr=new NoteCellRenderer(notesCol, width, height, this.ligne_instrum, imgCol);
               table.getColumnModel().getColumn(i).setCellRenderer(ncr);
        }
        
        table.setTableHeader(null);
        //modifier l'hauteur des lignes
        table.setAutoscrolls(false);
        table.setEnabled(false);
        table.setMaximumSize(new java.awt.Dimension(2147483647, height*this.ligne_instrum));
        table.setMinimumSize(new java.awt.Dimension(120, height));
        table.setPreferredSize(new java.awt.Dimension(width, height*this.ligne_instrum));
        table.setRowHeight(height);
        table.setVisible(true);
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
        Guitare g = new Guitare(new Gamme("G", "MAJEUR"),"STANDARD");
        
        System.out.println(g);
        System.out.println(g.getNoteGammeAtPos(4, 1));
    }

}
