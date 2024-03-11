package Parte1;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class ServicioBFS {

	private Grafo<?> grafo;
	private HashMap<Integer, Integer> infoVertice;
	
	public ServicioBFS(Grafo<?> grafo) {
		this.grafo = grafo;
		this.infoVertice= new HashMap<Integer, Integer>();
	}
	
	// Visitado --> 1
	// No visitado --> -1
	
	public List<Integer> bfsForest(){
		List<Integer> recorrido= new ArrayList<Integer>();
		Queue<Integer> fila= new LinkedList<Integer>();
		Iterator<Integer> itVertices= this.grafo.obtenerVertices();
		while(itVertices.hasNext()) {
			Integer actual= itVertices.next();
			this.infoVertice.put(actual, -1);
		}
		itVertices= this.grafo.obtenerVertices();
		while(itVertices.hasNext()) {
			Integer actual= itVertices.next();
			if(this.infoVertice.get(actual)==-1) {
				this.bfsVisit(actual, recorrido, fila);
			}
		}
		return recorrido;
	}
	
	private void bfsVisit(Integer actual, List<Integer> recorrido, Queue<Integer> fila) {
		this.infoVertice.replace(actual, 1);
		fila.add(actual);
		while(!fila.isEmpty()) {
			Integer aux= fila.poll();
			recorrido.add(aux);
			Iterator<Integer> itAdy= this.grafo.obtenerAdyacentes(aux);
			while(itAdy.hasNext()) {
				Integer adyacente= itAdy.next();
				if(this.infoVertice.get(adyacente)== -1) {
					fila.add(adyacente);
					this.infoVertice.replace(adyacente, 1);
				}
			}
		}
	}

}
