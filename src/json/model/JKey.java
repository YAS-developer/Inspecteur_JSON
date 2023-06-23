package json.model;

import java.awt.Color;
import json.view.LabelModel;
import json.view.PanelModel;
import json.view.VuePrincipale;

/**
 *  Clé des valeurs json
*/

public class JKey extends JNoeud {
    private String key;
    public JKey(String key)
    {
        this.key = key;
    }

    @Override 
    public String affiche(boolean last, int ind)
    {
        String aff = "";

        for(int i = 0; i < ind; i++)
        {
            aff+="  ";
        }


        for(JNoeud jn : this.fils)
        {
                // si le noeud est  Objet
                if(jn instanceof JObject){
                    if(last)
                    {
                        aff+='"'+this.key+'"'+": "+jn.affiche(true, ind)+'\n';
                    }
                    else
                    {
                        aff+='"'+this.key+'"'+": "+jn.affiche(false, ind)+'\n';
                    }
                }
                // si le noeud est Tableau
                else if(jn instanceof JTab)
                {
                    if(last)
                    {
                        aff+='"'+this.key+'"'+": "+jn.affiche(true, ind+1)+'\n';
                    }
                    else
                    {
                        aff+='"'+this.key+'"'+": "+jn.affiche(false, ind+1)+'\n';
                    }
                }
                // si le noeud est un bool ou number ou string ou other
                else{
                        if(last)
                        {
                            aff+='"'+this.key+'"'+": "+jn.affiche(true, 0)+'\n';
                        }
                        else
                        {
                            aff+='"'+this.key+'"'+": "+jn.affiche(false, 0)+'\n';
                        }
                }   
        }
        return aff;
    }

    @Override
    public void setIncrement(boolean oui){}


    @Override
    public void addToPanel(boolean last, int ind, VuePrincipale vp) {
        
        PanelModel pm = new PanelModel();
        
        String aff = "";

        for(int i = 0; i < ind; i++)
        {
            aff+="  ";
        }

        LabelModel espace = new LabelModel(aff);
        pm.add(espace);

        LabelModel lm = new LabelModel('"'+this.key+'"', new Color(152,118,170));
        pm.add(lm);
        pm.add(new LabelModel(": ", Color.YELLOW));

        

        // pm.setSize(new Dimension(10, 10));

       


        for(JNoeud jn : this.fils)
        {
                // si le noeud est  Objet
                if(jn instanceof JObject){
                    if(last)
                    {
                        jn.addToPanel(true, ind, vp, pm);
                    }
                    else
                    {
                        jn.addToPanel(false, ind, vp, pm);
                    }
                }
                // si le noeud est Tableau
                else if(jn instanceof JTab)
                {
                    
                    if(last)
                    {
                        jn.addToPanel(true, ind+1, vp, pm);
                    }
                    else
                    {
                        jn.addToPanel(false, ind+1, vp, pm);
                    }
                    // pm.setBackground(Color.green);
                    // vp.add(pm,vp.GridBagConfig());
                    
                }
                // si le noeud est un bool ou number ou string ou other
                else{
                        if(last)
                        {

                            // aff+='"'+this.key+'"'+": "+jn.affiche(true, 0)+'\n';
                            jn.addToPanel(true, 0, vp, pm);
                            vp.add(pm, vp.GridBagConfig());
                        }
                        else
                        {
                            // aff+='"'+this.key+'"'+": "+jn.affiche(true, 0)+'\n';
                                jn.addToPanel(false, 0, vp, pm);
                            vp.add(pm, vp.GridBagConfig());
                        }
                }   
        }

        
        
    }

    @Override
    public void addToPanel(boolean last, int indentation, VuePrincipale vp, PanelModel pm) {
        // TODO Auto-generated method stub
        
    }


    @Override
    public void setObjInTab(boolean b) {
        // TODO Auto-generated method stub
        
    }

    @Override
    public void affichePhp(boolean last, int ind, VuePrincipale vp) {
    
        PanelModel pm = new PanelModel();
        
        String aff = "";

        for(int i = 0; i < ind; i++)
        {
            aff+="  ";
        }

        pm.add(new LabelModel(aff));
        aff="";

        LabelModel lm = new LabelModel('['+this.key+']', new Color(152,118,170));
        pm.add(lm);
        pm.add(new LabelModel(" => ", Color.yellow));

        
        for(JNoeud jn : this.fils)
        {
                // si le noeud est  Objet
                if(jn instanceof JObject){
                        jn.affichePhp(false, ind+1, vp, pm);
                }
                // si le noeud est Tableau
                else if(jn instanceof JTab)
                {
                    if(last)
                    {
                        // aff+='['+this.key+']'+" => "+jn.affichePhp(true, ind+1)+'\n';
                        // pm.add(new LabelModel('['+this.key+']'+" => "));
                        jn.affichePhp(true, ind+1, vp, pm);
                    }
                    else
                    {
                        // aff+='['+this.key+']'+" => "+jn.affichePhp(false, ind+1)+'\n';
                        // pm.add(new LabelModel('['+this.key+']'+" => "));
                        jn.affichePhp(false, ind+1, vp, pm);

                    }
                }
                // si le noeud est un bool ou number ou string ou other
                else{
                    jn.affichePhp(true, 0, vp, pm);
                    vp.add(pm, vp.GridBagConfig());
                } 
            
        }
        }

    @Override 
    public void affichePhp(boolean last, int ind, VuePrincipale vp, PanelModel pm){}
    
    @Override
    public void setVisible(boolean b) {
        // TODO Auto-generated method stub
        
    }

    @Override
    public boolean getVisible() {
        return false;
    }

    @Override
    public void deplier(boolean b) {
        for(JNoeud jn : this.fils){
            if(jn instanceof JObject || jn instanceof JTab){
                jn.setVisible(b);
                jn.deplier(b);
            }
        }
    }
    


}
