package equipe_25 ;

import equipe_25.IHM.FrameJeu;
import equipe_25.Metier.Architecte;
import equipe_25.Metier.ArbitrePlateau;
import equipe_25.Metier.Parterre;
import equipe_25.Metier.Dalle ;
import equipe_25.Metier.Pilier ;
import iut.algo.Clavier;

public class Controleur
{

    /*----- Attributs -----*/
    Architecte joueur1;

    Architecte joueur2;

    Architecte gagnant = null; // Par défaut, aucun joueur n'est gagnant

    Architecte joueurActif;

    /*--------Input-------*/
    int  numSommet   = 7;   // Un sommet qui ne peut pas exister

    char lettreDalle = 'Q'; // Une lettre qui ne peut pas exister

    int tour = 0; // Initialisation du compteur de tour à 0

    /*----------MVC----------*/
    ArbitrePlateau metier;

    FrameJeu IHM;

    boolean continueJeu = true;

	/*---------Constructeur----------*/

    public Controleur(int mode)
    {
        /*----------Instanciation----------*/
        this.joueur1     = new Architecte("gris" ,this);
        this.joueur2     = new Architecte("maron",this);
        this.joueurActif = joueur1;
        
        this.metier = new ArbitrePlateau(this);

        if (mode == 1) this.IHM = new FrameJeu( this, Dalle.ensembleDalle, Pilier.ensemblePilier ,joueurActif);
        
        /*-----JEU-----*/
        while ( continueJeu )
        {
            if ( joueurActif == joueur1 ) { tour++; } // Augmentation du tour quand on retombe sur le joueur 1
            
            System.out.println( "---------- Tour n°" + tour + " ----------" );

            //cas d'erreur
            do
            {
                maj();

                // Annonce du joueur actif + demande de dalle sur laquelle jouer
                System.out.println( "Joueur " + joueurActif.getCouleur() + ", sur quelle dalle voulez-vous poser un pilier ? [A-P]" );
                lettreDalle = Character.toUpperCase( Clavier.lire_char() );

                // Demande du sommet de la dalle sur lequel on veut jouer
                System.out.println( "\nSur quel sommet voulez vous jouer de [0-5] ?" );
                numSommet = Clavier.lire_int();
                
            }
            while ( !( jouer( lettreDalle, numSommet, joueurActif.getCouleur() ) ) );
            
            System.out.println( "\nPilier construit !! Il en reste " + Pilier.cptPilierPose + " à poser." );
        }
    }

    //a chaque fois que l'on va jouer correctement cela echangera les joueurs
    //il y a un doublon de methodes car avec la souris on doit utiliser les coordonnées
    public boolean jouer(char dalle, int index, String couleur)
    {
        if (metier.ajouterPilier( lettreDalle, numSommet, joueurActif.getCouleur() ))
        {
            changerJoueur() ;
            return true ;
        }
        else 
            return false ;

    }

    public boolean jouer(int x , int y , String couleur)
    {
        if (metier.ajouterPilier( x, y, joueurActif.getCouleur() ))
        {
            changerJoueur() ;
            return true ;
        }
        else 
            return false ;
    }

    public void maj()
    {
        IHM.maj();
    }

    public void afficherScore()
    {
        System.out.println("gagner");
    }

    public void changerJoueur()
    {
        //invertion des joueurs
        if ( joueurActif == joueur1 ) { joueurActif = joueur2; }
        else                          { joueurActif = joueur1; }
    }

    public Architecte getJoueurActif()
    {
        return this.joueurActif ;
    }

    /*------------*/
    /*    Main    */
    /*------------*/

    public static void main(String[] args) {
        new Controleur( 1 );
    }
}