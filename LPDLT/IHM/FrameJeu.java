package LPDLT.IHM ;
import LPDLT.Controleur ;


import LPDLT.Metier.Dalle ;
import LPDLT.Metier.Pilier ;

import java.awt.event.*;
import javax.swing.* ;
import java.util.ArrayList ;

public class FrameJeu extends JFrame implements MouseListener
{

    /*----Attribut----*/

    private Controleur ctrl ;

    /*----Panel----*/
    
    private PanelJeu panel ;

    /*----Constructeur----*/

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

    /*----Methodes----*/

    public void maj(){
        panel.maj();
    }


    public void mouseExited(MouseEvent e)
    {
        System.out.println(e.getX()+":"+e.getY());
    }

    public void mouseEntered(MouseEvent e)
    {
        System.out.println(e.getX()+":"+e.getY());
    }

    public void mouseReleased(MouseEvent e)
    {
        System.out.println(e.getX()+":"+e.getY());
    }

    public void mousePressed(MouseEvent e)
    {
        System.out.println(e.getX()+":"+e.getY());
    }

    public void mouseClicked(MouseEvent e)
    {
        System.out.println(e.getX()+":"+e.getY());
    }
}