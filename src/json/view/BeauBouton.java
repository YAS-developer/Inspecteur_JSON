package json.view;

import java.awt.*;
import javax.swing.*;


/**
 *  Bouton pour la vue
 */

public class BeauBouton extends JButton {

    /**
     * taille de la police
     */
    private int fontSize;

    /**
     * police
     */
    private Font font;


    /**
     * @param text texte du bouton
     * @param size taille du bouton
     */
    public BeauBouton(String text, int size) {

        super(text);
        this.fontSize = size;
        font = new Font("Serif", Font.PLAIN, fontSize);
        this.setForeground(Color.BLACK);
        this.setBackground(Color.WHITE);
        this.setHorizontalAlignment(SwingConstants.CENTER);
        this.setFont(font);
        this.setFocusPainted(false);

    }

    /**
     * @param text texte du bouton
     * @param size taille du bouton
     * @param img image du bouton
     */ 
    public BeauBouton(String text, int size, ImageIcon img) {

        super(text, img);
        this.fontSize = size;
        font = new Font("Serif", Font.PLAIN, fontSize);

        this.setForeground(Color.BLACK);
        this.setHorizontalAlignment(SwingConstants.CENTER);
        this.setFont(font);
        this.setOpaque(false);
        this.setContentAreaFilled(false);
        this.setBorderPainted(false);
        this.setFocusPainted(false);

    }
}