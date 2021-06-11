package equipe_25.Metier;

import equipe_25.Controleur;

import java.util.ArrayList;

public class ArbitrePlateau
{
    /*--------Attribut---------*/
    Parterre plateau ;
    
    /*-------------Constructeur--------------*/
    public ArbitrePlateau(Controleur ctrl)
    {
        this.plateau = new Parterre();
    }



    public boolean ajouterPilier(char dalle, int index, String couleur)
    {
        //si l'endroit est libre
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

    public boolean ajouterPilier(Pilier pilier, String couleur)
    {
        //si l'endroit est libre
        if( pilier.getCouleur().equals("neutre") || pilier.getCouleur().isEmpty() )
        {
            pilier.setCouleur(couleur);

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


    /*----------------Verification-----------------*/
    public boolean checkPlateau( Parterre plateau )
    {
        //si un des 2 a modifier qqch
        return Regle1_2( plateau ) ||
               Regle3  ( plateau );
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

    public boolean Regle3( Parterre plateau )
    {
        boolean aChangerQqch = false;

        //tableau qui evite les boucle et qui permet de tout supprimer
        ArrayList<Pilier> dejaVu = new ArrayList<Pilier>() ;

        //on va parcourir les ensemble de tache 
        for ( Pilier p : Pilier.ensemblePilier ) 
        {
            //if( !p.getCouleur().equals( Controleur.joueurActif.getCouleur() ) // && 
                //si le pilier et neutre on ne parcour pas ses voisin 
                if ( !(p.getCouleur().equals("neutre") || p.getCouleur().isEmpty()) )
                {
                    //si parcour n'a pas trouvé de sortie pour ce groupe
                    if ( parcour( p, dejaVu ) )
                    {
                        supprimer( dejaVu );
                        //le seul changement que l'on peut faire c'est de supprimer tout
                        aChangerQqch = true ;
                    }
                    //si il retourne faux c'est que ce n'est pas un groupe entouré
                    dejaVu = new ArrayList<Pilier>() ;
                }
                System.out.println("neutre"+p);
                //sinon il n'y a rien a changé
        }
        return aChangerQqch ;
    }

    //retourne vrai si n'a jamais trouvé de voisin vide ou neutre 
    public boolean parcour( Pilier p, ArrayList<Pilier> dejaVu )
    {
        //System.out.println(dejaVu);
        //System.out.println(Pilier.ensemblePilier);

        if (!dejaVu.contains(p))
        {
            //on note ce sommet
            dejaVu.add(p);

            //on parcour tout les voisins de ce pillier
            for( Pilier voisin : p.getVoisin() )
            {
                //condition qui font qu'il ne sont pas enfermé
                if ( voisin == null )                                                       { return false; }
                if ( voisin.getCouleur().equals("neutre") || voisin.getCouleur().isEmpty() ){ return false; }

                //condition de parcour
                //si il a un voisin de sa couleur
                if ( voisin.getCouleur().equals( p.getCouleur()) && !dejaVu.contains(voisin))
                {
                    //si il renvoie faux c'est qu'il a trouvé une sortie
                    if(!parcour( voisin , dejaVu ))
                    {return false;}
                }
                //si il sont d'une couleur different on continu puis on sort
            }
        }
        //si on a parcouru tout les voisin sans trouvé de sortie
        return true ;
    }


    
    /** Methodes qui rend neutre a nouveau les pilier qui sont donner 
     * 
     * @param list
     */
    public void supprimer( ArrayList<Pilier> list )
    {
        for (Pilier p : Pilier.ensemblePilier) 
        {
            if (list.contains(p))
            {
                p.setCouleur("neutre");
            }
        }
    }


    /*R4
    Fin de Jeu et décompte
    - Si un Architecte possède 9 Dalle, à un moment de la partie, il l’emporte
    immédiatement.
    - Lorsque les Architectes ont construit 24 Piliers, l’Architecte contrôlant
    le plus de Dalles l’emporte
    R4 en cas d’égalité, l’Architecte ayant détruit le plus de Pilier l’emporte*/

    /*public void verificationFinJeu()
    {
        // Vérification du nombre de Dalle de chaque joueur
        if( joueur1.getNbDalle() >= 9 ) { continueJeu = false; gagnant = joueur1; }
        if( joueur2.getNbDalle() >= 9 ) { continueJeu = false; gagnant = joueur2; }

        // Vérification du nombre de Piliers construits
        if( Piler.cptPilierPose <= 0 )
        {
            continueJeu = false;
            
            // Contrôle du joueur qui a le plus de dalle
            if( joueur1.getNbDalle() > joueur2.getNbDalle() ) { gagnant = joueur1; } // Cas où le joueur1 a le plus de Dalles
            else
            {
                if( joueur1.getNbDalle() < joueur2.getNbDalle() ) { gagnant = joueur2; } // Cas où le joueur2 a le plus de Dalles
                else // Cas d'égalité en nombre de Dalles possédées
                {
                    if( joueur1.getNbPilierDetruit() > joueur2.getNbPilierDetruit() ) { gagnant = joueur1; } // Cas où le joueur1 a détruit le plus de Piliers
                    else
                    {
                        if( joueur1.getNbPilierDetruit() < joueur2.getNbPilierDetruit() ) { gagnant = joueur2; } // Cas où le joueur2 a détruit le plus de Piliers
                    }
                }
            } // Si à la fin de cette boucle ( continueJeu == true ) mais ( gagnant == null ), c'est qu'il y a égalité parfaite
        }
    }*/
    
    public String toString()
    {
        return plateau.toString();
    }
}