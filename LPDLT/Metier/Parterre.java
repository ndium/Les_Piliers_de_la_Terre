package LPDLT.Metier;

import java.util.ArrayList ;

public class Parterre {

	public Parterre(){

		//losange de base 
		Dalle.ensembleDalle.add (new Dalle(200,  50));
		Dalle.ensembleDalle.add (new Dalle(151,  83));
		Dalle.ensembleDalle.add (new Dalle(249,  83));
		Dalle.ensembleDalle.add (new Dalle(102, 116));
		Dalle.ensembleDalle.add (new Dalle(200, 116));
		Dalle.ensembleDalle.add (new Dalle(298, 116));
		Dalle.ensembleDalle.add (new Dalle( 53, 149));
		Dalle.ensembleDalle.add (new Dalle(151, 149));
		Dalle.ensembleDalle.add (new Dalle(249, 149));
		Dalle.ensembleDalle.add (new Dalle(298, 149));
		Dalle.ensembleDalle.add (new Dalle(102, 182));
		Dalle.ensembleDalle.add (new Dalle(200, 182));
		Dalle.ensembleDalle.add (new Dalle(249, 182));
		Dalle.ensembleDalle.add (new Dalle(151, 215));
		Dalle.ensembleDalle.add (new Dalle(249, 215));
		Dalle.ensembleDalle.add (new Dalle(200, 248));
		//verifier apres la taille 

	}

	public String toString()
	{
		String s =  "           [   Lié a   ]\n"+
					"           |0|1|2|3|4|5|\n"+
				    "+----------+-+-+-+-+-+-+\n";
		
		for( Dalle d : Dalle.ensembleDalle )
		{
			s += "|"+d.toString()+"\n";
		}

		return s ;
	}
}

