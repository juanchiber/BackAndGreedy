package Greedy;

import java.util.ArrayList;
import Backtracking.Arco;

public class Greedy {
    ArrayList<Arco<Integer>> solucion;
    Integer metrica;
    Integer suma;

    public Greedy(){
        this.solucion = new ArrayList<Arco<Integer>>();
    }
    
    public ArrayList<Arco<Integer>> solucionGreedy(ArrayList<String[]> datos) {
        this.solucion.clear();
        this.suma = 0;
        ArrayList<Arco<Integer>> arcos = new ArrayList<Arco<Integer>>();
        ArrayList<String> vertices = new ArrayList<String>();
        for (String [] fila : datos){
        	// Como no trabajamos con grafos, creamos tanto los arcos de ida como de vuelta, asimilando un grafo no dirigido
            Arco<Integer> auxIda = new Arco(fila[0], fila[1],Integer.parseInt(fila[2]));
            Arco<Integer> auxVuelta = new Arco(fila[1], fila[0],Integer.parseInt(fila[2]));
            if (!arcos.contains(auxIda)){
                arcos.add(auxIda);
            }
            if (!arcos.contains(auxVuelta)){
                arcos.add(auxVuelta);
            }
            if (!vertices.contains(fila[0])){
                vertices.add(fila[0]);
            }
            if (!vertices.contains(fila[1])){
                vertices.add(fila[1]);
            }
        }
        this.greedy(arcos, vertices);
        return this.solucion;
    }

    private void greedy(ArrayList<Arco<Integer>> arcos, ArrayList<String> vertices) {
        ArrayList<String> verticesParciales = new ArrayList<String>();
        Arco<Integer> a = this.seleccionar(verticesParciales, arcos);
        if(a == null){
            System.out.println("No hay solucion.");
            return;
        }
        arcos.remove(a);
        solucion.add(a);
        this.metrica= 1;	// La inicializo en 1 ya que agrego el primer arco a la solucion
        this.suma += a.getDistancia();
        verticesParciales.add(a.getVerticeOrigen());
        verticesParciales.add(a.getVerticeDestino());
        while(!(esSolucion(vertices, verticesParciales)) && !(arcos.isEmpty())){
            this.metrica++;
            a = this.seleccionar(verticesParciales, arcos);
            if(a == null){
                System.out.println("No hay solucion.");
                return;
            }
            arcos.remove(a);
            if(esFactible(a, verticesParciales)){
            	//this.metrica++;
                if(!verticesParciales.contains(a.getVerticeOrigen())){
                    verticesParciales.add(a.getVerticeOrigen());
                }
                if(!verticesParciales.contains(a.getVerticeDestino())){
                    verticesParciales.add(a.getVerticeDestino());
                }
                this.solucion.add(a);
                this.suma += a.getDistancia();
            }
        }
        if(!esSolucion(vertices, verticesParciales)){
            System.out.println("No hay solucion.");
        }
    }
    
    
    private boolean esFactible(Arco<Integer> a, ArrayList<String> verticesParciales) {
        for(String v: verticesParciales){
            if(a.getVerticeDestino().equals(v)){
                return false;
            }
        }
        return true;
    }
    
    
    private boolean esSolucion(ArrayList<String> vertices, ArrayList<String> verticesParciales) {
        return verticesParciales.size() == vertices.size();
    }
    
    
    private Arco<Integer> seleccionar(ArrayList<String> verticesParciales ,ArrayList<Arco<Integer>> arcos){
        Arco<Integer> arco = null;
        if(verticesParciales.isEmpty()){
            arco = arcos.get(0);
            for(Arco<Integer> aux : arcos){
                if(arco.getDistancia() > aux.getDistancia()){
                    arco = aux;
                }
            }
        }
        else{
            for(Arco<Integer> aux: arcos){
                if(this.contieneVerticeEnOrigen(aux, verticesParciales)){
                    arco = aux;
                }
            }
            if(arco == null){
                return null;
            }
            for(Arco<Integer> aux : arcos){
                if(this.contieneVerticeEnOrigen(aux, verticesParciales)){
                    if(arco.getDistancia() > aux.getDistancia()){
                        arco = aux;
                    }
                }
            }
        }
        return arco;
    }
    
    
    private boolean contieneVerticeEnOrigen(Arco<Integer> aux, ArrayList<String> verticesParciales) {
        for(String v: verticesParciales){
            if(aux.getVerticeOrigen().equals(v)){
                return true;
            }
        }
        return false;
    }

    
    public Integer getMetrica() {
        return this.metrica;
    }

    
    public Integer getSuma() {
        return this.suma;
    }
}
