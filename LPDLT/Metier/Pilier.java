package LPDLT.Metier ;

public class Pilier
{
    private static int NB_PILIER = 24;

    private int[]  tabSommet;
    private String couleur;
    private int posX;
    private int posY;

    private Dalle dalle;

    public Pilier creerPilier(String couleur,int x, int y)
    {
        if (couleur.equals("Noire") || couleur.equals("Marron"))
        {
            if((x==-16 && y==-33) || (x==16 && y==-33) || (x==-33 && y==0) || (x==33 && y==0) || (x==-16 && y==33) || (x==16 && y==33))
            {
                new Pilier(couleur,x,y);
            }
            else
            {
                System.out.println("les coordonnées du pilier sont incorrectes");
            }
        }
        return null;
    }

    private  Pilier(String couleur,int x,int y)
    {
        this.couleur = couleur;
        //this.posX    = Dalle.getX() + x;
        //this.posY    = Dalle.getY() + y;

    }

}