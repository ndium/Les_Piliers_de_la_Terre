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
        Architecte joueurActif = joueur1;

        int  numSommet   = 7;   // Un sommet qui ne peut pas exister
        char lettreDalle = 'Q'; // Une lettre qui ne peut pas exister
        
        ArbitrePlateau metier = new ArbitrePlateau(this);

        FrameJeu IHM = new FrameJeu( this, Dalle.ensembleDalle, Pilier.ensemblePilier );
        
        while ( !joueur1.gagner() && !joueur2.gagner() )// && Pilier.nbPilierMax > 0)
        {
            System.out.println( metier.toString() );

            //inversement des joueurs
            if ( joueurActif == joueur1 ) { joueurActif = joueur2; }
            else                          { joueurActif = joueur1; }

            do
            { 
                IHM.maj();

                // Annonce du joueur actif + demande de dalle sur laquelle jouer
                System.out.println( "Joueur " + joueurActif.getCouleur() + ", sur quelle dalle voulez-vous poser un pilier ? [A-P]" );
                lettreDalle = Character.toUpperCase( Clavier.lire_char() );

                // Demande du sommet de la dalle sur lequel on veut jouer
                System.out.println( "\nSur quel sommet voulez vous jouer de [0-5] ?" );
                numSommet = Clavier.lire_int();
            } 
            while ( !( metier.ajouterPilier( lettreDalle, numSommet, joueurActif.getCouleur() ) ) );//&& Pilier.nbPilierMax > 0 ) );
            
            System.out.println( "\nPilier construit !!" );
        }
        /*
        condition de fin comme R4
            metier.getAction(joueurActif.getAction());
            metier.toString();*/


    }
    public static void main(String[] args) {
        new Controleur( 0 );
    }
}