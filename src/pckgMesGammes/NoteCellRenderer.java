/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pckgMesGammes;

import java.awt.Color;
import java.awt.Component;
import javax.swing.JTable;
import javax.swing.table.DefaultTableCellRenderer;

/**
 *
 * @author alicia
 */
 class NoteCellRenderer extends DefaultTableCellRenderer{
     /**
      * tableau de NoteDrawPanel de 2 lignes (français, anglais) ou on retient les dessins de note pour une colonne
      * pour l'affichage des notes d'une gamme
      */
     private NoteDrawPanel[] ndp;
     
     /**
      * constructeur utilise pour le tableau affichant la gamme cree un tableau de deux entrees 
      * Note graphique (dessin de rond avec texte) en français et anglais
      * @param note Note
      * @param x int
      */
     public NoteCellRenderer(Note note, int width, int height){
         ndp=new NoteDrawPanel[2];
         this.ndp[0]=new NoteDrawPanel(note.get_couleur(), note.get_nom_fr(), width, height, null);         
         this.ndp[1]=new NoteDrawPanel(note.get_couleur(), note.get_nom_e(), width, height, null); 
     }
     
      /**
      * constructeur utilise pour le tableau affichant les notes sur un instrument
      * le tableau de notes contient toutes les notes d'une colonne
      * @param notes Note[]
      * @param x int
      * @param taille
      */
     public NoteCellRenderer(Note[] notes, int width, int height, int taille, String[] images){
         ndp=new NoteDrawPanel[taille];
         for(int i=0; i<taille; i++){
             Color c=(notes[i]!=null)?notes[i].get_couleur():null;
             String en=(notes[i]!=null)?notes[i].get_nom_e():null;
             this.ndp[i]=new NoteDrawPanel(c,en , width, height, images[i]);  
         }
     }
     
      public NoteDrawPanel[] getNdp() {
        return ndp;
    }

    public void setNote(NoteDrawPanel[] ndp) {
        this.ndp = ndp;
    }
    @Override
    public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus, int row, int column) {
        super.getTableCellRendererComponent(table, value, isSelected, hasFocus, row, column);
        
        //on retourne le dessin de la note en fonction de la ligne
        return ndp[row];
    }
}
