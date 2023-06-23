package json.model;

import json.view.VuePrincipale;
import json.view.LabelModel;
import json.view.PanelModel;
import java.awt.Color;

/**
 *  Autres valeurs json
*/

public class JOther extends JNoeud {
    
    private String val;
    
    public JOther(String value)
    {
        this.val = value;
    }

    @Override
    public String affiche(boolean last, int ind)
    {
        String aff ="";
        for(int j = 0; j < ind; j++)
        {
            aff+="  ";
        }
        if(last)
        {
            aff+=this.val;
            return aff;
        }
        aff+=this.val+',';
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
            LabelModel lm = new LabelModel('"'+this.val+'"', new Color(2,144,123));
            pm.add(lm);
        }
        else
        {
            LabelModel lm = new LabelModel('"'+this.val+'"', new Color(2,144,123));
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
            LabelModel lm = new LabelModel(this.val, new Color(2,144,123));
            pan.add(lm);
        }
        else
        {
            LabelModel lm = new LabelModel(this.val, new Color(2,144,123));
            pan.add(lm);
            pan.add(new LabelModel(",", Color.YELLOW));
        }

        pm.add(pan);
        
    }

    @Override
    public void affichePhp(boolean last, int ind, VuePrincipale vp, PanelModel pm) {
        
            PanelModel pan = new PanelModel();
            String aff ="";
            for(int j = 0; j < ind; j++)
            {
                aff+="  ";
            }

            pan.add(new LabelModel(aff));
            LabelModel lm = new LabelModel(this.val, new Color(2,144,123));
            pan.add(lm);
            pm.add(pan);
            vp.add(pm, vp.GridBagConfig());
    }

    @Override
    public void affichePhp(boolean last, int indentation, VuePrincipale vp) {
        // TODO Auto-generated method stub
        
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
