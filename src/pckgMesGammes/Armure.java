
package pckgMesGammes;

import java.util.Arrays;
import java.util.Objects;

class Armure {
  /**
   * typre d'alteration (bemol ou diese ou becare) {b, #, ?}
   */
  protected String alteration;

  /**
   * nombre d'alterations
   */
  protected int nb_alte;
 /**
   * liste des notes effectivement presentent sur l'armure
   */
  protected String[] armure;
  /**
   * liste de toutes les notes presentent sur l'armure
   */
  public static final String[] NOTES_ARMURE={"F", "C", "G", "D", "A", "E", "B"};
  
  
  /**
   * constructeur 
   * @param String alteration
   * @param int nb
   */
  public Armure(String alteration, int nb){
      this.alteration=alteration;
      this.nb_alte=nb;
      this.construit_vrais_notes();
  }
  
   public String getAlteration() {
        return alteration;
    }

    public void setAlteration(String alteration) {
        this.alteration = alteration;
    }

    public int getNb_alte() {
        return nb_alte;
    }

    public void setNb_alte(int nb_alte) {
        this.nb_alte = nb_alte;
    }

    public String[] getArmure() {
        return armure;
    }

    public void setArmure(String[] armure) {
        this.armure = armure;
    }
    
    /**************************************************************************/
    /**************************** Methodes ************************************/
    /**************************************************************************/
    
    /**
     * fonction qui construit l'armure en fonction du type et du nombre d'alterations
     */
    public final void construit_vrais_notes() {
        this.armure = new String[this.nb_alte];
        switch (this.alteration) {
            case "#":
                for (int i = 0; i < this.nb_alte; i++) {
                    this.armure[i] = NOTES_ARMURE[i]+"#";
                }
                break;
            case "b":
                for (int i = 0; i<this.nb_alte; i++) {
                    this.armure[i] = NOTES_ARMURE[NOTES_ARMURE.length-1-i]+"b";
                }
                break;
        }
    }
    
    /**
     * fonction qui indique si une note est comprise dans une armure
     * @param String note
     * @return boolean 
     */
    public boolean is_in_armure(String note){
        int i=0;
        while(i<this.armure.length&& !this.armure[i].equals(note)){
            i++;
        }
        if(i==this.armure.length){
            return false;
        }
        else{
            return true;
        }
    }
    
    
    @Override
    public String toString(){
        String res="Alte : "+this.alteration+"\n"+
                "Nb : "+this.nb_alte+"\n"+
                "Armure : "+String.join(", ",this.armure);
        return res;
    }
    
   

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 67 * hash + Objects.hashCode(this.alteration);
        hash = 67 * hash + this.nb_alte;
        hash = 67 * hash + Arrays.deepHashCode(this.armure);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Armure other = (Armure) obj;
        if (this.nb_alte != other.nb_alte) {
            return false;
        }
        if (!Objects.equals(this.alteration, other.alteration)) {
            return false;
        }
        if (!Arrays.deepEquals(this.armure, other.armure)) {
            return false;
        }
        return true;
    }
   
     public static void main(String args[]) {
        Armure armure = new Armure("b",3);
        System.err.println(armure);
    }
}
