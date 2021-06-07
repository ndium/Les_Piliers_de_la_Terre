public class Dalle {

    public static int Compteur_Nommeur = 'A' ;
    
    private int x,y = 0;

    private char identifiant ;

    public Dalle(int x,int y){
        this.x=x;
        this.y=y;
        this.identifiant = Compteur_Nommeur++ ;    
    }
}