package equipe_25.Metier;

import java.util.ArrayList ;

public class Dalle {

    /*------Static---------*/

    private static char Compteur_Nommeur = 'A';

    private static ArrayList<Dalle> ensembleDalle = new ArrayList<Dalle>(16);

    /*------CONSTANTE------*/

    private final int[][] SOMMETS; // Tableau qui va contenir les coordonnées des sommets de la Dalle

    /*----- attributs -----*/

    private char identifiant;
    
    private int x, y;
    
    private String couleur = "neutre";

    private Dalle [] voisin    = new Dalle [6]; // Tableau contenant les Dalles adjacentes
    
    private Pilier[] tabPilier = new Pilier[6]; // Tableau contenant les bjets Piliers adjecents

    /*----- Constructeur -----*/

    // Factory
    // pour limiter dans l'arrayList
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
        this.SOMMETS     = new int[][] { {x-16, x+16, x+33, x+16, x-16, x-33}, {y-33, y-33, y, y+33, y+33, y} };
    }

    /*----- Getteur -----*/

    public static ArrayList<Dalle> getEnsembleDalle(){return Dalle.ensembleDalle;}

    public char     getID     () { return this.identifiant; }

    public String   getCouleur() { return this.couleur;     }

    public int      getX      () { return this.x;           }

    public int      getY      () { return this.y;           }

    public Pilier[] getPilier () { return this.tabPilier;   }
 
    public int[][]  getSommets() { return this.SOMMETS;     }

    /*----- Setteur -----*/

    public void setVoisin ( int index, Dalle d ) { this.voisin[index] = d ;      }

    public void setCouleur(Architecte joueur)
    {
        this.couleur = joueur.getCouleur();
        joueur.ajouterDalle() ;
    }

    public void supprimer( Architecte joueur)
    {
        joueur.supprimerDalle() ;
        this.couleur = "neutre";
    }

    /*----- ToString -----*/


    /*----- ToString -----*/

    public String toString()
    {

        String s = " Dalle " + this.identifiant + ": |";

        for (int i = 0; i < this.voisin.length; i++)
        {
            if (this.voisin[i] != null){
                s+= this.voisin[i].getID();
            }
            else{
                s+= " ";
            }
            s += "|";
        }
        return s ;
    }
}