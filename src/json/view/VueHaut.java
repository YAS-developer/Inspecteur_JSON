package json.view;

import java.awt.Color;
import java.awt.Font;
import javax.swing.JPanel;
import javax.swing.JTextField;
import json.controler.EventFrame;
import java.awt.BorderLayout;


/**
 *  Header de {@link Frame}
 */

public class VueHaut extends JPanel{
    
    /**
     * barre pour url
     */
    private JTextField barre;

    /**
     * bouton valider
     */
    private BeauBouton valider;

    

    /**
    *  @param frame {@link Frame}
    */
    public VueHaut(Frame frame){
        this.setLayout(new BorderLayout());
        this.barre = new JTextField("Veuillez inserer une url d'un fichier json");
        this.barre.addMouseListener(new EventFrame(frame));
        this.barre.setBackground(new Color(51,51,51));
        this.barre.setFont(new Font("Arial",1,20));
        this.barre.setForeground(new Color(204,204,204));


        this.valider = new BeauBouton("Valider",30);
        this.valider.addActionListener(new EventFrame(frame));

        this.add(barre, BorderLayout.CENTER);
        this.add(valider, BorderLayout.EAST);
    }


    /**
    * @return barre url
    */
    public JTextField getBarre(){
        return this.barre;
    }

    /**
    * @return bouton valider
    */
    public BeauBouton getValider(){
        return this.valider;
    }

}
