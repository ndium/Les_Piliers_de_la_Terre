//package Metier;

public class Dalle {

    //compteur auto incrementé
    public static char Compteur_Nommeur = 'A' ;
    
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
    }

    /*------------Setteur--------------*/

    public Dalle creerVoisin( int index )
    {
        Dalle dalle ;

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

            this.voisin[index] = dalle ;

            return dalle ;
        }
    }

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