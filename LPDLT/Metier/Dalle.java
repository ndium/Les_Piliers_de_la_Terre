<<<<<<< HEAD
package LPDLT.Metier;

import java.util.ArrayList ;
=======
package LDPLT.Metier;
>>>>>>> 68089bac945511582382eee7b359a2f46d28f979

public class Dalle {

    //compteur auto incrementé
    public static char Compteur_Nommeur = 'A' ;

    public static ArrayList<Dalle> ensembleDalle = new ArrayList<Dalle>(16);
    
    //numero du proprietaire de la case 0 pour personne
    private int numJoueur = 0 ;

    private int x, y;

    private char identifiant ;

    private Dalle[] voisin = new Dalle[6];

    /// FAIRE LES PILLIER ///


    /**Constructeur de dalle qui prend les coordonnées
     * 
     * @param x
     * @param y
     */
    
    public Dalle(int x, int y){
        this.x = x;
        this.y = y;
        this.identifiant = Dalle.Compteur_Nommeur++;

        for (Dalle d : ensembleDalle) 
        {
            if(this.x   ==d.getX() && this.y-67==d.getY())
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


            if(this.x   ==d.getX() && this.y+67==d.getY())
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

    /*
    public Dalle creerVoisin( int index )
    {
        Dalle dalle ;

        if (voisin[index] != null){return null ;}

        switch (index){

            case 0 ->{
                dalle = new Dalle(this.x,this.y-67);
            }

            case 1 ->{
                dalle = new Dalle(this.x+49,this.y-33);
            }

            case 2 ->{
                dalle = new Dalle(this.x+49,this.y+33);
            }

            case 3 ->{
                dalle = new Dalle(this.x,this.y+67);
            }

            case 4 ->{
                
                dalle = new Dalle(this.x-49,this.y+33) ;
            }

            case 5 ->{

                dalle = new Dalle(this.x-49,this.y-33) ;
            }
            default -> {
                System.out.println("/!\\ Index du voisin en dehors des plages de " + identifiant);
                return null ;
            }

        }
<<<<<<< HEAD

        this.voisin[index] = dalle ;

        return dalle ;
    }*/
=======
        this.voisin[index] = dalle ;

        return dalle ;
    }
>>>>>>> 68089bac945511582382eee7b359a2f46d28f979

    public void prendre(int IDjoueur){
        this.numJoueur = IDjoueur ;
    }

    /*----------getteur----------*/

    public char getID(){
        return this.identifiant ;
    }
    public int getJoueur(){
        return this.numJoueur ;
    }
    public int getX(){
        return this.x;
    }
    public int getY(){
        return this.y;
    }

    public int getX(){return this.x;}

    public int getY(){return this.y;}


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