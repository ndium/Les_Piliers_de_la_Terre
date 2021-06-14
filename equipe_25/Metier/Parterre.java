package equipe_25.Metier;

import java.util.ArrayList;

import equipe_25.Metier.Pilier;

public class Parterre {

	/*----CONSTANTES----*/

	public final int DECALX = 0 ;
	public final int DECALY = 0 ;

	public final int TAILLE_ZONE_CLIC = 10;

	private ArrayList<Dalle>  ensembleDalle  ;
	private ArrayList<Pilier> ensemblePilier ;

	private int[][] tabCoordonnees ;

	/*----Constructeur----*/

	public Parterre(){
		this((new int[][]{ { 200, 151, 249, 102, 200, 298,  53, 151, 249, 347, 102, 200, 298, 151, 249, 200 },
		                   {  50,  83,  83, 116, 116, 116, 149, 149, 149, 149, 182, 182, 182, 215, 215, 248 } }));
	}

	public Parterre( int[][] tabCoordonnees ){

		//losange de base 

		this.ensembleDalle  =  Dalle .getEnsembleDalle () ;
		this.ensemblePilier =  Pilier.getEnsemblePilier() ;
		this.tabCoordonnees = tabCoordonnees ;

		for( int i = 0; i < 16; i++ )
		{
			this.ensembleDalle.add( Dalle.creerDalle( this.DECALX + this.tabCoordonnees[0][i], this.DECALY+ this.tabCoordonnees[1][i] ) );
		}

		//création de l'arraylist contenant tout les piliers
		this.ensemblePilier.add( new Pilier( this.ensembleDalle.get(0).getSommets()[0][0], this.ensembleDalle.get(0).getSommets()[1][0] ) );

		for( Dalle d: this.ensembleDalle ) // boucle qui parcourt toutes les dalles
		{
			for( int i = 0; i < 6; i++ ) // boucle qui parcourt tous les sommets d'une dalle
			{
				boolean existe = false; // on part du principe que le pilier n'existe pas 

				for( int j = 0; j < this.ensemblePilier.size(); j++ ) // parcours de tous les piliers déjà créés
				{
					if( ( this.ensemblePilier.get(j).getX() == d.getSommets()[0][i] ) && ( this.ensemblePilier.get(j).getY() == d.getSommets()[1][i] ) ) { existe = true; }// si le pilier existe déjà, existe = true
				}

				if(!existe) { this.ensemblePilier.add( new Pilier( d.getSommets()[0][i], d.getSommets()[1][i] ) ); } // ajout du pilier
			}
		}

		//liens dalle -> Pilier
		for( Dalle d: this.ensembleDalle )
		{
			for( Pilier p: this.ensemblePilier )
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

	// retourne un pilier en fonction de sin id et de l'index
	public Pilier getPilier( char id, int index )
	{
		for (Dalle d : this.ensembleDalle)
		{
			if( d.getID() == id )
			{
				return d.getPilier()[index];
			}
		}
		return null;
	}

	// retourne le pilier aux coordonnees x et y
	public Pilier getPilier(int x ,int y )
	{
		for (Pilier p : this.ensemblePilier) 
        {
            if ((x >= p.getX() - this.TAILLE_ZONE_CLIC && x <= p.getX() + this.TAILLE_ZONE_CLIC) && (y >= p.getY() - this.TAILLE_ZONE_CLIC && y <= p.getY() + this.TAILLE_ZONE_CLIC))
            {
                return p ;
            }
        }
        return null ;
	}

	/*----- Setteur -----*/

	//ajoute un pilier avec un id , un index et une couleur
	public void setPilier( char id, int index, String couleur)
	{
		this.getPilier(id,index).setCouleur(couleur);
	}

	// ajoute un pilier avec des coordonnees x et y et une couleur
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

		for( Dalle d : this.ensembleDalle )
		{
			s += "|"+d.toString()+"\n";
			m += "| Dalle " + d.getID() + ": |" + String.format("%3d", d.getX() ) + "|" + String.format("%3d", d.getY() ) + "|\n";
		}

		s += "+----------+-+-+-+-+-+-+";
		m += "+----------+---+---+";

		return s + "\n\n";// + m;
	}
}

