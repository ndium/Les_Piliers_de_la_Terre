package equipe_25.IHM ;
import equipe_25.Controleur ;
import equipe_25.Metier.Dalle ;
import equipe_25.Metier.Pilier ;
import equipe_25.Metier.Architecte ;


import javax.swing.* ;
import java.awt.*;
import java.util.ArrayList ;


public class PanelJeu extends JPanel implements java.io.Serializable
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
    private Controleur ctrl ;

    /*----Constructeur----*/

    public PanelJeu(Controleur ctrl ,ArrayList<Dalle> ensembleDalle,ArrayList<Pilier> ensemblePilier)
    {
        this.setLayout(null);
        this.ctrl = ctrl ;
        this.addMouseListener(this.ctrl.getJoueurActif());
        this.ensembleDalle  = ensembleDalle ;
        this.ensemblePilier = ensemblePilier ;
        //pas obligatoire 
        this.setBackground((this.ctrl.getJoueurActif().getCouleur().equals("gris"))? Color.GRAY : Color.ORANGE);

        /*----Creation des Anneaux----*/

        for (Dalle d : this.ensembleDalle)
        {
            JLabel labelTmp = new JLabel(new ImageIcon(this.CHEMIN_ANNEAU + d.getCouleur() + ".png"));

            this.tabLabelAnneau.add(labelTmp);
            
            this.add(labelTmp);

            labelTmp.setLocation(d.getX()-33,d.getY()-33);
            labelTmp.setSize(67,67);
        }

        /*----Creation des Pilier----*/

        for(Pilier p : this.ensemblePilier)
        {
            JLabel labelTmp = new JLabel( new ImageIcon(this.CHEMIN_PILIER+p.getCouleur()+".png"));

            this.tabLabelPilier.add(labelTmp);

            this.add(labelTmp);

            labelTmp.setLocation(p.getX()-6,p.getY()-6); 
            labelTmp.setSize(13,13);          
        }

        /*----Creation des Dalle----*/

        for (Dalle d : this.ensembleDalle)
        {
            //JLabel specialement pour les numeros
            JLabel labelTmp = new JLabel(
                
                new ImageIcon(this.CHEMIN_DALLE)
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
        //pas obligatoire
        this.setBackground((this.ctrl.getJoueurActif().getCouleur().equals("gris"))? Color.GRAY : Color.ORANGE);

        //mise a jour des anneaux

        for (int i=0  ; i < this.tabLabelAnneau.size(); i++)
        {
            this.tabLabelAnneau.get(i).setIcon(new ImageIcon(this.CHEMIN_ANNEAU + this.ensembleDalle.get(i).getCouleur()+".png"));

            this.tabLabelAnneau.get(i).setSize(67,67);
        }

        // mise a jour des Piliers

        for(int i = 0  ; i < this.tabLabelPilier.size(); i++)
        {
            this.tabLabelPilier.get(i).setIcon( new ImageIcon(this.CHEMIN_PILIER + this.ensemblePilier.get(i).getCouleur()+".png"));

            this.tabLabelPilier.get(i).setSize(13,13);
        }
        //Dalle n'a pas besoin d'etre mise a jour
    }
}