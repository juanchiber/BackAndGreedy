package Parte1;

import java.util.Objects;

public class Arco<T> {

	private int verticeOrigen;
	private int verticeDestino;
	private T etiqueta;

	public Arco(int verticeOrigen, int verticeDestino, T etiqueta) {
		this.verticeOrigen = verticeOrigen;
		this.verticeDestino = verticeDestino;
		this.etiqueta = etiqueta;
	}
	
	public int getVerticeOrigen() {
		return verticeOrigen;
	}
	
	public int getVerticeDestino() {
		return verticeDestino;
	}

	public T getEtiqueta() {
		return etiqueta;
	}
	
	public boolean equals(Object obj) {
        if (this == obj) {	//compara si el objeto ARCO actual(this) es igual al objeto pasado por parametro
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {	//corrobora que el objeto no sea null, o si pertenezca a otra clase
            return false;
        }
        Arco<?> i = (Arco<?>) obj;	// si no se cumplen las 2 condiciones, castea el objeto  a Arco<T> y lo guarda en i
        return verticeOrigen == i.verticeOrigen && verticeDestino == i.verticeDestino;	//compara los vertices de this con i
    }

    @Override
    public int hashCode() {
        return Objects.hash(verticeOrigen, verticeDestino);
    }
	
	public String toString() {
	    return "[" + this.verticeOrigen + ", " + this.verticeDestino + ", " +  this.etiqueta + "]";
	}

}