package Backtracking;

import java.util.ArrayList;

public class Estado {
	
	private ArrayList<String> vertices;
	private ArrayList<Arco<Integer>> solucionParcial;
	private ArrayList<Arco<Integer>> posibilidades;
	private Integer suma;
	
	public Estado(ArrayList<Arco<Integer>> arcos, ArrayList<String> vertices) {
		this.vertices= vertices;
		this.posibilidades= arcos;
		this.solucionParcial= new ArrayList<Arco<Integer>>();
		this.suma= 0;
	}
	
	public ArrayList<Arco<Integer>> getPosibilidades(){
		return this.posibilidades;
	}
	
	public Integer getSuma() {
		return suma;
	}
	
	public void setSuma(Integer suma) {
		this.suma= suma;
	}

	public ArrayList<String> getVertices() {
		return this.vertices;
	}

	public ArrayList<Arco<Integer>> getSolucionParcial() {
		return solucionParcial;
	}

	public void removeFromPosibilidades(Arco<Integer> tunel) {
		posibilidades.remove(tunel);
	}


}
