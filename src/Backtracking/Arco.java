package Backtracking;

import java.util.Objects;

public class Arco<T> {

	private String verticeOrigen;
	private String verticeDestino;
	private T distancia;

	public Arco(String verticeOrigen, String verticeDestino, T distancia) {
		this.verticeOrigen = verticeOrigen;
		this.verticeDestino = verticeDestino;
		this.distancia = distancia;
	}
	
	public String getVerticeOrigen() {
		return verticeOrigen;
	}
	
	public String getVerticeDestino() {
		return verticeDestino;
	}

	public T getDistancia() {
		return distancia;
	}
	
	public boolean equals(Object obj) {
        try {
            Arco aux = (Arco) obj;
            return this.verticeOrigen.equals(aux.getVerticeOrigen()) && this.verticeDestino.equals(aux.getVerticeDestino());
        } catch (Exception e) {
            return false;
        }
    }
	
    @Override
    public int hashCode() {
        return Objects.hash(verticeOrigen, verticeDestino);
    }
	
    @Override
	public String toString() {
	    return "[" + this.verticeOrigen + " <--> " + this.verticeDestino + "] " + this.distancia+ "km" ;
	}

}