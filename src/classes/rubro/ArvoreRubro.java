package classes.rubro;

public class ArvoreRubro {
    private Node root;
    private int rotationsRight;
    private int rotationsLeft;

    public ArvoreRubro() {
        this.rotationsRight = 0;
        this.rotationsLeft = 0;
    }

    public int getRotationsRight() {
        return this.rotationsRight;
    }

    public int getRotationsLeft() {
        return this.rotationsLeft;
    }
    public Node getRoot() {
        return this.root;
    }

    // Inserção na árvore
    public void insert(int key) {
        Node newNode = new Node(key);
        root = insertRecursive(root, newNode);
        fixInsert(newNode); // Corrige as violações das propriedades
    }

    // Inserção recursiva como em uma árvore binária de busca
    private Node insertRecursive(Node current, Node newNode) {
        if (current == null) {
            return newNode;
        }

        if (newNode.key < current.key) {
            current.left = insertRecursive(current.left, newNode);
            current.left.parent = current;
        } else if (newNode.key > current.key) {
            current.right = insertRecursive(current.right, newNode);
            current.right.parent = current;
        }
        return current;
    }

    // Corrige as violações após a inserção
    private void fixInsert(Node node) {
        while (node != root && node.parent.isRed) {
            Node parent = node.parent;
            Node grandparent = parent.parent;

            if (grandparent == null) {
                break; // Se não há avô, interrompe o loop
            }

            if (parent == grandparent.left) {
                Node uncle = grandparent.right;

                // Caso 1: O tio é vermelho -> Recolorimos
                if (uncle != null && uncle.isRed) {
                    parent.isRed = false;
                    uncle.isRed = false;
                    grandparent.isRed = true;
                    node = grandparent; // Subimos na árvore
                } else {
                    // Caso 2: Nó é filho direito -> Rotação à esquerda
                    if (node == parent.right) {
                        node = parent;
                        rotateLeft(node);
                    }
                    // Caso 3: Nó é filho esquerdo -> Rotação à direita
                    parent.isRed = false;
                    grandparent.isRed = true;
                    rotateRight(grandparent);
                }
            } else {
                Node uncle = grandparent.left;

                // Simétrico ao caso anterior
                if (uncle != null && uncle.isRed) {
                    parent.isRed = false;
                    uncle.isRed = false;
                    grandparent.isRed = true;
                    node = grandparent;
                } else {
                    if (node == parent.left) {
                        node = parent;
                        rotateRight(node);
                    }
                    parent.isRed = false;
                    grandparent.isRed = true;
                    rotateLeft(grandparent);
                }
            }
        }
        root.isRed = false; // A raiz deve ser sempre preta
    }


    // Rotação à esquerda
    private void rotateLeft(Node node) {
        Node rightChild = node.right;
        node.right = rightChild.left;

        if (rightChild.left != null) {
            rightChild.left.parent = node;
        }
        rightChild.parent = node.parent;

        if (node.parent == null) {
            root = rightChild;
        } else if (node == node.parent.left) {
            node.parent.left = rightChild;
        } else {
            node.parent.right = rightChild;
        }
        rightChild.left = node;
        node.parent = rightChild;
        rotationsLeft++;
    }

    // Rotação à direita
    private void rotateRight(Node node) {
        Node leftChild = node.left;
        node.left = leftChild.right;

        if (leftChild.right != null) {
            leftChild.right.parent = node;
        }
        leftChild.parent = node.parent;

        if (node.parent == null) {
            root = leftChild;
        } else if (node == node.parent.right) {
            node.parent.right = leftChild;
        } else {
            node.parent.left = leftChild;
        }
        leftChild.right = node;
        node.parent = leftChild;
        rotationsRight++;
    }

    // Exibe a árvore (em ordem)
    public void printTree() {
        printInOrder(root);
    }

    private void printInOrder(Node node) {
        if (node != null) {
            printInOrder(node.left);
            System.out.print((node.isRed ? "R" : "B") + node.key + " ");
            printInOrder(node.right);
        }
    }
    public int height(Node node) {
        if (node == null) {
            return -1; // Retorna -1 porque uma árvore vazia tem altura -1
        }
        int leftHeight = height(node.left);
        int rightHeight = height(node.right);

        // A altura é o maior caminho entre os subárvores esquerda e direita, mais 1
        return Math.max(leftHeight, rightHeight) + 1;
    }

    // Método público de busca
    public boolean search(int key) {
        return searchRecursive(root, key);
    }

    // Método auxiliar recursivo para busca
    private boolean searchRecursive(Node current, int key) {
        if (current == null) {
            return false; // Não encontrou a chave
        }

        if (key == current.key) {
            return true; // Chave encontrada
        } else if (key < current.key) {
            return searchRecursive(current.left, key); // Busca na subárvore esquerda
        } else {
            return searchRecursive(current.right, key); // Busca na subárvore direita
        }
    }
}
