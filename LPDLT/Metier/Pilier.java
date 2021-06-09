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

    private Dalle[] tabDalles = new Dalle[3];

    public static ArrayList<Pilier> ensemblePilier = new ArrayList<Pilier>();

    /*public Pilier creerPilier(String couleur,int x, int y)
    {
        if (couleur.equals("Noire") || couleur.equals("Marron"))
        {
            return new Pilier (couleur);
        }
        return null;
    }*/

    /* ------------ */
    /* Constructeur */
    /* ------------ */

    public Pilier(int x, int y)
    {
        this.posX = x;
        this.posY = y;
    }

    public String toString() { return this.posX + "/" + this.posY; }

    public int getX() { return this.posX; }
    public int getY() { return this.posY; }
/*
    private boolean placerPillier (String couleur, int x, int y)
    {
        if (nbPilier <= NB_PILIER)
        {
            if (couleur.equals("Noire") || couleur.equals("Marron"))
            {
                if((x==-16 && y==-33) || (x==16 && y==-33) || (x==-33 && y==0) || (x==33 && y==0) || (x==-16 && y==33) || (x==16 && y==33))
                {
                    this.posX = Dalle.getX() + x;
                    this.posY = Dalle.getY() + y;

                    nbPilier ++;
                    return true;
                }
            }
            return false;
        }
    }*/

    private void destructionPilier ()
    {
        
    }

}