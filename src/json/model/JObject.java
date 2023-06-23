package json.model;

import json.controler.ReplyEvent;
import json.view.*;

import java.awt.*;

/**
 *  Objets json
*/

public class JObject extends JNoeud
{
    private boolean incr;
    private static int compt;
    private boolean ObjInTab ;
    private boolean visible;
    private static int firstObj = 0;
 

    /**
    Constructeur de la classe JObjet qui représente un objet JSON.
    */
    public JObject()
    {
        this.incr = false;
        JObject.compt = -1;
        this.ObjInTab = false;
        if(JObject.firstObj == 0){
            this.visible = true;
            JObject.firstObj++;
        }
        else{
            this.visible = false;
        }
    }

    @Override
    public String affiche(boolean last, int ind)
    {

        String aff = "";

        if(this.incr){
            
            for(int j = 0; j < ind; j++)
            {
                aff+="  ";
            }
        }
        

        aff+="{\n";
        int i = 0;
        int size = this.fils.size();

        for(JNoeud jn : this.fils)
        {
            if(i == size-1)
            {
                aff+=jn.affiche(true, ind+1);
            }
            else
            {
                aff+=jn.affiche(false, ind+1);
            }
            
            i++;
            

        }
        
        for(int j = 0; j < ind; j++)
        {
            aff+="  ";
        }  

        if(last)
        {
            aff+="}";
        }
        else
        {
            
            aff+="},";
        }
        
        return aff;
    }

   
    @Override
    public void setIncrement(boolean oui){
        this.incr = oui;
    }

    @Override
    public void addToPanel(boolean last, int ind, VuePrincipale vp) {

        String aff = "";
        if(!this.visible){
            if(last){
                PanelModel pn = new PanelModel();
                if(this.incr){
                
                    for(int j = 0; j < ind; j++)
                    {
                        aff+="  ";
                    }
                }
                pn.add(new LabelModel(aff));
                LabelModel lm = new LabelModel("{...}", Color.YELLOW, this);
                lm.addMouseListener(new ReplyEvent(vp,lm));
                pn.add(lm);
                vp.add(pn, vp.GridBagConfig());
                
            }
            else{
                PanelModel pn = new PanelModel();
                if(this.incr){
                
                    for(int j = 0; j < ind; j++)
                    {
                        aff+="  ";
                    }
                }
                pn.add(new LabelModel(aff));
                LabelModel lm = new LabelModel("{...},", Color.YELLOW, this);
                lm.addMouseListener(new ReplyEvent(vp,lm));
                pn.add(lm);
                vp.add(pn, vp.GridBagConfig());
                
            }
        }
        else{
            PanelModel pn = new PanelModel();
            aff="";
            if(this.incr){
                
                for(int j = 0; j < ind; j++)
                {
                    aff+="  ";
                }
            }

            pn.add(new LabelModel(aff));

            aff="";


            LabelModel lm = new LabelModel("{", Color.YELLOW, this);
            lm.addMouseListener(new ReplyEvent(vp,lm));
            
            pn.add(lm);
            vp.add(pn, vp.GridBagConfig());

            int i = 0;
            int size = this.fils.size();
    

            for(JNoeud jn : this.fils)
            {
                if(i == size-1)
                {
                    jn.addToPanel(true, ind+1, vp);
                }
                else
                {
                    jn.addToPanel(false, ind+1, vp);
                }
                
                i++;
            }

            PanelModel pn1 = new PanelModel();

            aff="";
            
            for(int j = 0; j < ind; j++)
            {
                aff+="  ";
            }  

            pn1.add(new LabelModel(aff));
            aff="";

            if(last)
            {
                pn1.add(new LabelModel("}", Color.YELLOW));
            }
            else
            {
                pn1.add(new LabelModel("},", Color.YELLOW));
            }
            vp.add(pn1, vp.GridBagConfig());
        }
        
    }

    @Override
    public void addToPanel(boolean last, int ind, VuePrincipale vp, PanelModel pn) {


        if(!this.visible){
            if(last){
                PanelModel pan = new PanelModel();
                LabelModel lm = new LabelModel("{...}", Color.YELLOW, this);
                lm.addMouseListener(new ReplyEvent(vp,lm));
                pan.add(lm);
                pn.add(pan);
                vp.add(pn, vp.GridBagConfig());
            }
            else{
                PanelModel pan = new PanelModel();
                LabelModel lm = new LabelModel("{...},", Color.YELLOW, this);
                lm.addMouseListener(new ReplyEvent(vp,lm));
                pan.add(lm);
                pn.add(pan);
                vp.add(pn, vp.GridBagConfig());
            }
        }
        else{
            PanelModel pan = new PanelModel();
            String aff ="";
    
            if(this.incr){
                for(int j = 0; j < ind-1; j++)
                {
                    aff+="  ";
                }
            }
    
            pan.add(new LabelModel(aff));
    
            aff="";
            
            LabelModel lm = new LabelModel("{", Color.YELLOW, this);
            lm.addMouseListener(new ReplyEvent(vp,lm));
    
            pan.add(lm);
            pn.add(pan);
            vp.add(pn, vp.GridBagConfig());
    
            int i = 0;
            int size = this.fils.size();
    
            for(JNoeud jn : this.fils)
            {
                if(i == size-1)
                {
                    jn.addToPanel(true, ind+1, vp);
                }
                else
                {
                    jn.addToPanel(false, ind+1, vp);
                }
                
                i++;
            }
            
            PanelModel pn1 = new PanelModel();
    
            aff="";
            
            for(int j = 0; j < ind; j++)
            {
                aff+="  ";
            }  
    
            pn1.add(new LabelModel(aff));
            aff="";
    
            if(last)
            {
                // aff+="}";
                pn1.add(new LabelModel("}", Color.YELLOW));
            }
            else
            {
                
                // aff+="},";
                pn1.add(new LabelModel("},", Color.YELLOW));
            }
            vp.add(pn1, vp.GridBagConfig());    
        }
    }

