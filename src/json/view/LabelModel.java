package json.view;

import java.awt.Color;
import javax.swing.JLabel;
import json.model.JNoeud;


/**
 * Label pour la disposiotion de {@link VuePrincipale} 
*/
public class LabelModel extends JLabel {

    /**
     * noeud du label
    */
    private JNoeud node;

    /**
     * 
     * @param s chaine de caracteres du Label
     */
    public LabelModel(String s)
    {
        super(s);
        this.setForeground(Color.WHITE);
    }


     /**
     * 
     * @param s chaine de caracteres du Label
     * @param c couleur de la police du Label
    */    
    public LabelModel(String s, Color c)
    {
        super(s);
        this.setForeground(c);


    }


    /**
     * 
     * @param s chaine de caracteres du Label
     * @param c couleur de la police du Label
     * @param node {@link JNoeud} du Label
    */
    public LabelModel(String s, Color c, JNoeud node)
    {
        super(s);
        this.setForeground(c);
        this.node = node;

    }

    /**
     * 
     * @return JNoeud du Label
    */
    public JNoeud getNode()
    {
        return this.node;
    }
    
}
