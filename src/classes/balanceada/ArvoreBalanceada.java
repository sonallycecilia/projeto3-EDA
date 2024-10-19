package classes.balanceada;

public class ArvoreBalanceada {
    private int rotationsRight;
    private int rotationsLeft;
    private Node root;

    public ArvoreBalanceada() {
        this.rotationsRight = 0;
        this.rotationsLeft = 0;
        root = null;
    }

    public int getRotationsRight(){
        return this.rotationsRight;
    }
    public int getRotationsLeft(){
        return this.rotationsLeft;
    }
    public Node getRoot(){
        return this.root;
    }

    // Método para obter a altura de um nó
    public int height(Node node) {
        if (node == null) return 0;
        return node.height;
    }

    // Método para calcular o fator de balanceamento de um nó
    public int getBalance(Node node) {
        if (node == null) return 0;
        return height(node.left) - height(node.right);
    }

    // Rotação à direita
    public Node rotateRight(Node y) {
        Node x = y.left;
        Node T2 = x.right;

        // Realiza a rotação
        x.right = y;
        y.left = T2;

        // Atualiza as alturas
        y.height = Math.max(height(y.left), height(y.right)) + 1;
        x.height = Math.max(height(x.left), height(x.right)) + 1;

        rotationsRight++;
        return x;
    }

    // Rotação à esquerda
    public Node rotateLeft(Node x) {
        Node y = x.right;
        Node T2 = y.left;

        // Realiza a rotação
        y.left = x;
        x.right = T2;

        // Atualiza as alturas
        x.height = Math.max(height(x.left), height(x.right)) + 1;
        y.height = Math.max(height(y.left), height(y.right)) + 1;

        rotationsLeft++;
        return y;
    }

    // Insere um nó na árvore AVL e a mantém balanceada
    public void insert(int key) {
        this.root = insert(root, key);
    }

    private Node insert(Node node, int key) {
        if (node == null) return new Node(key);  // Cria um novo nó

        if (key < node.key) {
            node.left = insert(node.left, key);  // Insere à esquerda
        } else if (key > node.key) {
            node.right = insert(node.right, key);  // Insere à direita
        } else {
            return node;  // Chaves duplicadas não são permitidas
        }

        // Atualiza a altura do nó atual
        node.height = 1 + Math.max(height(node.left), height(node.right));

        // Verifica o fator de balanceamento e realiza rotações se necessário
        int balance = getBalance(node);

        // Caso 1: Rotação à direita (LL)
        if (balance > 1 && key < node.left.key) {
            return rotateRight(node);
        }

        // Caso 2: Rotação à esquerda (RR)
        if (balance < -1 && key > node.right.key) {
            return rotateLeft(node);
        }

        // Caso 3: Rotação dupla esquerda-direita (LR)
        if (balance > 1 && key > node.left.key) {
            node.left = rotateLeft(node.left);
            return rotateRight(node);
        }

        // Caso 4: Rotação dupla direita-esquerda (RL)
        if (balance < -1 && key < node.right.key) {
            node.right = rotateRight(node.right);
            return rotateLeft(node);
        }

        return node;  // Retorna o nó atualizado
    }

    // Exibe a árvore em ordem
    public void inOrder(Node node) {
        if (node != null) {
            inOrder(node.left);
            System.out.print(node.key + " ");
            inOrder(node.right);
        }
    }

    public boolean search(int key) {
        return search(root, key);
    }

    // Método auxiliar de busca
    private boolean search(Node node, int key) {
        // Se o nó atual é nulo, a chave não foi encontrada
        if (node == null) {
            return false;
        }

        // Se a chave for igual à chave do nó atual, a chave foi encontrada
        if (node.key == key) {
            return true;
        }

        // Se a chave for menor, continue a busca na subárvore esquerda
        if (key < node.key) {
            return search(node.left, key);
        }

        // Se a chave for maior, continue a busca na subárvore direita
        return search(node.right, key);
    }

}
