package PDLT.IHM ;
import PDLT.Controleur ;

import javax.swing.* ;

public class FrameJeu extends JFrame{

    private Controleur ctrl ;

    public FrameJeu(Controleur ctrl)
    {
        this.ctrl = ctrl ;

        this.setTitle("Les Piliers De La terre");
        this.setSize(1100,680);
        this.setDefaultCloseOperation(3);

        this.add(new JLabel(new ImageIcon("/images/pilier_gris.png")));
    
        //this.addMouseListener();
        //this.addMouseMotionListener();
    }


}