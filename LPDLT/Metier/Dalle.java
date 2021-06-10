package LPDLT.Metier;

import java.util.ArrayList ;

public class Dalle {

    //compteur auto incrementé
    public static char Compteur_Nommeur = 'A' ;

    public static ArrayList<Dalle> ensembleDalle = new ArrayList<Dalle>(16);
    
    //numero du proprietaire de la case 0 pour personne
    private int x, y;
    
    private String couleur = "neutre";

    private char identifiant ;

    private Dalle [] voisin    = new Dalle [6];
    
    public Pilier[] tabPilier = new Pilier[6];

    private final int[][] sommets;

    /**Constructeur de dalle qui prend les coordonnées
     * 
     * @param x
     * @param y
     */
    
    public static Dalle creerDalle(int x, int y)
    {
        if( Dalle.ensembleDalle.size() < 16)
            return new Dalle(x, y);
        
        return null;
    }

    
    private Dalle(int x, int y)
    {
        this.x = x;
        this.y = y;
        this.identifiant = Dalle.Compteur_Nommeur++;
        this.sommets     = new int[][] { {x-16, x+16, x+33, x+16, x-16, x-33}, {y-33, y-33, y, y+33, y+33, y} };

        //reperage des voisin du nouvel objet
        for (Dalle d : ensembleDalle) 
        {
            if(this.x   ==d.getX() && this.y-66==d.getY())
            {
                d.setVoisin(0,this);
                this.setVoisin(3,d);
            }


            if(this.x+49==d.getX() && this.y-33==d.getY())
            {
                d.setVoisin(1,this);
                this.setVoisin(4,d);
            }


            if(this.x+49==d.getX() && this.y+33==d.getY())
            {
                d.setVoisin(2,this);
                this.setVoisin(5,d);
            }


            if(this.x   ==d.getX() && this.y+66==d.getY())
            {
                d.setVoisin(3,this);
                this.setVoisin(0,d);
            }


            if(this.x-49==d.getX() && this.y+33==d.getY())
            {
                d.setVoisin(4,this);
                this.setVoisin(1,d);
            }


            if(this.x-49==d.getX() && this.y-33==d.getY())
            {
                d.setVoisin(5,this);
                this.setVoisin(2,d);
            }

        }
    }

    /*------------Setteur--------------*/

    public void setVoisin (int index ,Dalle d)
    {
        this.voisin[index] = d ;
    }

    public void prendre(String couleur){
        this.couleur = couleur ;
    }

    /*----------getteur----------*/

    public char getID(){
        return this.identifiant ;
    }
    public String getCouleur(){
        return this.couleur ;
    }

    public int getX(){return this.x;}

    public int getY(){return this.y;}

    public Pilier[] getPilier() { return this.tabPilier; }

    public int[][] getSommets() { return this.sommets; }

    public void setCouleur( String couleur ) { this.couleur = couleur; }

    public String toString(){

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