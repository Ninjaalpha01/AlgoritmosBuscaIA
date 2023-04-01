package buscaemlargura;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;
import java.util.Stack;


public class BuscaEmLargura {
    public void buscaLargura(No inicio, No fim) {
        Queue<No> fila = new LinkedList<No>();
        Map<No, No> caminho = new HashMap<No, No>(); // Serve para gerar o caminho final, mapeando por onde passou cada nó

        fila.add(inicio);
        inicio.jaVisitado = true;

        while (!fila.isEmpty()) {
            No atual = fila.remove();
            if (atual == fim) {
                // Encontrou o fim, imprime o caminho
                ArrayList<No> caminhoFinal = new ArrayList<No>();
                caminhoFinal.add(atual);
                while (caminho.containsKey(atual)) {
                    atual = caminho.get(atual);
                    caminhoFinal.add(atual);
                }
                Collections.reverse(caminhoFinal);
                System.out.println("Caminho encontrado: " + caminhoFinal);
                System.out.println("Custo do caminho final encontrado: " + (caminhoFinal.size() - 1));
                System.out.println("Custo de todo o percurso feito pelo algoritmo: " + caminho.size());
                return;
            }
            
            for (No vizinho : atual.vizinhos) {
                if (!vizinho.jaVisitado) {
                    fila.add(vizinho);
                    vizinho.jaVisitado = true;
                    caminho.put(vizinho, atual);
                }
            }
        }
        System.out.println("Não foi possível encontrar um caminho entre " + inicio.nome + " e " + fim.nome);
    }
    
    public void buscaEmProfundidade(No inicio, No destino) {
        Stack<No> pilha = new Stack<>();
        pilha.push(inicio);
        
        System.out.print("Caminho percorrido pela busca em profundidade: ");

        while (!pilha.isEmpty()) {
            No atual = pilha.pop();

            if (!atual.jaVisitado) {
                System.out.print(atual.nome + " ");
                atual.jaVisitado=true;

                if (atual == destino) {
                    break;
                }

                for (No vizinho : atual.vizinhos) {
                    if (!vizinho.jaVisitado) {
                        pilha.push(vizinho);
                    }
                }
            }
        }
    }
    
}