package json.model;



import json.view.PanelModel;
import json.view.VuePrincipale;
import json.view.LabelModel;

import java.awt.Color;

/**
 *  Valeur numérique json
*/

public class VNumber extends JNoeud {
    private Number value;

    public VNumber(Number val)
    {
        this.value = val;
    }

    @Override
    public String affiche(boolean last, int ind)
    {
        String aff ="";
        for(int i = 0; i < ind; i++)
        {
            aff+="  ";
        }

        if(last)
        {
            aff += String.valueOf(value);
            return aff;    
        }
        aff+=String.valueOf(value)+',';
        return aff;
    }
     @Override
    public void setIncrement(boolean oui){}

    @Override
    public void addToPanel(boolean last, int ind, VuePrincipale vp) {
        PanelModel pm = new PanelModel();
        String aff ="";
        for(int i = 0; i < ind; i++)
        {
            aff+="  ";
        }
        pm.add(new LabelModel(aff));

        aff="";

        if(last)
        {
            LabelModel lm = new LabelModel(String.valueOf(this.value), new Color(0,168,243));
            pm.add(lm);
        }
        else
        {
            LabelModel lm = new LabelModel(String.valueOf(this.value), new Color(0,168,243));
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
            LabelModel lm = new LabelModel(String.valueOf(this.value), new Color(0,168,243));
            pan.add(lm);
        }
        else
        {
            LabelModel lm = new LabelModel(String.valueOf(this.value), new Color(0,168,243));
            pan.add(lm);
            pan.add(new LabelModel(",", Color.YELLOW));
        }

        pm.add(pan);
        vp.add(pm, vp.GridBagConfig());
        
    }

    @Override
    public void affichePhp(boolean last, int ind, VuePrincipale vp) {
        PanelModel pm = new PanelModel();

        String aff ="";
        for(int i = 0; i < ind; i++)
        {
            aff+="  ";
        }
        aff +=String.valueOf(value);
        pm.add(new LabelModel(aff));
        aff="";
        LabelModel lm = new LabelModel(String.valueOf(this.value), new Color(0,168,243));
        pm.add(lm);
        vp.add(pm, vp.GridBagConfig());
    }

    @Override
    public void affichePhp(boolean last, int ind, VuePrincipale vp, PanelModel pm) {
        PanelModel pan = new PanelModel();
        String aff ="";
        for(int i = 0; i < ind; i++)
        {
            aff+="  ";
        }
        pan.add(new LabelModel(aff));
        aff="";

        LabelModel lm = new LabelModel(String.valueOf(this.value), new Color(0,168,243));
        pan.add(lm);
        pm.add(pan);
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
