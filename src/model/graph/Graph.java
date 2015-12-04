package model.graph;

import model.Face;
import model.Node;

import java.util.ArrayList;

/**
 * Main class representative of a general graph
 *
 * Created by juliengauttier on 14/10/15.
 */
abstract public class Graph {

    /**
     * List of node of the graph
     */
    protected ArrayList<Node> nodes;

    /**
     * List of faces of the graph
     */
    protected ArrayList<Face> faces;

    /**
     * Number of node in the graph
     */
    protected int size;


    public ArrayList<Node> getNodes() {
        return nodes;
    }

    public Node getNode(int i){
        return nodes.get(i);
    }

    public int getSize() {
        return size;
    }

    public String toString(){
        String s ="";
        for(int i =0 ; i< size; i++)
            s+= nodes.get(i).toString()+"\n";
        return s;
    }

    public void addNoeud(Node nodeA, Node nodeB){
        if(nodes.contains(nodeA)){
            nodeA.addNeighbour(nodeB);
            nodes.add(nodeB);
        }
    }

    public void random() {
        ArrayList list = new ArrayList<Node>();

        int rand = (int)(Math.random()*10)+5;
        for (int i  = 0 ; i<rand ; i++){
            //       Node e = new Node();
            //       list.add(e);
        }

    }
}
