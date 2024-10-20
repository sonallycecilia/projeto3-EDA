import classes.balanceada.ArvoreBalanceada;
import classes.binaria.ArvoreBinaria;
import classes.rubro.ArvoreRubro;
import classes.splay.ArvoreSplay;

import java.io.*;
import java.util.*;

public class Main {
    public static final String DATABASE_PATH = "C:\\Users\\sonal\\IdeaProjects\\projetoEDA3\\src\\database\\";

    public static void main(String[] args) {

        /*
        //GERANDO ARQUIVOS DB
        gerarDadosAleatorios(1000000, "desordenados_1000000");
        gerarDadosOrdenados(1000000, "ordenados_1000000", false);
        gerarDadosOrdenados(1000000, "ordenados50finais_1000000", true);

        gerarDadosAleatorios(2000000, "desordenados_2000000");
        gerarDadosOrdenados(2000000, "ordenados_2000000", false);
        gerarDadosOrdenados(2000000, "ordenados50finais_2000000", true);

        gerarDadosAleatorios(3000000, "desordenados_3000000");
        gerarDadosOrdenados(3000000, "ordenados_3000000", false);
        gerarDadosOrdenados(3000000, "ordenados50finais_3000000", true);

        gerarDadosRepetidos(1000000, "repetidos_1000000");
        */

        /*
        //BINARIA
        ArvoreBinaria tree;
        int[] numeros;

        numeros = lerArquivo("ordenados_1000000", 1000);
        tree = new ArvoreBinaria();
        for (int i = 0; i < numeros.length; i++){ tree.insert(numeros[i]); }
        System.out.printf("Altura total: %d\n\n", tree.height(tree.getRoot()));
        numeros = null;
        tree = null;

        tree = new ArvoreBinaria();
        numeros = lerArquivo("ordenados_2000000", 2000);
        for (int i = 0; i < numeros.length; i++){ tree.insert(numeros[i]); }
        System.out.printf("Altura total: %d\n\n", tree.height(tree.getRoot()));
        numeros = null;
        tree = null;

        tree = new ArvoreBinaria();
        numeros = lerArquivo("desordenados_3000000", 3000000);
        for (int i = 0; i < numeros.length; i++){ tree.insert(numeros[i]); }
        System.out.printf("Altura total: %d\n\n", tree.height(tree.getRoot()));
        numeros = null;

        int[] numerosBusca = lerArquivo("busca_1000000", 10000000);
        int achados = 0;
        for (int i = 0; i < numerosBusca.length; i++){
            if(tree.buscar(numerosBusca[i])) { achados++; }
        }
        System.out.printf("Achados: %d\n", achados);
        */

        /*
        //BALANCEADA
        ArvoreBalanceada tree;
        int[] numeros;
        tree = new ArvoreBalanceada();
        numeros = lerArquivo("ordenados50finais_1000000", 1000000);
        for (int i = 0; i < numeros.length; i++){ tree.insert(numeros[i]); }
        System.out.printf("Altura total: %d\n" +
                        "Rotacoes direita: %d\n" +
                        "Rotacoes esquerda: %d\n\n",
                        tree.height(tree.getRoot()), tree.getRotationsRight(), tree.getRotationsLeft());
        numeros = null;
        tree = null;

        tree = new ArvoreBalanceada();
        numeros = lerArquivo("ordenados50finais_2000000", 2000000);
        for (int i = 0; i < numeros.length; i++){ tree.insert(numeros[i]); }
        System.out.printf("Altura total: %d\n" +
                        "Rotacoes direita: %d\n" +
                        "Rotacoes esquerda: %d\n\n",
                tree.height(tree.getRoot()), tree.getRotationsRight(), tree.getRotationsLeft());
        numeros = null;
        tree = null;

        tree = new ArvoreBalanceada();
        numeros = lerArquivo("desordenados_3000000", 3000000);
        for (int i = 0; i < numeros.length; i++){ tree.insert(numeros[i]); }
        System.out.printf("Altura total: %d\n" +
                        "Rotacoes direita: %d\n" +
                        "Rotacoes esquerda: %d\n\n",
                tree.height(tree.getRoot()), tree.getRotationsRight(), tree.getRotationsLeft());
        numeros = null;

        int[] numerosBusca = lerArquivo("busca_1000000", 10000000);
        int achados = 0;
        for (int i = 0; i < numerosBusca.length; i++){
            if(tree.search(numerosBusca[i])) { achados++; }
        }
        System.out.printf("Achados: %d\n", achados);
         */


        /*
        //SPLAY
        ArvoreSplay tree;
        int[] numeros;

        tree = new ArvoreSplay();
        numeros = lerArquivo("ordenados_1000000", 1000);
        for (int i = 0; i < numeros.length; i++){ tree.insert(numeros[i]); }
        System.out.printf("Altura total: %d\n" +
                        "Rotacoes direita: %d\n" +
                        "Rotacoes esquerda: %d\n\n",
                tree.height(tree.getRoot()), tree.getRotationsRight(), tree.getRotationsLeft());
        numeros = null;
        tree = null;

        tree = new ArvoreSplay();
        numeros = lerArquivo("ordenados_ 2000000", 2000);
        for (int i = 0; i < numeros.length; i++){ tree.insert(numeros[i]); }
        System.out.printf("Altura total: %d\n" +
                        "Rotacoes direita: %d\n" +
                        "Rotacoes esquerda: %d\n\n",
                tree.height(tree.getRoot()), tree.getRotationsRight(), tree.getRotationsLeft());
        numeros = null;
        tree = null;

        tree = new ArvoreSplay();
        numeros = lerArquivo("desordenados_3000000", 3000000);
        for (int i = 0; i < numeros.length; i++){ tree.insert(numeros[i]); }
        System.out.printf("Altura total: %d\n" +
                        "Rotacoes direita: %d\n" +
                        "Rotacoes esquerda: %d\n\n",
                tree.height(tree.getRoot()), tree.getRotationsRight(), tree.getRotationsLeft());
        numeros = null;

        int[] numerosBusca = lerArquivo("busca_1000000", 10000000);
        int achados = 0;
        for (int i = 0; i < numerosBusca.length; i++){
            if(tree.search(numerosBusca[i])) { achados++; }
        }
        System.out.printf("Achados: %d\n", achados);
         */

        //RUBRO
        ArvoreRubro tree;
        int[] numeros;

        /*
        tree = new ArvoreRubro();
        numeros = lerArquivo("ordenados50finais1561_1000000", 1000000);
        for (int i = 0; i < numeros.length; i++){ tree.insert(numeros[i]); }
        System.out.printf("Altura total: %d\n" +
                        "Rotacoes direita: %d\n" +
                        "Rotacoes esquerda: %d\n\n",
                tree.height(tree.getRoot()), tree.getRotationsRight(), tree.getRotationsLeft());
        numeros = null;
        tree = null;

        tree = new ArvoreRubro();
        numeros = lerArquivo("ordenados50finais_2000000", 2000000);
        for (int i = 0; i < numeros.length; i++){ tree.insert(numeros[i]); }
        System.out.printf("Altura total: %d\n" +
                        "Rotacoes direita: %d\n" +
                        "Rotacoes esquerda: %d\n\n",
                tree.height(tree.getRoot()), tree.getRotationsRight(), tree.getRotationsLeft());
        numeros = null;
        tree = null;
         */

        tree = new ArvoreRubro();
        numeros = lerArquivo("desordenados_3000000", 3000000);
        for (int i = 0; i < numeros.length; i++){ tree.insert(numeros[i]); }
        System.out.printf("Altura total: %d\n" +
                        "Rotacoes direita: %d\n" +
                        "Rotacoes esquerda: %d\n\n",
                tree.height(tree.getRoot()), tree.getRotationsRight(), tree.getRotationsLeft());
        numeros = null;

        int[] numerosBusca = lerArquivo("busca_1000000", 10000000);
        int achados = 0;
        for (int i = 0; i < numerosBusca.length; i++){
            if(tree.search(numerosBusca[i])) { achados++; }
        }
        System.out.printf("Achados: %d\n", achados);

    }

