package LPDLT.Metier ;

import java.util.ArrayList;

public class Pilier
{
<<<<<<< HEAD
    /*----Attributs----*/
=======
    /*----- Attributs -----*/
>>>>>>> 4bd80188e4d6a2f4c77ebfc55a235118ae794f65

    private int x;
    private int y;

    private String couleur = "neutre";

    private Dalle[] tabDalle = new Dalle[6]; // Tableau contenant les Dalles adjacentes au Pilier

    public int nbPilier = 0; // Nombre de Piliers "créés" ( basculement de couleur vers maron ou gris )
    public static ArrayList<Pilier> ensemblePilier = new ArrayList<Pilier>(); // ArrayList regroupant tous les Piliers du Parterre

<<<<<<< HEAD
    /*----Constructeur----*/
=======
    /*----- Constructeur -----*/
>>>>>>> 4bd80188e4d6a2f4c77ebfc55a235118ae794f65

    public Pilier(int x, int y)
    {
        this.x = x;
        this.y = y;
    }

<<<<<<< HEAD
    /*----Getteur----*/
    public int getX() { return this.x; }
    public int getY() { return this.y; }
    
=======
    /*----- Getteur -----*/

    public int    getX()       { return this.x;       }
    public int    getY()       { return this.y;       }
>>>>>>> 4bd80188e4d6a2f4c77ebfc55a235118ae794f65
    public String getCouleur() { return this.couleur; }

    public Dalle[] getDalle() { return this.tabDalle; }

<<<<<<< HEAD
    /*----Setteur----*/
    public void setCouleur(String couleur) { this.couleur = couleur; }

    /*----toString----*/
=======
    /*----- Setteur -----*/

    public void setCouleur(String couleur)
    {
        this.couleur = couleur;
        if( !this.couleur.equals("neutre") ) // Si le basculement de la couleur donne du maron ou du gris
            nbPilier++;
    }

    /*----- toString -----*/

>>>>>>> 4bd80188e4d6a2f4c77ebfc55a235118ae794f65
    public String toString() { return  this.x + ":" + this.y; }

}