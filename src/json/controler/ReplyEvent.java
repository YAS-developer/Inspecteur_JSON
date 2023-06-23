package json.controler;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.LinkedList;
import json.view.LabelModel;
import json.view.VuePrincipale;


/**
 * Evenement du replie syntaxique
 */
public class ReplyEvent implements MouseListener {

    /**
     * {@link VuePrincipale}
    */
    private VuePrincipale vp;

    /**
     * {@link LabelModel}
    */
    private LabelModel lb;

    /**
     * 
     * @param vp {@link VuePrincipale} de la vue
     * @param lb {@link LabelModel} Label de l'evenement
    */
    public ReplyEvent(VuePrincipale vp, LabelModel lb)
    {
        this.vp = vp;
        this.lb = lb;
    }

    @Override
    public void mouseClicked(MouseEvent e) {
        // on inverse le boolean du noeud cliquer
        this.lb.getNode().setVisible(!this.lb.getNode().getVisible());
        vp.getFrame().setVuePrincipale();
        EventFrame.getTree().AffichePanel(vp);
    }

    @Override
    public void mousePressed(MouseEvent e) {
        // TODO Auto-generated method stub
        
    }

    @Override
    public void mouseReleased(MouseEvent e) {
        // TODO Auto-generated method stub
        
    }

    @Override
    public void mouseEntered(MouseEvent e) {
        // TODO Auto-generated method stub
        
    }

    @Override
    public void mouseExited(MouseEvent e) {
        // TODO Auto-generated method stub
        
    }
}
