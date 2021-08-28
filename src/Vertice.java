import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Vertice implements Comparable<Vertice>{

    private String nome;
    private int distancia;
    private boolean visitado = false;
    private Vertice pai;
    private List<Aresta> arestas = new ArrayList<Aresta>();
    private List<Vertice> adjacentes = new ArrayList<Vertice>();

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public int getDistancia() {
        return distancia;
    }

    public void setDistancia(int distancia) {
        this.distancia = distancia;
    }

    public boolean isVisitado() {
        return visitado;
    }

    public void setVisitado(boolean visitado) {
        this.visitado = visitado;
    }

    public Vertice getPai() {
        return pai;
    }

    public void setPai(Vertice pai) {
        this.pai = pai;
    }

    public List<Aresta> getArestas() {
        return arestas;
    }

    public void setArestas(List<Aresta> arestas) {
        this.arestas = arestas;
    }

    public List<Vertice> getAdjacentes() {
        return adjacentes;
    }

    public void setAdjacentes(List<Vertice> adjacentes) {
        this.adjacentes = adjacentes;
    }

    @Override
    public int compareTo(Vertice vertice) {
        if(this.getDistancia() < vertice.getDistancia()) return -1;
        else if(this.getDistancia() == vertice.getDistancia()) return 0;
        return 1;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Vertice)) return false;
        Vertice vertice = (Vertice) o;
        return nome.equals(vertice.nome);
    }

    @Override
    public int hashCode() {
        return Objects.hash(nome);
    }

    @Override
    public String toString() {
        String s = "";
        s+= this.getNome();
        return s;
    }
}