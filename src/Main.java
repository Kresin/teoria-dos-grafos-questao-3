import java.io.BufferedReader;
import java.util.Scanner;

import bfs.BFS;
import dfs.DFS;
import file.GerenciadorArquivos;
import graph.Grafo;
import graph.No;

/**
 * @author Gabriel Kresin e Iago G. Tambosi
 */
public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        GerenciadorArquivos gerenciadorArquivos = new GerenciadorArquivos();

        System.out.println("Informe o endereço completo do arquivo (Exemplo: C:\\git\\teoria-dos-grafos-questao-3\\arquivos\\Arquivo_1.txt)");
        String path = scanner.nextLine();

        BufferedReader bufferedReader = gerenciadorArquivos.carregarArquivoLeitura(path);
        Grafo grafo = new Grafo(bufferedReader);

        System.out.println("Qual deve ser o vértice de partida para percorrer as buscas?");
        String v = scanner.nextLine();
        No no = grafo.obterNoApartirDoNome(v);

        System.out.println("Resultado BFS:");
        BFS bfs = new BFS();
        bfs.bfs(grafo, no);
        System.out.println(bfs.ordemNosEncontrados.toString());
        String arquivo = gerenciadorArquivos.criaArquivo();
        gerenciadorArquivos.escreveArquivo(arquivo, "Resultado BFS:" + "\n" + bfs.ordemNosEncontrados.toString());

        System.out.println("Resultado DFS:");
        grafo.resetarNosVisitados();
        DFS dfs = new DFS();
        dfs.dfs(grafo, no);
        System.out.println(dfs.ordemNosEncontrados.toString());
        gerenciadorArquivos.escreveArquivo(arquivo, "\nResultado DFS:" + "\n" + dfs.ordemNosEncontrados.toString());
    }

}
