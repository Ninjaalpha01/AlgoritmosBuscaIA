package buscaemlargura;

import java.util.Collections;

public class Teste {
	
	public static void main(String[] args) {
		
		BuscaEmLargura busca = new BuscaEmLargura();

		No a11 = new No("a11");
		No a12 = new No("a12");
        No b21 = new No("b21");
        No b31 = new No("b31");
        No c22 = new No("c22");
        No c32 = new No("c32");
        No d41 = new No("d41");
        No d42 = new No("d42");
        No e51 = new No("e51");
        No e52 = new No("e52");
        No e61 = new No("e61");
        No e62 = new No("e62");
        No f71 = new No("f71");
        No f72 = new No("f72");
        
        Collections.addAll(a11.vizinhos, a12);
        Collections.addAll(a12.vizinhos, a11, c22);
        Collections.addAll(b21.vizinhos, b31, c22);
        Collections.addAll(b31.vizinhos, b21, c32, d41);
        Collections.addAll(c22.vizinhos, b21, c32, a12); // g23
        Collections.addAll(c32.vizinhos, c22, b31);
        Collections.addAll(d41.vizinhos, b31, d42, e51);
        Collections.addAll(d42.vizinhos, d41, e52);
        Collections.addAll(e51.vizinhos, d41, e52, e61);
        Collections.addAll(e52.vizinhos, e51, d42, e62);
        Collections.addAll(e61.vizinhos, e51, e62, f71);
        Collections.addAll(e62.vizinhos, e61, e52, f72);
        Collections.addAll(f71.vizinhos, f72, e61);
        Collections.addAll(f72.vizinhos, f71, e62); // j73

        System.out.println("Busca em largura:");
        busca.buscaLargura(a11, b21);
        
        a11 = new No("a11");
		a12 = new No("a12");
		b21 = new No("b21");
        b31 = new No("b31");
        c22 = new No("c22");
        c32 = new No("c32");
        d41 = new No("d41");
        d42 = new No("d42");
        e51 = new No("e51");
        e52 = new No("e52");
        e61 = new No("e61");
        e62 = new No("e62");
        f71 = new No("f71");
        f72 = new No("f72");
        
        Collections.addAll(a11.vizinhos, a12);
        Collections.addAll(a12.vizinhos, a11, c22);
        Collections.addAll(b21.vizinhos, b31, c22);
        Collections.addAll(b31.vizinhos, b21, c32, d41);
        Collections.addAll(c22.vizinhos, b21, c32, a12); // g23
        Collections.addAll(c32.vizinhos, c22, b31);
        Collections.addAll(d41.vizinhos, b31, d42, e51);
        Collections.addAll(d42.vizinhos, d41, e52);
        Collections.addAll(e51.vizinhos, d41, e52, e61);
        Collections.addAll(e52.vizinhos, e51, d42, e62);
        Collections.addAll(e61.vizinhos, e51, e62, f71);
        Collections.addAll(e62.vizinhos, e61, e52, f72);
        Collections.addAll(f71.vizinhos, f72, e61);
        Collections.addAll(f72.vizinhos, f71, e62); // j73
        
        System.out.println("\nBusca em Profundidade:");
        busca.buscaEmProfundidade(a11, f72);
		
	}
	
}
