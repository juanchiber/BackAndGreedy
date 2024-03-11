package Backtracking;

import java.util.ArrayList;

public class MainBack {

	public static void main(String[] args) {
		String path = "../TPE/src/datasets/dataset2.txt";
		CSVReader reader = new CSVReader(path);
		ArrayList<String[]> datos = reader.read();
		Backtracking back= new Backtracking();
		ArrayList<Arco<Integer>> solucion= back.solucionBack(datos);
		System.out.println("Backtracking:");
		for(Arco<Integer> aux: solucion) {
			System.out.println(aux);
		}
		System.out.println("Kilometros totales a construir: " + back.getSumaIdeal() + "km");
		System.out.println("Metrica: " + back.getMetrica());
	}
}
