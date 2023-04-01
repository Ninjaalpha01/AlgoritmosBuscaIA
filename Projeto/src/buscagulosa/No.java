package buscagulosa;

import java.util.*;

public class No {
    private String nome;
    private boolean jaVisitado;
    public List<No> vizinhos;
    private int distanciaManhattan; // Distância de Manhattan até o destino

    public No(String nome) {
        this.nome = nome;
        this.jaVisitado = false;
        this.vizinhos = new ArrayList<>();
        this.distanciaManhattan = 0;
    }

    public String getNome() {
        return nome;
    }

    public boolean isJaVisitado() {
        return jaVisitado;
    }

    public void setJaVisitado(boolean jaVisitado) {
        this.jaVisitado = jaVisitado;
    }

    public List<No> getVizinhos() {
        return vizinhos;
    }

    public void addVizinho(No vizinho) {
        this.vizinhos.add(vizinho);
    }

    public int getDistanciaManhattan() {
        return distanciaManhattan;
    }

    public void setDistanciaManhattan(int distanciaManhattan) {
        this.distanciaManhattan = distanciaManhattan;
    }

    public int calculaDistanciaManhattan(No destino) {
        System.out.println("Calculando distância de Manhattan de " + this.nome + " até " + destino.nome);
        System.out.println("Distância X: " + Math.abs(destino.getCoordenadaX(destino.nome)) + " - "
                + this.getCoordenadaX(this.nome)
                + " = " + Math.abs(destino.getCoordenadaX(destino.nome) - this.getCoordenadaX(this.nome)));

        System.out.println("Distância Y: " + Math.abs(destino.getCoordenadaY(destino.nome)) + " - "
                + this.getCoordenadaY(this.nome)
                + " = " + Math.abs(destino.getCoordenadaY(destino.nome) - this.getCoordenadaY(this.nome)));

        int distanciaX = Math.abs(destino.getCoordenadaX(destino.nome) - this.getCoordenadaX(this.nome));
        int distanciaY = Math.abs(destino.getCoordenadaY(destino.nome) - this.getCoordenadaY(this.nome));
        return distanciaX + distanciaY;
    }

    public int getCoordenadaX(String nome) {
        return Integer.parseInt(nome.substring(1, 2));
    }

    public int getCoordenadaY(String nome) {
        return Integer.parseInt(nome.substring(2, 3));
    }

    public boolean buscaGulosa(No destino, List<No> caminho) {
        // if (caminho.size() != 0)
        // System.out.print("[");
        // for (No no : caminho)
        // System.out.print(no.nome + ", ");
        // if (caminho.size() != 0)
        // System.out.println("\b\b]");

        caminho.add(this);
        this.setJaVisitado(true);

        if (this == destino) {
            return true;
        }

        PriorityQueue<No> fronteira = new PriorityQueue<>(Comparator.comparingInt(No::getDistanciaManhattan));
        for (No vizinho : this.getVizinhos()) {
            System.out.println("No: " + this.getNome());
            if (!vizinho.isJaVisitado()) {
                System.out.println("===========================================");
                System.out.println("\tVizinho: " + vizinho.getNome() + " - Distância de Manhattan: "
                        + vizinho.calculaDistanciaManhattan(destino));
                vizinho.setDistanciaManhattan(vizinho.calculaDistanciaManhattan(destino));
                System.out.println("===========================================");
                fronteira.add(vizinho);
            }
        }

        while (!fronteira.isEmpty()) {
            No proximo = fronteira.poll();
            if (proximo.buscaGulosa(destino, caminho)) {
                return true;
            } else {
                caminho.remove(proximo); // remove último nó adicionado
            }
        }

        return false;
    }

    public void mostrarCaminho(List<No> caminho) {
        System.out.println("\u001B[35m");
        StringBuilder builder = new StringBuilder();
        builder.append("Caminho percorrido: ");
        for (int i = 0; i < caminho.size(); i++) {
            builder.append(caminho.get(i).getNome());
            if (i < caminho.size() - 1) {
                builder.append(" -> ");
            }
        }
        System.out.println(builder.toString());
        System.out.println("\u001B[0m");
    }

}