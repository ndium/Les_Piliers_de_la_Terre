package LPDLT.Metier ;

public class Architecte
{
    /*----- Attributs -----*/

    // static
    private static int nbJoueurs = 0;

    // non static
    private int numJoueur;

    private String couleur;

    private int nbDalle = 0;
    private int cptPilierDetruit = 0;

    private boolean gagner = false;

    /*----- Constructeur -----*/

    public Architecte(String couleur)
    {
        this.numJoueur = ++Architecte.nbJoueurs;
        this.couleur   = couleur;
    }

    /*----- Getteur -----*/

    public int     getNumJoueur       () { return this.numJoueur;        }
    public int     getNbDalles        () { return this.nbDalle;          }
    public String  getCouleur         () { return this.couleur;          }
    public int     getCptPilierDetruit() { return this.cptPilierDetruit; }
    public boolean gagner          () { return this.gagner;           }

    /*----- Setteur -----*/

    public void ajouterDalle        () { this.nbDalle++;          }
    public void ajouterPilierDetruit() { this.cptPilierDetruit++; }

    /*----- ToString() -----*/

    public String toString()
    {
        return "Joueur " + this.couleur          + ":" +
        "\n Possède "    + this.nbDalle          + " dalle(s)" +
        "\n A détruit "  + this.cptPilierDetruit + " pilier(s)\n";
    }
}