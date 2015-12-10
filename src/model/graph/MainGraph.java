package model.graph;

import model.Face;
import model.Fragment;
import model.Node;

import java.util.ArrayList;

/**
 * Graph representative of G in algorithm
 *
 * Created by alistarle on 04/12/2015.
 */
public class MainGraph extends Graph {

    /**
     * Link to the subgraph H in algorithm
     */
    private SubGraph H;

    /**
     * List of fragment of G
     */
    private ArrayList<Fragment> fragments;

    /**
     * Init mainGraph with size
     *
     * @param size
     */
    public MainGraph(int size){
        this.nodes = new ArrayList<>(size);
        this.faces = new ArrayList<>();
        this.fragments = new ArrayList<>();
        this.size = size;
        for(int i = 0 ; i<size ; i++)
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
        //TODO Generer la liste des fragment du graphe grâce au graphe H




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

    public void setH(SubGraph h) {
        this.H = h;
    }
}
