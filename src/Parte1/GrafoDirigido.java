package Parte1;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;

public class GrafoDirigido<T> implements Grafo<T> {

	private LinkedHashMap<Integer, ArrayList<Arco<T>>> vertices;
	
	
	// Complejidad computacional O(1) ya que solo crea una LinkedHashMap
	public GrafoDirigido() {
		vertices= new LinkedHashMap<>();
	}
	
	
	// Complejidad computacional O(1). Dicho metodo corrobora primero que no exista el vertice que queremos ingresar,
	// si no existe, lo crea en el Array de vertices.
	@Override
	public void agregarVertice(int verticeId) {
		if(!vertices.containsKey(verticeId)) {
			this.vertices.put(verticeId, new ArrayList<Arco<T>>());
		}
	}


	// Complejidad computacional O(n) donde n representa la cantidad arcos que se recorren de la lista total de vertices
	@Override
	public void borrarVertice(int verticeId) {
	    if (this.contieneVertice(verticeId)) {
	        // Elimina los arcos donde el vértice es el destino
	        for (ArrayList<Arco<T>> listaArcos : vertices.values()) {
	            listaArcos.removeIf(arco -> arco.getVerticeDestino() == verticeId);
	        }
	        vertices.remove(verticeId);
	    }
	}
	

	// Complejidad computacional O(n) donde n representa la cantidad de arcos que se recorren del Array de arcos asociados al vertice 
	// origen para corroborar si existe el arco entre los dos vertices que paso por parametro. De no existir, lo creo.
	@Override
	public void agregarArco(int verticeId1, int verticeId2, T etiqueta) {
		if(this.contieneVertice(verticeId1) && this.contieneVertice(verticeId1)) {
			if(!this.existeArco(verticeId1, verticeId2)) {
				Arco<T> nuevo= new Arco<T>(verticeId1, verticeId2, etiqueta);
				ArrayList<Arco<T>> listaArcos= vertices.get(verticeId1);
				listaArcos.add(nuevo);
			}
		}
	}
	

	// Complejidad computacional O(n) donde n representa la cantidad total de arcos asociados al vertice origen pasado por parametro, 
	// debera recorrer dicha estructura hasta encontrar el arco que corresponde al vertice origen y vertice destino.
	@Override
	public void borrarArco(int verticeId1, int verticeId2) {
		ArrayList<Arco<T>> arcos= vertices.get(verticeId1);
		if(arcos!=null) {
			int indiceArco=-1;
			for(int i=0; i<arcos.size();i++) {
				if(arcos.get(i).getVerticeDestino()==verticeId2) {
					indiceArco= i;
					break;
				}
			}
			if(indiceArco!=-1) {
				arcos.remove(indiceArco);
			}
		}
	}
	

	// Complejidad computacional O(1), ya que el metodo "containsKey" retorna si existe o no dicho vertice en el HashMap
	@Override
	public boolean contieneVertice(int verticeId) {
		boolean existe= false;
		if(vertices.containsKey(verticeId)) {
			existe= true;
		}
		return existe;
	}
	

	// Complejidad computacional O(n) ya que el for debe consultar uno a uno los arcos asociados al primer vertice pasado por parametro
	// que representa el vertice origen, hasta encontrar el arco correspondiente a dicho vertice y el vertice destino.
	@Override
	public boolean existeArco(int verticeId1, int verticeId2) {
		ArrayList<Arco<T>> arcos= vertices.get(verticeId1);
		if(arcos!=null) {
			for(Arco<T> arco : arcos) {
				if(arco.getVerticeOrigen()==verticeId1 && arco.getVerticeDestino()==verticeId2) {
					return true;
				}
			}
			return false;
		}
		return false;
	}
	

	// Complejidad computacional O(1), ya que el metodo size() siempre se mantiene actualizado
	@Override
	public int cantidadVertices() {
		return this.vertices.size();
	}
	

	// Complejidad computacional O(n) donde n representa la cantidad total de vertices, a medida que recorre cada uno, incrementa cantidad.
	@Override
	public int cantidadArcos() {
		int cantidad = 0;
		for (ArrayList<Arco<T>> adyacentes : vertices.values()) {
	        cantidad+= adyacentes.size();
	    }
		return cantidad;
	}
	

	// Complejidad computacional O(1) donde se crea un Array de los vertices totales, y se crea un iterador de dicho Array
	@Override
	public Iterator<Integer> obtenerVertices() {
	    ArrayList<Integer> listaVertices = new ArrayList<>(this.vertices.keySet());
	    Iterator<Integer> iter = listaVertices.iterator();
	    return iter;
	}
	

	// Complejidad computacional O(n) donde n representa la cantidad de adyacentes del vertice
	@Override
	public Iterator<Integer> obtenerAdyacentes(int verticeId) {
		ArrayList<Arco<T>> arcos= vertices.get(verticeId);
		if(arcos!=null) {
			ArrayList<Integer> adyacentes= new ArrayList<>();
			for(Arco<T> arco : arcos) {
				adyacentes.add(arco.getVerticeDestino());
			}
		    return adyacentes.iterator();
		}
		return null;
	}
	
	
	// Complejidad computacional 0(n) idem al caso anterior "existeArco()", de existir dicho arco, lo crea con sus respectivos valores y devuelve.
	@Override
	public Arco<T> obtenerArco(int verticeId1, int verticeId2) {
		ArrayList<Arco<T>> arcos= vertices.get(verticeId1);
		if(arcos!=null) {
			for(int i=0; i<arcos.size(); i++) {
				if((arcos.get(i).getVerticeOrigen()==verticeId1)&&(arcos.get(i).getVerticeDestino()==verticeId2)) {
					Arco<T> arco= new Arco<T>(verticeId1, verticeId2, null);
					return arco;
				}
			}
		}
		return null;
	}
	
	
	// Complejidad computacional O(n+a) donde n representa la cantidad de vertices y a la cantidad de arcos de cada vertice 
	@Override
	public Iterator<Arco<T>> obtenerArcos() {
		ArrayList<Arco<T>> arcos= new ArrayList<>();
		for(ArrayList<Arco<T>> listaArcos : this.vertices.values()) {
			arcos.addAll(listaArcos);
		}
		Iterator<Arco<T>> iter= arcos.iterator();
		return iter;
	}


	// Complejidad computacional O(n) donde n representa la cantidad de arcos del vertice dado
	@Override
	public Iterator<Arco<T>> obtenerArcos(int verticeId) {
		ArrayList<Arco<T>> arcos= vertices.get(verticeId);
		if(arcos!=null) {
			Iterator<Arco<T>> iter= arcos.iterator();
			return iter;
		}
		return null;
	}
	
}
