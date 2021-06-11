package equipe_25.CUI;

import equipe_25.Controleur;
import equipe_25.Metier.Dalle;
import equipe_25.Metier.Pilier;

import java.util.ArrayList;

public class CUI
{
    Controleur ctrl;

    private ArrayList<Dalle>    ensembleDalle;
    private ArrayList<Pilier>   ensemblePilier;

    public CUI(Controleur ctrl, ArrayList<Dalle> ensembleDalles, ArrayList<Pilier> ensemblePilier)
    {
        this.ctrl = ctrl;

        this.ensemblePilier = ensemblePilier;
        this.ensembleDalle  = ensembleDalles;

    }


}