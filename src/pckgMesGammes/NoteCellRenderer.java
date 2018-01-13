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
     private NoteDrawPanel[] ndp=new NoteDrawPanel[2];
     
     public NoteCellRenderer(Note note, int x){
         this.ndp[0]=new NoteDrawPanel(note.get_couleur(), note.get_nom_fr(), x, 1);         
         this.ndp[1]=new NoteDrawPanel(note.get_couleur(), note.get_nom_e(), x, 1); 
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
