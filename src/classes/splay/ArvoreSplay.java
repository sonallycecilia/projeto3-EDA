package classes.splay;

public class ArvoreSplay {
    private int rotationsRight;
    private int rotationsLeft;
    private Node root;

    // Construtor: Inicializa a árvore com a raiz como null
    public ArvoreSplay() {
        this.root = null;
        this.rotationsRight = 0;
        this.rotationsLeft = 0;
    }

    public int getRotationsLeft() {
        return rotationsLeft;
    }

    public int getRotationsRight() {
        return rotationsRight;
    }

    public Node getRoot() {
        return root;
    }

    // Método de rotação à direita
    private Node rotateRight(Node y) {
        Node x = y.left;
        y.left = x.right;
        x.right = y;
        rotationsRight++;
        return x;
    }

    // Método de rotação à esquerda
    private Node rotateLeft(Node x) {
        Node y = x.right;
        x.right = y.left;
        y.left = x;
        rotationsLeft++;
        return y;
    }

    // Operação Splay: Move o nó com a chave dada para a raiz
    private Node splay(Node node, int key) {
        if (node == null || node.key == key) {
            return node;
        }

        // Caso 1: Chave está na subárvore esquerda
        if (key < node.key) {
            if (node.left == null) return node;  // Chave não encontrada

            // Zig-Zig (Esquerda-Esquerda)
            if (key < node.left.key) {
                node.left.left = splay(node.left.left, key);
                node = rotateRight(node);
            }
            // Zig-Zag (Esquerda-Direita)
            else if (key > node.left.key) {
                node.left.right = splay(node.left.right, key);
                if (node.left.right != null) {
                    node.left = rotateLeft(node.left);
                }
            }
            return (node.left == null) ? node : rotateRight(node);
        }

        // Caso 2: Chave está na subárvore direita
        else {
            if (node.right == null) return node;  // Chave não encontrada

            // Zag-Zag (Direita-Direita)
            if (key > node.right.key) {
                node.right.right = splay(node.right.right, key);
                node = rotateLeft(node);
            }
            // Zag-Zig (Direita-Esquerda)
            else if (key < node.right.key) {
                node.right.left = splay(node.right.left, key);
                if (node.right.left != null) {
                    node.right = rotateRight(node.right);
                }
            }
            return (node.right == null) ? node : rotateLeft(node);
        }
    }

    // Método público de inserção
    public void insert(int key) {
        if (root == null) { // Se a árvore está vazia
            root = new Node(key);
            return;
        }

        root = splay(root, key); // Splay para mover a chave para a raiz

        // Inserindo o novo nó
        if (key < root.key) {
            Node newNode = new Node(key);
            newNode.right = root;
            newNode.left = root.left;
            root.left = null;
            root = newNode;
        } else if (key > root.key) {
            Node newNode = new Node(key);
            newNode.left = root;
            newNode.right = root.right;
            root.right = null;
            root = newNode;
        }
    }

    // Método público de busca
    public boolean search(int key) {
        root = splay(root, key);
        return root != null && root.key == key;
    }

    // Método público de remoção
    public void remove(int key) {
        if (root == null) return;

        root = splay(root, key); // Splay para mover a chave para a raiz

        if (root.key != key) return; // Chave não encontrada

        // Se não tem subárvore esquerda, conecta a subárvore direita
        if (root.left == null) {
            root = root.right;
        } else {
            Node temp = root; // Armazena a raiz atual
            root = splay(root.left, key); // Splay na subárvore esquerda
            root.right = temp.right; // Conecta a subárvore direita
        }
    }

    // Método para exibir a árvore em ordem
    public void displayInOrder() {
        inOrder(root);
        System.out.println();
    }

    // Método auxiliar para exibir a árvore em ordem
    private void inOrder(Node node) {
        if (node != null) {
            inOrder(node.left);
            System.out.print(node.key + " ");
            inOrder(node.right);
        }
    }

    // Método para calcular a altura da árvore
    public int height(Node node) {
        if (node == null) {
            return -1; // Se a árvore está vazia, altura é -1 (ou 0, dependendo da convenção)
        }
        int leftHeight = height(node.left);
        int rightHeight = height(node.right);
        return Math.max(leftHeight, rightHeight) + 1;
    }
}

