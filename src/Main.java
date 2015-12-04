import controller.GraphController;
import model.graph.MainGraph;
import read.Read;
import write.Write;

/**
 * Created by juliengauttier on 14/10/15.
 */

public class Main {

    public static void main(String[]args) throws Exception {
        MainGraph G = Read.getGraph("test.graph"); //On initialise G à partir du fichier
        GraphController controller = new GraphController(); //On crée un controlleur de graphe ( qui lancera l'algo )
        if(controller.isPlanar(G)) //Si le graphe est planaire on l'écrit
            Write.writeGraph(G);
    }
}
