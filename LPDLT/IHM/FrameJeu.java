package LPDLT.IHM ;
import LPDLT.Controleur ;

import java.util.Scanner;
import java.io.FileInputStream;
import javax.swing.* ;

public class FrameJeu extends JFrame{

    private Controleur ctrl ;
    private ImageIcon imageDalle = new ImageIcon("./LPDLT/images/Dalle.png");
    private JLabel labelDalle = new JLabel(imageDalle);

    public FrameJeu(Controleur ctrl)
    {
        this.ctrl = ctrl ;

        this.setTitle("Les Piliers De La terre");
        this.setSize(1100,680);
        this.setDefaultCloseOperation(3);

        this.add(labelDalle);

        //this.add(new JLabel(new ImageIcon("/images/pilier_gris.png")));
    
        //this.addMouseListener();
        //this.addMouseMotionListener();

        this.setVisible(true);
    }

    public void maj(){

    }


}