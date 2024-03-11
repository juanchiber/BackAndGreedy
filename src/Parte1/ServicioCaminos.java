package Parte1;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class ServicioCaminos {

	private Grafo<?> grafo;
	private int origen;
	private int destino;
	private int lim;
	
	public ServicioCaminos(Grafo<?> grafo, int origen, int destino, int lim) {
		this.grafo = grafo;
		this.origen = origen;
		this.destino = destino;
		this.lim = lim;
	}
	
	public <T> List<List<Integer>> caminos() {
		List<List<Integer>> caminosValidos= new ArrayList<>();
		List<Integer> caminoActual= new ArrayList<>();
		List<Arco<T>> arcosVisitados= new ArrayList<Arco<T>>();
		this.caminosVisit(origen, caminoActual, caminosValidos, arcosVisitados, 0);
		return caminosValidos;
	}
	
	private <T> void caminosVisit(int vertice, List<Integer> caminoActual, List<List<Integer>> caminosValidos, List<Arco<T>> arcosVisitados, int arcosRecorridos) {
		caminoActual.add(vertice);
		if(vertice==destino) {
			caminosValidos.add(new ArrayList<>(caminoActual));
		}
		if(arcosRecorridos >= lim) {
			caminoActual.remove(caminoActual.size() - 1);
			return;
		}
		if(arcosRecorridos < lim) {
			Iterator<Integer> itAdyacentes= this.grafo.obtenerAdyacentes(vertice);
			while(itAdyacentes.hasNext()) {
				int adyacente= itAdyacentes.next();
				Arco<T> nuevoArco= new Arco<T>(vertice, adyacente, null);
				if(!arcosVisitados.contains(nuevoArco)) {
					arcosVisitados.add(nuevoArco);
					this.caminosVisit(adyacente, caminoActual, caminosValidos, arcosVisitados, arcosRecorridos + 1);
					arcosVisitados.remove(nuevoArco);
				}
			}
		}
		caminoActual.remove(caminoActual.size() - 1);		// retrocede un lugar, y sigue explorando a partir del vertice anterior
	} 

}