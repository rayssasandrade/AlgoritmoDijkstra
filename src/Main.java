import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);

        Grafo grafo = new Grafo();
        grafo.addVertices(preencherGrafo());

        System.out.println("Cidades do mapa: Paripiranga, Simão Dias, Lagarto, Itabaiana e Aracajú");
        System.out.println("Digite a cidade de origem: ");
        String cidadeOrigem = input.next().trim();
        Vertice v1 = grafo.getVerticesByName(cidadeOrigem);

        System.out.println("Digite a cidade de destino: ");
        String cidadeDestino = input.next().trim();
        Vertice v2 = grafo.getVerticesByName(cidadeDestino);

        List<Vertice> resultado = new ArrayList<Vertice>();
        AlgoritmoDijkstra algoritmo = new AlgoritmoDijkstra();
        resultado = algoritmo.menorCaminhoDijkstra(grafo, v1, v2);
        System.out.println("Esse é o menor caminho feito pelo algoritmo:"
                + resultado);

    }

    public static ArrayList<Vertice> preencherGrafo(){

        Vertice paripiranga = new Vertice();
        paripiranga.setNome("Paripiranga");
        Vertice simaoDias = new Vertice();
        simaoDias.setNome("Simão Dias");
        Vertice lagarto = new Vertice();
        lagarto.setNome("Lagarto");
        Vertice itabaiana = new Vertice();
        itabaiana.setNome("Itabaiana");
        Vertice aracaju = new Vertice();
        aracaju.setNome("Aracajú");


        Aresta a1 = new Aresta(paripiranga, simaoDias);
        a1.setPeso(1);
        Aresta a2 = new Aresta(paripiranga, lagarto);
        a2.setPeso(4);
        Aresta a3 = new Aresta(lagarto, aracaju);
        a3.setPeso(2);
        Aresta a4 = new Aresta(paripiranga, aracaju);
        a4.setPeso(5);
        Aresta a5 = new Aresta(paripiranga, itabaiana);
        a5.setPeso(7);
        Aresta a6 = new Aresta(simaoDias, itabaiana);
        a6.setPeso(10);
        Aresta a7 = new Aresta(aracaju, itabaiana);
        a7.setPeso(1);

        ArrayList<Aresta> arestas1 = new ArrayList<>();
        ArrayList<Aresta> arestas2 = new ArrayList<>();
        ArrayList<Aresta> arestas3 = new ArrayList<>();
        ArrayList<Aresta> arestas4 = new ArrayList<>();
        ArrayList<Aresta> arestas5 = new ArrayList<>();
        ArrayList<Vertice> vertices1 = new ArrayList<>();
        ArrayList<Vertice> vertices2 = new ArrayList<>();
        ArrayList<Vertice> vertices3 = new ArrayList<>();
        ArrayList<Vertice> vertices4 = new ArrayList<>();
        ArrayList<Vertice> vertices5 = new ArrayList<>();

        arestas1.add(a5);
        arestas1.add(a2);
        arestas1.add(a4);
        arestas1.add(a1);
        vertices1.add(itabaiana);
        vertices1.add(lagarto);
        vertices1.add(aracaju);
        vertices1.add(simaoDias);
        paripiranga.setArestas(arestas1);
        paripiranga.setAdjacentes(vertices1);

        arestas2.add(a6);
        vertices2.add(itabaiana);
        simaoDias.setArestas(arestas2);
        simaoDias.setAdjacentes(vertices2);

        arestas3.add(a3);
        vertices3.add(aracaju);
        lagarto.setArestas(arestas3);
        lagarto.setAdjacentes(vertices3);

        arestas4.add(a7);
        vertices4.add(itabaiana);
        aracaju.setArestas(arestas4);
        aracaju.setAdjacentes(vertices4);

        ArrayList<Vertice> verticesGrafo = new ArrayList<>();
        verticesGrafo.add(paripiranga);
        verticesGrafo.add(simaoDias);
        verticesGrafo.add(lagarto);
        verticesGrafo.add(itabaiana);
        verticesGrafo.add(aracaju);
        return verticesGrafo;
    }
}