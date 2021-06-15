package equipe_25.Metier;

import equipe_25.Controleur ;
import java.io.FileInputStream;
import java.io.ObjectInputStream;
import java.io.FileOutputStream;
import java.io.ObjectOutputStream;
import java.io.IOException;


public class Sauvegarde
{
    /*------------------*/
    /*    Sauvegarde    */
    /*------------------*/
    
    public static void sauvegarde(Controleur ctrl)
    {
        try
        {
            FileOutputStream   fos = new FileOutputStream  ( "./equipe_25/Scenarii/scenario_1.data" );
            ObjectOutputStream oos = new ObjectOutputStream( fos );

            oos.writeObject( ctrl );

            oos.close();
        }
        catch ( Exception e ) {}

    }

    public static Controleur reprendre(int numScenario)
    {
        Controleur controleur = null ;

        try
        {
            FileInputStream   fis = new FileInputStream( "./equipe_25/Scenarii/scenario_" + numScenario + ".data" );
            ObjectInputStream ois = new ObjectInputStream( fis );

            controleur = (Controleur) ois.readObject();

            ois.close();
        }
        catch ( Exception e ) {}

        return controleur;
    }
}