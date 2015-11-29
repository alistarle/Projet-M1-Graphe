import graphe.Graphe;
import read.read;
import write.write;

/**
 * Created by juliengauttier on 14/10/15.
 */

public class Main {

    public static void main(String[]args){
        Graphe graphe = read.getGraphe("test.graphe");
        if(estPlanaire(graphe)){
            write.writeGraphe(graphe);
        }

    }

    public static boolean estPlanaire(Graphe g){

        return true;
    }

}
