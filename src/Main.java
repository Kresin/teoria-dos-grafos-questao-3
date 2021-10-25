import java.io.BufferedReader;
import java.time.LocalDateTime;
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

        BFS bfs = new BFS();
        System.out.println("Início execução bfs: " + LocalDateTime.now());
        bfs.bfs(grafo, no);
        System.out.println("Fim execução bfs: " + LocalDateTime.now());
        System.out.println("Resultado BFS:");
//        System.out.println(bfs.ordemNosEncontrados.toString());
        String arquivo = gerenciadorArquivos.criaArquivo();
        gerenciadorArquivos.escreveArquivo(arquivo, "Resultado BFS:" + "\n" + bfs.ordemNosEncontrados.toString());

        System.out.println("--------------------------------------------------------------");
        grafo.resetarNosVisitados();

        DFS dfs = new DFS();
        System.out.println("Início execução dfs: " + LocalDateTime.now());
        dfs.dfs(grafo, no);
        System.out.println("Fim execução dfs: " + LocalDateTime.now());
        System.out.println("Resultado DFS:");
//        System.out.println(dfs.ordemNosEncontrados.toString());
        gerenciadorArquivos.escreveArquivo(arquivo, "\nResultado DFS:" + "\n" + dfs.ordemNosEncontrados.toString());
    }

}
