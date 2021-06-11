package equipe_25.Metier ;

import java.util.ArrayList;

public class Pilier
{
    /*----- Attributs -----*/

    private int x;
    private int y;

    private String couleur = "neutre";

    private Dalle[] tabDalle = new Dalle[3]; // Tableau contenant les Dalles adjacentes au Pilier

    private Pilier[] tabVoisin = new Pilier[3];

    public static int cptPilierPose = 2 * 24; // Nombre de Pilier limite

    private int dernierChangement = -1 ;

    public static ArrayList<Pilier> ensemblePilier = new ArrayList<Pilier>(); // ArrayList regroupant tous les Piliers du Parterre

    /*----Constructeur----*/

    public Pilier(int x, int y)
    {
        this.x = x;
        this.y = y;
    }

    public static void lierVoisin()
    {
        // Remplissage du tableau de Dalles regroupant les voisins de la Dalle
        for (Pilier p1 : ensemblePilier) 
        {
            for (Pilier p2 : ensemblePilier) 
            {
                //System.out.println(p2);

                if( p1.getX()-17 == p2.getX() && p1.getY()-33 == p2.getY() )
                    p1.setVoisin( 0, p2 );

                if( p1.getX()+17 == p2.getX() && p1.getY()-33 == p2.getY() )
                    p1.setVoisin( 0, p2 );

                if( p1.getX()-32 == p2.getX() && p1.getY() == p2.getY() )
                    p1.setVoisin( 1, p2 );

                if( p1.getX()+32 == p2.getX() && p1.getY() == p2.getY() )
                    p1.setVoisin( 1, p2 );

                if( p1.getX()-17 == p2.getX() && p1.getY()+33 == p2.getY() )
                    p1.setVoisin( 2, p2 );

                if( p1.getX()+17 == p2.getX() && p1.getY()+33 == p2.getY() )
                    p1.setVoisin( 2, p2 );
            }
        }
    }
    
    /*----- Getteur -----*/

    public int      getX      () { return this.x;         }

    public int      getY      () { return this.y;         }

    public String   getCouleur() { return this.couleur;   }

    public Dalle[]  getDalle  () { return this.tabDalle;  }

    public Pilier[] getVoisin () { return this.tabVoisin; }

    /*----- Setteur -----*/

    public void setCouleur(String couleur)
    {
        if( !couleur.equals( "neutre" ) )
            cptPilierPose--;

        this.dernierChangement = cptPilierPose;
        this.couleur = couleur;
    }

    public void setVoisin(int index,Pilier p)
    {
        tabVoisin[index] = p ;
    }

    /*----- toString -----*/

    public String toString() { return  this.x + ":" + this.y; }

}