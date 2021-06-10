package LPDLT.Metier ;

import java.util.ArrayList;

public class Pilier
{
    /*----Attributs----*/

    private int x;
    private int y;

    private Dalle[] tabDalle = new Dalle[6];

    private String couleur = "neutre";

    public static ArrayList<Pilier> ensemblePilier = new ArrayList<Pilier>();

    /*----Constructeur----*/

    public Pilier(int x, int y)
    {
        this.x = x;
        this.y = y;
    }

    /*----Getteur----*/
    public int getX() { return this.x; }
    public int getY() { return this.y; }
    
    public String getCouleur() { return this.couleur; }

    public Dalle[] getDalle() { return this.tabDalle; }

    /*----Setteur----*/
    public void setCouleur(String couleur) { this.couleur = couleur; }

    /*----toString----*/
    public String toString() { return  this.x + ":" + this.y; }

}