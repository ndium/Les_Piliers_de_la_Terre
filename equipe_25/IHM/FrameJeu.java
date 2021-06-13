package equipe_25.IHM ;

import equipe_25.Controleur ;
import equipe_25.Metier.Architecte;
import equipe_25.Metier.Dalle ;
import equipe_25.Metier.Pilier ;

import javax.swing.* ;
import java.awt.event.WindowEvent;
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
        panel = new PanelJeu(ctrl,ensembleDalles , ensemblePilier);

        this.setTitle("Les Piliers De La terre");
        this.setSize(420,350);
        this.setDefaultCloseOperation(3);
        this.add(panel) ;

        this.setVisible(true);
    }

    /*----Methodes----*/

    protected void processWindowEvent( WindowEvent e) 
    {
        //message quand la fenetre ce ferme
        if (e.getID() == WindowEvent.WINDOW_CLOSING && this.getDefaultCloseOperation() == EXIT_ON_CLOSE)
            ctrl.afficherScore();

        super.processWindowEvent(e);
    }

    public void maj(){
        panel.maj();
    }

}