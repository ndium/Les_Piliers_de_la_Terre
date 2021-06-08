package PDLT.Metier ;

public class Dalle {

    //compteur auto incrementé
    public static char Compteur_Nommeur = 'A' ;
    
    //numero du proprietaire de la case 0 pour personne
    private int numJoueur = 0 ;

    private int x,y = 0;

    private char identifiant ;

    private Dalle[] voisin = new Dalle[6];


    /**Constructeur de dalle qui prend les coordonnées
     * 
     * @param x
     * @param y
     */
    
    public Dalle(int x,int y){
        this.x=x;
        this.y=y;
        this.identifiant = ++Dalle.Compteur_Nommeur ;
    }

    /*------------Setteur--------------*/

    public void ajouterVoisin(Dalle dalle , int index )
    {
        try{
            this.voisin[index] = dalle ;
        }catch( ArrayIndexOutOfBoundsException ex ){System.out.println("/!\\ Index du voisin en dehors des plages" + identifiant);}
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

        String s = " Dalle " + this.identifiant ;

        for (int i=0;i<voisin.length;i++) 
        {
            if (voisin[i] != null){
                s += voisin[i].getID() + "|";
            }
            else{
                s+= " ";
            }
            return s ;

        }
    }
}