package LPDLT.Metier ;

public class Pilier
{
    private static int NB_PILIER = 24;

    private int nbPilier;
    private String couleur;
    private int posX;
    private int posY;

    private Dalle dalle;

    public Pilier creerPilier(String couleur,int x, int y)
    {
        if (couleur.equals("Noire") || couleur.equals("Marron"))
        {
            return new Pilier (couleur);
        }
        return null;
    }

    private  Pilier(String couleur/*,int posX,int posY*/)
    {
        this.couleur  = couleur;
        /*this.posX   = posX;
        this.posY     = posY;*/
        this.nbPilier = 0;

    }

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
    }

    private void destructionPilier ()
    {
        
    }

}