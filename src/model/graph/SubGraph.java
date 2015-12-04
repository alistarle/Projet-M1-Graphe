package model.graph;

import model.Face;
import model.Node;

import java.util.ArrayList;

/**
 * Created by alistarle on 04/12/2015.
 */
public class SubGraph extends Graph {
    private MainGraph main;

    public SubGraph(MainGraph main, Face face) {
        this.main = main;
        this.faces = new ArrayList<>();
        this.nodes = new ArrayList<>();
        nodes.addAll(face.getNodeList());

        //TODO Lier les noeuds entre eux pour creer un cycle

        faces.add(face);
        faces.add(face);
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
     * Mark every node in the model.graph if are present in the mainGraph associated
     */
    public void syncWithMain() {
        //TODO Parcourir la liste des noeuds du graphe donnée et les marquer dans le mainGraph associé
    }

    /**
     * Add te given path to the model.graph
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
        //TODO Supprimer la face de la liste, et en ajouter deux nouvelles
    }
}
