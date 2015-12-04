package controller;

import model.Face;
import model.Fragment;
import model.Node;
import model.graph.MainGraph;
import model.graph.SubGraph;

import java.util.ArrayList;

/**
 * Created by alistarle on 04/12/2015.
 */
public class GraphController {
    private ArrayList<Fragment> fragments;
    private ArrayList<Face> faces;
    private ArrayList<Node> path;
    private boolean update;


    /**
     * Return new graph made from a random cycle of another model.graph
     *
     * @param graph
     * @return
     * @throws Exception
     */
    public SubGraph genGraphFromFirstCycle(MainGraph graph) throws Exception {
        ArrayList<Node> seen = new ArrayList<>();
        ArrayList<Node> nodes = new ArrayList<>();

        for(Node node : graph.getNodes()) {
            seen.add(node);
            for(Node neighbour : node.getNeighbours()) {
                neighbour.setFather(node);

                //Si on a trouvé un cycle
                if(seen.contains(neighbour)) {
                    Node father = neighbour.getFather();
                    nodes.add(neighbour);
                    while(father.getFather() != null) {
                        nodes.add(father);
                        father = father.getFather();
                    }
                    nodes.add(father.clone());
                    return new SubGraph(graph,new Face(nodes));
                }
                seen.add(neighbour);
            }
        }

        throw new Exception("Aucun cycle dans la liste des noeud envoyés");
    }

    /**
     * Check if a model.graph is planar or not
     *
     * @param graph
     * @return
     */
    public boolean isPlanar(MainGraph graph) throws Exception {
        SubGraph inner = this.genGraphFromFirstCycle(graph); //On a initialisé H
        graph.setSub(inner); //On définie H comme étant le sous-graphe de G
        fragments = graph.getFragments();
        while(fragments.iterator().hasNext()) {
            fragments = graph.getFragments();
            update = false;
            for(Fragment fragment : fragments) {
                if(!update) {
                    faces = graph.getEligible(fragment);
                    if(faces.size() == 0)
                        return false;
                    else if(faces.size() == 1) {
                        path = fragment.calcPath();
                        inner.divePath(faces.get(0),path);
                        update = true;
                    }
                }
            }
            if(!update) {
                path = fragments.get(0).calcPath();
                faces = graph.getEligible(fragments.get(0));
                inner.divePath(faces.get(0),path);
            }
        }
        return true;
    }
}
