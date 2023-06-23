package json.model;

import json.view.PanelModel;
import json.view.VuePrincipale;
import json.view.LabelModel;
import java.awt.Color;

import json.controler.ReplyEvent;

/**
 *  Tableau json
*/

public class JTab extends JNoeud {
    
    private boolean incr;
    private boolean visible;
    private static int compteur = 0;  

    public JTab()
    {
        this.incr = false;
        this.visible = false;
    }

   


    @Override
    public String affiche(boolean last, int ind)
    {
        
        String aff ="";

        if(this.incr){
            for(int j = 0; j < ind-1; j++)
            {
                aff+="  ";
            }
        }
        
        aff+="[\n";
        int i = 0;
        int size = this.fils.size();
        boolean tabObj = false;



        for(JNoeud jn : this.fils)
        {
            if(jn instanceof JObject){
                tabObj = true;
                if(i==size-1)
                {
                    jn.setIncrement(true);
                    aff+=jn.affiche(true, ind)+'\n';
                }
                else
                {
                    jn.setIncrement(true);
                    aff+=jn.affiche(false, ind)+'\n';
                }
            }
            else if(jn instanceof JTab)
            {
                tabObj = true;
                if(i==size-1)
                {
                    jn.setIncrement(true);
                    aff+=jn.affiche(true, ind+1)+'\n';
                }
                else
                {
                    jn.setIncrement(true);
                    aff+=jn.affiche(false, ind+1)+'\n';
                }
            }
            else
            {
                if(i==size-1)
                {
                    aff+=jn.affiche(true, ind)+'\n';
                }
                else
                {
                    aff+=jn.affiche(false, ind)+'\n';
                }
            }
            i++;
        }

        // si il existe un ou plusieurs tableaux ou Objets dans le JTab
        if(!tabObj){
            for(int j = 0; j < ind-1; j++)
            {
                aff+="  ";
            }
        }
        // si on incremente le fils
        else if(!this.incr){
            
            for(int j = 0; j < ind-1; j++)
            {
                aff+="  ";
            }
        }
        else
        {
            for(int j = 0; j < ind-1; j++)
            {
                aff+="  ";
            } 
        }

        if(last)
        {
            aff+="]";
        }
        else
        {
            
            aff+="],";
        }

        return aff;
    }

    @Override
    public void setIncrement(boolean oui){
        this.incr = oui;
    }

    @Override
    public void addToPanel(boolean last, int ind, VuePrincipale vp) {
        PanelModel pm = new PanelModel();
        if(!this.visible)
        {
            if(last){
                LabelModel lm = new LabelModel("[...]", Color.YELLOW, this);
                lm.addMouseListener(new ReplyEvent(vp,lm));
            }
            else{
                LabelModel lm = new LabelModel("[...],", Color.YELLOW, this);
                lm.addMouseListener(new ReplyEvent(vp,lm));
            }
           
        }
        else
        {
            String aff ="";

            if(this.incr){
                for(int j = 0; j < ind-1; j++)
                {
                    aff+="  ";
                }
            }

            pm.add(new LabelModel(aff));

            aff="";
            
            LabelModel lm = new LabelModel("[", Color.YELLOW, this);
            lm.addMouseListener(new ReplyEvent(vp,lm));
            pm.add(lm);
            vp.add(pm, vp.GridBagConfig());


        

            int i = 0;
            int size = this.fils.size();
            boolean tabObj = false;



            for(JNoeud jn : this.fils)
            {
                if(jn instanceof JObject){
                    tabObj = true;
                    if(i==size-1)
                    {
                        jn.setVisible(false);
                        jn.setIncrement(true);
                        jn.addToPanel(true, ind, vp);
                    }
                    else
                    {
                        jn.setVisible(false);
                        jn.setIncrement(true);
                        jn.addToPanel(false, ind, vp);
                    }
                }
                else if(jn instanceof JTab)
                {
                    tabObj = true;
                    if(i==size-1)
                    {
                        jn.setIncrement(true);
                        jn.addToPanel(true, ind+1, vp);
                    }
                    else
                    {
                        jn.setIncrement(true);
                        jn.addToPanel(false, ind+1, vp);
                    }
                }
                else
                {
                    if(i==size-1)
                    {
                        jn.addToPanel(true, ind, vp);
                    }
                    else
                    {
                        jn.addToPanel(false, ind, vp);
                    }
                }
                i++;
            }

            // si il existe un ou plusieurs tableaux ou Objets dans le JTab
            PanelModel p1 = new PanelModel();
            if(!tabObj){
                for(int j = 0; j < ind-1; j++)
                {
                    aff+="  ";
                }
                p1.add(new LabelModel(aff));
                aff="";
            }
            // si on incremente le fils
            else if(!this.incr){
                
                for(int j = 0; j < ind-1; j++)
                {
                    aff+="  ";
                }
                p1.add(new LabelModel(aff));
                aff="";
            }
            else
            {
                for(int j = 0; j < ind-1; j++)
                {
                    aff+="  ";
                } 
                p1.add(new LabelModel(aff));
                aff="";
            }

            if(last)
            {
                p1.add(new LabelModel("]", Color.YELLOW));
            }
            else
            {
                
                p1.add(new LabelModel("],", Color.YELLOW));
            }

            vp.add(p1, vp.GridBagConfig());

        }
        
    }


