package model;

import java.util.ArrayList;

/**
 * Class representative of a face
 * <p/>
 * Created by juliengauttier on 19/11/15.
 */
public class Face {

    /**
     * List of node who compose the face, linking isn't important, the order of the nodelist define the face
     */
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
        for (Node node : fragment.getContactPoint()) {
            if (!nodeList.contains(node))
                return false;
        }
        return true;
    }

    /**
     * Return if a face is equal to another, order is important, but it can be reserved.
     * Indeed, face with node 1-2-3-4-5 equals face with node 5-4-3-2-1
     *
     * @param o
     * @return
     */
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (this.getNodeList().size() != ((Face) o).getNodeList().size()) return false;

        Face face = (Face) o;
        boolean ordre = true;

        //Verifier ordre ou ordre inverse 1-2-3 3-2-1
        for (int i = 0; i < ((Face) o).getNodeList().size(); i++) {
            if ((this.getNodeList().get(i).getName() != (face).getNodeList().get(i).getName())||(!ordre)){
                ordre = false;
                if(this.getNodeList().get(i).getName() != (face).getNodeList().get(this.getNodeList().size()-1-i).getName()){
                    return false;
                }
            }
        }
        return ordre;
    }
}
