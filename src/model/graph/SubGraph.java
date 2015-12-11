package model.graph;

import model.Face;
import model.Node;

import java.util.ArrayList;

/**
 * Graph representative of H in algorithm
 *
 * Created by alistarle on 04/12/2015.
 */
public class SubGraph extends Graph {

    /**
     * Link to the mainGraph G in algorithm
     */
    private MainGraph G;

    /**
     * Init H with a face and G
     *
     * @param G
     * @param face
     */
    public SubGraph(MainGraph G, Face face) {
        this.G = G;
        this.faces = new ArrayList<>();
        this.nodes = new ArrayList<>();
        nodes.addAll(face.getNodeList()); //On ajoute tout les noeuds du cycle dans H

        initNodeLinking(face); //On initialise les liens entre les noeuds de la face

        faces.add(face); //On ajoute les faces, interne et externe, au debut ce sont les mêmes
        faces.add(face);
    }


    /**
     * Init link between node of the face to create a cycle
     *
     * @param face
     */
    public void initNodeLinking(Face face) {
        ArrayList<Node> nodes = face.getNodeList();
        Node node = new Node();

        //Setup first node
        node = nodes.get(0);
        node.getNeighbours().add(nodes.get(nodes.size()-1));
        node.getNeighbours().add(nodes.get(1));

        //Setup other node
        for(int i = 1; i < nodes.size()-2; i++) {
            nodes.get(i).getNeighbours().add(nodes.get(i+1));
            nodes.get(i).getNeighbours().add(nodes.get(i-1));
        }

        //TODO : throw null exception ?

        //Setup last node
        /*
        node = nodes.get(nodes.size()-1);
        node.getNeighbours().add(nodes.get(nodes.size()-2));
        node.getNeighbours().add(nodes.get(0));
        */
    }

    /**
     * Dive the given path in the given face
     *
     * @param face
     * @param path
     */
    public void divePath(Face face, ArrayList<Node> path) throws Exception {
        this.addPath(face, path);
        this.splitFace(face, path);
        this.syncWithMain();
    }

    /**
     * Mark every node in the graph if are present in the mainGraph associated
     */
    public void syncWithMain() {
        //Parcourir la liste des noeuds du graphe et les marquer dans le mainGraph G associé
        for(Node node :this.nodes){
            for(Node node2 : this.G.nodes){
                if(node2.equals(node)){
                    node2.setContactPoint(true);
                }else{
                    node2.setContactPoint(false);
                }
            }
        }
    }

    /**
     * Add te given path to the graph
     *
     * @param path
     */
    public void addPath(Face face, ArrayList<Node> path) throws Exception {
        Node first = new Node();
        Node last = new Node();
        for(Node node : this.nodes){
            if(node.equals(path.get(0))){
                first = node;
            }
            if(node.equals(path.get(path.size()-1))){
                last = node;
            }
        }
        Node temp = first;
        for(Node node : path){
            temp.getNeighbours().add(node);
            temp=node;
            if(temp.equals(last)){
                //TODO debug
                return;
            }
        }
        //throw exception juste pour les test
        throw new Exception("Chemin invalide");




    }


    /**
     * Split the given face in two with the given path
     *
     * @param face
     * @param path
     */
    public void splitFace(Face face, ArrayList<Node> path) {
        Face face1 = new Face(new ArrayList<Node>());
        Face face2 = new Face(new ArrayList<Node>());
        //TODO calculer faces
        for(int i = 0 ; i < G.getFragments().size(); i++){
            if(face.equals(G.faces.get(i)))
                G.faces.remove(i);
        }
        G.faces.add(face1);
        G.faces.add(face2);
    }
}
