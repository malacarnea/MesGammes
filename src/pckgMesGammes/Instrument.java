package pckgMesGammes;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.Map;
import javax.swing.JTable;

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
     * attribut a initialiser dans la méthode init des classes filles
     * donne la largeur d'une cellule du tableau affichant l'instrument
     */
     protected int instrument_cell_width;
     
     /**
     * attribut a initialiser dans la méthode init des classes filles
     * donne la hauteur d'une cellule du tableau affichant l'instrument
     */
     protected int instrument_cell_height;
     
     /**
     * attribut a initialiser dans la méthode init des classes filles
     * tableau d'adresse des fichiers representant graphiquement l'instrument
     */
     protected String[][] instrument_images;
    
    /**
     * coonstante qui definit la liste des instruments disponibles
     */
    public static final String[] INTRUMENTS={"Piano", "Guitare", "Basse"};
    
    
     /**
     * constante qui donne l'image de la tete de la guitare/basse
     */
    public static final String TETE="/pckgMesGammes/img/tete.png";
    /**
     * constante qui donne l'image d'une corde normale
     */
    public static final String CORDE="/pckgMesGammes/img/GuitareString.png";
    /**
     * constante qui donne le chemin de l'image du clou entier sur la guitare/basse
     */
    public static final String CLOU="/pckgMesGammes/img/clou.png";
    /**
     * constante qui donne le chemin de l'image du demi clou haut sur la guitare/basse
     */
    public static final String DEMI_CLOU_UP="/pckgMesGammes/img/clouUp.png";
    /**
     * constante qui donne le chemin de l'image du demi clou bas sur la guitare/basse
     */
    public static final String DEMI_CLOU_DOWN="/pckgMesGammes/img/clouDown.png";
    
   
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

    public Note[][] getNotes_instrum() {
        return notes_instrum;
    }

    public void setNotes_instrum(Note[][] notes_instrum) {
        this.notes_instrum = notes_instrum;
    }

    public Note[][] getGamme_instrum() {
        return gamme_instrum;
    }

    public void setGamme_instrum(Note[][] gamme_instrum) {
        this.gamme_instrum = gamme_instrum;
    }

    public Note[][] getAccord_instrum() {
        return accord_instrum;
    }

    public void setAccord_instrum(Note[][] accord_instrum) {
        this.accord_instrum = accord_instrum;
    }

    public int getLigne_instrum() {
        return ligne_instrum;
    }

    public void setLigne_instrum(int ligne_instrum) {
        this.ligne_instrum = ligne_instrum;
    }

    public int getTaille_instrum() {
        return taille_instrum;
    }

    public void setTaille_instrum(int taille_instrum) {
        this.taille_instrum = taille_instrum;
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
     * @description function qui retourne la note sur le tableau de l'instrument a la position (i, j)
     * @param int i
     * @param int j
     * @return Note
     */
    public Note getNoteAtPos(int i, int j){
        return this.notes_instrum[i][j];
    }
    /**
     * @description function qui retourne la note sur le tableau de gamme de l'instrument a la position (i, j)
     * @param int i
     * @param int j
     * @return Note
     */
    public Note getNoteGammeAtPos(int i, int j){
        return this.gamme_instrum[i][j];
    }
    
     /**
     * @description function qui retourne la note sur le tableau d'accord de l'instrument a la position (i, j)
     * @param int i
     * @param int j
     * @return Note
     */
    public Note getNoteAccordAtPos(int i, int j){
        return this.accord_instrum[i][j];
    }
    /**
     * fonction qui permet d'initialiser une guitare en fonction du tunning
     *
     * @param String tunning
     */
    public abstract void init_instrum(String tunning);
    
     /**
     * @description methode qui permet de dessiner graphiquement une guitare sur le JTable en parametre
     * @param table JTable
     */
    public void drawInstrumentGamme(JTable table) {
        int height = this.instrument_cell_height;
        int width= this.instrument_cell_width;
        InstrumentTableModel model = new InstrumentTableModel(this);
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
                imgCol[j]=this.instrument_images[j][i];
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
