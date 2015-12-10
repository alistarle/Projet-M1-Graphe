package write;

import model.graph.Graph;
import model.Node;
import model.graph.MainGraph;

import java.io.File;
import java.io.FileWriter;

/**
 * Created by juliengauttier on 29/11/15.
 */
public class Write{
    public Graph graph;
    public static String file = "graphe.dot";


    public static boolean writeGraph(MainGraph g){
        File f = new File(file);

        String s = "model.graph system {\n";
        Node Temp;
        Node TempVoisins;
        for (int i = 0; i < g.getSize(); i++) {
            Temp = g.getNode(i);
            s+=Temp.getName()+" [label= \""+Temp.getName()+"\"];\n";
        }
        for (int i = 0; i < g.getSize(); i++) {
            Temp = g.getNode(i);
            for(int j = 0 ; j < Temp.getNeighbours().size(); j++){
                TempVoisins = Temp.getNeighbours().get(j);
                if(TempVoisins!=null)
                s+=Temp.getName()+"--"+TempVoisins.getName()+ ";\n";
            }
        }


        s+="}";
        try {
            FileWriter fw = new FileWriter(f);
            fw.write(s);
            fw.close();
        }catch (Exception e){
            System.out.print("erreur");

        }
        System.out.println(s);
        return true;
    }

}
