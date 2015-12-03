package graphe;

import java.lang.reflect.Array;
import java.util.ArrayList;

/**
 * Created by juliengauttier on 19/11/15.
 */
public class Cycle {
    private ArrayList<Noeud> cycle;
    private Face interieur;
    private Face exterieur;

    public Cycle(ArrayList<Noeud> cycle) {
        this.cycle = cycle;
    }

    public static Cycle genRandomCycle(ArrayList<Noeud> listNoeud) throws Exception {
        ArrayList<Noeud> atteint = new ArrayList<>();
        ArrayList<Noeud> cycle = new ArrayList<>();

        for(Noeud noeud : listNoeud) {
            atteint.add(noeud);
            for(Noeud voisin : noeud.getVoisins()) {
                voisin.setPere(noeud);

                //Si on a trouvé un cycle
                if(atteint.contains(voisin)) {
                    Noeud pere = voisin.getPere();
                    cycle.add(voisin);
                    while(pere.getPere() != null) {
                        cycle.add(pere);
                        pere = pere.getPere();
                    }
                    cycle.add(pere);
                    return new Cycle(cycle);
                }
                atteint.add(voisin);
            }
        }

        throw new Exception("Aucun cycle dans la liste des noeud envoyés");
    }

    @Override
    public String toString() {
        return "Cycle{" +
                "cycle=" + cycle +
        '}';
    }
}