    //métodos do main
    public static int[] lerArquivo(String nome, int qtd) {
        String path = DATABASE_PATH + File.separator + nome + ".txt";
        int[] data = new int[qtd];

        try (BufferedReader arquivo = new BufferedReader(new FileReader(path))) {
            String number;
            int i = 0;
            while ((number = arquivo.readLine()) != null && i < qtd) {
                data[i] = Integer.parseInt(number.trim());
                i++;
            }
        } catch (IOException e) {
            System.out.println("Erro ao extrair informações");
            e.printStackTrace();
        } catch (NumberFormatException e) {
            System.out.println("Erro ao converter número: " + e.getMessage());
            e.printStackTrace();
        }
        return data;
    }

    public static void gerarDadosAleatorios(int qtdElementos, String nome){
        String path = DATABASE_PATH + nome + ".txt";
        Set<Integer> numeros = new HashSet<>();
        Random random = new Random();

        while (numeros.size() < qtdElementos) {
            int numero = random.nextInt();
            numeros.add(numero);
        }
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(path))) {
            for (int numero : numeros) {
                writer.write(numero + "\n");
            }
            System.out.println("Arquivo gerado com sucesso em: " + path);
        } catch (IOException e) {
            System.err.println("Erro ao gravar o arquivo: " + e.getMessage());
        }
    }

    public static void gerarDadosOrdenados(int qtdElementos, String nome, boolean metade) {
        String path = DATABASE_PATH + nome + ".txt";
        Set<Integer> numeros = new HashSet<>();
        Random random = new Random();
        int qtdMetade = qtdElementos / 2;

        while (numeros.size() < qtdElementos) {
            int numero = random.nextInt();
            numeros.add(numero);
        }

        // Converte para uma lista para manipulação
        List<Integer> listaNumeros = new ArrayList<>(numeros);

        if (metade) {
            // Embaralha a primeira metade
            List<Integer> primeiraMetade = listaNumeros.subList(0, qtdMetade);
            Collections.shuffle(primeiraMetade);

            // Ordena a segunda metade
            List<Integer> segundaMetade = listaNumeros.subList(qtdMetade, qtdElementos);
            Collections.sort(segundaMetade);
        } else{
            Collections.sort(listaNumeros);
        }

        // Grava os números no arquivo
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(path))) {
            for (int numero : listaNumeros) {
                writer.write(numero + "\n");
            }
            System.out.println("Arquivo gerado com sucesso em: " + path);
        } catch (IOException e) {
            System.err.println("Erro ao gravar o arquivo: " + e.getMessage());
        }
    }

    public static void gerarDadosRepetidos(int qtd, String nome){
        String path = DATABASE_PATH + nome + ".txt";
        List<Integer> listaNumeros = new ArrayList<>();
        Random random = new Random();
        while (listaNumeros.size() < qtd) {
            int numero = random.nextInt(500001);
            listaNumeros.add(numero);
        }

        try (BufferedWriter writer = new BufferedWriter(new FileWriter(path))) {
            for (int numero : listaNumeros) {
                writer.write(numero + "\n");
            }
            System.out.println("Arquivo gerado com sucesso em: " + path);
        } catch (IOException e) {
            System.err.println("Erro ao gravar o arquivo: " + e.getMessage());
        }
    }
}


