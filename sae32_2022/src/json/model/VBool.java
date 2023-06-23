package json.model;

import json.view.PanelModel;
import json.view.VuePrincipale;
import json.view.LabelModel;
import java.awt.Color;

/**
 *  Valeur boolean json
*/

public class VBool extends JNoeud {

    private boolean bool;
    public VBool(boolean b)
    {   
        this.bool = b;
    }

    @Override
    public String affiche(boolean last, int ind)
    {
        String aff="";
        for(int i = 0; i < ind; i++)
        {
            aff+="  ";
        }

        if(bool)
        {
            if(last)
            {
                aff+="true";
                return aff;
            }
            aff+="true,";
            return aff;
        }
        else
        {
            if(last)
            {
                aff+="false";
                return aff;    
            }
            aff+="false,";
            return "false,";
        }
    }
    
     @Override
    public void setIncrement(boolean oui){}

    @Override
    public void addToPanel(boolean last, int ind, VuePrincipale vp) {
        // TODO Auto-generated method stub
        
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
            if(bool)
            {
                LabelModel lm = new LabelModel("true", Color.GREEN);
                pan.add(lm);
            }
            else
            {
                LabelModel lm = new LabelModel("false", Color.RED);
                pan.add(lm);
            }
            
        }
        else
        {
            if(bool)
            {
                LabelModel lm = new LabelModel("true", Color.GREEN);
                pan.add(lm);

            }
            else
            {
                LabelModel lm = new LabelModel("false", Color.RED);
                pan.add(lm);

            }
            pan.add(new LabelModel(",", Color.YELLOW));
        }

        pm.add(pan);
        
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

        if(bool)
        {
            pm.add(new LabelModel("true", Color.GREEN));
 
        }
        else
        {
            LabelModel lm = new LabelModel("false", Color.red);
            pm.add(new LabelModel("false", Color.RED));

        }

        
        vp.add(pm, vp.GridBagConfig());
        
    }


    @Override
    public void affichePhp(boolean last, int ind, VuePrincipale vp, PanelModel pm) {
        // TODO Auto-generated method stub
        PanelModel pan = new PanelModel();
        String aff="";
        for(int i = 0; i < ind; i++)
        {
            aff+="  ";
        }

        if(bool)
        {
            LabelModel lm = new LabelModel("true", Color.GREEN);
            pan.add(lm);   
        }
        else
        {
            LabelModel lm = new LabelModel("false", Color.RED);
            pan.add(lm);
        }

        pm.add(pan);
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
    public boolean getVisible(){
        return false; 
    }

    @Override
    public void deplier(boolean b) {
        // TODO Auto-generated method stub
        
    }


  
}
