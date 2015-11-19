package graphe;

import java.util.*;

/**
 * Created by juliengauttier on 14/10/15.
 */
public class Noeud {
    public int nom;
    private ArrayList<Noeud> voisins;
    private boolean marqeur1;
    private boolean marqueur2;

    public Noeud(int c){
        nom = c;
        this.voisins = new ArrayList<>();
        marqeur1 = false;
        marqueur2 = false;

    }

    public Noeud(ArrayList<Noeud> voisins) {
        this.voisins = voisins;
        marqeur1 = false;
        marqueur2 = false;
    }

    public ArrayList<Noeud> getVoisins() {
        return voisins;
    }

    public boolean addVoisin(Noeud e){
        voisins.add(e);
        return true;
    }

    public String toString(){
        String s = "";
        s+= nom + " : ";

        for (int i = 0 ; i < voisins.size() ; i++){
            s+= voisins.get(i).nom+" ";
        }
        return  s;
    }
}
