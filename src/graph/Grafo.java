package graph;

import java.io.BufferedReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;

public class Grafo {

    // Cada nó do mapa de adjacência possui uma lista de nós filhos
    public HashMap<No, LinkedList<No>> mapaAdjacencias;
    // Lista de nós únicos
    List<No> nos = new ArrayList<>();

    // Construtor
    public Grafo(BufferedReader bufferedReader) {
        mapaAdjacencias = new HashMap<>();
        criarGrafoApartirDeArquivo(bufferedReader);
    }

    /**
     * Adiciona uma aresta no mapa de adajencias entre dois vértices.
     */
    public void adicionaArestaAuxiliar(No a, No b) {
        LinkedList<No> tmp = mapaAdjacencias.get(a);

        if (tmp != null) {
            tmp.remove(b);
        } else {
            tmp = new LinkedList<>();
        }

        tmp.add(b);
        mapaAdjacencias.put(a, tmp);
    }

    /**
     * Adiciona uma aresta no mapa de adjacência. Como o grafo é não dirigido a aresta e adicionado no sentido origem -> destino e destino -> origem.
     * @param origem
     * @param destino
     */
    public void adicionaAresta(No origem, No destino) {
        // We make sure that every used node shows up in our .keySet()
        if (!mapaAdjacencias.keySet().contains(origem)) {
            mapaAdjacencias.put(origem, null);
        }

        if (!mapaAdjacencias.keySet().contains(destino)) {
            mapaAdjacencias.put(destino, null);
        }

        adicionaArestaAuxiliar(origem, destino);
        adicionaArestaAuxiliar(destino, origem);
    }

    public void resetarNosVisitados() {
        for (No no : mapaAdjacencias.keySet()) {
            no.desvisitar();
        }
    }

    public void criarGrafoApartirDeArquivo(BufferedReader bufferedReader) {
        String linhaAtual;
        boolean primeiraLinha = true;

        try {
            while ((linhaAtual = bufferedReader.readLine()) != null) {
                if (primeiraLinha) {
                    // Não faz nada pois o valor da primeira linha é a quantidade de vértices
                    primeiraLinha = false;
                } else {
                    String[] valores = linhaAtual.split(" ");

                    No noOrigem = obterNoApartirDoNome(valores[0]);
                    if (noOrigem == null) {
                        noOrigem = new No(Integer.parseInt(valores[0]), valores[0]);
                        nos.add(noOrigem);
                    }

                    No noDestino = obterNoApartirDoNome(valores[1]);
                    if (noDestino == null) {
                        noDestino = new No(Integer.parseInt(valores[1]), valores[1]);
                        nos.add(noDestino);
                    }

                    adicionaAresta(noOrigem, noDestino);
                }

            }
        } catch (IOException e) {
            System.out.println("Erro ao ler o arquivo.");
        } finally {
            try {
                bufferedReader.close();
            } catch (IOException ex) {
                System.out.println("Erro ao fechar o arquivo.");
            }
        }
    }

    public No obterNoApartirDoNome(String nodeName) {
        if (nos.isEmpty()) {
            return null;
        }
        for (No no : nos) {
            if (no.nome.equals(nodeName)) {
                return no;
            }
        }
        return null;
    }

}
