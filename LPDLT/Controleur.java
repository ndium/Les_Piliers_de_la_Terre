package LPDLT ;
import LPDLT.IHM.FrameJeu;
import LPDLT.Metier.Architecte;
import LPDLT.Metier.Parterre;

public class Controleur {

    public Controleur(int mode)
    {
        Architecte joueur = new Architecte("vert");
        
        //mode CUI
        if (mode == 0){
            
        }
        Parterre   metier = new Parterre() ;
        System.out.println( metier.toString());
       

        /*
        while (!Joueur1.gagner() || !Joueur2.gagner()){

            if (joueurActif == joueur1)
            {
                joueurActif = joueur2;
            }
            else{
                joueurActif = joueur1;               
            }

            metier.getAction(jourActif.getAction())
            metier.toString();
        }
        */

    }
    public static void main(String[] args) {
        new Controleur(0);
    }
}