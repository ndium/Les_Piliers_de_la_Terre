package LPDLT.Metier;

import java.util.ArrayList ;

public class Parterre {

	/* -------- */
	/* Attribut */
	/* -------- */

	//Constante
	public final int DECALX = -40 ;
	public final int DECALY = -50 ;

	/* ------------ */
	/* Constructeur */
	/* ------------ */

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

		//création de l'arraylist contenant tout les piliers
		Pilier.ensemblePilier.add( new Pilier( Dalle.ensembleDalle.get(0).getSommets()[0][0], Dalle.ensembleDalle.get(0).getSommets()[1][0] ) );

		for( Dalle d: Dalle.ensembleDalle ) // boucle qui parcourt toutes les dalles
		{
			for( int i = 0; i < 6; i++ ) // boucle qui parcourt tous les sommets d'une dalle
			{
			boolean existe = false; // on part du principe que le pilier n'existe pas 

			for( int j = 0; j < Pilier.ensemblePilier.size(); j++ ) { // parcours de tous les piliers déjà créés
				if( ( Pilier.ensemblePilier.get(j).getX() == d.getSommets()[0][i] ) && ( Pilier.ensemblePilier.get(j).getY() == d.getSommets()[1][i] ) ) { existe = true; }// si le pilier existe déjà, existe = true
			}

			if(!existe) { Pilier.ensemblePilier.add( new Pilier( d.getSommets()[0][i], d.getSommets()[1][i] ) ); } // ajout du pilier
			}
		}

	}

	/* -------- */
	/* Methodes */
	/* -------- */

	public String toString()
	{
		String s =  "           [   Lié a   ]\n"+
					"           |0|1|2|3|4|5|\n"+
				    "+----------+-+-+-+-+-+-+\n";
		
		String m =  "           [Coord  ]\n"+
					"           | x | y |\n"+
					"+----------+---+---+\n";


		for( Dalle d : Dalle.ensembleDalle )
		{
			s += "|"+d.toString()+"\n";
			m += "| Dalle " + d.getID() + ": |" + String.format("%3d", d.getX() ) + "|" + String.format("%3d", d.getY() ) + "|\n";
		}
		s += "+----------+-+-+-+-+-+-+";
		m += "+----------+---+---+";

		return s + "\n\n" + m;


	}
}

