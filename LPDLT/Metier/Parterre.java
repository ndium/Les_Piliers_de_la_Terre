package LPDLT.Metier;

import java.util.ArrayList ;

public class Parterre {

	public final int DECALX = -20 ;
	public final int DECALY = -30 ;


	public Parterre(){

		//losange de base 
		Dalle.ensembleDalle.add (new Dalle(DECALX+200,DECALY+  50));
		Dalle.ensembleDalle.add (new Dalle(DECALX+151,DECALY+  83));
		Dalle.ensembleDalle.add (new Dalle(DECALX+249,DECALY+  83));
		Dalle.ensembleDalle.add (new Dalle(DECALX+102,DECALY+ 116));
		Dalle.ensembleDalle.add (new Dalle(DECALX+200,DECALY+ 116));
		Dalle.ensembleDalle.add (new Dalle(DECALX+298,DECALY+ 116));
		Dalle.ensembleDalle.add (new Dalle(DECALX+ 53,DECALY+ 149));
		Dalle.ensembleDalle.add (new Dalle(DECALX+151,DECALY+ 149));
		Dalle.ensembleDalle.add (new Dalle(DECALX+249,DECALY+ 149));
		Dalle.ensembleDalle.add (new Dalle(DECALX+347,DECALY+ 149));
		Dalle.ensembleDalle.add (new Dalle(DECALX+102,DECALY+ 182));
		Dalle.ensembleDalle.add (new Dalle(DECALX+200,DECALY+ 182));
		Dalle.ensembleDalle.add (new Dalle(DECALX+298,DECALY+ 182));
		Dalle.ensembleDalle.add (new Dalle(DECALX+151,DECALY+ 215));
		Dalle.ensembleDalle.add (new Dalle(DECALX+249,DECALY+ 215));
		Dalle.ensembleDalle.add (new Dalle(DECALX+200,DECALY+ 248));

		//verifier apres la taille 

	}

	public String toString()
	{
		String s =  "           [   Lié a   ]\n"+
					"           |0|1|2|3|4|5|\n"+
				    "+----------+-+-+-+-+-+-+\n";
		
		String m = 	"           |x|y| | | | |\n"+
					"+----------+-+-+-+-+-+-+\n";

		for( Dalle d : Dalle.ensembleDalle )
		{
			s += "|"+d.toString()+"\n";
		}

		

		return s ;
	}
}

