package LPDLT.IHM ;
import LPDLT.Metier.Dalle ;
import LPDLT.Metier.Pilier ;

import javax.swing.* ;
import java.awt.*;
import java.util.ArrayList ;


public class PanelJeu extends JPanel
{
    //Constante
    //!\ Modifier les chemins pour qu'il n'y ait a rajouté que les couleur
    private final String IMAGE_DALLE        = "./LPDLT/images/Dalle.png";
    private final String IMAGE_PILIER_GRIS  = "./LPDLT/images/pilier_gris.png";
    private final String IMAGE_PILIER_MARON = "./LPDLT/images/pilier_maron.png";
    private final String IMAGE_ANNEAU_GRIS  = "./LPDLT/images/anneau_gris.png";
    private final String IMAGE_ANNEAU_MARON = "./LPDLT/images/anneau_maron.png";

    //ensemble changeant 
    private ArrayList<JLabel> tabLabelPilier = new ArrayList<JLabel>();
    private ArrayList<JLabel> tabLabelAnneau = new ArrayList<JLabel>();

    //attribut
    private ArrayList<Dalle>  list ;
    private ArrayList<Pilier> ensemblePilier ;

    public PanelJeu(ArrayList<Dalle> list,ArrayList<Pilier> ensemblePilier)
    {
        this.setLayout(null);
        this.list = list ;
        this.ensemblePilier = ensemblePilier ;

        /*----------------------*/
        /* Creation des Anneaux */
        /*----------------------*/

        for (Dalle d : list)
        {
            JLabel labelTmp = new JLabel(new ImageIcon(""));

            if (d.getCouleur().equals("Gris"))
                labelTmp= new JLabel(new ImageIcon(IMAGE_ANNEAU_GRIS));

            if (d.getCouleur().equals("Maron"))
                labelTmp= new JLabel(new ImageIcon(IMAGE_ANNEAU_MARON));

            tabLabelAnneau.add(labelTmp);
            this.add(labelTmp);
            labelTmp.setLocation(d.getX()-33,d.getY()-33);
            labelTmp.setSize(67,67);
        }

        /*---------------------*/
        /* Creation des Pilier */
        /*---------------------*/

        for(Pilier p : ensemblePilier)
        {
            JLabel labelTmp = new JLabel(new ImageIcon(""));

            if (p.getCouleur().equals("Gris")){
                labelTmp.setIcon(new ImageIcon(IMAGE_PILIER_GRIS));
            }

            if (p.getCouleur().equals("Maron")){
                labelTmp.setIcon(new ImageIcon(IMAGE_PILIER_MARON));
            }

            tabLabelPilier.add(labelTmp);
            this.add(labelTmp);
            labelTmp.setLocation(p.getX()-6,p.getY()-6); 
            labelTmp.setSize(13,13);          
        }

        /*--------------------*/
        /* Creation des Dalle */
        /*--------------------*/

        for (Dalle d : list)
        {

            /* On fait creer un panel avec un icone dedans*/

            JLabel labelTmp = new JLabel(
                
                new ImageIcon(IMAGE_DALLE)
                {
                    public synchronized void paintIcon(Component c, Graphics g, int x, int y) 
                    {
                        super.paintIcon(c,g,x,y);

                        Graphics2D g2d = (Graphics2D)g ;
            
                        g2d.setFont(new Font("HANGING_BASELINE", Font.BOLD, 16));
                    
                        g2d.drawString(Character.toString(d.getID()) ,28,38);
                    }
                });

            this.add(labelTmp);
            labelTmp.setLocation(d.getX()-33,d.getY()-33);
            labelTmp.setSize(67,67);
        }

        //this.addMouseListener();
        //this.addMouseMotionListener();

    }
    public void getID(int index)
    {
        tabLabelPilier.get(index).setIcon(null);
    }

    public void prendrePilier(String couleur,int index)
    {
        if(couleur.equals("GRIS")){
            tabLabelPilier.get(index).setIcon(new ImageIcon(IMAGE_PILIER_GRIS));
        }
        if(couleur.equals("MARON")){
            tabLabelPilier.get(index).setIcon(new ImageIcon(IMAGE_PILIER_MARON));
        }
    }

    public void detruirePilier(int index)
    {
        tabLabelPilier.get(index).setIcon(null);
    }
}