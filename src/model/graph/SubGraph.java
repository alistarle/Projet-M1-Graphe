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
        nodes.addAll(face.getNodeList()); //On ajoute tout les noeud du cycle dans H

        initNodeLinking(face); //On initialise les liens entre les noeuds de la face

        faces.add(face); //On ajoute les face, interne et externe, au debut ce sont les même
        faces.add(face);
    }


    /**
     * Init link between node of the face to create a cycle
     *
     * @param face
     */
    public void initNodeLinking(Face face) {
        ArrayList<Node> nodes = face.getNodeList();
        Node node;

        //Setup first node
        node = nodes.get(0);
        node.getNeighbours().add(nodes.get(nodes.size()-1));
        node.getNeighbours().add(nodes.get(1));

        //Setup other node
        for(int i = 1; i < nodes.size()-2; i++) {
            nodes.get(i).getNeighbours().add(nodes.get(i+1));
            nodes.get(i).getNeighbours().add(nodes.get(i-1));
        }

        //Setup last node
        node = nodes.get(nodes.size()-1);
        node.getNeighbours().add(nodes.get(nodes.size()-2));
        node.getNeighbours().add(nodes.get(0));
    }

    /**
     * Dive the given path in the given face
     *
     * @param face
     * @param path
     */
    public void divePath(Face face, ArrayList<Node> path) {
        this.addPath(face, path);
        this.splitFace(face, path);
        this.syncWithMain();
    }

    /**
     * Mark every node in the graph if are present in the mainGraph associated
     */
    public void syncWithMain() {
        //TODO Parcourir la liste des noeuds du graphe et les marquer dans le mainGraph G associé
    }

    /**
     * Add te given path to the graph
     *
     * @param path
     */
    public void addPath(Face face, ArrayList<Node> path) {
        //TODO Ajouter le chemin au graphe
    }


    /**
     * Split the given face in two with the given path
     *
     * @param face
     * @param path
     */
    public void splitFace(Face face, ArrayList<Node> path) {
        //TODO Supprimer la face de la liste des faces, et en ajouter deux nouvelles calculés à partir du chemin donné
    }
}
