package json.model;

import java.util.LinkedList;
import json.view.VuePrincipale;
import json.view.PanelModel;

/**
 *  Classe abstraite des noeuds de l'arbre
*/

public abstract class JNoeud {
    
    /**
    *Attribut de la classe JNoeud, il stock une liste chainée d'objets JNoeud qui représente les fils de l'objet courant. Il permet de stocker les sous-éléments d'un élément JSON
    */
    LinkedList<JNoeud> fils;

    /**
    Constructeur par défaut de la classe JNoeud, il initialise une nouvelle liste chainée pour stocker les fils de l'objet JNoeud.
    */
    public JNoeud(){
        this.fils = new LinkedList<>();
    }
    
    /**
    *Permet d'ajouter un élément de type JNoeud à la liste chainée fils de l'objet courant.
    *@param node L'élément de type JNoeud à ajouter à la liste chainée fils.
    */
    public void addToList(JNoeud node)
    {
            this.fils.add(node);
    }

    /**
    *Méthode abstraite qui permet d'afficher l'élément courant de la classe JNoeud sous forme d'une chaîne de caractères en utilisant une indentation appropriée.
    *@param last détermine si l'élément courant est le dernier élément de la liste.
    *@param indentation L'indentation requise pour l'élément courant.
    *@return Une chaîne de caractères représentant l'élément courant.
    */
    abstract public String affiche(boolean last, int indentation);

    /**
    *Méthode abstraite qui permet de definir l'attribut increment de l'élément courant.
    *@param b le boolean qui doit être affecté à l'attribut increment.
    */
    abstract public void setIncrement(boolean b);

    /**
    *Méthode abstraite qui permet d'ajouter l'élément courant de la classe JNoeud à un panel (VuePrincipal) en utilisant une indentation appropriée.
    *@param last détermine si l'élément courant est le dernier élément d'une liste d'éléments ou non.
    *@param indentation Le niveau d'indentation de l'élément courant.
    *@param vp l'instance de la classe VuePrincipale à laquelle les éléments de l'arbre seront ajoutés.
    */
    abstract public void addToPanel(boolean last, int indentation, VuePrincipale vp);

    /**
    Méthode abstraite qui permet d'ajouter l'élément courant de la classe JNoeud à PanelModel en utilisant une indentation appropriée.
    *@param last détermine si l'élément courant est le dernier élément d'une liste d'éléments ou non.
    *@param indentation Le niveau d'indentation de l'élément courant.
    *@param vp L'instance de la classe VuePrincipale qui étend JPanel à laquelle les éléments de l'arbre seront ajoutés.
    *@param pm l'instance de la classe PanelModel qui permet d'ajouter sur le même Panel avant d'ajouter à VuePrincipale
    */
    abstract public void addToPanel(boolean last, int indentation, VuePrincipale vp, PanelModel pm);

    /**
    *Méthode abstraite qui permet d'afficher l'élément courant de la classe JNoeud sous forme d'une chaîne de caractères en utilisant une indentation appropriée en format PHP.
    *@param last détermine si l'élément courant est le dernier élément d'une liste d'éléments ou non.
    *@param indentation Le niveau d'indentation de l'élément courant.
    *@param vp l'instance de la classe VuePrincipale qui étend JPanel à laquelle les éléments de l'arbre seront ajoutés sous forme de chaîne de caractères en format PHP.
    */
    abstract public void affichePhp(boolean last, int indentation, VuePrincipale vp);

    /**
    *Méthode abstraite qui permet d'afficher l'élément courant de la classe JNoeud sous forme d'une chaîne de caractères en utilisant une indentation appropriée en format PHP.
    *@param last détermine si l'élément courant est le dernier élément d'une liste d'éléments ou non.
    *@param indentation Le niveau d'indentation de l'élément courant.
    *@param vp l'instance de la classe VuePrincipale qui étend JPanel à laquelle les éléments de l'arbre seront ajoutés sous forme de chaîne de caractères en format PHP.
    *@param pm l'instance de la classe PanelModel qui permet d'ajouter des éléments de l'arbre sous forme de chaine de caracères en format PHP puis d'ajouter pm à VuePrincipale.
    */
    abstract public void affichePhp(boolean last, int indentation, VuePrincipale vp, PanelModel pm);

    /**
    *Méthode abstraite qui permet de mettre à jour l'attribut objInTab de l'élément courant lorsqu'un Objet est da,s un Tableau.
    @param b la valeur qui doit être affecté à l'attribut objInTab
    */
    abstract public void setObjInTab(boolean b);
    
    /**
    *Méthode abstraite qui permet de mettre à jour l'attribut visible de l'élément courant (Pour déplier, replier).
    *@param b la valeur qui doit être affecté à l'attribut visible
    */
    abstract public void setVisible(boolean b);

    /**
    *Méthode abstraite qui permet de savoir si l'élément courant est visible ou non.
    *@return Renvoie un boolean true si l'élement est visible, false s'il ne l'est pas
    */
    abstract public boolean getVisible();

    /**
    *méthode abstraite qui permet de déplier ou de replier tous les éléments de l'arbre en fonction de la valeur de b.
    *@param b Valeur qui détermine si l'arbre doit être déplié (true) ou replié(false)
    */
    abstract public void deplier(boolean b);

}
