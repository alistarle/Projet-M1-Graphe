import graphe.Cycle;
import graphe.Graphe;
import read.read;
import write.write;

/**
 * Created by juliengauttier on 14/10/15.
 */

public class Main {

    public static void main(String[]args) throws Exception {
        Graphe graphe = read.getGraphe("test.graphe");
<<<<<<< Updated upstream
        Cycle cycle = Cycle.genRandomCycle(graphe.getNoeuds());
        System.out.println(cycle);
        //if(estPlanaire(graphe)){
        //    write.writeGraphe(graphe);
        //}
=======
        String planaire = "false";
        if(estPlanaire(graphe)){
            write.writeGraphe(graphe);
            planaire = "true";
        }
>>>>>>> Stashed changes

        System.out.print(planaire);


    }

    public static boolean estPlanaire(Graphe g){

        return true;
    }

}
