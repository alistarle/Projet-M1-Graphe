package write;

import graphe.Graphe;
import graphe.Noeud;

import java.io.File;
import java.io.FileWriter;

/**
 * Created by juliengauttier on 29/11/15.
 */
public class write{
    public Graphe graphe;
    public static String file = "TEST.dot";


    public static boolean writeGraphe(Graphe g){
        File f = new File(file);

        String s = "graph system {\n";
        Noeud Temp;
        Noeud TempVoisins;
        for (int i = 0; i < g.getTaille(); i++) {
            Temp = g.getNoeud(i);
            s+=Temp.nom+" [label= \""+Temp.nom+"\"];\n";
        }
        for (int i = 0; i < g.getTaille(); i++) {
            Temp = g.getNoeud(i);
            for(int j = 0 ; j < Temp.getVoisins().size(); j++){
                TempVoisins = Temp.getVoisins().get(j);
                s+=Temp.nom+"--"+TempVoisins.nom+ ";\n";
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
