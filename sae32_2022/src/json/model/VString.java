package json.model;

import json.view.VuePrincipale;
import json.view.LabelModel;
import json.view.PanelModel;
import java.awt.Color;

/**
 *  Valeur Chaîne de caractères json
*/

public class VString extends JNoeud {
    
    private String value;

    public VString(String val)
    {
        this.value = val;
    }

    @Override
    public String affiche(boolean last, int ind)
    {
        String aff = "";
        for(int i = 0; i < ind; i++)
        {
            aff+="  ";
        }
        
        if(last)
        {
            aff+='"'+value+'"';
            return aff;
        }
        aff+='"'+value+"\",";
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
        pm.add(new LabelModel(aff));
        
        if(last)
        {
            LabelModel lm = new LabelModel('"'+this.value+'"', new Color(185,122,86));
            pm.add(lm);
        }
        else
        {
            LabelModel lm = new LabelModel('"'+this.value+'"', new Color(185,122,86));
            pm.add(lm);
            pm.add(new LabelModel(",", Color.YELLOW));
            
            
        } 
        vp.add(pm, vp.GridBagConfig());    
    }

    @Override
    public void addToPanel(boolean last, int ind, VuePrincipale vp, PanelModel pm) {
        PanelModel pan = new PanelModel();
        String aff = "";
        for(int i = 0; i < ind; i++)
        {
            aff+="  ";
        }
        LabelModel espace = new LabelModel(aff);
        pan.add(espace);

        if(last)
        {
            LabelModel lm = new LabelModel('"'+this.value+'"', new Color(185,122,86));
            pan.add(lm);
        }
        else
        {
            LabelModel lm = new LabelModel('"'+this.value+'"', new Color(185,122,86));
            pan.add(lm);
            pan.add(new LabelModel(",", Color.YELLOW));
        }

        pm.add(pan);

    }

    @Override
    public void affichePhp(boolean last, int ind, VuePrincipale vp, PanelModel pm) {
        PanelModel pan = new PanelModel();
        String aff = "";
        for(int i = 0; i < ind; i++)
        {
            aff+="  ";
        }
        
        pan.add(new LabelModel(aff));

        LabelModel lm = new LabelModel(this.value, new Color(185,122,86));
        pan.add(lm);
        pm.add(pan);
        vp.add(pm, vp.GridBagConfig());
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

        LabelModel lm = new LabelModel(this.value, new Color(185,122,86));
        pm.add(lm);
        vp.add(pm, vp.GridBagConfig());
    
    }

    @Override
    public void setObjInTab(boolean b) {
        // TODO Auto-generated method stub
        
    }

   

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
        // TODO Auto-generated method stub
        
    }

 
}
