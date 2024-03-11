package Greedy;

import java.util.ArrayList;
import Backtracking.Arco;
import Backtracking.CSVReader;

public class MainGreedy {

	public static void main(String[] args) {
		String path = "../TPE/src/datasets/dataset1.txt";
		CSVReader reader = new CSVReader(path);
		ArrayList<String[]> datos = reader.read();
		Greedy greedy= new Greedy();
		ArrayList<Arco<Integer>> solucion= greedy.solucionGreedy(datos);
		System.out.println("Greedy:");
		for(Arco<Integer> aux: solucion) {
			System.out.println(aux);
		}
		System.out.println("Kilometros totales a construir: " + greedy.getSuma() + "km");
		System.out.println("Metrica: " + greedy.getMetrica());
	}
}