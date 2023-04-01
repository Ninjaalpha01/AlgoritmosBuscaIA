package buscaastar;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;

public class Arvore {
    private No raiz;

    public Arvore(No raiz) {
        this.raiz = raiz;
    }

    public No getRaiz() {
        return raiz;
    }

    public void setRaiz(No raiz) {
        this.raiz = raiz;
    }

    // Adiciona um novo nó à árvore
    public void addNo(No pai, No filho) {
        pai.addVizinho(filho);
    }

    // Calcula a distância de Manhattan entre dois nós
    public int distanciaManhattan(No no1, No no2) {
        int x1 = no1.getDistanciaManhattan();
        int y1 = no1.getDistanciaManhattan();
        int x2 = no2.getDistanciaManhattan();
        int y2 = no2.getDistanciaManhattan();

        return Math.abs(x1 - x2) + Math.abs(y1 - y2);
    }

    // Implementa a busca A*
    public List<No> buscaAStar(No destino) {
        List<No> caminho = new ArrayList<No>();
        PriorityQueue<No> fronteira = new PriorityQueue<>(Comparator.comparingInt(n -> n.getDistanciaManhattan() + n.getVizinhos().size()));
        fronteira.add(raiz);

        while (!fronteira.isEmpty()) {
            No atual = fronteira.poll();
            caminho.add(atual);

            if (atual == destino) {
                return caminho;
            }

            for (No vizinho : atual.getVizinhos()) {
                int custo = atual.getDistanciaManhattan() + distanciaManhattan(atual, vizinho);
                if (!vizinho.isJaVisitado() || custo < vizinho.getDistanciaManhattan()) {
                    vizinho.setDistanciaManhattan(custo);
                    vizinho.setJaVisitado(true);
                    fronteira.add(vizinho);
                }
            }
        }

        return null;
    }

    public void printMelhorCaminho(No no) {
        if (no.getPai() != null) {
            printMelhorCaminho(no.getPai());
            System.out.print(" -> ");
        }
        System.out.print(no.getNome());
    }
}

