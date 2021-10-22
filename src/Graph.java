import java.util.LinkedList;

/**
 * @author Gabriel Kresin e Iago G. Tambosi
 */
public class Graph {

    //TODO
    // - Criar método para percorrer o arquivo e montar o grafo
    // - Marcar o tempo de execução do algoritmo

    private int vertices;
    private LinkedList<Integer> adjacencyList[];

    public Graph(int vertices) {
        this.vertices = vertices;
        adjacencyList = new LinkedList[vertices];
        for (int i = 0; i < vertices; i++) {
            adjacencyList[i] = new LinkedList<>();
        }
    }



}
