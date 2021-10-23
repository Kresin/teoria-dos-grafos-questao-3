import java.io.BufferedReader;
import java.io.IOException;
import java.util.LinkedList;

/**
 * @author Gabriel Kresin e Iago G. Tambosi
 */
public class Graph {

    //TODO
    // - Criar método para percorrer o arquivo e montar o grafo
    // - Marcar o tempo de execução do algoritmo

    // Número de vértices
    int vertices;

    //Lista de adjacências
    LinkedList<Integer>[] adjacencyList;

    public Graph() {
    }

    // Construtor
    public Graph(int vertices) {
        this.vertices = vertices;
        adjacencyList = new LinkedList[vertices];
        for (int i = 0; i < adjacencyList.length; i++) {
            adjacencyList[i] = new LinkedList<>();
        }
    }

    /**
     * Adiciona uma aresta ao grafo
     */
    public void addEdge(int p, int v) {
        adjacencyList[p].add(v);
    }

    public Graph createGraphFromFile(BufferedReader bufferedReader) {
        Graph graph = null;
        String actualLine;
        boolean firstLine = true;
        try {
            while ((actualLine = bufferedReader.readLine()) != null) {
                if (firstLine) {
                    int numberOfVertices = Integer.parseInt(actualLine);
                    graph = new Graph(numberOfVertices);
                }
                String[] edges = actualLine.split(" ");
                int f = Integer.parseInt(edges[0]);
                int s = Integer.parseInt(edges[1]);
                addEdge(f, s);
                firstLine = false;
            }
        } catch (IOException ex) {
            System.out.println("Ocorreu um erro ao gerar o grafo a partir do arquivo.");
        } finally {
            try {
                bufferedReader.close();
            } catch (IOException ex) {
                System.out.println("Erro ao fechar o arquivo.");
            }
        }

        return graph;
    }
}
