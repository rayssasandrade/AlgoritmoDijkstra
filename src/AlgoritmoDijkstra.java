import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class AlgoritmoDijkstra {

    //Vai guardar o menor caminho
    List<Vertice> menorCaminho = new ArrayList<Vertice>();

    Vertice verticeCaminho = new Vertice();
    Vertice atual = new Vertice();
    Vertice adjacente = new Vertice();
    List<Vertice> naoVisitados = new ArrayList<Vertice>();

    public List<Vertice> menorCaminhoDijkstra(Grafo grafo, Vertice v1, Vertice v2) {

        //adiciona a origem ao caminho
        menorCaminho.add(v1);

        for (int i = 0; i < grafo.getVertices().size(); i++) {
            //varre colocando 0 no vertice de origem e máxima distância,
            //além de colocar os vértices na lista de não visitados.
            if (grafo.getVertices().get(i).getNome().equals(v1.getNome())) {
                grafo.getVertices().get(i).setDistancia(0);
            } else {
                grafo.getVertices().get(i).setDistancia(Integer.MAX_VALUE);
            }
            this.naoVisitados.add(grafo.getVertices().get(i));
        }

        //ordena a lista
        Collections.sort(naoVisitados);

        //enquanto os vertices serem todos visitados
        while (!this.naoVisitados.isEmpty()) {
            atual = this.naoVisitados.get(0);
            System.out.println("Visita vertice:  " + atual);

            //Visita todos aretas do vertice
            for (int i = 0; i < atual.getArestas().size(); i++) {
                //pega primeiro vertice adjacente
                adjacente = atual.getArestas().get(i).getDestino();
                System.out.println("Analisando adjacente" + adjacente);
                //verifica se não foi visitado ainda
                if (!adjacente.isVisitado()) {
                    //comparando a vistância que havia com a atual, se menor substitui
                    if (adjacente.getDistancia() > (atual.getDistancia() + atual.getArestas().get(i).getPeso())) {
                        adjacente.setDistancia(atual.getDistancia() + atual.getArestas().get(i).getPeso());
                        adjacente.setPai(atual);

                        //se a lista foi mudada com a nova distância
                        //o anteior é apagado
                        if (adjacente == v2) {
                            menorCaminho.clear();
                            verticeCaminho = adjacente;
                            menorCaminho.add(adjacente);
                            while (verticeCaminho.getPai() != null) {
                                menorCaminho.add(verticeCaminho.getPai());
                                verticeCaminho = verticeCaminho.getPai();
                            }

                            //ordena a lista
                            Collections.sort(menorCaminho);
                        }
                    }
                }
            }

            //coloca atual como já visitado e tira da lista de não visitados
            atual.setVisitado(true);
            this.naoVisitados.remove(atual);

            Collections.sort(naoVisitados);
            System.out.println("Ainda não visitados: " + naoVisitados);

        }
        return menorCaminho;
    }
}
