package model;

import java.util.*;

/**
 * Created by juliengauttier on 14/10/15.
 */
public class Node implements Cloneable {
    private int name;
    private ArrayList<Node> neighbours;
    private boolean contactPoint = false;

    private Node father;

    public Node(int c){
        name = c;
        this.neighbours = new ArrayList<>();
    }

    public Node(ArrayList<Node> neighbours) {
        this.neighbours = neighbours;
    }

    public Node() {
        this.neighbours = new ArrayList<>();

    }

    public ArrayList<Node> getNeighbours() {
        return neighbours;
    }

    public boolean addNeighbour(Node e){
        neighbours.add(e);
        return true;
    }

    public String toString(){
        String s = "";
        s+= name + " : ";

        for (int i = 0 ; i < neighbours.size() ; i++){
            s+= neighbours.get(i).name +" ";
        }
        return  s;
    }

    public Node getFather() { return father; }

    public void setFather(Node father) {
        this.father = father;
    }

    public boolean isContactPoint() {
        return contactPoint;
    }

    public void setContactPoint(boolean contactPoint) {
        this.contactPoint = contactPoint;
    }

    public int getName() {
        return name;
    }

    public Node clone() {

        //TODO Faire la fonction clone

        return null;
    }
}
