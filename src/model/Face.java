package model;

import java.util.ArrayList;

/**
 * Created by juliengauttier on 19/11/15.
 */
public class Face {
    private ArrayList<Node> nodeList;

    public Face(ArrayList<Node> nodeList) {
        this.nodeList = nodeList;
    }

    public ArrayList<Node> getNodeList() {
        return nodeList;
    }

    /**
     * Return whether or not the face is ilegible to receive the fragment
     *
     * @param fragment
     * @return
     */
    public boolean isEligible(Fragment fragment) {

        //TODO Regarder si tout les points de contact du fragment sont dans la face

        return true;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Face face = (Face) o;

        //TODO Verifier si les sommets sont dans le même ordre ou dans le sens inverse : 1-2-3-4-5 = 5-4-3-2-1
        return false;
    }
}
