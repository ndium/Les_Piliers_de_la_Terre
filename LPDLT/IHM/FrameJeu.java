package LPDLT.IHM ;
import LPDLT.Controleur ;


import LPDLT.Metier.Dalle ;
import LPDLT.Metier.Pilier ;

import javax.swing.* ;
import java.util.ArrayList ;

public class FrameJeu extends JFrame{

    /* -------- */
    /* Attribut */
    /* -------- */

    private Controleur ctrl ;

    //panel
    private PanelJeu panel ;

    /* ------------ */
    /* Constructeur */
    /* ------------ */

    public FrameJeu(Controleur ctrl, ArrayList<Dalle> ensembleDalles,ArrayList<Pilier> ensemblePilier)
    {
        this.ctrl = ctrl ;

        panel = new PanelJeu(ensembleDalles , ensemblePilier);

        this.setTitle("Les Piliers De La terre");
        this.setSize(400,300);
        this.setDefaultCloseOperation(3);
        this.add(panel) ;

        this.setVisible(true);
    }

    /* -------- */
    /* Methodes */
    /* -------- */

    public void maj(){

    }
}