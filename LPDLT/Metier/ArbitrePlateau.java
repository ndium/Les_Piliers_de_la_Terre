package LPDLT.Metier;

import LPDLT.Controleur ;

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

    public void ajouterPilier(char dalle, int index, String couleur)
    {
        plateau.setPilier(dalle, index, couleur);
        // verification du plateau
    }




    /*R1 
    La prise de contrôle par majorité
    Lorsqu’un Architecte place son 4
    ème Pilier sur une même dalle, il en prend le
    contrôle et place son ou ses Anneaux de prise de contrôle.*/

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