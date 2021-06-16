package equipe_25.Metier ;

import iut.algo.Clavier;
import equipe_25.Controleur ;
import equipe_25.Metier.Architecte;
import equipe_25.Metier.ArbitrePlateau;
import equipe_25.Metier.Parterre;
import equipe_25.Metier.Dalle ;
import equipe_25.Metier.Pilier ;

public class Jeu
{
    /*-----------------*/
    /*    Attributs    */
    /*-----------------*/

    Architecte joueur1;

    Architecte joueur2;

    Architecte gagnant = null; // Par défaut, aucun joueur n'est gagnant

    Architecte joueurActif;

    Controleur ctrl ;

    /*--------------*/
    /*    inputs    */
    /*--------------*/

    int  numSommet   = 7;   // Un sommet qui ne peut pas exister

    char lettreDalle = 'Q'; // Une lettre qui ne peut pas exister

    int tour = 0; // Initialisation du compteur de tour à 0

    /*-----------*/
    /*    MVC    */
    /*-----------*/

    ArbitrePlateau metier;

    boolean continueJeu = true;

	/*--------------------*/
    /*    Constructeur    */
    /*--------------------*/

    /*
    ->mode 0 CUI
    ->mode 1 GUI
    ->mode 2 Scenario
     */

    public Jeu(Controleur ctrl,int mode, int numScenario)
    {
        /*----- Instanciation -----*/
        this.ctrl        = ctrl ;
        this.joueur1     = new Architecte("gris"  ,ctrl);
        this.joueur2     = new Architecte("marron",ctrl);
        this.joueurActif = this.joueur1;
        
        this.metier = new ArbitrePlateau(ctrl);

        //IHM
        if (mode == 1) 
        {
            if ( this.joueurActif == this.joueur1 ) { this.tour++; }
        }

        //lecture scenario
        if (mode == 3)
        {
            LectureScenario.lireScenario(numScenario);
        }
        
        /*-----JEU-----*/
        //si le mode n'est pas IHM
        if (mode != 1 )
        {
            while ( this.continueJeu )
            {
                // Augmentation du tour quand on retombe sur le joueur 1
                if ( this.joueurActif == this.joueur1 ) { this.tour++; }
                System.out.println( "---------- Tour n°" + this.tour + " ----------" );

                //cas d'erreur
                do
                {
                    System.out.println( "Joueur " + this.joueurActif.getCouleur() + ", sur quelle dalle voulez-vous poser un pilier ? [A-P]" );
                    if (mode == 2)
                    {
                        this.lettreDalle = Character.toUpperCase( Clavier.lire_char() );
                    }
                    else
                    {
                        if (!LectureScenario.estTerminer())
                            this.numSommet = Character.getNumericValue(LectureScenario.getActionSuivante());
                        else
                            this.numSommet = Clavier.lire_int();
                    }
    
                    System.out.println( "\nSur quel sommet voulez vous jouer de [0-5] ?" );
                    if( mode == 2 )
                    {
                        this.numSommet = Clavier.lire_int();
                    }
                    else
                    {
                        if (!LectureScenario.estTerminer())
                            this.numSommet = Character.getNumericValue(LectureScenario.getActionSuivante());
                        else
                            this.numSommet = Clavier.lire_int();
                    }
                    System.out.println("");
                    this.afficherScore();
                    System.out.println("");
                    this.verificationFinJeu();
                }
                while (  this.jouer( this.lettreDalle, this.numSommet, this.joueurActif.getCouleur()  ) );
    
            }
            this.scoreFinal();
        }
    }

    /*----------------*/
    /*    Getteurs    */
    /*----------------*/

    public Architecte getJoueur( String couleur )
    {
        if( couleur.equals( this.joueur1.getCouleur() ) )
        {
            return this.joueur1 ;
        }
        else
        {
            return this.joueur2 ;
        }
    }

    public Architecte getJoueurActif()
    {
        return this.joueurActif ;
    }

    public Architecte getJoueurAdverse( String couleur )
    {
        if( couleur.equals( this.joueur1.getCouleur() ) )
        {
            return this.joueur2 ;
        }
        else
        {
            return this.joueur1 ;
        }
    }

    public int getTour()
    {
        return this.tour ;
    }
    
    /*----------------*/
    /*    Setteurs    */
    /*----------------*/

