package buscaastar;

import java.util.*;

public class No {
    private String nome;
    private boolean jaVisitado;
    private No pai;
    public List<No> vizinhos;
    private int distanciaManhattan;
    private int distanciaAteInicio;
    private int estimativaDistanciaRestante;

    public No(String nome) {
        this.nome = nome;
        this.jaVisitado = false;
        this.vizinhos = new ArrayList<>();
        this.distanciaManhattan = 0;
    }

    public void setEstimativaDistanciaRestante(int estimativaDistanciaRestante) {
        this.estimativaDistanciaRestante = estimativaDistanciaRestante;
    }

    public void setDistanciaAteInicio(int distanciaAteInicio) {
        this.distanciaAteInicio = distanciaAteInicio;
    }

    public No getPai() {
        return this.pai;
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
        int distanciaX = Math.abs(destino.getX(destino.nome) - this.getX(this.nome));
        int distanciaY = Math.abs(destino.getY(destino.nome) - this.getY(this.nome));
        return distanciaX + distanciaY;
    }

    public int getX(String nome) {
        return Integer.parseInt(nome.substring(1, 2));
    }

    public int getY(String nome) {
        return Integer.parseInt(nome.substring(2, 3));
    }

    public boolean buscaAEstrela(No destino, List<No> caminho) {
        caminho.add(this);
        this.setJaVisitado(true);

        if (this == destino) {
            return true;
        }

        PriorityQueue<No> fronteira = new PriorityQueue<>(Comparator.comparingInt(No::getF));
        for (No vizinho : this.getVizinhos()) {
            if (!vizinho.isJaVisitado()) {
                vizinho.setDistanciaManhattan(vizinho.calculaDistanciaManhattan(destino));
                vizinho.setDistanciaAteInicio(this.getDistanciaAteInicio() + this.getDistanciaManhattan());
                vizinho.setEstimativaDistanciaRestante(vizinho.calculaDistanciaManhattan(destino));
                fronteira.add(vizinho);
            }
        }

        while (!fronteira.isEmpty()) {
            No proximo = fronteira.poll();
            if (proximo.buscaAEstrela(destino, caminho)) {
                return true;
            }
        }

        return false;
    }

    public int getF() {
        return this.getDistanciaAteInicio() + this.calculaDistanciaManhattan(new No("G"));
    }

    public int getDistanciaAteInicio() {
        if (this.pai == null) {
            return 0;
        }
        return this.getDistanciaAteInicio() + 1;
    }
}