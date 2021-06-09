package LPDLT ;
import LPDLT.IHM.FrameJeu;
import LPDLT.Metier.Architecte;
import LPDLT.Metier.Parterre;
import LPDLT.Metier.Dalle ;
import LPDLT.Metier.Pilier ;
import iut.algo.Clavier;

public class Controleur {

    public Controleur(int mode)
    {
        Architecte joueur1 = new Architecte("Noir");
        Architecte joueur2 = new Architecte("Maron");
        boolean AuJoueur1DeJouer = true;
        
        //mode CUI
        if (mode == 0){
            
        }
        Parterre   metier = new Parterre() ;
        FrameJeu   IHM    = new FrameJeu(this,Dalle.ensembleDalle,Pilier.ensemblePilier);
        
        System.out.println( metier.toString());
       
        /*
        while (!Joueur1.gagner() || !Joueur2.gagner()){

            if (AuJoueur1DeJouer == true)
            {
                System.out.println("Au joueur 1 de jouer !");

                System.out.println("Sur quelle dalle voulez vous poser un pilier ? ");
                char lettreDalle = Clavier.lire_char();

                System.out.println("Sur quel sommet voulez vous jouer de 0 à 5 ?");
                int numSommet = Clavier.lire_int();

                System.out.println("Construction du pilier !");

                AuJoueur1DeJouer = false;
            }
            else
            {
                System.out.println("Au joueur 2 de jouer !");

                System.out.println("Sur quelle dalle voulez vous poser un pilier ? ");
                char lettreDalle = Clavier.lire_char();

                System.out.println("Sur quel sommet voulez vous jouer de 0 à 5 ?");
                int numSommet = Clavier.lire_int();

                System.out.println("Construction du pilier !");

                AuJoueur1DeJouer = true;               
            }

            metier.getAction(joueurActif.getAction());
            metier.toString();
        }*/

    }
    public static void main(String[] args) {
        new Controleur(0);
    }
}