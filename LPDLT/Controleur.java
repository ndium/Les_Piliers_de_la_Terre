package LPDLT ;
import LPDLT.IHM.FrameJeu;

public class Controleur {

    public Controleur(){
        new FrameJeu(this);
    }
    public static void main(String[] args) {
        new Controleur();
    }
}