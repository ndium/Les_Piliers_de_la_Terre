package LPDLT.Metier ;

public class Architecte
{
    /* --------- */
    /* Attributs */
    /* --------- */

    // attribut static
    private static int nbJoueurs = 0;

    // attribut non static
    private int numJoueur;
    private int nbDalles = 0;
    private int cptPilierDetruit = 0;

    private boolean gagner = false;

    private String couleur;

    /* ------------ */
    /* Constructeur */
    /* ------------ */

    public Architecte(String couleur)
    {
        this.numJoueur = ++Architecte.nbJoueurs;
        this.couleur = couleur;
    }

    /* -------- */
    /* Methodes */
    /* -------- */

    public int    getNumJoueur() { return this.numJoueur; }
    public int    getNbDalles () { return this.nbDalles;  }
    public String getCouleur  () { return this.couleur;   }
    public boolean gagner() { return this.gagner; }

    public void ajouterDalle()         { this.nbDalles++;         }
    public void ajouterPilierDetruit() { this.cptPilierDetruit++; }
    public void ajouterPilier(){}

    public String toString()
    {
        return "Joueur " + this.couleur;
        /*"\n Possède " + this.nbDalles + " dalle(s)" +
        "\n A détruit " + this.cptPilierDetruit + " pilier(s)";*/
    }
}