package LPDLT ;

import javax.lang.model.util.ElementScanner14;

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

        int tour = 0;
        
        ArbitrePlateau metier = new ArbitrePlateau(this);

        FrameJeu IHM = new FrameJeu( this, Dalle.ensembleDalle, Pilier.ensemblePilier );
        
        while ( !joueur1.gagner() && !joueur2.gagner() )// && Pilier.nbPilierMax > 0)
        {
            System.out.println( metier.toString() );

            if ( joueurActif == joueur1 ) { tour++; }
            System.out.println( "---------- Tour n°" + tour + " ----------" );

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
            
            System.out.println( "\nPilier construit !! Il en reste " + Pilier.nbPilierMax + " à poser." );

            //invertion des joueurs
            if ( joueurActif == joueur1 ) { joueurActif = joueur2; }
            else                          { joueurActif = joueur1; }
        }
        /*
        condition de fin comme R4
            metier.getAction(joueurActif.getAction());
            metier.toString();*/
        
        public void verificationFinJeu()
        {
            // Vérification du nombre de Dalle de chaque joueur
            if( joueur1.getNbDalle() >= 9 ) { arretJeu = true; gagnant = joueur1; }
            if( joueur2.getNbDalle() >= 9 ) { arretJeu = true; gagnant = joueur2; }

            // Vérification du nombre de Piliers construits
            if( Piler.nbPilierConstruit <= 0 )
            {
                arretJeu = true;
                
                // Contrôle du joueur qui a le plus de dalle
                if( joueur1.getNbDalle() > joueur2.getNbDalle() ) { gagnant = joueur1; } // Cas où le joueur1 a le plus de Dalles
                else
                {
                    if( joueur1.getNbDalle() < joueur2.getNbDalle() ) { gagnant = joueur2; } // Cas où le joueur2 a le plus de Dalles
                    else // Cas d'égalité en nombre de Dalles possédées
                    {
                        if( joueur1.getNbPilierDetruit() > joueur2.getNbPilierDetruit() ) { gagnant = joueur1; } // Cas où le joueur1 a détruit le plus de Piliers
                        else
                        {
                            if( joueur1.getNbPilierDetruit() < joueur2.getNbPilierDetruit() ) { gagnant = joueur2; } // Cas où le joueur2 a détruit le plus de Piliers
                        }
                    }
                } // Si à la fin de cette boucle arretJeu == true mais gagnant == null, c'est qu'il y a égalité parfaite
            }
        }
    }
    public static void main(String[] args) {
        new Controleur( 0 );
    }
}