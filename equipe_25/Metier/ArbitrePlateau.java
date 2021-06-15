package equipe_25.Metier;

import equipe_25.Controleur;

import java.util.ArrayList;

public class ArbitrePlateau implements java.io.Serializable
{
    /*--------Attribut---------*/
    private Parterre plateau ;
    private Controleur ctrl ;

    private ArrayList<Dalle>  ensembleDalle  ;
    private ArrayList<Pilier> ensemblePilier ;

    private static ArrayList<Pilier> datationEntourant = new ArrayList<Pilier>();

    
    /*-------------Constructeur--------------*/
    public ArbitrePlateau(Controleur ctrl)
    {
        this.plateau = new Parterre();
        this.ctrl = ctrl ;

        this.ensembleDalle  =  Dalle .getEnsembleDalle () ;
        this.ensemblePilier =  Pilier.getEnsemblePilier() ;
    }



    public boolean ajouterPilier(char dalle, int index, String couleur)
    {
        if (this.plateau.getPilier(dalle,index) != null)
        {
            //si l'endroit est vide
            if( (this.plateau.getPilier(dalle, index).getCouleur().equals("neutre") || this.plateau.getPilier(dalle, index).getCouleur().isEmpty()) && Pilier.cptPilierPose < this.plateau.getPilier(dalle,index).getDate()-1 )
            {
                this.plateau.setPilier(dalle, index, couleur) ;
                ///on verifie le plateau jusqu'a qu'il n'y ait plus rien a faire changer
                while(checkPlateau( this.plateau ));

                return true;
            }
            else
            {
                System.out.println( "\nPlacement impossible !!" );
                return false;
            }
        }
        else
        {
            return false ;
        }
    }

    public boolean ajouterPilier(int x , int y, String couleur)
    {

        if (this.plateau.getPilier(x,y) != null )
        {
            if(( this.plateau.getPilier(x,y).getCouleur().equals("neutre") || plateau.getPilier(x,y).getCouleur().isEmpty() ) && Pilier.cptPilierPose < this.plateau.getPilier(x,y).getDate()-1 )
            {
                this.plateau.setPilier(x,y, couleur);
                
                while(checkPlateau( this.plateau ));

                return true;
            }
            else
            {
                System.out.println( "\nIl y a déjà un Pilier ici !!" );
                return false;
            }            
        }
        else{
            return false ;
        }


    }

    /*----------------Verification-----------------*/
    public boolean checkPlateau( Parterre plateau )
    {
        //si un des 2 a modifier qqch
        return Regle1_2( this.plateau ) ||
               Regle3  ( this.plateau );
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
        for( Dalle d: this.ensembleDalle )
        {
            boolean detruire = true ;
            int cptGris  = 0;
            int cptmarron = 0;

            //on parcour ces pillier et on note les score
            for( int i = 0; i < 6; i++ )
            {
                if( d.getPilier()[i].getCouleur().equals("gris")  ) { cptGris++;  }
                if( d.getPilier()[i].getCouleur().equals("marron") ) { cptmarron++; }
            }

            //si on n'a 4 pillier ou plus 
            if( cptGris  >= 4 ) 
            {
                //si la dalle est deja de cette couleur elle ne dtruira pas les pilier
                if (!d.getCouleur().equals("gris"))
                {
                    d.setCouleur(ctrl.getJoueur("gris"));
                    retour = true ;
                }
                else
                    detruire = false ;
            }

            if( cptmarron >= 4 ) 
            { 
                if (!d.getCouleur().equals("marron"))
                {
                    d.setCouleur(ctrl.getJoueur("marron"));
                    retour = true ;
                }
                else
                    detruire = false ;
            }

            //on pourrait reunnir les 2 if
            //si elle n'a plus ces 4 pilier 
            if (cptGris < 4 && d.getCouleur().equals("gris"))
            {
                d.supprimer(ctrl.getJoueur( d.getCouleur() )) ;
                retour = true ;
            }
            if (cptmarron < 4 && d.getCouleur().equals("marron"))
            {
                d.supprimer(ctrl.getJoueur( d.getCouleur() )) ;
                retour = true ;
            }

            // Destruction des piliers de couleur différente de la dalle
            if (detruire)
            {
                for( int i = 0; i < 6; i++ )
                {
                    if( !d.getCouleur().equals("neutre") && !d.getPilier()[i].getCouleur().equals( d.getCouleur() ) ) 
                    {
                        if (!d.getPilier()[i].getCouleur().equals("neutre"))
                        {
                            d.getPilier()[i].supprimer(ctrl.getJoueur(d.getCouleur()));
                        }
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

        //on va parcourir les pilier
        for ( Pilier p : this.ensemblePilier )
        {
            //if( !p.getCouleur().equals( Controleur.joueurActif.getCouleur() ) // && 
                //si le pilier et neutre on ne parcour pas ses voisin 
                if ( !(p.getCouleur().equals("neutre") || p.getCouleur().isEmpty()) )
                {
                    if (!ctrl.getJoueurActif().equals(p.getCouleur()))
                    {
                        //si parcour n'a pas trouvé de sortie pour ce groupe
                        if ( parcour( p, dejaVu ) )
                        {
                            //-1 quand + jeune + vieux 
                            if(this.datation(dejaVu , ArbitrePlateau.datationEntourant )==-1)
                            {
                                supprimer( dejaVu );
                                //le seul changement que l'on peut faire c'est de supprimer tout
                                aChangerQqch = true ;
                            }
                        }
                        //si il retourne faux c'est que ce n'est pas un groupe entouré
                        dejaVu = new ArrayList<Pilier>() ;
                    }

                }
                //sinon il n'y a rien a changé
        }
        return aChangerQqch ;
    }

    //retourne vrai si n'a jamais trouvé de voisin vide ou neutre 
    public boolean parcour( Pilier p, ArrayList<Pilier> dejaVu )
    {
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
                    if(!parcour( voisin , dejaVu )) {return false;}
                }
                else{
                    if (!voisin.getCouleur().equals(p.getCouleur()))
                    {
                        ArbitrePlateau.datationEntourant.add(voisin);
                    }
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
        for (Pilier p : this.ensemblePilier)
        {
            if (list.contains(p))
            {
                p.supprimer(ctrl.getJoueurAdverse(p.getCouleur()));
            }
        }
    }

    public int datation( ArrayList<Pilier> groupe , ArrayList<Pilier> entourant)
    {
        int dateMax1 = 48 ;
        int dateMax2 = 48 ;

        for (Pilier p : groupe) {
            if (p.getDate() < dateMax1 ) {dateMax1 = p.getDate() ;  } 
        }

        for (Pilier p : entourant) {
            if (p.getDate() < dateMax2 ) {dateMax2 = p.getDate() ;  } 
        }

        ArbitrePlateau.datationEntourant = new ArrayList<Pilier>() ;

        //le premier est + jeune 
        if (dateMax2 < dateMax1 )
        {
            return -1 ;
        }
        else 
            return +1 ;
    }
    
    public String toString()
    {
        return plateau.toString();
    }
}