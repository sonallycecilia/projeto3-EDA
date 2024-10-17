import classes.binaria.ArvoreBinaria;

import java.io.*;
import java.util.*;

public class Main {
    public static final String DATABASE_PATH = "C:\\Users\\sonal\\IdeaProjects\\projetoEDA3\\src\\database\\";

    public static void main(String[] args) {

        /* GERANDO ARQUIVOS DA DATABASE
        gerarDadosAleatorios(1000000, "desordenados_1000000");
        gerarDadosOrdenados(1000000, "ordenados_1000000", false);
        gerarDadosOrdenados(1000000, "ordenados50finais_1000000", true);

        gerarDadosAleatorios(2000000, "desordenados_2000000");
        gerarDadosOrdenados(2000000, "ordenados_2000000", false);
        gerarDadosOrdenados(2000000, "ordenados50finais_2000000", true);

        gerarDadosAleatorios(3000000, "desordenados_3000000");
        gerarDadosOrdenados(3000000, "ordenados_3000000", false);
        gerarDadosOrdenados(3000000, "ordenados50finais_3000000", true);
        */

        int[] numeros = lerArquivo("desordenados_1000000", 1000000);
        ArvoreBinaria tree = new ArvoreBinaria();
        for (int i = 0; i < numeros.length; i++){
            tree.inserir(numeros[i]);
        }

        System.out.printf("Altura total da Arvore Binaria: %d\n", tree.alturaTotal());
    }

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
}

