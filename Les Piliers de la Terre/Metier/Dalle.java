package Metier ;

public class Dalle {

    public static char Compteur_Nommeur = 'A' ;
    
    private int x,y = 0;

    private char identifiant ;

    public Dalle[] voisin = new Dalle[6];

    public Dalle(int x,int y){
        this.x=x;
        this.y=y;
        this.identifiant = ++Dalle.Compteur_Nommeur ;
    }

    public void ajouterVoisin(Dalle dalle , int index )
    {
        try{
            this.voisin[index] = dalle ;
        }catch( ArrayIndexOutOfBoundsException ex ){System.out.println("/!\\ Index du voisin en dehors des plages"+identifiant);}
    }

    public char getID(){
        return this.identifiant ;
    }

    public String toString(){

        String s = "" ;

        for (int i=0;i<voisin.length;i++) 
        {
            if (voisin(i)!=null){
                s+= voisin.getID()+"|";
            }
            else{
                s+= " ";
            }
            return s ;

        }

    }
}