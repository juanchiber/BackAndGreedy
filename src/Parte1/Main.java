package Parte1;

public class Main {
	public static <T> void main (String[]args) {
		GrafoDirigido<T> grafo= new GrafoDirigido<T>();
	
		grafo.agregarVertice(10);
		grafo.agregarVertice(1);
		grafo.agregarVertice(2);
		grafo.agregarVertice(3);
		grafo.agregarVertice(4);
		grafo.agregarVertice(5);
		grafo.agregarVertice(6);
		grafo.agregarVertice(7);
		grafo.agregarVertice(20);
		grafo.agregarVertice(15);
		grafo.agregarVertice(21);
		grafo.agregarVertice(14);
		grafo.agregarVertice(16);
		grafo.agregarVertice(22);
		//grafo.agregarVertice(100);
		
		grafo.agregarArco(10, 5, null);
		grafo.agregarArco(10, 20, null);
		grafo.agregarArco(5, 4, null);
		grafo.agregarArco(5, 6, null);
		grafo.agregarArco(20, 15, null);
		grafo.agregarArco(20, 21, null);
		grafo.agregarArco(4, 2, null);
		grafo.agregarArco(6, 7, null);
		grafo.agregarArco(15, 14, null);
		grafo.agregarArco(15, 16, null);
		grafo.agregarArco(21, 22, null);
		grafo.agregarArco(2, 1, null);
		grafo.agregarArco(2, 3, null);
		grafo.agregarArco(3, 1, null);
		grafo.agregarArco(14, 1, null);
		grafo.agregarArco(3, 5, null);
		grafo.agregarArco(5, 1, null);
		grafo.agregarArco(22, 7, null);
		grafo.agregarArco(7, 1, null);
		
		System.out.println(grafo.obtenerArco(10, 5));
		
		//grafo.agregarArco(100, 2, null);
		
		//grafo.imprimirAdyacentes(100);
		//grafo.obtenerArco(100, 2);
		//grafo.borrarVertice(100);
		//grafo.obtenerArco(100, 2);
		
		/*
		grafo.imprimirVertices();
		System.out.println("---------");
		grafo.imprimirAdyacentes(10);
		System.out.println("---------");
		grafo.obtenerArco(10, 5);
		System.out.println("---------");
		grafo.obtenerArcos();
		System.out.println("---------");
		grafo.obtenerArcos(5);
		System.out.println("---------");
		 */
		
		ServicioDFS dfs= new ServicioDFS(grafo);
		ServicioBFS bfs= new ServicioBFS(grafo);
		ServicioCaminos caminos= new ServicioCaminos(grafo, 10, 1, 5);	
	
		//System.out.println(dfs.dfsForest());
		//System.out.println("---------");
		System.out.println(bfs.bfsForest());
		//System.out.println("---------");
		///System.out.println(caminos.caminos());
	
	}

}
