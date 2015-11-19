package read;

import graphe.Graphe;
import graphe.Noeud;

import java.io.*;

/**
 * Created by juliengauttier on 08/11/15.
 */
public class read {
    public Graphe graphe;
    String FICHIER;



    public static Graphe getGraphe(String fichier){
        String chaine="";
        Graphe graphe = new Graphe();
        try{
            InputStream ips=new FileInputStream(fichier);
            InputStreamReader ipsr=new InputStreamReader(ips);
            BufferedReader br=new BufferedReader(ipsr);
            String ligne = br.readLine();

            graphe = new Graphe(Integer.parseInt(ligne));



            int nom;
            Noeud noeud;
            while ((ligne=br.readLine())!=null)
            {

                noeud = graphe.getNoeud(Integer.parseInt(ligne.charAt(0)+""));
                for(int i = 1; i<ligne.length() ; i++){
                    if(ligne.charAt(i)=='['){
                        i++;
                        while (ligne.charAt(i)!=']'){
                            char c = ligne.charAt(i);
                            if((c!=',')&&(c!=' ')&&(c!=']')){
                                try {
                                    noeud.addVoisin(graphe.getNoeud(Integer.parseInt(ligne.charAt(i) + "")));
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
        System.out.print(graphe.toString());
        return graphe;
    }

}
