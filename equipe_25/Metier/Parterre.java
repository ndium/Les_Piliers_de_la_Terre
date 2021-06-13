package equipe_25.Metier;

import java.util.ArrayList;

import equipe_25.Metier.Pilier;

public class Parterre {

	/*----CONSTANTES----*/

	public final int DECALX = 0 ;
	public final int DECALY = 0 ;

	private ArrayList<Dalle>  ensembleDalle  ;
	private ArrayList<Pilier> ensemblePilier ;

	/*----Constructeur----*/

	public Parterre(){

		//losange de base 

		ensembleDalle  =  Dalle .getEnsembleDalle () ;
		ensemblePilier =  Pilier.getEnsemblePilier() ;


		ensembleDalle.add( Dalle.creerDalle( DECALX+200, DECALY+  50 ) );
		ensembleDalle.add( Dalle.creerDalle( DECALX+151, DECALY+  83 ) );
		ensembleDalle.add( Dalle.creerDalle( DECALX+249, DECALY+  83 ) );
		ensembleDalle.add( Dalle.creerDalle( DECALX+102, DECALY+ 116 ) );
		ensembleDalle.add( Dalle.creerDalle( DECALX+200, DECALY+ 116 ) );
		ensembleDalle.add( Dalle.creerDalle( DECALX+298, DECALY+ 116 ) );
		ensembleDalle.add( Dalle.creerDalle( DECALX+ 53, DECALY+ 149 ) );
		ensembleDalle.add( Dalle.creerDalle( DECALX+151, DECALY+ 149 ) );
		ensembleDalle.add( Dalle.creerDalle( DECALX+249, DECALY+ 149 ) );
		ensembleDalle.add( Dalle.creerDalle( DECALX+347, DECALY+ 149 ) );
		ensembleDalle.add( Dalle.creerDalle( DECALX+102, DECALY+ 182 ) );
		ensembleDalle.add( Dalle.creerDalle( DECALX+200, DECALY+ 182 ) );
		ensembleDalle.add( Dalle.creerDalle( DECALX+298, DECALY+ 182 ) );
		ensembleDalle.add( Dalle.creerDalle( DECALX+151, DECALY+ 215 ) );
		ensembleDalle.add( Dalle.creerDalle( DECALX+249, DECALY+ 215 ) );
		ensembleDalle.add( Dalle.creerDalle( DECALX+200, DECALY+ 248 ) );

		//création de l'arraylist contenant tout les piliers
		ensemblePilier.add( new Pilier( ensembleDalle.get(0).getSommets()[0][0], ensembleDalle.get(0).getSommets()[1][0] ) );

		for( Dalle d: ensembleDalle ) // boucle qui parcourt toutes les dalles
		{
			for( int i = 0; i < 6; i++ ) // boucle qui parcourt tous les sommets d'une dalle
			{
				boolean existe = false; // on part du principe que le pilier n'existe pas 

				for( int j = 0; j < ensemblePilier.size(); j++ ) // parcours de tous les piliers déjà créés
				{
					if( ( ensemblePilier.get(j).getX() == d.getSommets()[0][i] ) && ( ensemblePilier.get(j).getY() == d.getSommets()[1][i] ) ) { existe = true; }// si le pilier existe déjà, existe = true
				}

				if(!existe) { ensemblePilier.add( new Pilier( d.getSommets()[0][i], d.getSommets()[1][i] ) ); } // ajout du pilier
			}
		}

		//liens dalle -> Pilier
		for( Dalle d: ensembleDalle )
		{
			for( Pilier p: ensemblePilier )
			{
				if ( p.getX() == d.getX()-16 && p.getY() == d.getY()-33 ) { d.getPilier()[0] = p; } // en haut à gauche       : 0
				if ( p.getX() == d.getX()+16 && p.getY() == d.getY()-33 ) { d.getPilier()[1] = p; } // en haut à droite indice: 1
				if ( p.getX() == d.getX()+33 && p.getY() == d.getY()    ) { d.getPilier()[2] = p; } // à droite               : 2
				if ( p.getX() == d.getX()+16 && p.getY() == d.getY()+33 ) { d.getPilier()[3] = p; } // en bas à droite        : 3
				if ( p.getX() == d.getX()-16 && p.getY() == d.getY()+33 ) { d.getPilier()[4] = p; } // en bas à gauche        : 4
				if ( p.getX() == d.getX()-33 && p.getY() == d.getY()    ) { d.getPilier()[5] = p; } // à gauche               : 5
			}
		}

		Pilier.lierVoisin();//tout les pilier retouve leur voisin 
	}

	/*---- Getteur ----*/

	public Pilier getPilier( char id, int index )
	{
		for (Dalle d : ensembleDalle)
		{
			if( d.getID() == id )
			{
				return d.getPilier()[index];
			}
		}
		return null;
	}

	public Pilier getPilier(int x ,int y )
	{
		for (Pilier p : ensemblePilier) 
        {
            if ((x >= p.getX()-10 && x <= p.getX()+10) && (y >= p.getY()-10 && y <= p.getY()+10))
            {
                return p ;
            }
        }
        return null ;
	}

	/*----- Setteur -----*/

	public void setPilier( char id, int index, String couleur )
	{
		this.getPilier(id,index).setCouleur(couleur);
	}

	public void setPilier( int x, int y, String couleur )
	{
		this.getPilier(x,y).setCouleur(couleur);
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

		for( Dalle d : ensembleDalle )
		{
			s += "|"+d.toString()+"\n";
			m += "| Dalle " + d.getID() + ": |" + String.format("%3d", d.getX() ) + "|" + String.format("%3d", d.getY() ) + "|\n";
		}

		s += "+----------+-+-+-+-+-+-+";
		m += "+----------+---+---+";

		return s + "\n\n";// + m;
	}
}

