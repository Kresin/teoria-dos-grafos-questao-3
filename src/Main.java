import java.io.BufferedReader;
import java.util.Scanner;

/**
 * @author Gabriel Kresin e Iago G. Tambosi
 */
public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        FileController fileController = new FileController();

        System.out.println("Informe o endereço completo do arquivo (Exemplo: C:\\git\\teoria-dos-grafos-questao-3\\arquivos\\Arquivo_1.txt)");
        String path = scanner.nextLine();

        BufferedReader bufferedReader = fileController.loadFile(path);
        Graph graph = new Graph();
        graph = graph.createGraphFromFile(bufferedReader);
    }

}
