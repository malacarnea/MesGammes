/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pckgMesGammes;

import javax.swing.JTable;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author alici
 */
 class GuitareTableModel extends AbstractTableModel{
    private Guitare guitare;
    private Object[][] data;
    private String[] title;
    
    
    public GuitareTableModel(Guitare g){
        this.guitare=g;
        System.out.println(g);
        this.data=new Object[g.getLigne_instrum()][g.getTaille_instrum()];
        for(int i=0; i<g.getLigne_instrum(); i++){
            for(int j=0; j<g.getTaille_instrum(); j++){
                Note note=g.getNoteGammeAtPos(i, j);
                this.data[i][j]=(note!=null)? note.get_nom_e() : 0;
                System.out.print(this.data[i][j]);
            }
            System.out.println("");
        }
        
        this.title=null;
//        for(int col=1; col<Guitare.NB_FRETES_GUITARE; col++){
//            guitareTable.addColumn(new TableColumn(1, 110, new GuitareCellRenderer(), null));
//        }
//        
////        guitareTable.setAutoCreateRowSorter(true);
////        guitareTable.setDefaultRenderer(GuitareCellRenderer.class, new GuitareCellRenderer());
//        for(int i=0;i<guitareTable.getRowCount(); i++){
//            for(int j =0; j<guitareTable.getColumnCount(); j++){
//                guitareTable.setValueAt(guitare.getNoteGammeAtPos(i, j), i, j);
//            }
//        }
//        this.guitareTable.setVisible(true);
//        System.out.println(this.guitare);
    }

    public Guitare getGuitare() {
        return guitare;
    }

    public void setGuitare(Guitare guitare) {
        this.guitare = guitare;
    }


    @Override
    public int getColumnCount() {
        return this.guitare.getTaille_instrum(); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public int getRowCount() {
        return this.guitare.getLigne_instrum(); //To change body of generated methods, choose Tools | Templates.
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
