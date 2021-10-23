import java.util.Stack;

/**
 * @author Gabriel Kresin e Iago G. Tambosi
 */
public class DFS {

    //TODO
    // - Implementar método para percorrer o grafo a partir de um vértice e escrever a árvore

    public void DFS(Graph graph, int n) {
        // cria um vetor com os vertices já visitados
        boolean visited[] = new boolean[graph.vertices];
        //cria a pilha que será usada para percorrer os vertices
        Stack<Integer> stack = new Stack<>();
        
        stack.push(n);
        int a = 0;
        
        while (!stack.empty()) {
            n = stack.peek();
            stack.pop();
            
            if (visited[n] == false) {
                System.out.println(n + " ");
                visited[n] = true;
            }

            for (int i = 0; i < graph.adjacencyList[n].size(); i++) {
                a = graph.adjacencyList[n].get(i);
                if (!visited[a]) {
                    stack.push(a);
                }
            }
        }
    }

}
