package LPDLT.Metier ;

import java.util.ArrayList ;

public class Pilier
{
    /* -------- */
    /* Attribut */
    /* -------- */

    private String couleur = "neutre";

    private int nbPilier;
    private int posX;
    private int posY;

    public static ArrayList<Dalle>  tabDalle       = new ArrayList<Dalle>();

    public static ArrayList<Pilier> ensemblePilier = new ArrayList<Pilier>();

    /* ------------ */
    /* Constructeur */
    /* ------------ */

    public Pilier(int x, int y)
    {
        this.posX = x;
        this.posY = y;
    }

    public int getX() { return this.posX; }
    public int getY() { return this.posY; }

    public String getCouleur() { return this.couleur; }

    public ArrayList<Dalle> getDalle() { return this.tabDalle; }

    public void setCouleur(String couleur) { this.couleur = couleur; }

    private void destructionPilier ()
    {
        
    }

    public String toString() { return  this.posX + "/" + this.posY; }

}