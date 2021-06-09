package LPDLT.CUI;

import LPDLT.Controleur;
import LPDLT.Metier.Dalle;
import LPDLT.Metier.Pilier;

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