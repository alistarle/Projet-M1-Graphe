package graphe;

import java.util.ArrayList;

/**
 * Created by juliengauttier on 14/10/15.
 */
public class Graphe {
    private ArrayList<Noeud> graphe;
    private int taille;

    public Graphe(int taille){
        this.graphe = new ArrayList<>(taille);
        this.taille = taille;
        for(int i = 0 ; i<taille ; i++)
            graphe.add(new Noeud(i));
    }

    public Graphe(){
        graphe = new ArrayList<>();
    }


    public Noeud getNoeud(int i){
        return graphe.get(i);
    }

    public void addNoeud(Noeud noeudA, Noeud noeudB){
        if(graphe.contains(noeudA)){
            noeudA.addVoisin(noeudB);
            graphe.add(noeudB);
        }
    }

    public void random() {
        ArrayList list = new ArrayList<Noeud>();

        int rand = (int)(Math.random()*10)+5;
        for (int i  = 0 ; i<rand ; i++){
     //       Noeud e = new Noeud();
     //       list.add(e);
        }
        
    }

    public String toString(){
        String s ="";
        for(int i =0 ; i<taille ; i++)
            s+=graphe.get(i).toString()+"\n";
        return s;
    }
}
