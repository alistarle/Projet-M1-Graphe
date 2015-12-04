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


    /**
     * List of fragment of G, used in algorithm
     */
    private ArrayList<Fragment> fragments;

    /**
     * List of eligible face of H, used in algorithm
     */
    private ArrayList<Face> faces;

    /**
     * List of node to compose a xy-chemin in algorithm
     */
    private ArrayList<Node> path;

    /**
     * Tell if H has been updated, used in algorithm
     */
    private boolean update;


    /**
     * Return new graph made from a random cycle of another MainGraph G
     *
     * @param G
     * @return
     * @throws Exception
     */
    public SubGraph genGraphFromFirstCycle(MainGraph G) throws Exception {
        ArrayList<Node> seen = new ArrayList<>();
        ArrayList<Node> nodes = new ArrayList<>();

        for(Node node : G.getNodes()) {
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
                    return new SubGraph(G,new Face(nodes));
                }
                seen.add(neighbour);
            }
        }

        throw new Exception("Aucun cycle dans la liste des noeud envoyés");
    }

    /**
     * Check if a MainGraph G is planar or not
     *
     * @param G
     * @return
     */
    public boolean isPlanar(MainGraph G) throws Exception {
        SubGraph H = this.genGraphFromFirstCycle(G); //On a initialisé H
        G.setH(H); //On définie H comme étant le sous-graphe de G
        fragments = G.getFragments();
        while(fragments.iterator().hasNext()) { //Tant qu'il y a des fragments de G
            fragments = G.getFragments();
            update = false;
            for(Fragment fragment : fragments) {
                if(!update) {
                    faces = G.getEligible(fragment);
                    if(faces.size() == 0)
                        return false;
                    else if(faces.size() == 1) {
                        path = fragment.calcPath(); //On calcul un xy-chemin
                        H.divePath(faces.get(0), path); //On plonge un xy-chemin dans H
                        update = true;
                    }
                }
            }
            if(!update) {
                path = fragments.get(0).calcPath(); //On calcul un xy-chemin
                faces = G.getEligible(fragments.get(0)); //On plonge ce xy-chemin dans H
                H.divePath(faces.get(0), path);
            }
        }
        return true;
    }
}
