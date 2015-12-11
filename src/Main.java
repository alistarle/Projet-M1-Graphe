import controller.GraphController;
import model.graph.MainGraph;
import read.Read;
import write.Write;

/**
 * Created by juliengauttier on 14/10/15.
 */

public class Main {

    public static void main(String[] args) throws Exception {
        if(args.length == 0) {
            System.out.println("Aucun fichier n'a été trouvé");
            System.exit(0);
        }
        MainGraph G = Read.getGraph(args[0]); //On initialise G à partir du fichier
        GraphController controller = new GraphController(); //On crée un controlleur de graphe ( qui lancera l'algo )
        if(controller.isPlanar(G)) //Si le graphe est planaire on l'écrit
            Write.writeGraph(G);
    }
}
