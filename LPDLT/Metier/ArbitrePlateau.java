package LPDLT.Metier;

import LPDLT.Controleur;

import java.util.ArrayList;

public class ArbitrePlateau
{
    Parterre plateau ;
    
    /**Classe qui gere les regles
     * 
     * @param ctrl
     */
    public ArbitrePlateau(Controleur ctrl)
    {
        this.plateau = new Parterre();
    }

    public boolean ajouterPilier(char dalle, int index, String couleur)
    {
        if( plateau.getPilier(dalle, index).getCouleur().equals("neutre") || plateau.getPilier(dalle, index).getCouleur().isEmpty() )
        {
            plateau.setPilier(dalle, index, couleur);

            checkPlateau( plateau );

            return true;
        }
        else
            return false;
        // verification du plateau


    }

    public void checkPlateau( Parterre plateau )
    {
        Regle1_2( plateau );

        // à la fin
        //VerifScore( plateau );
    }


    /*R1 
    La prise de contrôle par majorité
    Lorsqu’un Architecte place son 4
    ème Pilier sur une même dalle, il en prend le
    contrôle et place son ou ses Anneaux de prise de contrôle.*/
    public void Regle1_2( Parterre plateau )
    {
        for( Dalle d: Dalle.ensembleDalle )
        {
            int cptGris  = 0;
            int cptMaron = 0;

            for( int i = 0; i < 6; i++ )
            {
                if( d.getPilier()[i].getCouleur().equals("gris")  ) { cptGris++;  }
                if( d.getPilier()[i].getCouleur().equals("maron") ) { cptMaron++; }
            }

            if( cptGris  >= 4 ) { d.setCouleur("gris" ); }
            if( cptMaron >= 4 ) { d.setCouleur("maron"); }

            // Destruction des piliers de couleur différente de la dalle
            for( int i = 0; i < 6; i++ )
            {
                if( !d.getCouleur().equals("neutre") && !d.getPilier()[i].getCouleur().equals( d.getCouleur() ) ) { d.getPilier()[i].setCouleur("neutre"); }
            }
        }
    }


    /*R2
    La destruction de pilier(s) adverse(s)
    Lors de la prise contrôle d’une Dalle, tous les Piliers adverses sur cette Dalle
    sont détruits.*/

    /*R3 
    L’enfermement
    Lorsqu’un Architecte enferme un Pilier ou un groupe de Piliers (que celui-ci
    ne dispose plus d’aucune emplacement libre à proximité directe), ce ou ce
    groupe de Piliers sont détruits. */

    /*R4
    Fin de Jeu et décompte
    - Si un Architecte possède 9 Dalle, à un moment de la partie, il l’emporte
    immédiatement.
    - Lorsque les Architectes ont construit 24 Piliers, l’Architecte contrôlant
    le plus de Dalles l’emporte
    R4 en cas d’égalité, l’Architecte ayant détruit le plus de Pilier l’emporte*/

    public String toString()
    {
        return plateau.toString();
    }
}