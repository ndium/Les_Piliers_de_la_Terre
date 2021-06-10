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

            while(checkPlateau( plateau ));

            return true;
        }
        else
        {
            System.out.println( "\nIl y a déjà un Pilier ici !!" );
            return false;
        }
        // verification du plateau


    }

    //renvoie si il a modifier qqch
    public boolean checkPlateau( Parterre plateau )
    {
        return Regle1_2( plateau );

        // à la fin
        //VerifScore( plateau );
    }


    /*R1 
    La prise de contrôle par majorite
    Lorsqu’un Architecte place son 4ème Pilier sur une même dalle, il en prend 
    le contrôle et place son ou ses Anneaux de prise de contrôle.*/


    /*R2
    La destruction de pilier(s) adverse(s)
    Lors de la prise contrôle d’une Dalle, tous les Piliers adverses sur cette Dalle
    sont détruits.*/

    public boolean Regle1_2( Parterre plateau )
    {
        boolean retour = false ;

        //on parcour toute les dalles
        for( Dalle d: Dalle.ensembleDalle )
        {
            boolean detruire = true ;
            int cptGris  = 0;
            int cptMaron = 0;

            //on parcour ces pillier et on note les score
            for( int i = 0; i < 6; i++ )
            {
                if( d.getPilier()[i].getCouleur().equals("gris")  ) { cptGris++;  }
                if( d.getPilier()[i].getCouleur().equals("maron") ) { cptMaron++; }
            }

            //si on n'a 4 pillier ou plus 
            if( cptGris  >= 4 ) 
            {
                //si la dalle est deja de cette couleur elle ne dtruira pas les pilier
                if (!d.getCouleur().equals("gris"))
                {
                    d.setCouleur("gris" );
                    retour = true ;
                }
                else
                    detruire = false ;
            }

            if( cptMaron >= 4 ) 
            { 
                if (!d.getCouleur().equals("maron"))
                {
                    d.setCouleur("maron" );
                    retour = true ;
                }
                else
                    detruire = false ;
            }

            //on pourrait reunnir les 2 if
            //si elle n'a plus ces 4 pilier 
            if (cptGris < 4 && d.getCouleur().equals("gris"))
            {
                System.out.println("couleur neutre");
                d.setCouleur("neutre" );
                retour = true ;
            }
            if (cptMaron < 4 && d.getCouleur().equals("maron"))
            {
                System.out.println("couleur neutre");
                d.setCouleur("neutre" );
                retour = true ;
            }


            // Destruction des piliers de couleur différente de la dalle
            if (detruire)
            {
                for( int i = 0; i < 6; i++ )
                {
                    if( !d.getCouleur().equals("neutre") && !d.getPilier()[i].getCouleur().equals( d.getCouleur() ) ) 
                    { 
                        d.getPilier()[i].setCouleur("neutre");
                        retour = true ;
                    }
                }
            }
        }
        return retour ;
    }

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