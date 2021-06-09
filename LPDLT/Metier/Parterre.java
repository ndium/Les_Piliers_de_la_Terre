package LPDLT.Metier;

import java.util.ArrayList ;

public class Parterre {

	/* -------- */
	/* Attribut */
	/* -------- */

	//Constante
	public final int DECALX = 0 ;
	public final int DECALY = 0 ;

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

		//ajout des piliers  tabPilier de Dalle.java
		for( Dalle d: Dalle.ensembleDalle )
		{
			for( Pilier p: Pilier.ensemblePilier ) // à faire en switch
			{
				if( ( p.getX()==d.getX()+16 && p.getY()==d.getY()-33 ) || // en haut à droite indice: 0
					( p.getX()==d.getX()+33 && p.getY()==d.getY()    ) || // à droite               : 1
					( p.getX()==d.getX()+16 && p.getY()==d.getY()+33 ) || // en bas à droite        : 2
					( p.getX()==d.getX()-16 && p.getY()==d.getY()+33 ) || // en bas à gauche        : 3
					( p.getX()==d.getX()-33 && p.getY()==d.getY()    ) || // à gauche               : 4
					( p.getX()==d.getX()-16 && p.getY()==d.getY()-33 ) ) {// en haut à gauche       : 5
					
					d.getPilier().add( p );
				}
			}
		}

		System.out.println(Dalle.ensembleDalle.get(0).getPilier().get(0) == Pilier.ensemblePilier.get(0));
		//System.out.println(d                         .getPilier().get(0) == p                    .get(0);)
		//complétion tabDalle de Pilier.java
		for( Pilier p: Pilier.ensemblePilier )
		{
			for( Dalle d: Dalle.ensembleDalle )
			{
				for( int i = 0; i < 6; i++ )
				{
					if( d.getPilier().get(i) ==  p ) { p.getDalle().add(d); break; }
				}
			}
		}

		for( Pilier p : Pilier.ensemblePilier )
		{
			System.out.println(p);
			for ( int i = 0; i < 6; i++ )
			{
				try {
					System.out.println( p.getDalle().get(i) );
				} catch( IndexOutOfBoundsException e ) {System.out.println("erreur2");}
			}
		}

		/*for( Dalle d : Dalle.ensembleDalle )
		{
			System.out.println(d);
			for ( int i = 0; i < 6; i++ )
			{
				try {
					System.out.println( d.getPilier().get(i) );
				} catch( IndexOutOfBoundsException e ) {System.out.println("erreur2");}
			}
		}*/

	}

	/* -------- */
	/* Methodes */
	/* -------- */

	public void setPilier( char id, int index, String couleur )
	{
		for (Dalle d : Dalle.ensembleDalle) {
			if( d.getID() == id )
				d.getPilier().get(index).setCouleur(couleur);
		}
	}

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

