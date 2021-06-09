package LPDLT ;
import LPDLT.IHM.FrameJeu;
import LPDLT.Metier.Architecte;
import LPDLT.Metier.ArbitrePlateau;
import LPDLT.Metier.Parterre;
import LPDLT.Metier.Dalle ;
import LPDLT.Metier.Pilier ;
import iut.algo.Clavier;

public class Controleur {

    public Controleur(int mode)
    {
        Architecte joueur1 = new Architecte("gris");
        Architecte joueur2 = new Architecte("maron");
        Architecte joueurActif = joueur1 ;
        
        ArbitrePlateau metier = new ArbitrePlateau(this) ;

        while (!joueur1.gagner() && !joueur2.gagner())
        {
            System.out.println( metier.toString());

            //inversement des joueur a la mi-temps
            if (joueurActif == joueur1){
                joueurActif = joueur2 ;
            }
            else{
                joueurActif = joueur1 ;
            }

            System.out.println("Au "+joueurActif.toString()+" de jouer !");


            System.out.println("Sur quelle dalle voulez vous poser un pilier[A-P] ? ");
            
            char lettreDalle = Character.toUpperCase(Clavier.lire_char());

            System.out.println("Sur quel sommet voulez vous jouer de [0-5] ?");

            int numSommet = Clavier.lire_int();

            System.out.println("Construction du pilier !");
            
            metier.ajouterPilier(lettreDalle, numSommet, joueurActif.getCouleur());

            FrameJeu IHM    = new FrameJeu(this, Dalle.ensembleDalle, Pilier.ensemblePilier);
        }
        /*
        condition de fin comme R4
            metier.getAction(joueurActif.getAction());
            metier.toString();*/


    }
    public static void main(String[] args) {
        new Controleur(0);
    }
}