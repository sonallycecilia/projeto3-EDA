package classes.binaria;

public class Node {
    int valor;
    Node esquerda, direita;

    Node(int valor) {
        this.valor = valor;
        esquerda = direita = null;
    }
}