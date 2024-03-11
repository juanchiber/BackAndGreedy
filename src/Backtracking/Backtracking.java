package Backtracking;

import java.util.ArrayList;

public class Backtracking {
	
	private ArrayList<Arco<Integer>> solucionIdeal;
	private Integer sumaIdeal;
	private Integer metrica;
	
	public Backtracking() {
		
		this.solucionIdeal= new ArrayList<Arco<Integer>>();
		this.sumaIdeal= Integer.MAX_VALUE;
		this.metrica= 0;
	}
	
	public ArrayList<Arco<Integer>> solucionBack(ArrayList<String[]> datos) {
		this.solucionIdeal.clear();
		Estado e = this.generarEstado(datos);
		this.backtracking(e);
		return this.solucionIdeal;
	}

	private void backtracking(Estado e) {
		this.metrica++;
		if(this.esSolucion(e)) {
			if(this.esFactible(e)){
				this.solucionIdeal= new ArrayList<Arco<Integer>>(e.getSolucionParcial());
				this.sumaIdeal= e.getSuma();	
			}
		}
		else {
			Arco<Integer> tunel= e.getPosibilidades().get(0);
			e.removeFromPosibilidades(tunel);
			e.setSuma(e.getSuma()+tunel.getDistancia());
			if(!(e.getSuma() > this.sumaIdeal)) {
				e.getSolucionParcial().add(tunel);
				this.backtracking(e);				
			}
			e.getSolucionParcial().remove(tunel);
			e.setSuma(e.getSuma() - tunel.getDistancia());
			
			this.backtracking(e);
			e.getPosibilidades().add(tunel);
		}
		
	}

	private boolean esSolucion(Estado e) {
		if(!e.getPosibilidades().isEmpty()) {
			return false;
		}
		return true;
	}

	private boolean esFactible(Estado e) {
		ArrayList<String> verticesParciales= getVerticesParciales(e.getSolucionParcial());
		for(String vertice: e.getVertices()) {
			if(!verticesParciales.contains(vertice)) {
				return false;
			}
		}
		Grafo grafo= new GrafoNoDirigido(e.getVertices(), e.getSolucionParcial());
		if(!grafo.esConexo()) {
			return false;
		}
		if(e.getSuma() > this.sumaIdeal) {
			return false;
		}
		return true;
	}

	private ArrayList<String> getVerticesParciales(ArrayList<Arco<Integer>> solucionParcial) {
		ArrayList<String> aux= new ArrayList<String>();
		for(Arco<Integer> arco: solucionParcial) {
			if(!aux.contains(arco.getVerticeOrigen())) {
				aux.add(arco.getVerticeOrigen());
			}
			if(!aux.contains(arco.getVerticeDestino())) {
				aux.add(arco.getVerticeDestino());
			}
		}
		return aux;
	}

	private Estado generarEstado(ArrayList<String[]> datos) {
		ArrayList<Arco<Integer>> arcos= new ArrayList<Arco<Integer>>();
		ArrayList<String> vertices= new ArrayList<String>();
		for(String[] d: datos) {
			Arco<Integer> aux= new Arco<Integer>(d[0], d[1], Integer.parseInt(d[2]));
			if(!arcos.contains(aux)){
				arcos.add(aux);
			}
			if(!vertices.contains(d[0])) {
				vertices.add(d[0]);
			}
			if(!vertices.contains(d[1])) {
				vertices.add(d[1]);
			}
		}
		Estado e= new Estado(arcos, vertices);
		return e;
	}
	
	public Integer getSumaIdeal() {
		return this.sumaIdeal;
	}
	
	public Integer getMetrica() {
		return this.metrica;
	}
		
}
