package json.model;


import java.io.*;

import json.view.VuePrincipale;

/**
 *  Arbre Syntaxique Abstrait
*/
public class ArbreT {

    


    /**
    * Racine de l'arbre {@link JObject} 
   */
    private JObject racine;

    /**
    * Caractere récupéré
    */
    private int carac;

    /**
    * boolean fini de tableau
    */
    private boolean endtab;

    /**
    * boolean fini de tableau
    */
    private boolean endobj;

    public ArbreT()
    {
        this.racine = null;
        this.carac = 0;
        this.endtab = false;
        this.endobj = false;
    }

    /**
    *Prend en entrée un entier (int) qui représente un caractère ASCII et retourne vrai si le caractère est un WhiteSpace (tabulation, espace, saut de ligne ou retour à la ligne) et *faux sinon.
    * @param a L'entier représentant le caractère à tester
    * @return Vrai si le caractère est un espace blanc (tabulation, espace, saut de ligne ou retour à la ligne) et faux sinon.
    */
    private boolean isWhiteSpace(int a)
    {
        if(a == 9 || a == 32 || a == 10 || a == 13) // 13 = tab ; 32 = espace ; 10 = sautdligne ; 13 = retour ligne
        {
            return true;
        }
        else
        {
            return false;
        }

    }

    /**
    *Prend en parametre un flux d'entrée (InputStream) et retourne un JObject jusqu'a ce que la fin de l'objet soit atteinte
    *@param is flux d'entrée à partir duquel lire les données
    *@return Retourne tout le contenu d'un JObject jusqu'à ce qu'il se termine.
    *@throws IOException Si une erreur survient lors de la lecture à partir de l'InputStream.
    */
    public JObject takeObject(InputStream is)
    {
        JObject obj = new JObject();
        JNoeud nKey = null;
        JNoeud val = null;
        try
        {
            while((carac = is.read()) != '}'&& !this.endobj)
            {
                if(this.isWhiteSpace(carac))
                {

                }
                else
                {
                    if(this.isWhiteSpace(carac))
                    {

                    }
                    if(carac == '"')
                    {
                        String key = this.getString(is);
                        nKey = new JKey(key);
                        
                    }
                    else if(carac == ':')
                    {
                        val = this.getValue(is);
                        nKey.addToList(val);
                        obj.addToList(nKey);

                    }
                }
            }
            if(carac == ']')
            {
                this.endtab = true;
            }
            this.endobj = false;
        }
        catch(IOException e)
        {
            System.out.println(e);
        }

        return obj;
    }


    /**
    *Prend en pramètre un flux d'entrée (InputStream) et retourne un objet JNoeud qui contient la valeur lue dans l'InputStream.
    *@param is Flux d'entrée à partir duquel lire les données.
    *@return Un objet JNoeud qui contient la valeur lue dans l'InputStream.
    *@throws IOException Si une erreur survient lors de la lecture à partir de l'InputStream.
    */
    public JNoeud getValue(InputStream is)
    {
        // JNoeud value;
        String val="";
        try{
            while((carac = is.read()) != ',')
            {
                if(carac == '{')
                {
                    JObject obj = takeObject(is);
                    return obj;
                }
                else if(carac == '[')
                {
                    JTab tab = takeTab(is);
                    return tab;
                }
                else if(carac == '"')
                {
                    String val2 = this.getString(is);
                    VString vs = new VString(val2);
                    return vs;
                }
                else
                {
                    if(this.isWhiteSpace(carac))
                    {

                    }
                    else if(carac == ']')
                    {
                        this.endtab = true;
                        break;
                    }
                    else if(carac == '}')
                    {
                        this.endobj = true;
                        break;
                    }
                    else if(carac == ',')
                    {
                        break;
                    }
                    else
                    {

                        val+=(char) carac; 
                    }
                }

            }  
            if(val != "")
            {
                return this.getType(val);
            }
            
        }
        catch(IOException e)
        {
            System.out.println(e);
        }

        return null;
    }

    /**
    *Cette fonction prend en entrée un flux d'entrée (InputStream) et retourne un objet JTab qui contient tous les éléments lus dans le tableau jusqu'à ce que la fin du tableau soit *atteinte.
    *@param is Le flux d'entrée à partir duquel lire les données.
    *@return Un objet JTab qui contient tous les éléments lus dans le tableau jusqu'à ce que la fin du tableau soit atteinte.
    *@throws IOException Si une erreur survient lors de la lecture à partir du flux d'entrée.
    */
    public JTab takeTab(InputStream is)
    {
        JTab tab = new JTab();
        String value = "";
        try
        {
            while((carac = is.read()) != ']' && !this.endtab)
            {
                if(carac == '{')
                {
                    JObject obj = takeObject(is);
                    tab.addToList(obj);
                }
                else if(carac == '[')
                {
                    JTab otherTab = takeTab(is);
                    tab.addToList(otherTab);
                }
                else if(carac == '"')
                {
                    String sVal = this.getString(is);
                    VString vs = new VString(sVal);
                    tab.addToList(vs);
                }
                else
                {
                    if(this.isWhiteSpace(carac))
                    {

                    }
                    else if(carac == ']')
                    {
                        this.endtab = true;
                        break;
                    }
                    else if(carac == '}')
                    {
                        this.endobj = true;
                        break;
                    }
                    else if(carac != ',')
                    {
                        value+=(char) carac;
                    }
                    else
                    {
                        if(value != "")
                        {
                            tab.addToList(this.getType(value)); 
                            value="";
                        }
                    }                
                }
                
            }
            if(value != "")
            {
                tab.addToList(this.getType(value)); 
                value="";
            }
        }
        catch(IOException e)
        {
            System.out.println(e);
        }

        return tab;
    }

