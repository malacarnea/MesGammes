package pckgMesGammes;

class Guitare extends Instrument {
    protected Note[][] notes_guitare;
    protected Note[][] gamme_guitare;
    protected Note[][] accord_guitare;
    public static final int NB_FRETES = 12;
    
//    public get_positions_accord(Accord accord) {
//    }

    @Override
    public void gamme_on_instrum(Gamme gamme) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}
