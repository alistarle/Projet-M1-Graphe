package read;

import model.graph.Graph;
import model.Node;
import model.graph.MainGraph;

import java.io.*;

/**
 * Created by juliengauttier on 08/11/15.
 */
public class Read {
    public Graph graph;
    String FICHIER;



    public static MainGraph getGraph(String fichier){
        String chaine="";
        MainGraph graph = new MainGraph();
        try{
            InputStream ips=new FileInputStream(fichier);
            InputStreamReader ipsr=new InputStreamReader(ips);
            BufferedReader br=new BufferedReader(ipsr);
            String ligne = br.readLine();

            graph = new MainGraph(Integer.parseInt(ligne));



            int nom;
            Node node;
            while ((ligne=br.readLine())!=null)
            {

                node = graph.getNode(Integer.parseInt(ligne.charAt(0) + ""));
                for(int i = 1; i<ligne.length() ; i++){
                    if(ligne.charAt(i)=='['){
                        i++;
                        while (ligne.charAt(i)!=']'){
                            char c = ligne.charAt(i);
                            if((c!=',')&&(c!=' ')&&(c!=']')){
                                try {
                                    node.addNeighbour(graph.getNode(Integer.parseInt(ligne.charAt(i) + "")));
                                }catch (Exception e3){
                                    System.out.println(e3);
                                }
                            }
                            i++;
                        }
                    }

                }
                System.out.println(ligne);


            }
            br.close();
        }
        catch (Exception e){
            System.out.println(e.toString()+"\n Creation d'un fichier");

            try {
                FileWriter fw = new FileWriter (fichier);
                BufferedWriter bw = new BufferedWriter (fw);
                PrintWriter fichierSortie = new PrintWriter(bw);
                fichierSortie.println (chaine+"\n test de lecture et écriture");
                fichierSortie.close();
                System.out.println("Le fichier " + fichier + " a été créé");
            }
            catch (Exception e2){
                System.out.println(e2.toString());
            }
        }
        System.out.print(graph.toString());
        return graph;
    }

}
