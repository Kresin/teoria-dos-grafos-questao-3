import java.io.*;

/**
 * @author Gabriel Kresin e Iago G. Tambosi
 */
public class FileController {

    private final String FILE_NAME = "\\arvores\\arvore.txt";

    /**
     * Carrega um arquivo com base no endereço fornecido por parâmetro
     * @param path Local do arquivo
     * @return @{@link BufferedReader} com o arquivo carregado em memória
     */
    public BufferedReader loadFile(String path) {
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
    public String createFile() {
        String path = System.getProperty("user.dir") + FILE_NAME;
        File oldFile = new File(path);
        oldFile.delete();

        File newFile = new File(path);
        try {
            newFile.createNewFile();
        } catch (IOException e) {
            System.out.println("Não foi possível criar o arquivo: " + e.getMessage());
        }
        return path;
    }

}