    @Override
    public void addToPanel(boolean last, int ind, VuePrincipale vp, PanelModel pm) {
        
        if(!this.visible)
        {
            if(last){
                PanelModel pan = new PanelModel();
                LabelModel lm = new LabelModel("[...]", Color.YELLOW, this);
                lm.addMouseListener(new ReplyEvent(vp,lm));
                pan.add(lm);
                pm.add(pan);
                vp.add(pm,vp.GridBagConfig());
            }
            else{
                PanelModel pan = new PanelModel();
                LabelModel lm = new LabelModel("[...],", Color.YELLOW, this);
                lm.addMouseListener(new ReplyEvent(vp,lm));
                pan.add(lm);
                pm.add(pan);
                vp.add(pm,vp.GridBagConfig());
            }
        }
        else
        {
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
            
            LabelModel lm = new LabelModel("[", Color.YELLOW, this);
            lm.addMouseListener(new ReplyEvent(vp,lm));
            pan.add(lm);
            pm.add(pan);
            vp.add(pm, vp.GridBagConfig());


            int i = 0;
            int size = this.fils.size();
            boolean tabObj = false;



            for(JNoeud jn : this.fils)
            {
                if(jn instanceof JObject){
                    tabObj = true;
                    if(i==size-1)
                    {
                        jn.setIncrement(true);
                        jn.addToPanel(true, ind, vp);
                    }
                    else
                    {
                        jn.setIncrement(true);
                        jn.addToPanel(false, ind, vp);
                    }
                }
                else if(jn instanceof JTab)
                {
                    tabObj = true;
                    if(i==size-1)
                    {
                        jn.setIncrement(true);
                        jn.addToPanel(true, ind+1, vp);
                    }
                    else
                    {
                        jn.setIncrement(true);
                        jn.addToPanel(false, ind+1, vp);
                    }
                }
                else
                {
                    if(i==size-1)
                    {
                        jn.addToPanel(true, ind+1, vp);
                    }
                    else
                    {
                        jn.addToPanel(false, ind+1, vp);
                    }
                }

                i++;
            }


            PanelModel p1 = new PanelModel();

            if(!tabObj){
                for(int j = 0; j < ind-1; j++)
                {
                    aff+="  ";
                }
                p1.add(new LabelModel(aff));
                aff="";
            }
            // si on incremente le fils
            else if(!this.incr){
                
                for(int j = 0; j < ind-1; j++)
                {
                    aff+="  ";
                }
                p1.add(new LabelModel(aff));
                aff="";
            }
            else
            {
                for(int j = 0; j < ind-1; j++)
                {
                    aff+="  ";
                } 
                p1.add(new LabelModel(aff));
                aff="";
            }

            if(last)
            {
                p1.add(new LabelModel("]", Color.YELLOW));
            }
            else
            {
                
                p1.add(new LabelModel("],", Color.YELLOW));
            }

            vp.add(p1, vp.GridBagConfig());

    }

  
    }



