package equipe_25.Metier;

import java.util.Scanner;
import java.io.FileInputStream;
import java.util.ArrayList ;

public class LectureScenario 
{
    private static ArrayList<Character> action = new ArrayList<Character>() ;
    private static int cpt = 0 ;

    public static void lireScenario(int numScenario)
    {
        try
        {
            Scanner sc = new Scanner ( new FileInputStream ( "./equipe_25/Scenarii/scenario" + numScenario + ".data" ) );

            while ( sc.hasNextLine() )
                LectureScenario.action.add(sc.nextLine().charAt(0));

            sc.close();
        }
        catch (Exception e){ e.printStackTrace(); }
    }

    public static char getActionSuivante()
    {
        return LectureScenario.action.get(++LectureScenario.cpt) ;
    }

    public static boolean estTerminer()
    {
        return (LectureScenario.action.size()-1 == LectureScenario.cpt) ;
    }
}