package LPDLT.Metier;

import java.util.ArrayList;

public class Parterre {

	/*----Attributs----*/

	//Constantes
	public final int DECALX = 0 ;
	public final int DECALY = 0 ;

	/*----Constructeur----*/

	public Parterre(){

		//losange de base 
		Dalle.ensembleDalle.add( Dalle.creerDalle( DECALX+200, DECALY+  50 ) );
		Dalle.ensembleDalle.add( Dalle.creerDalle( DECALX+151, DECALY+  83 ) );
		Dalle.ensembleDalle.add( Dalle.creerDalle( DECALX+249, DECALY+  83 ) );
		Dalle.ensembleDalle.add( Dalle.creerDalle( DECALX+102, DECALY+ 116 ) );
		Dalle.ensembleDalle.add( Dalle.creerDalle( DECALX+200, DECALY+ 116 ) );
		Dalle.ensembleDalle.add( Dalle.creerDalle( DECALX+298, DECALY+ 116 ) );
		Dalle.ensembleDalle.add( Dalle.creerDalle( DECALX+ 53, DECALY+ 149 ) );
		Dalle.ensembleDalle.add( Dalle.creerDalle( DECALX+151, DECALY+ 149 ) );
		Dalle.ensembleDalle.add( Dalle.creerDalle( DECALX+249, DECALY+ 149 ) );
		Dalle.ensembleDalle.add( Dalle.creerDalle( DECALX+347, DECALY+ 149 ) );
		Dalle.ensembleDalle.add( Dalle.creerDalle( DECALX+102, DECALY+ 182 ) );
		Dalle.ensembleDalle.add( Dalle.creerDalle( DECALX+200, DECALY+ 182 ) );
		Dalle.ensembleDalle.add( Dalle.creerDalle( DECALX+298, DECALY+ 182 ) );
		Dalle.ensembleDalle.add( Dalle.creerDalle( DECALX+151, DECALY+ 215 ) );
		Dalle.ensembleDalle.add( Dalle.creerDalle( DECALX+249, DECALY+ 215 ) );
		Dalle.ensembleDalle.add( Dalle.creerDalle( DECALX+200, DECALY+ 248 ) );

		//création de l'arraylist contenant tout les piliers
		Pilier.ensemblePilier.add( new Pilier( Dalle.ensembleDalle.get(0).getSommets()[0][0], Dalle.ensembleDalle.get(0).getSommets()[1][0] ) );

		for( Dalle d: Dalle.ensembleDalle ) // boucle qui parcourt toutes les dalles
		{
			for( int i = 0; i < 6; i++ ) // boucle qui parcourt tous les sommets d'une dalle
			{
				boolean existe = false; // on part du principe que le pilier n'existe pas 

				for( int j = 0; j < Pilier.ensemblePilier.size(); j++ ) // parcours de tous les piliers déjà créés
				{
					if( ( Pilier.ensemblePilier.get(j).getX() == d.getSommets()[0][i] ) && ( Pilier.ensemblePilier.get(j).getY() == d.getSommets()[1][i] ) ) { existe = true; }// si le pilier existe déjà, existe = true
				}

				if(!existe) { Pilier.ensemblePilier.add( new Pilier( d.getSommets()[0][i], d.getSommets()[1][i] ) ); } // ajout du pilier
			}
		}

		//liens pillier <- dalle 
		for( Dalle d: Dalle.ensembleDalle )
		{
			for( Pilier p: Pilier.ensemblePilier )
			{
				if ( p.getX() == d.getX()-16 && p.getY() == d.getY()-33 ) { d.getPilier()[0] = p; } // en haut à gauche       : 0
				if ( p.getX() == d.getX()+16 && p.getY() == d.getY()-33 ) { d.getPilier()[1] = p; } // en haut à droite indice: 1
				if ( p.getX() == d.getX()+33 && p.getY() == d.getY()    ) { d.getPilier()[2] = p; } // à droite               : 2
				if ( p.getX() == d.getX()+16 && p.getY() == d.getY()+33 ) { d.getPilier()[3] = p; } // en bas à droite        : 3
				if ( p.getX() == d.getX()-16 && p.getY() == d.getY()+33 ) { d.getPilier()[4] = p; } // en bas à gauche        : 4
				if ( p.getX() == d.getX()-33 && p.getY() == d.getY()    ) { d.getPilier()[5] = p; } // à gauche               : 5
			}
		}

		//liens Dalle <- pilier
		/*
		for( Pilier p: Pilier.ensemblePilier )
		{
			int indice = 0;
			for( Dalle d: Dalle.ensembleDalle )
			{
				for( int i = 0; i < 6; i++ )
				{
					if( d.getPilier()[i] == p ) { p.getDalle()[ indice++ ] = d; }
				}
			}
		}*/

		Pilier.lierVoisin();

		//parcour pillier

		for (Pilier p  : Pilier.ensemblePilier)
		{
			System.out.println("pilier observé: " + p);

			for (int i = 0; i < 3; i++)
			{
				System.out.println(p.getVoisin()[i]);
			}
		}

		for( int i = 0; i < 6; i++ )
		{
			System.out.println( Dalle.ensembleDalle.get(0).getPilier()[i] );
		}

	}

	/*---- Getteur ----*/

	public Pilier getPilier( char id, int index )
	{
		for (Dalle d : Dalle.ensembleDalle)
		{
			if( d.getID() == id )
			{
				return d.getPilier()[index];
			}
		}
		return null;
	}

	/*----- Setteur -----*/

	public void setPilier( char id, int index, String couleur )
	{
		for (Dalle d : Dalle.ensembleDalle)
		{
			if( d.getID() == id )
			{
				d.getPilier()[index].setCouleur(couleur);
			}
		}
	}

	/*----- ToString() -----*/

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

		return ""; //s + "\n\n" + m;
	}
}

