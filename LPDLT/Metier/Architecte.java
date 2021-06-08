package PDLT.Metier ;

public class Architecte
{
    private static int nbJoueurs = 0;
    private int numJoueur;
    
    private String couleur;

    private int nbDalles = 0;

    public Architecte(String couleur)
    {
        this.numJoueur = ++Architecte.nbJoueurs;
        this.couleur = couleur;
    }

    public int    getNumJoueur() { return this.numJoueur; }
    public int    getNbDalles () { return this.nbDalles;  }
    public String getCouleur  () { return this.couleur;   }

    public void ajouterDalle() { this.nbDalles++; }
}