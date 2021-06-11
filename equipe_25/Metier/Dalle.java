package equipe_25.Metier;

import java.util.ArrayList ;

public class Dalle {

    /*------Static---------*/

    public static char Compteur_Nommeur = 'A';

    public static ArrayList<Dalle> ensembleDalle = new ArrayList<Dalle>(16);

    /*------CONSTANTE------*/

    private final int[][] sommets; // Tableau qui va contenir les coordonnées des sommets de la Dalle

    /*----- attributs -----*/

    private char identifiant;
    
    private int x, y;
    
    private String couleur = "neutre";

    private Dalle [] voisin    = new Dalle [6]; // Tableau contenant les Dalles adjacentes
    
    private Pilier[] tabPilier = new Pilier[6]; // Tableau contenant les bjets Piliers adjecents

    /*----- Constructeur -----*/

    // Factory
    public static Dalle creerDalle(int x, int y)
    {
        if( Dalle.ensembleDalle.size() < 16 )
            return new Dalle( x, y );
        
        return null;
    }

    private Dalle(int x, int y)
    {
        this.x = x;
        this.y = y;
        this.identifiant = Dalle.Compteur_Nommeur++;
        this.sommets     = new int[][] { {x-16, x+16, x+33, x+16, x-16, x-33}, {y-33, y-33, y, y+33, y+33, y} };
    }

    /*----- Getteur -----*/

    public char     getID     () { return this.identifiant; }

    public String   getCouleur() { return this.couleur;     }

    public int      getX      () { return this.x;           }

    public int      getY      () { return this.y;           }

    public Pilier[] getPilier () { return this.tabPilier;   }

    public int[][]  getSommets() { return this.sommets;     }

    /*----- Setteur -----*/

    public void setVoisin ( int index, Dalle d ) { this.voisin[index] = d ;     }

    public void setCouleur( String couleur     ) { this.couleur       = couleur;}


    /*----- ToString -----*/

    public String toString()
    {

        String s = " Dalle " + this.identifiant + ": |";

        for (int i=0; i<voisin.length; i++)
        {
            if (voisin[i] != null){
                s+= voisin[i].getID();
            }
            else{
                s+= " ";
            }
            s += "|";
        }
        return s ;
    }
}