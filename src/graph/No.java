package graph;

/**
 * @author Gabriel Kresin e Iago G. Tambosi
 */
public class No {

    int n;
    public String nome;
    boolean visitado;

    public No(int n, String nome) {
        this.n = n;
        this.nome = nome;
        visitado = false;
    }

    public void visitar() {
        visitado = true;
    }

    public void desvisitar() {
        visitado = false;
    }

    public boolean isVisitado() {
        return visitado;
    }

}
