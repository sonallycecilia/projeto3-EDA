package classes.balanceada;

class Node {
    int key;
    int height;
    Node left, right;

    Node(int key) {
        this.key = key;
        height = 1;
    }
}
