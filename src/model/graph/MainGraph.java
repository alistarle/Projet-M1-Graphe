package model.graph;

import model.Face;
import model.Fragment;
import model.Node;

import java.util.ArrayList;

/**
 * Created by alistarle on 04/12/2015.
 */
public class MainGraph extends Graph {
    private SubGraph sub;
    private ArrayList<Fragment> fragments;

    public MainGraph(int taille){
        this.nodes = new ArrayList<>(taille);
        this.faces = new ArrayList<>();
        this.fragments = new ArrayList<>();
        this.size = taille;
        for(int i = 0 ; i<taille ; i++)
            nodes.add(new Node(i));
    }

    public MainGraph(){
        nodes = new ArrayList<>();
        faces = new ArrayList<>();
        fragments = new ArrayList<>();
    }

    /**
     * Generate the list of fragment for the graph with the subgraph information
     */
    public void genFragments() {
        //TODO Generer la liste des fragment du graphe grâce au sub-graphe H
    }

    /**
     * Return list of face who are eligible to receive a fragment
     *
     * @param fragment
     * @return
     */
    public ArrayList<Face> getEligible(Fragment fragment) {
        ArrayList<Face> faces = new ArrayList<>();
        for(Face face : this.faces) {
            if(face.isEligible(fragment))
                faces.add(face);
        }
        return faces;
    }

    public ArrayList<Fragment> getFragments() {
        return fragments;
    }

    public void setSub(SubGraph sub) {
        this.sub = sub;
    }
}
