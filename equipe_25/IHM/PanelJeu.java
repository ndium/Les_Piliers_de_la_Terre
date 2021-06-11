package equipe_25.IHM ;
import equipe_25.Metier.Dalle ;
import equipe_25.Metier.Pilier ;

import javax.swing.* ;
import java.awt.*;
import java.util.ArrayList ;


public class PanelJeu extends JPanel
{
    //Constante de chemin pour les image
    private final String CHEMIN_DALLE   = "./equipe_25/images/Dalle.png";
    private final String CHEMIN_PILIER  = "./equipe_25/images/pilier_";
    private final String CHEMIN_ANNEAU  = "./equipe_25/images/anneau_";

    //ensemble changeant 
    private ArrayList<JLabel> tabLabelPilier = new ArrayList<JLabel>();
    private ArrayList<JLabel> tabLabelAnneau = new ArrayList<JLabel>();

    /*----Attribut----*/
    private ArrayList<Dalle>  ensembleDalle ;
    private ArrayList<Pilier> ensemblePilier ;

    /*----Constructeur----*/

    public PanelJeu(ArrayList<Dalle> ensembleDalle,ArrayList<Pilier> ensemblePilier)
    {
        this.setLayout(null);
        this.ensembleDalle  = ensembleDalle ;
        this.ensemblePilier = ensemblePilier ;

        /*----Creation des Anneaux----*/

        for (Dalle d : ensembleDalle)
        {
            JLabel labelTmp = new JLabel(new ImageIcon(CHEMIN_ANNEAU+d.getCouleur()+".png"));

            tabLabelAnneau.add(labelTmp);
            
            this.add(labelTmp);

            labelTmp.setLocation(d.getX()-33,d.getY()-33);
            labelTmp.setSize(67,67);
        }

        /*----Creation des Pilier----*/

        for(Pilier p : ensemblePilier)
        {
            JLabel labelTmp = new JLabel( new ImageIcon(CHEMIN_PILIER+p.getCouleur()+".png"));

            tabLabelPilier.add(labelTmp);

            this.add(labelTmp);

            labelTmp.setLocation(p.getX()-6,p.getY()-6); 
            labelTmp.setSize(13,13);          
        }

        /*----Creation des Dalle----*/

        for (Dalle d : ensembleDalle)
        {
            //JLabel specialement pour les numeros
            JLabel labelTmp = new JLabel(
                
                new ImageIcon(CHEMIN_DALLE)
                {
                    //on redefinie cette methode a la voler specialement pour les ID 
                    //elle est l'equivalent de PaintComponent pour les ImageIcon

                    public void paintIcon(Component c, Graphics g, int x, int y) 
                    {
                        super.paintIcon(c,g,x,y);

                        Graphics2D g2d = (Graphics2D)g ;
            
                        g2d.setFont(new Font("HANGING_BASELINE", Font.BOLD, 16));
                    
                        g2d.drawString(Character.toString(d.getID()) ,28,38);
                    }
                });

            //les dalle n'ont pas de ensembleDallee car on n'a pas besoin d'y retoucher apres
            this.add(labelTmp);
            labelTmp.setLocation(d.getX()-33,d.getY()-33);
            labelTmp.setSize(67,67);
        }

    }

    /*-------------MAJ-------------*/
    public void maj()
    {
        //mise a jour des anneaux

        for (int i=0  ; i<tabLabelAnneau.size(); i++)
        {
            tabLabelAnneau.get(i).setIcon(new ImageIcon(CHEMIN_ANNEAU+ensembleDalle.get(i).getCouleur()+".png"));

            tabLabelAnneau.get(i).setSize(67,67);
        }

        // mise a jour des Pilliers

        for(int i=0  ; i<tabLabelPilier.size(); i++)
        {
            tabLabelPilier.get(i).setIcon( new ImageIcon(CHEMIN_PILIER+ensemblePilier.get(i).getCouleur()+".png"));

            tabLabelPilier.get(i).setSize(13,13);          
        }
        //Dalle n'a pas besoin d'etre mise a jour
    }
}