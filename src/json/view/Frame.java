package json.view;

import javax.swing.JFrame;
import javax.swing.JScrollPane;
import java.awt.BorderLayout;
import java.awt.Color;


/**
 *  Frame de l'inspecteur JSON
 */

public class Frame extends JFrame{

    /**
     *  {@link VueHaut}
     */
    private VueHaut vh;

    /**
     *  {@link VuePrincipale}
     */
    private VuePrincipale vp;

    /**
     *  {@link VueBas}
     */
    private VueBas vb;

    /**
     *  scroll de {@link VuePrincipale}
     */
    private JScrollPane jsp;

    /**
     *  Creation de la Frame
     */
    public Frame(){
        super("JSON Manager");
       
        this.vh = new VueHaut(this);
        this.vb = new VueBas(this);
        this.vp = new VuePrincipale(this);
        this.jsp = new JScrollPane(this.vp);

        this.add(this.vh , BorderLayout.NORTH);
        this.add(this.jsp,BorderLayout.CENTER);
        this.add(this.vb,BorderLayout.SOUTH);

        this.ConfigFrame();
    }

    /** 
     * Configuration de la Frame {@link Frame}
    */
    public void ConfigFrame(){
        this.setBackground(new Color(33,33,34));
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setSize(1000,600);
        this.setLocationRelativeTo(null);
        this.setVisible(true); 
    }

    /** 
     * @return {@link VueHaut} de la {@link Frame}
     * 
    */  
    public VueHaut getVueHaut(){
        return this.vh;
    }

     /** 
     * @return {@link VuePrincipale} de {@link Frame}
     * 
    */  
    public VuePrincipale getVuePrincipale(){
        return this.vp;
    }

     /** 
     * @return {@link VueBas} de {@link Frame}
     * 
    */  
    public VueBas getVueBas(){
        return this.vb;
    }

    /**
     * reinitialisation de {@link VuePrincipale} de {@link Frame}
     */
    public void setVuePrincipale(){
        if(this.jsp != null){
            this.remove(this.jsp);
        }
        this.vp.removeAll();
        this.jsp = new JScrollPane(this.vp);
        this.add(jsp,BorderLayout.CENTER);
        this.revalidate();
    }
}