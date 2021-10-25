package dfs;

import java.util.LinkedList;

import graph.Grafo;
import graph.No;

/**
 * @author Gabriel Kresin e Iago G. Tambosi
 */
public class DFS {

    public StringBuilder ordemNosEncontrados = new StringBuilder();

    /**
     * Realiza a pesquisa em profundidado em um grafo a partir de um vertice específico
     * @param grafo
     * @param no
     */
    public void dfs(Grafo grafo, No no) {
        depthFirstSearch(grafo, no);

        // Executa a pesquisa em profundidade enquanto houver nós não visitados
        for (No n : grafo.mapaAdjacencias.keySet()) {
            if (!n.isVisitado()) {
                // Executa a pesquisa em profundidade a partir do nó desconexo ou não encontrado durante as execuções anteriores
                depthFirstSearch(grafo, n);
            }
        }
    }

    /**
     * Realiza a pesquisa em profundidado em um grafo a partir de um vertice específico
     * @param grafo
     * @param no
     */
    public void depthFirstSearch(Grafo grafo, No no) {
        no.visitar();
        ordemNosEncontrados.append(no.nome).append(" ");

        LinkedList<No> vizinhos = grafo.mapaAdjacencias.get(no);
        if (vizinhos == null)
            return;

        for (No vizinho : vizinhos) {
            if (!vizinho.isVisitado())
                depthFirstSearch(grafo, vizinho);
        }
    }

}
