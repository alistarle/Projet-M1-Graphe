package model;

import model.graph.Graph;

import java.util.ArrayList;

/**
 * Created by juliengauttier on 19/11/15.
 */
public class Fragment {
    private Graph graph;
    private ArrayList<Node> nodeList;

    /**
     * Create a new fragement of a model.graph with a list of node
     *
     * @param graph
     * @param nodeList
     */
    public Fragment(Graph graph, ArrayList<Node> nodeList) {
        this.nodeList = nodeList;
        this.graph = graph;
    }

    /**
     * Return list of point of the fragment who are contact point
     *
     * @return
     */
    public ArrayList<Node> getContactPoint() {
        ArrayList<Node> listContact = new ArrayList<>();
        for(Node node : nodeList)
            if(node.isContactPoint())
                listContact.add(node);
        return listContact;
    }

    /**
     * Return list of node who are a path between two contact point
     *
     * @return
     */
    public ArrayList<Node> calcPath() throws Exception {
        ArrayList<Node> seen = new ArrayList<>();
        ArrayList<Node> path = new ArrayList<>();
        Node from = this.getContactPoint().get(0);

        //TODO Parcours en profondeur depuis from jusqu'a un autre point de contact, retourner path ou throw exception sinon

        throw new Exception("Chemin non trouvé dans le fragment");
    }
}
