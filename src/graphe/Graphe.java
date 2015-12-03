package graphe;

import java.util.ArrayList;

/**
 * Created by juliengauttier on 14/10/15.
 */
public class Graphe {
    private ArrayList<Noeud> noeuds;
    private ArrayList<Aretes> aretes;
    private int taille;

    public Graphe(int taille){
        this.noeuds = new ArrayList<>(taille);
        this.aretes = new ArrayList<>();
        this.taille = taille;
        for(int i = 0 ; i<taille ; i++)
            noeuds.add(new Noeud(i));
    }

    public Graphe(){
        noeuds = new ArrayList<>();
        aretes = new ArrayList<>();
    }

    public ArrayList<Noeud> getNoeuds() {
        return noeuds;
    }

    public Noeud getNoeud(int i){
        return noeuds.get(i);
    }

    public void addNoeud(Noeud noeudA, Noeud noeudB){
        if(noeuds.contains(noeudA)){
            noeudA.addVoisin(noeudB);
            noeuds.add(noeudB);
            aretes.add(new Aretes(noeudA,noeudB));
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

    public int getTaille() {
        return taille;
    }

    public String toString(){
        String s ="";
        for(int i =0 ; i<taille ; i++)
            s+= noeuds.get(i).toString()+"\n";
        return s;
    }
}
