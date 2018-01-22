/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pckgMesGammes;

import javax.swing.table.AbstractTableModel;

/**
 *
 * @author alici
 */
 class InstrumentTableModel extends AbstractTableModel{
    
    private Object[][] data;
    private String[] title;
    private int ligne;
    private int col;
    
    public InstrumentTableModel(Instrument g){
        this.data=new Object[g.getLigne_instrum()][g.getTaille_instrum()];
        this.title=new String[g.getTaille_instrum()];
        this.col=g.getTaille_instrum();
        this.ligne=g.getLigne_instrum();
        for(int i=0; i<g.getLigne_instrum(); i++){
            for(int j=0; j<g.getTaille_instrum(); j++){
                Note note=g.getNoteGammeAtPos(i, j);
                this.data[i][j]=(note!=null)? note.get_nom_e() : 0;
            }
            this.title[i]=String.valueOf(i);
        }
        
        
    }

   


    @Override
    public int getColumnCount() {
        return this.col; //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public int getRowCount() {
        return this.ligne; //To change body of generated methods, choose Tools | Templates.
    }

    public void addColumn(Object columnName, Object[] columnData) {
//        super.addColumn(columnName, columnData); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        return this.data[rowIndex][columnIndex];
    }

    @Override
    public void setValueAt(Object aValue, int rowIndex, int columnIndex) {
        this.data[rowIndex][columnIndex]=aValue; //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Class getColumnClass(int columnIndex) {
        return getValueAt(0, columnIndex).getClass(); //To change body of generated methods, choose Tools | Templates.
    }


    
    
    
}
