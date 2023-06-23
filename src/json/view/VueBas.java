package json.view;

import javax.swing.JPanel;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.Color;
import java.awt.GridBagConstraints;

import json.controler.EventFrame;

/**
 *  Footer de {@link Frame}
 */
public class VueBas extends JPanel{
    
    /**
     * Bouton deplier
     */
    private BeauBouton deplier;

    /**
     * Bouton traduire
     */
    private BeauBouton traductionPhp;

    /**
     * @param frame {@link Frame}
     */
    public VueBas(Frame frame){

        this.deplier = new BeauBouton("Tout deplier", 30);
        this.deplier.addActionListener(new EventFrame(frame));
        
        this.traductionPhp = new BeauBouton("Basculer en PHP", 30);
        this.traductionPhp.addActionListener(new EventFrame(frame));

        this.setBackground(new Color(33,33,34));

        this.setLayout(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();

        gbc.gridx = 1;     
        gbc.gridy = 0;      
        gbc.gridwidth = 1;  
        gbc.gridheight = 1; 
        gbc.fill = GridBagConstraints.NONE;     
        gbc.anchor = GridBagConstraints.CENTER; 
        gbc.weightx = 1.0;  
        gbc.weighty = 1.0;  
        gbc.insets = new Insets(0, 200, 15, 0);   
        this.add(deplier,gbc);

        gbc.gridx = 2;     
        gbc.gridy = 0;      
        gbc.gridwidth = 1;  
        gbc.gridheight = 1; 
        gbc.fill = GridBagConstraints.NONE;     
        gbc.anchor = GridBagConstraints.CENTER; 
        gbc.weightx = 1.0;  
        gbc.weighty = 1.0;  
        gbc.insets = new Insets(0, 0, 15, 200);   
        this.add(traductionPhp,gbc);

    }

    /**
     * @return bouton deplier 
     */
    public BeauBouton getDeplier(){
        return this.deplier;
    }

    /**
     * @return bouton traduire
     */
    public BeauBouton getTraductionPhp(){
        return this.traductionPhp;
    }
}
