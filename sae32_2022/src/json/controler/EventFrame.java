package json.controler;

import json.model.ArbreT;
import json.view.Frame;
import json.view.VuePrincipale;
import java.awt.event.MouseListener;
import java.io.IOException;
import java.io.InputStream;
import java.net.MalformedURLException;
import java.net.URL;
import java.awt.event.MouseEvent;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JOptionPane;


/**
 *  Event pour {@link Frame}
 */
public class EventFrame implements MouseListener, ActionListener{

    /**
    *  {@link Frame}
    */
    private Frame frame;

    /**
    *  url saisie dans la barre de recherche de {@link VuePrincipale}
    */
    private URL url;


    /**
     * Arbre syntaxique abstrait de {@link VuePrincipale}
     */
    private static ArbreT tree;


    /**
    *  @param frame {@link Frame}
    */
    public EventFrame(Frame frame){
        this.frame = frame;
        this.url = null;
    }


    @Override
    public void actionPerformed(ActionEvent e){


        // clique sur le bouton valider
        if(e.getSource().equals(frame.getVueHaut().getValider())){


            this.ConfigTree();
            try{
                EventFrame.tree.AffichePanel(frame.getVuePrincipale());  
            }
            catch(NullPointerException exception){
                JOptionPane.showMessageDialog(this.frame,"Veuillez selectionner un fichier json",null,JOptionPane.INFORMATION_MESSAGE);
            } 
        }

        // clique sur le bouton deplier/plier
        if(e.getSource().equals(frame.getVueBas().getDeplier())){
            if(frame.getVueBas().getDeplier().getText().equals("Tout deplier")){
                try{
                    this.frame.setVuePrincipale();
                    EventFrame.tree.deplierArbre(this.frame.getVuePrincipale(),true); 
                    this.frame.getVueBas().getDeplier().setText("Tout plier");
                }
                catch(NullPointerException exception){
                    JOptionPane.showMessageDialog(this.frame,"Veuillez selectionner un fichier json",null,JOptionPane.INFORMATION_MESSAGE);  
                } 
            }
            else{
                try{
                    this.frame.setVuePrincipale();
                    EventFrame.tree.deplierArbre(this.frame.getVuePrincipale(),false); 
                    this.frame.getVueBas().getDeplier().setText("Tout deplier");
                }
                catch(NullPointerException exception){
                    JOptionPane.showMessageDialog(this.frame,"Veuillez selectionner un fichier json",null,JOptionPane.INFORMATION_MESSAGE);  
                } 
            }
        }

        // clique sur le bouton Traduire
        if(e.getSource().equals(frame.getVueBas().getTraductionPhp())){
            if(frame.getVueBas().getTraductionPhp().getText().equals("Basculer en PHP")){
                try{
                    this.frame.setVuePrincipale();
                    EventFrame.tree.AfficheInPhp((frame.getVuePrincipale())); 
                    frame.getVueBas().getTraductionPhp().setText("Basculer en JSON");
                }
                catch(NullPointerException exception){
                    JOptionPane.showMessageDialog(this.frame,"Veuillez selectionner un fichier json",null,JOptionPane.INFORMATION_MESSAGE);  
                } 
            }
            else{
                try{
                    this.frame.setVuePrincipale();
                    EventFrame.tree.AffichePanel(frame.getVuePrincipale());
                    frame.getVueBas().getTraductionPhp().setText("Basculer en PHP");

                }
                catch(NullPointerException exception){
                    JOptionPane.showMessageDialog(this.frame,"Veuillez selectionner un fichier json",null,JOptionPane.INFORMATION_MESSAGE);  
                }
            }
        }
    }
    @Override
    public void mouseClicked(MouseEvent e){
        
        // clique sur la barre
        if(e.getComponent().equals(frame.getVueHaut().getBarre())){
            String path = frame.getVueHaut().getBarre().getText();
            if(path.equals("Veuillez inserer une url d'un fichier json")){
                frame.getVueHaut().getBarre().setText("");
            }
        }
    }

    @Override
    public void mousePressed(MouseEvent e){
        
    }

    @Override
    public void mouseReleased(MouseEvent e){
        
    }

    @Override
    public void mouseEntered(MouseEvent e){
       
    }

    @Override
    public void mouseExited(MouseEvent e){
        
    }

    /**
     * Creation de l'arbre et reinitialisation de {@link VuePrincipale}
     */
    public void ConfigTree()
    {
        try{
            this.url = new URL(frame.getVueHaut().getBarre().getText());

            try
            {
                InputStream is = url.openStream();
                EventFrame.tree = new ArbreT();
                EventFrame.tree.createTree(is);
                this.frame.setVuePrincipale(); 
            }
            catch(IOException exc)
            {
                System.out.println(exc);
            }
        }
        catch(MalformedURLException exc){
            JOptionPane.showMessageDialog(this.frame,"Veuillez selectionner un fichier json",null,JOptionPane.INFORMATION_MESSAGE);
        }
    }

    /**
     * 
     * @return Arbre syntaxique abstrait de {@link VuePrincipale}
    */
    public static ArbreT getTree(){
        if(EventFrame.tree != null){
            return EventFrame.tree;
        }
        return null;
    }
}