    public void changerJoueur()
    {
        if ( this.joueurActif == this.joueur1 ) { this.joueurActif = this.joueur2; }
        else                                    { this.joueurActif = this.joueur1; }
    }

    /*-----------*/
    /*    Jeu    */
    /*-----------*/

    //a chaque fois que l'on va jouer correctement cela echangera les joueurs
    //il y a un doublon de methodes car avec la souris on doit utiliser les coordonnées
    public boolean jouer( char dalle, int index, String couleur )
    {
        if ( this.metier.ajouterPilier( this.lettreDalle, this.numSommet, this.joueurActif.getCouleur() ) )
        {
            this.changerJoueur();
            return true;
        }
        else 
            return false;
    }

    public boolean jouer( int x, int y, String couleur )
    {
        if ( this.metier.ajouterPilier( x, y, this.joueurActif.getCouleur() ) )
        {
            this.changerJoueur() ;
            return true ;
        }
        else 
            return false ;
    }

    public void maj()
    {

        System.out.println( "---------- Tour n°" + this.tour + " ----------" );
        this.afficherScore();
        this.verificationFinJeu();
        if ( this.joueurActif == this.joueur1 ) { this.tour++; }
        if (!continueJeu)
        {this.scoreFinal();}
    }

    /*-----------------*/
    /*    Affichage    */
    /*-----------------*/

    public void scoreFinal()
    {
        String txt = "";

        if( this.gagnant == null ) { txt = "Egalité parfaite !";                                     }
        else                       { txt = "Victoire du joueur " + this.gagnant.getCouleur() + " !"; }

        System.out.println( txt );
        System.exit(0);
    }
    
    public void afficherScore()
    {
        System.out.println( "Le joueur " + this.joueur1.getCouleur() + " a detruit " + this.joueur1.getNbPilierDetruit() + " piliers" );
        System.out.println( "Le joueur " + this.joueur2.getCouleur() + " a detruit " + this.joueur2.getNbPilierDetruit() + " piliers" );

        System.out.println( "Le joueur " + this.joueur1.getCouleur() + " possède " + this.joueur1.getNbDalle() + " dalles" );
        System.out.println( "Le joueur " + this.joueur2.getCouleur() + " possède " + this.joueur2.getNbDalle() + " dalles" );
        
        System.out.println( "\nPilier construit !! Il en reste " + Pilier.cptPilierPose + " à poser." );
    }

    /*R4
    Fin de Jeu et décompte
    - Si un Architecte possède 9 Dalle, à un moment de la partie, il l’emporte
    immédiatement.
    - Lorsque les Architectes ont construit 24 Piliers, l’Architecte contrôlant
    le plus de Dalles l’emporte
    R4 en cas d’égalité, l’Architecte ayant détruit le plus de Pilier l’emporte*/

    public void verificationFinJeu()
    {
        // Vérification du nombre de Dalle de chaque joueur
        if( this.joueur1.getNbDalle() >= 9 ) { this.continueJeu = false; this.gagnant = this.joueur1; ctrl.fermerIHM();}
        if( this.joueur2.getNbDalle() >= 9 ) { this.continueJeu = false; this.gagnant = this.joueur2; ctrl.fermerIHM();}

        // Vérification du nombre de Piliers construits
        if( Pilier.cptPilierPose <= 0 )
        {
            this.continueJeu = false;
            ctrl.fermerIHM();
            
            // Contrôle du joueur qui a le plus de dalle
            if( this.joueur1.getNbDalle() > this.joueur2.getNbDalle() ) { this.gagnant = this.joueur1; } // Cas où le joueur1 a le plus de Dalles
            else
            {
                if( this.joueur1.getNbDalle() < this.joueur2.getNbDalle() ) { this.gagnant = this.joueur2; } // Cas où le joueur2 a le plus de Dalles
                else // Cas d'égalité en nombre de Dalles possédées
                {
                    if( this.joueur1.getNbPilierDetruit() > this.joueur2.getNbPilierDetruit() ) { this.gagnant = this.joueur1; } // Cas où le joueur1 a détruit le plus de Piliers
                    else
                    {
                        if( this.joueur1.getNbPilierDetruit() < this.joueur2.getNbPilierDetruit() ) { this.gagnant = this.joueur2; } // Cas où le joueur2 a détruit le plus de Piliers
                    }
                }
            } // Si à la fin de cette boucle ( this.continueJeu == true ) mais ( this.gagnant == null ), c'est qu'il y a égalité parfaite
        }
    }
}