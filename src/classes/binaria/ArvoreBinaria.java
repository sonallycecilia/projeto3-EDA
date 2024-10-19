package classes.binaria;

public class ArvoreBinaria {
    private Node root;

    public Node getRoot(){
        return root;
    }
    // Inserir um novo valor na árvore
    public void insert(int valor) {
        root = inserirRecursivo(root, valor);
    }

    private Node inserirRecursivo(Node atual, int valor) {
        if (atual == null) {
            return new Node(valor);
        }

        if (valor < atual.valor) {
            atual.esquerda = inserirRecursivo(atual.esquerda, valor);
        } else if (valor > atual.valor) { // Impede a inserção de duplicatas
            atual.direita = inserirRecursivo(atual.direita, valor);
        }
        return atual;
    }

    // Método para calcular a altura da árvore
    public int height(Node node) {
        if (node == null) {
            return -1; // Retorna -1 para que uma árvore vazia tenha altura -1
        }
        int alturaEsquerda = height(node.esquerda);
        int alturaDireita = height(node.direita);
        return Math.max(alturaEsquerda, alturaDireita) + 1;
    }

    // Método público de busca
    public boolean buscar(int valor) {
        return buscarRecursivo(this.root, valor);
    }

    private boolean buscarRecursivo(Node node, int valor) {
        if (node == null) {
            return false; // O valor não foi encontrado
        }

        if (valor == node.valor) {
            return true; // O valor foi encontrado
        }

        // Busca na subárvore esquerda ou direita
        return valor < node.valor
                ? buscarRecursivo(node.esquerda, valor)
                : buscarRecursivo(node.direita, valor);
    }
}