package buscaemlargura;

import java.util.ArrayList;

class No {
    String nome;
    boolean jaVisitado;
    ArrayList<No> vizinhos;

    public No(String nome) {
        this.nome = nome;
        this.jaVisitado = false;
        this.vizinhos = new ArrayList<No>();
    }

    public void addVizinho(No vizinho) {
        this.vizinhos.add(vizinho);
    }

	@Override
	public String toString() {
		return nome + "";
	}
    
}