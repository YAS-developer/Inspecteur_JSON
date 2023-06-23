package json.view;

import java.awt.Color;
import java.util.LinkedList;
import javax.swing.JPanel;
import java.awt.*;



/**
 *  Body de {@link Frame}   
 */
public class VuePrincipale extends JPanel{

    /**
     * modifie la ligne pour ajouter un composant
     */
    private static int countGrid;
    
    /**
     * {@link Frame}
     */
    private Frame frame;
    
    /**
     * 
     * @param frame {@link Frame}
    */
    public VuePrincipale(Frame frame){
        this.frame = frame;
        this.setBackground(new Color(33,33,34));
        this.setLayout(new GridBagLayout());
        VuePrincipale.countGrid = 0;
    }


    /**
     * 
     * @return GridBagConstraints de {@link VuePrincipale}
    */
    public GridBagConstraints GridBagConfig()
    { 
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.anchor = GridBagConstraints.LINE_START;
        gbc.fill = GridBagConstraints.NONE;
        gbc.weightx = 1;
        gbc.weighty = 0;
        gbc.gridwidth = 0;           
        gbc.gridheight = 1;
        gbc.gridy = VuePrincipale.countGrid;
        gbc.insets = new Insets(0, 0, 0, 0);
        VuePrincipale.countGrid++;
        return gbc;
    }


    /***
     * 
     * @return recupere la frame de la vue {@link Frame}
    */
    public Frame getFrame()
    {
        return this.frame;
    }


}

