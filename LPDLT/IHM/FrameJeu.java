package LPDLT.IHM ;
import LPDLT.Controleur ;
import LPDLT.Metier.Dalle ;

import javax.swing.* ;
import java.util.ArrayList ;

public class FrameJeu extends JFrame{

    /* -------- */
    /* Attribut */
    /* -------- */

    private Controleur ctrl ;

    //Constante
    private final ImageIcon imageDalle       = new ImageIcon("./LPDLT/images/Dalle.png");
    private final ImageIcon imagePillierGris = new ImageIcon("./LPDLT/images/pilier_gris.png");
    private final ImageIcon imagePillierMaron= new ImageIcon("./LPDLT/images/pilier_Maron.png");
    private final ImageIcon imageAnneauGris  = new ImageIcon("./LPDLT/images/anneau_gris.png");
    private final ImageIcon imageAnneauMaron = new ImageIcon("./LPDLT/images/anneau_maron.png");

    //panel dessous
    private JPanel panelDalle = new JPanel();

    //liste des dalle pour les changer
    private ArrayList<JLabel> tabPanelPillier = new ArrayList<JLabel>();

    /* ------------ */
    /* Constructeur */
    /* ------------ */

    public FrameJeu(Controleur ctrl, ArrayList<Dalle> list)
    {
        this.ctrl = ctrl ;

        this.setTitle("Les Piliers De La terre");
        this.setSize(400,300);
        this.setDefaultCloseOperation(3);
        panelDalle.setLayout(null);

        /*--------------------*/
        /* Creation des Dalle */
        /*--------------------*/

        for (Dalle d : list) 
        {
            JLabel labelTmp = new JLabel(imageDalle);

            panelDalle.add(labelTmp);
            labelTmp.setLocation(d.getX(),d.getY()); 
            labelTmp.setSize(67,67);
        }
        this.add(panelDalle);

        //tabPanelDalle.get(8).setIcon(imagePillierGris);

        //this.addMouseListener();
        //this.addMouseMotionListener();

        this.setVisible(true);
    }

    /* -------- */
    /* Methodes */
    /* -------- */

    public void maj(){

    }


}