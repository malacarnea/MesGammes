/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pckgMesGammes;

import java.awt.Color;
import java.util.Iterator;
import java.util.Map.Entry;
import javax.swing.table.TableColumn;

/**
 *
 * @author alicia
 */
public class GUI_Gamme extends javax.swing.JFrame {
    /**
     *@description Gamme utilisee dans l'interface
     */
    private Gamme gamme;
    /**
     * constante qui definit la hauteur des cases des tableaux
     */
    public static final int HEIGHT_CELL=30;
    /**
     * constante qui definit la largeur des cases des tableaux
     */
    public static final int WIDTH_CELL=110;
    /**
     * Creates new form SrchGamme
     */
    public GUI_Gamme() {
        initComponents();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        horizontal_separator = new javax.swing.JSeparator();
        jLabel1 = new javax.swing.JLabel();
        btRechercheNote = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tableauGamme = new javax.swing.JTable();
        btRetour = new javax.swing.JButton();
        labelTabGamme = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        cbInstrument = new javax.swing.JComboBox<>();
        btInstrument = new javax.swing.JButton();
        panelInstrument = new javax.swing.JPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        jTableInstrument = new javax.swing.JTable();
        jPanel1 = new javax.swing.JPanel();
        jLabel5 = new javax.swing.JLabel();
        cbMode = new javax.swing.JComboBox<>();
        jPanel2 = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        cbNote = new javax.swing.JComboBox<>();
        vertical_separator = new javax.swing.JSeparator();
        jLabel4 = new javax.swing.JLabel();
        cbDiese = new javax.swing.JComboBox<>();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setBackground(null);

        jLabel1.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel1.setText("Rechercher une gamme avec une note ou avec les dièses/bémols:");

        btRechercheNote.setText("Rechercher");
        btRechercheNote.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btRechercheNoteActionPerformed(evt);
            }
        });

        jLabel2.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N

        tableauGamme.setBackground(null);
        tableauGamme.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        tableauGamme.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {"Nom français", null, null, null, null, null, null, null},
                {"Nom anglais", null, null, null, null, null, null, null}
            },
            new String [] {
                "", "Degré I", "Degré II", "Degré III", "Degré IV", "Degré V", "Degré VI", "Degré VII"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Object.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tableauGamme.setAutoscrolls(false);
        tableauGamme.setEnabled(false);
        tableauGamme.setMaximumSize(new java.awt.Dimension(2147483647, 60));
        tableauGamme.setMinimumSize(new java.awt.Dimension(120, 60));
        tableauGamme.setPreferredSize(new java.awt.Dimension(600, 60));
        tableauGamme.setRowHeight(30);
        jScrollPane1.setViewportView(tableauGamme);
        if (tableauGamme.getColumnModel().getColumnCount() > 0) {
            tableauGamme.getColumnModel().getColumn(0).setHeaderValue("");
            tableauGamme.getColumnModel().getColumn(1).setHeaderValue("Degré I");
            tableauGamme.getColumnModel().getColumn(2).setHeaderValue("Degré II");
            tableauGamme.getColumnModel().getColumn(3).setHeaderValue("Degré III");
            tableauGamme.getColumnModel().getColumn(4).setHeaderValue("Degré IV");
            tableauGamme.getColumnModel().getColumn(5).setHeaderValue("Degré V");
            tableauGamme.getColumnModel().getColumn(6).setHeaderValue("Degré VI");
            tableauGamme.getColumnModel().getColumn(7).setHeaderValue("Degré VII");
        }

        btRetour.setText("Retour");
        btRetour.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btRetourActionPerformed(evt);
            }
        });

        labelTabGamme.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N

        jLabel6.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel6.setText("Gamme sur instrument :");

        cbInstrument.setModel(new javax.swing.DefaultComboBoxModel<>(Instrument.INTRUMENTS));
        cbInstrument.setEnabled(false);

        btInstrument.setText("Afficher");
        btInstrument.setEnabled(false);
        btInstrument.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btInstrumentActionPerformed(evt);
            }
        });

        jTableInstrument.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jTableInstrument.setRowHeight(30);
        jTableInstrument.setTableHeader(null);
        jTableInstrument.setVisible(false);
        jScrollPane2.setViewportView(jTableInstrument);
        jTableInstrument.getAccessibleContext().setAccessibleParent(panelInstrument);

        javax.swing.GroupLayout panelInstrumentLayout = new javax.swing.GroupLayout(panelInstrument);
        panelInstrument.setLayout(panelInstrumentLayout);
        panelInstrumentLayout.setHorizontalGroup(
            panelInstrumentLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane2, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 892, Short.MAX_VALUE)
        );
        panelInstrumentLayout.setVerticalGroup(
            panelInstrumentLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelInstrumentLayout.createSequentialGroup()
                .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 189, Short.MAX_VALUE)
                .addContainerGap())
        );

        jPanel1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(153, 153, 153)));

        jLabel5.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel5.setText("Sélectionner un mode :");

        cbMode.setModel(new javax.swing.DefaultComboBoxModel<>(Gamme.modes_gamme()));
        cbMode.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbModeActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(274, 274, 274)
                .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 177, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(110, 110, 110)
                .addComponent(cbMode, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(17, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(cbMode, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(14, 14, 14))
        );

        jPanel2.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(153, 153, 153)));

        jLabel3.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel3.setText("Sélectionner une note :");

        cbNote.setModel(new javax.swing.DefaultComboBoxModel<>(this.getCbNotes()));
        cbNote.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbNoteActionPerformed(evt);
            }
        });

        vertical_separator.setOrientation(javax.swing.SwingConstants.VERTICAL);

        jLabel4.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel4.setText("Sélectionner un nombre de dièses/bémols :");

        cbDiese.setModel(new javax.swing.DefaultComboBoxModel<>( Gamme.armures_choices()));
        cbDiese.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbDieseActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap(50, Short.MAX_VALUE)
                .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 152, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(83, 83, 83)
                .addComponent(cbNote, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(102, 102, 102)
                .addComponent(vertical_separator, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 289, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(cbDiese, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(77, 77, 77))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(15, 15, 15)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(cbNote, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(0, 0, Short.MAX_VALUE))
            .addComponent(vertical_separator)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addContainerGap(14, Short.MAX_VALUE)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cbDiese, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(14, 14, 14))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(515, 515, 515)
                .addComponent(btRetour, javax.swing.GroupLayout.PREFERRED_SIZE, 113, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(btRechercheNote, javax.swing.GroupLayout.PREFERRED_SIZE, 97, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(520, 520, 520))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(153, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 604, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(209, 209, 209))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 230, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(27, 27, 27)
                        .addComponent(cbInstrument, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(76, 76, 76)
                        .addComponent(btInstrument)
                        .addGap(385, 385, 385))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(jLabel2)
                        .addGap(33, 33, 33))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(labelTabGamme, javax.swing.GroupLayout.PREFERRED_SIZE, 444, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(285, 285, 285))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(horizontal_separator, javax.swing.GroupLayout.PREFERRED_SIZE, 892, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 892, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(panelInstrument, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(139, 139, 139))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(jLabel2))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, Short.MAX_VALUE)
                        .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btRechercheNote, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(horizontal_separator, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(labelTabGamme, javax.swing.GroupLayout.PREFERRED_SIZE, 19, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(26, 26, 26)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cbInstrument, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btInstrument))
                .addGap(18, 18, Short.MAX_VALUE)
                .addComponent(panelInstrument, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(75, 75, 75)
                .addComponent(btRetour, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void cbNoteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbNoteActionPerformed
        // selectionne le bon diese en fonction de la note
        String note_select = (String) cbNote.getSelectedItem();
        String mode = (String) cbMode.getSelectedItem();
        if (note_select != null) {
            Armure armure = (Armure) Gamme.MODES_GAMMES.get(mode).get(note_select);
            String srch = armure.getNb_alte() + " " + armure.getAlteration();
            cbDiese.setSelectedItem(srch);
        }

    }//GEN-LAST:event_cbNoteActionPerformed

    private void btRetourActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btRetourActionPerformed
        new MainMesGammes().setVisible(true);
        this.setVisible(false);
    }//GEN-LAST:event_btRetourActionPerformed

    private void btRechercheNoteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btRechercheNoteActionPerformed
        String note_select = (String) cbNote.getSelectedItem();
        String mode = (String) cbMode.getSelectedItem();
        this.gamme = new Gamme(note_select, mode);
        //afficher nom de la gamme
        String texte = "Gamme de " + gamme.get_fondamentale().get_nom_fr() + " " + mode + " ou " + note_select + " " + mode;
        labelTabGamme.setText(texte);
        //afficher les notes
        Iterator it = gamme.get_notes_gamme().entrySet().iterator();
        while (it.hasNext()) {
            Entry entry = (Entry) it.next();
            String degre = (String) entry.getKey();
            //recuperer les infos de la note
            Note noteInGamme = (Note) entry.getValue();
            String[] notes = {noteInGamme.get_nom_fr(), noteInGamme.get_nom_e()};
            Color c = noteInGamme.get_couleur();
            //model de colonne
            TableColumn colonne = tableauGamme.getColumn(degre);
            int col = colonne.getModelIndex();
            int cellWidth = colonne.getWidth();
            //recuperation info ligne
            int cellHeight=tableauGamme.getRowHeight();
            //modifier les valeurs du tableau
            for (int i = 0; i < notes.length; i++) {
                tableauGamme.setValueAt(notes[i], i, col);
            }
            NoteCellRenderer ncr = new NoteCellRenderer(noteInGamme, cellWidth, cellHeight);
            colonne.setCellRenderer(ncr);
        }
           //activer cb instrument et bouton instrument
           cbInstrument.setEnabled(true);
           btInstrument.setEnabled(true);

    }//GEN-LAST:event_btRechercheNoteActionPerformed

    private void cbModeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbModeActionPerformed
        String mode = (String) cbMode.getSelectedItem();
        cbNote.removeAllItems();
        //remplir le cb des notes
        String[] listeNotes = Gamme.bases_mode(mode);

        for (String note : listeNotes) {
            cbNote.addItem(note);
        }
    }//GEN-LAST:event_cbModeActionPerformed

    private void cbDieseActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbDieseActionPerformed
        // selectionne la bonne note
        String mode = (String) cbMode.getSelectedItem();
        String selected = (String) cbDiese.getSelectedItem();
        String[] split = selected.split(" ");
        int nb = Integer.parseInt(split[0]);
        String alte = split[1];
        //armure a chercher
        Armure armureToSrch = new Armure(alte, nb);
        String note = Gamme.find_note_by_armure(mode, armureToSrch);
        //une fois la note trouvee, on la seletionne
        cbNote.setSelectedItem(note);
    }//GEN-LAST:event_cbDieseActionPerformed

    private void btInstrumentActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btInstrumentActionPerformed
        String select = (String) cbInstrument.getSelectedItem();
        String tunning = "STANDARD";
        Instrument i=null;
        switch (select) {
            case "Guitare":
                i = new Guitare(this.gamme, tunning);
                
                break;
            case "Basse":
                i = new Basse(this.gamme, tunning);
                break;
            default:
                i=new Piano(this.gamme);
        }
        i.drawInstrumentGamme(jTableInstrument);
        System.out.println(panelInstrument.getWidth());
    }//GEN-LAST:event_btInstrumentActionPerformed
    /**
     * fonction qui permet de modifier le contenu de la liste CbNotes en
     * fonction du mode selectionne
     * @return String[]
     */
    public String[] getCbNotes() {
        String mode = "MAJEUR";
        cbNote.removeAllItems();
        //remplir le cb des notes
        String[] listeNotes = Gamme.bases_mode(mode);
        return listeNotes;
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(GUI_Gamme.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(GUI_Gamme.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(GUI_Gamme.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(GUI_Gamme.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new GUI_Gamme().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btInstrument;
    private javax.swing.JButton btRechercheNote;
    private javax.swing.JButton btRetour;
    private javax.swing.JComboBox<String> cbDiese;
    private javax.swing.JComboBox<String> cbInstrument;
    private javax.swing.JComboBox<String> cbMode;
    private javax.swing.JComboBox<String> cbNote;
    private javax.swing.JSeparator horizontal_separator;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTable jTableInstrument;
    private javax.swing.JLabel labelTabGamme;
    private javax.swing.JPanel panelInstrument;
    private javax.swing.JTable tableauGamme;
    private javax.swing.JSeparator vertical_separator;
    // End of variables declaration//GEN-END:variables
}
