package Parte1;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;

public class ServicioDFS {

	private Grafo<?> grafo;
	private HashMap<Integer, String> infoVertice;

	public ServicioDFS(Grafo<?> grafo) {
		this.grafo = grafo;
		this.infoVertice= new HashMap<Integer, String>();
	}
	
	public String getColor(Integer vertice) {
	    return this.infoVertice.getOrDefault(vertice, "blanco");
	}
	
	// blanco= no visitado; amarillo= visitado; negro=finalizado;
	public void setColor(Integer vertice, String color) {	
	    this.infoVertice.put(vertice, color);
	}
	
	public List<Integer> dfsForest(){
		List<Integer> recorrido= new ArrayList<Integer>();
		Iterator<Integer> itVertices= this.grafo.obtenerVertices();
		while(itVertices.hasNext()) {
			Integer actual= itVertices.next();
			this.setColor(actual, "blanco");
		}
		itVertices= this.grafo.obtenerVertices();
		while(itVertices.hasNext()) {
			Integer actual= itVertices.next();
			if(this.getColor(actual)=="blanco") {
				this.dfsVisit(actual, recorrido);
			}
		}
		return recorrido;
	}
	
	private void dfsVisit (Integer vertice, List<Integer> recorrido) {
		this.setColor(vertice, "amarillo");
		recorrido.add(vertice);
		Iterator<Integer> itAdyacentes= this.grafo.obtenerAdyacentes(vertice);
		while(itAdyacentes.hasNext()) {
			Integer actual= itAdyacentes.next();
			if(this.getColor(actual)=="blanco") {
				this.dfsVisit(actual, recorrido);
			}
		}
		this.setColor(vertice, "negro");
	}
	
}