    @Override
    public void affichePhp(boolean last, int ind, VuePrincipale vp, PanelModel pm) {
       
        PanelModel pan = new PanelModel();
        String aff ="";
        compteur = 0;

        pan.add(new LabelModel("Array",new Color(47,189,186)));
        pm.add(pan);

        vp.add(pm, vp.GridBagConfig());


        PanelModel p1 = new PanelModel();

        
        for(int j = 0; j < ind; j++)
        {
            aff+="  ";    
        }

        p1.add(new LabelModel(aff));

        p1.add(new LabelModel("(", Color.yellow));

        vp.add(p1, vp.GridBagConfig());

        
        int i = 0;
        int size = this.fils.size();
        boolean tabObj = false;

        
        for(JNoeud jn : this.fils)
        {
            if(jn instanceof JObject){
                jn.setObjInTab(true);
                tabObj = true;
                if(i==size-1)
                {
                    jn.setIncrement(true);
                    jn.affichePhp(true, ind+1, vp);
                }
                else
                {
                    jn.setIncrement(true);
                    jn.affichePhp(false, ind+1, vp);
                }
                compteur++;
            }
            else if(jn instanceof JTab)
            {
                
                tabObj = true;
                if(i==size-1)
                {
                    jn.setIncrement(true);
                    jn.affichePhp(true, ind, vp);
                }
                else
                {
                    jn.setIncrement(true);
                    jn.affichePhp(true, ind, vp);
                       
                }
                compteur ++;              
            }
            else
            {       
                PanelModel pms = new PanelModel();  
                aff="";
                for(int j=0; j < ind+1; j++){
                    aff+= "  ";
                }
                pms.add(new LabelModel(aff));
                aff="";
                pms.add(new LabelModel("["+compteur+"]", new Color(47,189,186)));
                pms.add(new LabelModel(" => ", Color.YELLOW));
                jn.affichePhp(false, 0, vp,pms);
                vp.add(pms,vp.GridBagConfig());

                compteur++;           
            }
            i++;        
        }

        PanelModel p4 = new PanelModel();
        // si il existe un ou plusieurs tableaux ou Objets dans le JTab
        if(!tabObj){
            aff="";
            for(int j = 0; j < ind-1; j++)
            {
                aff+="  ";
            }
            p4.add(new LabelModel(aff));
            aff="";
        }
        // si on incremente le fils
        else if(!this.incr){  
            aff="";
            for(int j = 0; j < ind-1; j++)
            {
                aff+="  ";
                
            }
            p4.add(new LabelModel(aff));
            aff="";
        }
        else
        {
            aff="";
            for(int j = 0; j < ind-1; j++)
            {
                aff+="  ";
                
            } 
            p4.add(new LabelModel(aff));
            aff="";
        }
        if(last)
        {
            p4.add(new LabelModel(")",Color.yellow));
        }
        else
        {
            
            p4.add(new LabelModel("),", Color.yellow));
        }
        vp.add(p4, vp.GridBagConfig());
        
    }


    @Override
    public void affichePhp(boolean last, int ind, VuePrincipale vp) {

        PanelModel pm = new PanelModel();
        String aff ="";
        int compteur = 0;

        pm.add(new LabelModel("Array",new Color(47,189,186)));

        vp.add(pm, vp.GridBagConfig());

        PanelModel p1 = new PanelModel();
        
        for(int j = 0; j < ind; j++)
        {
            aff+="  ";    
        }
        p1.add(new LabelModel(aff));
        aff="";
        
        LabelModel lm = new LabelModel("(", Color.YELLOW);
        
        p1.add(lm);
        vp.add(p1, vp.GridBagConfig());

        int i = 0;
        int size = this.fils.size();
        boolean tabObj = false;

        
        for(JNoeud jn : this.fils)
        {
            if(jn instanceof JObject){
                jn.setObjInTab(true);
                tabObj = true;
                jn.setIncrement(true);
                jn.affichePhp(false, ind+1, vp);
                compteur++;
            }
            else if(jn instanceof JTab)
            {
                
                tabObj = true;
                jn.setIncrement(true);
                jn.affichePhp(false, ind,vp);
                compteur ++;              
            }
            else
            {      
                    PanelModel jp = new PanelModel();   
                    for(int j=0; j < ind+1; j++){
                        aff+= "  ";
                    }
                    jp.add(new LabelModel(aff));
                    jp.add(new LabelModel("["+compteur+"]", new Color(47,189,186)));
                    jp.add(new LabelModel(" => ", Color.yellow));
                    jp.add(new LabelModel("Array",new Color(47,189,186)));
                    vp.add(jp, vp.GridBagConfig());
                    // aff+="["+compteur+"] => "+jn.affichePhp(false, 0)+'\n';
        
                    jn.affichePhp(false, 0,vp);
                }
                compteur++;           
            }
            i++;        
        

            PanelModel p4 = new PanelModel();
        // si il existe un ou plusieurs tableaux ou Objets dans le JTab
        if(!tabObj){
            aff="";
            for(int j = 0; j < ind-1; j++)
            {
                aff+="  ";
            }
            p4.add(new LabelModel(aff));
            aff="";
        }
        // si on incremente le fils
        else if(!this.incr){  
            aff="";
            for(int j = 0; j < ind-1; j++)
            {
                aff+="  ";
            }
            p4.add(new LabelModel(aff));
            aff="";
        }
        else
        {
            aff="";
            for(int j = 0; j < ind-1; j++)
            {
                aff+="  ";
            } 
            p4.add(new LabelModel(aff));
            aff="";
        }
        
        p4.add(new LabelModel(")", Color.yellow));
    }


    @Override
    public void setObjInTab(boolean b) {
        // TODO Auto-generated method stub
        
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
}
