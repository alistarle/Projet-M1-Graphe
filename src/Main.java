import controller.GraphController;
import model.graph.MainGraph;
import read.Read;
import write.Write;

/**
 * Created by juliengauttier on 14/10/15.
 */

public class Main {

    public static void main(String[]args) throws Exception {
        MainGraph graph = Read.getGraph("test.graph");
        GraphController controller = new GraphController();
        if(controller.isPlanar(graph))
            Write.writeGraph(graph);
    }
}
