package Backtracking;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;

public class ServicioDFS {
    private Grafo grafo;
    private HashMap<String, HashMap<String, Integer>> informacionVertice;
    ArrayList<String> posibleRecorrido;

    public boolean esConexo(){
        this.DFS();
        Iterator<String> it = this.grafo.obtenerVertices();
        while(it.hasNext()){
            String vertice = it.next();
            if(informacionVertice.get(vertice).get("color") == -1){
                return false;
            }
        }
        return true;
    }

    public ServicioDFS(Grafo grafo) {
        this.grafo = grafo;
        this.informacionVertice = new HashMap<String, HashMap<String, Integer>>();
        posibleRecorrido = new ArrayList<String>();
    }

    public void DFS(){
        this.posibleRecorrido.clear();
        this.informacionVertice.clear();
        Iterator<String> iVertices = this.grafo.obtenerVertices();
        while(iVertices.hasNext()){
            HashMap<String, Integer> info = new HashMap<String, Integer>();
            info.put("color",-1);
            this.informacionVertice.put(iVertices.next(), info);
        }
        iVertices = this.grafo.obtenerVertices();
        String i = iVertices.next();
        this.DFS_visit(i);
    }

    public void DFS_visit(String vertice){
        this.posibleRecorrido.add(vertice);
        this.informacionVertice.get(vertice);
        HashMap<String, Integer> infoDeVertice = this.informacionVertice.get(vertice);
        infoDeVertice.replace("color", 0);
        Iterator<String> itAdyacentes = this.grafo.obtenerAdyacentes(vertice);
        while(itAdyacentes.hasNext()){
            String indice = itAdyacentes.next();
            HashMap<String, Integer> infoDeAdyacente = this.informacionVertice.get(indice);
            if(infoDeAdyacente.get("color") == -1){
                this.DFS_visit(indice);
            }
        }
        infoDeVertice.replace("color", 1);
    }

    
    public void funcionX(Integer i){
        System.out.print(i + " -");
    }
    
    
    public List<String> dfsForest() {
        this.DFS();
		return this.posibleRecorrido;
	}

}

