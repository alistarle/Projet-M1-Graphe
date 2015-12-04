package model.graph;

import model.Face;
import model.Node;

import java.util.ArrayList;

/**
 * Created by juliengauttier on 14/10/15.
 */
abstract public class Graph {
    protected ArrayList<Node> nodes;
    protected ArrayList<Face> faces;
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
            nodeA.addVoisin(nodeB);
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
