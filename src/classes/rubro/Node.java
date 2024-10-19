package classes.rubro;

class Node {
    int key;
    Node left, right, parent;
    boolean isRed;

    public Node(int key) {
        this.key = key;
        this.left = this.right = this.parent = null;
        this.isRed = true; // Novos nós são sempre vermelhos por padrão
    }
}
