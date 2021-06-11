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

            ///on verifie le plateau jusqu'a qu'il n'y ait plus rien a faire changer
            while(checkPlateau( plateau ));

            return true;
        }
        else
        {
            System.out.println( "\nIl y a déjà un Pilier ici !!" );
            return false;
        }
    }

    //renvoie si il a modifier qqch
    public boolean checkPlateau( Parterre plateau )
    {
        //si un des 2 a modifier qqch
        return Regle1_2( plateau ) ||
               Regle3  ( plateau );

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
        /*---------------------*/
        /*         /!\         */
        /*---------------------*/

        //->ajout des compteur de dalle et de pilier etc ...

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

    public boolean Regle3( Parterre plateau )
    {
        boolean retour = false ;

        //tableau qui evite les boucle et qui permet de tout supprimer
        ArrayList<Pilier> dejaVu = new ArrayList<Pilier>() ;

        /*
        on va parcourir les ensemble de tache 
        */
        for ( Pilier p : Pilier.ensemblePilier ) 
        {
            //si le pilier et neutre on ne parcoure pas ses voisin 
            if ( !p.getCouleur().equals("neutre") && !p.getCouleur().isEmpty() )
            {
                //si parcour retourne vrai c'est qu'il a tout parcouru sans trouvé de pillier neutre ou null
                if ( parcour( p, dejaVu ) )
                {
                    supprimer(dejaVu);
                    retour = true ;
                }
                dejaVu = new ArrayList<Pilier>() ;
                //sinon il n'y a rien a changé
            }
        }
        return retour ;
    }

    public boolean parcour( Pilier p, ArrayList<Pilier> dejaVu )
    {
        //si on a pas deja fait ce pilier
        if ( !dejaVu.contains( p ) )
        {
            for( Pilier voisin : p.getVoisin() )
            {
                //condition qui font qu'ils ne sont pas enfermés
                if( voisin == null )                                                       { return false ; }
                if( voisin.getCouleur().equals("neutre") || voisin.getCouleur().isEmpty() ){ return false ; }

                //condition de parcour
                //si il a un voisin de sa couleur
                if ( voisin.getCouleur().equals( p.getCouleur() ) )
                {
                    parcour(p,dejaVu);
                }
                //si il a un voisin d'une autre couleur qui n'est pas neutre 
                if (!voisin.getCouleur().equals(p.getCouleur()) && !(voisin.getCouleur().equals("neutre") || voisin.getCouleur().isEmpty()))
                { dejaVu.add(voisin); }
            }
        }
        return false ;
    }


    /* Methodes qui rend neutre a nouveau les pilier 
    qui sont sonner */
    public void supprimer(ArrayList<Pilier> list)
    {
        for (Pilier p : Pilier.ensemblePilier) 
        {
            if (list.contains(p))
            {
                p.setCouleur("neutre");
            }
        }
    }

    public String toString()
    {
        return plateau.toString();
    }
}