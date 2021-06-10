package LPDLT.Metier ;

import java.util.ArrayList;

public class Pilier
{
    /*----- Attributs -----*/

    private int x;
    private int y;

    private String couleur = "neutre";

    //private Dalle[] tabDalle = new Dalle[3]; // Tableau contenant les Dalles adjacentes au Pilier

    private Pilier[] tabVoisinPilier = new Pilier[3];

    public static int nbPilierMax = 24; // Nombre de Pilier limite

    public static ArrayList<Pilier> ensemblePilier = new ArrayList<Pilier>(); // ArrayList regroupant tous les Piliers du Parterre

    /*----Constructeur----*/

    public Pilier(int x, int y)
    {
        this.x = x;
        this.y = y;
    }
    
    /*----- Getteur -----*/

    public int    getX()       { return this.x;       }
    public int    getY()       { return this.y;       }
    public String getCouleur() { return this.couleur; }

    public Dalle[] getDalle() { return this.tabDalle; }

    /*----- Setteur -----*/

    public void setCouleur(String couleur)
    {
        this.couleur = couleur;
        if( !this.couleur.equals("neutre") ) // Si le basculement de la couleur donne du maron ou du gris
            nbPilier++;
    }

    public void setVoisinPilier(int index,Pilier p)
    {
        tabVoisinPilier[index] = p ;
    }

    /*----- toString -----*/

    public String toString() { return  this.x + ":" + this.y; }

}