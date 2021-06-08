package LPDLT.Metier ;

public class Pilier
{
    private String couleur = "neutre";

    private int posX;
    private int posY;

    private Dalle[] tabDalles = new Dalle[3];

    /*public Pilier creerPilier(String couleur,int x, int y)
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
        this.posX    = Dalle.getX() + x;
        this.posY    = Dalle.getY() + y;

    }*/

    public Pilier(int x, int y)
    {
        this.posX = x;
        this.posY = y;
    }
}