package file;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

/**
 * @author Gabriel Kresin e Iago G. Tambosi
 */
public class GerenciadorArquivos {

    private final String NOME_ARQUIVO = "\\arvores\\arvore.txt";

    /**
     * Carrega um arquivo do tipo somente leitura com base no endereço fornecido por parâmetro
     * @param path Local do arquivo
     * @return @{@link BufferedReader} com o arquivo carregado em memória
     */
    public BufferedReader carregarArquivoLeitura(String path) {
        File file = new File(path);
        FileReader fileReader = null;
        try {
            fileReader = new FileReader(file);
        } catch (FileNotFoundException ex) {
            System.out.println("Erro ao carregar o arquivo: " + ex.getMessage());
        }

        return new BufferedReader(fileReader);
    }

    /**
     * Cria um arquivo a partir do local onde os códigos fontes se encontram. Antes de criar um novo arquivo é realizada
     * a exclusão do arquivo criado na execução anterior.
     *
     * @return O local onde o arquivo foi criado.
     */
    public String criaArquivo() {
        String path = System.getProperty("user.dir") + NOME_ARQUIVO;
        File arquivoAntigo = new File(path);
        arquivoAntigo.delete();

        File arquivoNovo = new File(path);
        try {
            arquivoNovo.getParentFile().mkdirs();
            arquivoNovo.createNewFile();
        } catch (IOException e) {
            System.out.println("Não foi possível criar o arquivo: " + e.getMessage());
        }
        return path;
    }

    public void escreveArquivo(String path, String text) {
        FileWriter fileWriter;
        try {
            fileWriter = new FileWriter(path, true);
            BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);
            bufferedWriter.write(text);
            bufferedWriter.flush();
            bufferedWriter.close();
        } catch (IOException e) {
            System.out.println("Não foi escrever o arquivo: " + e.getMessage());
        }
    }

}
