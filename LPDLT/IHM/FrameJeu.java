package LPDLT.IHM ;
import LPDLT.Controleur ;
import LPDLT.Metier.Dalle ;

import javax.swing.* ;
import java.util.ArrayList ;

public class FrameJeu extends JFrame{

    private Controleur ctrl ;
    private JPanel panel = new JPanel();

    public FrameJeu(Controleur ctrl, ArrayList<Dalle> list)
    {
        this.ctrl = ctrl ;

        this.setTitle("Les Piliers De La terre");
        this.setSize(400,300);
        this.setDefaultCloseOperation(3);
        panel.setLayout(null);


        for (Dalle d : list) 
        {
            JLabel labelTmp = new JLabel(new ImageIcon("./LPDLT/images/Dalle.png"));
            panel.add(labelTmp);
            labelTmp.setLocation(d.getX(),d.getY()); 
            labelTmp.setSize(67,67);
        }
        this.add(panel);

        //this.addMouseListener();
        //this.addMouseMotionListener();

        this.setVisible(true);
    }

    public void maj(){

    }


}