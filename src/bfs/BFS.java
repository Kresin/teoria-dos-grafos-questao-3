package bfs;

import java.util.LinkedList;

import graph.Grafo;
import graph.No;

/**
 * @author Gabriel Kresin e Iago G. Tambosi
 */
public class BFS {

    public StringBuilder ordemNosEncontrados = new StringBuilder();

    /**
     * Realiza a pesquisa em largura em um grafo a partir de um vertice específico
     * @param grafo
     * @param no
     */
    public void bfs(Grafo grafo, No no) {
        breadthFirstSearch(grafo, no);

        // Executa a pesquisa em largura enquanto houver nós não visitados
        for (No n : grafo.mapaAdjacencias.keySet()) {
            if (!n.isVisitado()) {
                // Executa a pesquisa em largura a partir do nó desconexo ou não encontrado durante as execuções anteriores
                breadthFirstSearch(grafo, n);
            }
        }
    }

    /**
     * Realiza a pesquisa em largura em um grafo a partir de um vertice específico
     * @param grafo
     * @param no
     */
    public void breadthFirstSearch(Grafo grafo, No no) {
        if (no == null) {
            return;
        }

        // Cria a fila de nós e adiciona o primeiro nó
        LinkedList<No> queue = new LinkedList<>();
        queue.add(no);

        while (!queue.isEmpty()) {
            No noAtual = queue.removeFirst();

            // Verifica de o nó atual já foi visitado, se sim, pula este nó
            if (noAtual.isVisitado()) {
                continue;
            }

            // Marca o nó atual como visitado
            noAtual.visitar();
            ordemNosEncontrados.append(noAtual.nome).append(" ");

            LinkedList<No> vizinhos = grafo.mapaAdjacencias.get(noAtual);

            // Verifica se o nó atual possui vizinhos
            if (vizinhos == null) {
                continue;
            }

            for (No vizinho : vizinhos) {
                // Apenas vizinhos não visitados são adicionados
                if (!vizinho.isVisitado()) {
                    queue.add(vizinho);
                }
            }
        }
    }

}
