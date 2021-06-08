package LPDLT.Metier ;

public class Pilier
{
    private String couleur = "neutre";

<<<<<<< HEAD
    private int nbPilier;
    private String couleur;
=======
>>>>>>> d789e10a0b03aa9a40b9f3082b74f1e1a947fc25
    private int posX;
    private int posY;

    private Dalle[] tabDalles = new Dalle[3];

    /*public Pilier creerPilier(String couleur,int x, int y)
    {
        if (couleur.equals("Noire") || couleur.equals("Marron"))
        {
            return new Pilier (couleur);
        }
        return null;
    }

    private  Pilier(String couleur/*,int posX,int posY*/)
    {
<<<<<<< HEAD
        this.couleur  = couleur;
        /*this.posX   = posX;
        this.posY     = posY;*/
        this.nbPilier = 0;
=======
        this.couleur = couleur;
        //this.posX    = Dalle.getX() + x;
        //this.posY    = Dalle.getY() + y;
>>>>>>> d789e10a0b03aa9a40b9f3082b74f1e1a947fc25

    }*/

<<<<<<< HEAD
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

=======
    public Pilier(int x, int y)
    {
        this.posX = x;
        this.posY = y;
    }
>>>>>>> d789e10a0b03aa9a40b9f3082b74f1e1a947fc25
}