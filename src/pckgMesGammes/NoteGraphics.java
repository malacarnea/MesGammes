/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pckgMesGammes;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import javax.swing.JLabel;

/**
 *
 * @author alici
 */
public class NoteGraphics extends JLabel {
  
    private String txt="";
    private Color couleur=null;
    private int posX = 0;
    private int posY = 0;
    public static final int RAYON = 23;
    /**
     * Creates new form NoteDrawPanel
     * @param couleur
     * @param str
     * @param x
     * @param y
     */
    public NoteGraphics(Color couleur, String str, int x, int y){
        this.txt=str;
        this.couleur=couleur;
        this.posX=x;
        this.posY=y;
       
        initComponents();
    }

    public String getTxt() {
        return txt;
    }

    public void setTxt(String txt) {
        this.txt = txt;
    }

    public Color getCouleur() {
        return couleur;
    }

    public void setCouleur(Color couleur) {
        this.couleur = couleur;
    }

    public int getPosX() {
        return posX;
    }

    public void setPosX(int posX) {
        this.posX = posX;
    }

    public int getPosY() {
        return posY;
    }

    public void setPosY(int posY) {
        this.posY = posY;
    }

    @Override
    public void paintComponent(Graphics g) {
        //pas oublier le composant parent sinon ça le cache et on a un fond blanc tres moche
        super.paintComponent(g);
         g.setColor(Color.BLACK);
        g.drawOval(posX, posY, RAYON, RAYON);
        // On redéfinit une couleur pour notre rond
        g.setColor(this.couleur);
        // On le dessine aux coordonnées souhaitées
        g.fillOval(posX, posY, RAYON, RAYON);
        // On redéfinit une couleur pour le texte
        //si rond foncé, texte blanc et inversement
        g.setColor(this.couleurOpposee());
        //calculer la position du texte en fonction du nombre de caracteres de la note
        int length=txt.length();
        Font f = new Font ("Sanserif", Font.BOLD, 11);
        g.setFont (f);
        g.drawString(txt, posX+(RAYON/2-length), 15);
    }
    
    /**
     * fonction qui renvoie la couleur inverse de l'attribut couleur
     * pour un affichage clair du texte
     * @return Color
     */
    public Color couleurOpposee(){
        int blue=this.couleur.getBlue();
        int red=this.couleur.getRed();
        int green=this.couleur.getGreen();
        if(red==blue&& red==green && red>0&&red<255){
            blue=red=green=0;
        }
        return new Color(255-red, 255-green, 255-blue);
    }
    
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">                          
    private void initComponents() {

        setBorder(javax.swing.BorderFactory.createEtchedBorder());

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 70, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 13, Short.MAX_VALUE)
        );
    }// </editor-fold>                        


    // Variables declaration - do not modify                     
    // End of variables declaration                   
}