    /**

    *Prend en entrée une chaîne de caractères (String) et retourne un objet JNoeud qui contient la valeur de la chaîne de caractères. Si la chaîne de caractères peut être convertie en entier ou en double, un objet VNumber est retourné, si elle est "true" ou "false", un objet VBool est retourné, sinon un objet JOther est retourné.
    *@param value La chaîne de caractères à convertir en objet JNoeud.
    *@return Un objet JNoeud qui contient la valeur de la chaîne de caractères.
    */
    public JNoeud getType(String value)
    {
        try {
            VNumber vn =  new VNumber(Integer.parseInt(value));
            return vn;
        } 
        catch (NumberFormatException e) {
            try{
                double t = Double.parseDouble(value);

                if(String.valueOf(t).equals(value))
                {
                    VNumber vn =  new VNumber(t);
                    return vn;
                }
                else
                {
                    VNumber vn =  new VNumber(Double.parseDouble("dqsd"));
                }
                
                return null;  
            }
            catch(NumberFormatException e1)
            {
                if(value.equals("true") || value.equals("false"))
                {
                    VBool vb = new VBool(Boolean.parseBoolean(value));
                    return vb;
                }
                else 
                {
                    JOther jo = new JOther(value);
                    return jo;
                }
            }  
        }
        
    }


    /**
    *Prend en entrée un flux d'entrée (InputStream) et retourne une chaîne de caractères qui contient tous les caractères lus dans l'InputStream jusqu'à ce que le prochain caractère lu soit un guillemet (").
    *@param is Le flux d'entrée à partir duquel lire les données.
    *@return Une chaîne de caractères qui contient tous les caractères lus dans l'InputStream.
    *@throws IOException Si une erreur survient lors de la lecture à partir du flux d'entrée.
    */
    public String getString(InputStream is)
    {
        String s="";

        try
        {
            while((carac = is.read()) != '"')
            {
                s+=(char) carac;
            }
        }
        catch(IOException e)
        {
            System.out.println(e);
        }
        return s;
    }

    /**

    *Prend en entrée un flux d'entrée (InputStream) et construit un arbre de données à partir des données lues dans le flux d'entrée. Elle utilise la fonction takeObject pour construire l'arbre à partir du première objets JSON lu dans le flux d'entrée, et assigne la racine de l'arbre construit à la propriété racine de la classe.
    *@param is Le flux d'entrée à partir duquel lire les données.
    *@throws IOException Si une erreur survient lors de la lecture à partir du flux d'entrée.
    */
    public void createTree(InputStream is)
    {
        try{

            while((carac = is.read()) != -1)
            {
                if(this.isWhiteSpace(carac))
                {
                }
                else if(carac == '{')
                {
                    if(this.racine == null)
                    {
                        this.racine = this.takeObject(is);
                    }
                }

            }
        }
        catch(IOException e){
            System.out.println(e);
        }
    }

    /**
    *Affiche l'arbre de données  en utilisant la méthode affiche de la classe JNoeud. Elle utilise la racine de la classe pour accéder à la racine de l'arbre et appelle la méthode affiche pour afficher l'arbre en utilisant une indentation appropriée.
    */
    public void afficheArbre()
    {
        this.racine.setFirsObj(0);
        System.out.println(this.racine.affiche(true,0)); 
    }
    
    /**
    *Prend en paramètre une instance de la classe VuePrincipale et lui ajoute les éléments de l'arbre en utilisant la méthode addToPanel de la classe JNoeud pour l'ajouter sur la VuePrincipale en utilisant une indentation appropriée. Et appelle la méthode revalidate() pour mettre à jour l'affichage de VuePrincipale.
    *@param vp L'instance de la classe VuePrincipale à laquelle les éléments de l'arbre seront ajoutés.
    */
    public void AffichePanel(VuePrincipale vp)
    {
        this.racine.setFirsObj(0);
        this.racine.addToPanel(true, 0, vp);
        vp.revalidate();
    }

    /**
    *Prend en paramètre une instance de la classe VuePrincipale et lui ajoute  les éléments de l'arbre en utilisant la méthode affichephp de la classe JNoeud pour les afficher sous forme de code php en utilisant une indentation appropriée. Et appelle la méthode revalidate() pour mettre à jour l'affichage de VuePrincipale.
    *@param vp L'instance de la classe VuePrincipale à laquelle les éléments de l'arbre seront ajoutés.
    */
    public void AfficheInPhp(VuePrincipale vp)
    {
        this.racine.setFirsObj(0);
        this.racine.affichePhp(true, 0, vp);
        vp.revalidate();
    }

    /**
    *Prend en paramètre une instance de la classe VuePrincipale et un booléen. Elle utilise la racine de la classe pour accéder à la racine de l'arbre et appelle la méthode deplier pour déplier ou replier les sous-éléments de l'arbre en utilisant la valeur du booléen passé en argument. elle utilise la méthode addToPanel pour ajouter les éléments de l'arbre modifié à   VuePrincipale en utilisant une indentation appropriée. Et appelle la méthode revalidate() pour mettre à jour l'affichage de VuePrincipale.
    *@param vp L'instance de la classe VuePrincipale à laquelle les éléments de l'arbre seront ajoutés.
    *@param b Le booléen qui détermine si l'arbre doit être déplié ou replié.
    */
    public void deplierArbre(VuePrincipale vp, boolean b){
        this.racine.setFirsObj(0);
        this.racine.deplier(b);
        this.racine.addToPanel(true, 0, vp);
        vp.revalidate();
    }
}
