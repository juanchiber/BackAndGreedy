package Backtracking;

import java.util.ArrayList;

public class GrafoNoDirigido<T> extends GrafoDirigido<T> {

	public GrafoNoDirigido(ArrayList<String> vertices, ArrayList<Arco<Integer>> arcos) {
		for(String v: vertices) {
			this.agregarVertice(v);
		}
		for(Arco<Integer> a:arcos) {
			this.agregarArco(a.getVerticeOrigen(), a.getVerticeDestino(), (T) a.getDistancia());
		}
	}
	
	@Override
	public void agregarArco(String verticeId1, String verticeId2, T distancia) {
		super.agregarArco(verticeId1, verticeId2, distancia);
		super.agregarArco(verticeId2, verticeId1, distancia);
	}
	
	@Override
	public void borrarArco(String verticeId1, String verticeId2) {
		super.borrarArco(verticeId1, verticeId2);
		super.borrarArco(verticeId2, verticeId1);
	}
	
	@Override
	public int cantidadArcos() {
		return super.cantidadArcos() / 2;
	}

}