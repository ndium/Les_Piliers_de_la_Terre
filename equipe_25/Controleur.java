package equipe_25 ;

import iut.algo.Clavier;
import equipe_25.IHM.FrameJeu;
import equipe_25.Metier.Jeu ;
import equipe_25.Metier.Dalle ;
import equipe_25.Metier.Pilier ;
import equipe_25.Metier.Architecte;

public class Controleur implements java.io.Serializable
{
    Jeu metier ;
    FrameJeu IHM ;

    public Controleur(int mode,int scenario)
    {
        this.metier = new Jeu(this, mode, scenario);
        if (mode == 1) {this.IHM    = new FrameJeu( this, Dalle.getEnsembleDalle() , Pilier.getEnsemblePilier() );}
    }

    public void maj()
    {
        this.IHM.maj();
        this.metier.maj();
    }

    public void       fermerIHM        ()                             { IHM.fermer()                            ;}

    public boolean    jouer            (int x, int y, String couleur ){ return this.metier.jouer(x,y,couleur)   ;}

    public Architecte getJoueur        (String couleur)               { return this.metier.getJoueur(couleur)        ;}

    public Architecte getJoueurActif   ()                             { return this.metier.getJoueurActif()          ;}

    public Architecte getJoueurAdverse ( String couleur )             { return this.metier.getJoueur(couleur)        ;}

    public int        getTour          ()                             { return this.metier.getTour()                 ;}

    public void       afficherScore    ()                             { this.metier.afficherScore()                  ;}

    public void       setMetier        (Jeu metier)                   { this.metier = metier                    ;}

    public Jeu        getMetier        ()                             { return this.metier                      ;}


    /*------------*/
    /*    Main    */
    /*------------*/

    public static void main( String[] args ) 
    {
        System.out.println( "Voulez vous en mode GUI, CUI ou? \nG|C|S" );

        char reponse = Character.toUpperCase( Clavier.lire_char() ) ;

        if (reponse == 'G')
        {
            new Controleur(1,0);
        }

        if (reponse == 'C')
        {
            new Controleur(2,0);
        }

        if (reponse == 'S')
        {
            System.out.println( "Quel scenario vouler vous ?" );

            new Controleur(3, Clavier.lire_int());
        }
    }
}