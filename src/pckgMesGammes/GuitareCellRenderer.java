/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pckgMesGammes;

import java.awt.Component;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JTable;
import javax.swing.table.TableCellRenderer;

/**
 *
 * @author alici
 */
public class GuitareCellRenderer extends JLabel implements TableCellRenderer{
    JLabel label = new JLabel();
    @Override
    public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus, int row, int column) {
        System.out.println("GuitareCellRenderer");
        
        label.setIcon(new ImageIcon("img/GuitareString.png"));
        
        return label;
    }
    
}
