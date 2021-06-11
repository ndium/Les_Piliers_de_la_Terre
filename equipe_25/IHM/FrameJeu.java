package equipe_25.IHM ;
import equipe_25.Controleur ;
import equipe_25.Metier.Architecte;
import equipe_25.Metier.Dalle ;
import equipe_25.Metier.Pilier ;

import javax.swing.* ;
import java.util.ArrayList ;

public class FrameJeu extends JFrame
{

    /*----Attribut----*/

    private Controleur ctrl ;

    /*----Panel----*/
    
    private PanelJeu panel ;

    /*----Constructeur----*/

    public FrameJeu(Controleur ctrl, ArrayList<Dalle> ensembleDalles,ArrayList<Pilier> ensemblePilier, Architecte joueur )
    {
        this.ctrl = ctrl ;

        panel = new PanelJeu(ensembleDalles , ensemblePilier);

        this.setTitle("Les Piliers De La terre");
        this.setSize(400,300);
        this.setDefaultCloseOperation(3);
        this.add(panel) ;
        this.addMouseListener(joueur);

        this.setVisible(true);
    }

    /*----Methodes----*/

    public void maj(){
        panel.maj();
    }

}