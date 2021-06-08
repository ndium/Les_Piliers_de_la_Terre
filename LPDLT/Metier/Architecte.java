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

    public void ajouterDalle() { this.nbDalles++; }
    public void ajouterPilier(){}
}