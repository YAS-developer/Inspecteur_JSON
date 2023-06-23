package json.main;

import java.io.IOException;
import java.io.InputStream;
import java.net.MalformedURLException;
import java.net.URL;

import json.model.*;
import json.view.Frame;

public class Main {
    public static void main(String[] args) {
        
        if(args.length != 1){
            new Frame();
        }
        else{
                try
            {
                URL url = new URL(args[0]);

                try
                {
                    InputStream is = url.openStream();
                    ArbreT tree = new ArbreT();
                    tree.createTree(is);
                    tree.afficheArbre();
                }
                catch(IOException e)
                {
                    System.out.println(e);
                }
            }
            catch(MalformedURLException e)
            {
                System.out.println(e);
            }
        }
    }
}

