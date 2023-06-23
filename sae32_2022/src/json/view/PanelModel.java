package json.view;

import java.awt.Color;

import javax.swing.JPanel;
import java.awt.FlowLayout;


/**
 * panel pour la dispositon de {@link VuePrincipale}
 */
public class PanelModel extends JPanel {
    /**
     * creation du panel
     */
    public PanelModel()
    {
        super(new FlowLayout(FlowLayout.LEFT,1,1));
        this.setBackground(new Color(33,33,34));
    }
    
}
