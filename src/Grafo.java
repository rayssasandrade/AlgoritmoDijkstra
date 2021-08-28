import java.util.ArrayList;
import java.util.List;

public class Grafo {

    private List<Vertice> grafo = new ArrayList<Vertice>();

    public List<Vertice> getVertices() {
        return grafo;
    }

    public void addVertices(List<Vertice> grafo) {
        this.grafo = grafo;
    }

    public void addVertice(Vertice v){
        this.grafo.add(v);
    }

    public Vertice getVerticesByName(String nome) {
        for (int i = 0; i < this.getVertices().size(); i++) {
            if (nome.equalsIgnoreCase(this.getVertices().get(i).getNome())) {
                return this.getVertices().get(i);
            }
        }
        return null;
    }
}