    @Override
    public void affichePhp(boolean last, int ind, VuePrincipale vp)
    {
        PanelModel pan = new PanelModel();
        
        String aff = "";
        JObject.compt++;
        if(ObjInTab){
            for(int j = 0; j < ind-1; j++)
            {
                aff+="  ";
            }
        }
        pan.add(new LabelModel(aff));

        aff=""; 

        pan.add(new LabelModel("["+JObject.compt+"]"));
        pan.add(new LabelModel(" => ", Color.yellow));
        pan.add(new LabelModel("Array"));


        vp.add(pan,vp.GridBagConfig());
        
        for(int j = 0; j < ind; j++)
        { 
            aff+="  ";
        }

        PanelModel pane = new PanelModel();
        pane.add(new LabelModel(aff));
        aff="";

        pane.add(new LabelModel("(", Color.yellow));
        vp.add(pane,vp.GridBagConfig());

        
       
        int i = 0;
    
        int size = this.fils.size();
        
        
        for(JNoeud jn : this.fils)
        {
            if(jn instanceof JObject)
            {

            }
            else
            { 
                if(i == size-1)
                {
                    jn.affichePhp(true, ind+1, vp);
                }
                else
                {
                    jn.affichePhp(false, ind+1, vp);
                }
            }
            i++;
        }

        PanelModel pm1 = new PanelModel();
    
        aff="";

        for(int j = 0; j < ind-1; j++)
        {
            aff+="  ";
        } 
        pm1.add(new LabelModel(aff));
        
        if(last)
        {

            pm1.add(new LabelModel(")", Color.yellow));
        }
        else
        {    

            pm1.add(new LabelModel("),", Color.yellow));
        }

        vp.add(pm1, vp.GridBagConfig());
        
    }

    @Override
    public void affichePhp(boolean last, int ind, VuePrincipale vp, PanelModel pm){
        PanelModel pan = new PanelModel();
        JObject.compt++;
        String aff = "";
        if(ObjInTab){
            for(int j = 0; j < ind-1; j++)
            {
                aff+="  ";
            }
            pan.add(new LabelModel(aff));
            aff="";
        }

        pan.add(new LabelModel("["+JObject.compt+"] => Array"));

        pm.add(pan);

        vp.add(pm, vp.GridBagConfig());
                
        PanelModel pane = new PanelModel();
        for(int j = 0; j < ind; j++)
        { 
            aff+="  ";
        }
        pane.add(new LabelModel(aff));
        aff="";
        pane.add(new LabelModel("(", Color.yellow));
        vp.add(pane,vp.GridBagConfig());

        
       
        int i = 0;
        int size = this.fils.size();
        
        
        for(JNoeud jn : this.fils)
        {
            if(jn instanceof JObject)
            {

            }
            else
            { 
                if(i == size-1)
                {
                    jn.affichePhp(true, ind+1, vp);
                }
                else
                {
                    jn.affichePhp(false, ind+1, vp);
                }
            }
            i++;
        }

        PanelModel pm1 = new PanelModel();
    
        aff="";

        for(int j = 0; j < ind-1; j++)
        {

            aff+="  ";
        } 
        pm1.add(new LabelModel(aff));
        aff="";
        
        if(last)
        {

            pm1.add(new LabelModel(")", Color.yellow));
        }
        else
        {    

            pm1.add(new LabelModel("),", Color.yellow));
        }

        vp.add(pm1, vp.GridBagConfig());
    }
    @Override
    public void setObjInTab(boolean oui){
        this.ObjInTab = oui;
    }

    @Override
    public void setVisible(boolean b) {
        this.visible = b;
    }

    @Override
    public boolean getVisible() {
       return this.visible;
    }

    @Override
    public void deplier(boolean b) {
        this.setVisible(b);
        for(JNoeud jn : this.fils){
            jn.deplier(b);
        }
    }

    public void setFirsObj(int i) {
        JObject.firstObj = i;
    }

    
}