package rubrica;

import java.util.ArrayList;

public class Rubrica {
	private static ArrayList<String> rubrica;
	public static final int MAX_DIM = 3;
	public static void crea() {
		rubrica = new ArrayList<String>();
	}
	public static int numEl() {
		return rubrica.size();
	}
	public static int aggiungi(String string) {
		if(rubrica.size() < Rubrica.MAX_DIM ) {
			rubrica.add(string);
			return 1;
		}
		else {
			return -1;
		}
	}
	public static boolean trovato(String string) {
		for(int i=0;i<rubrica.size();i++) {
			if(rubrica.get(i).equals(string) == true) {
				return true;
			}
		}
		return false;
	}
	
	public static int aggiungiFinale(String string) {
		if(rubrica.size() < Rubrica.MAX_DIM && Rubrica.trovato(string) == false) {
			rubrica.add(string);
			return 1;
		}
		else if(rubrica.size() < Rubrica.MAX_DIM && Rubrica.trovato(string) == true) {
			return 0;
		}
		else {
			assert(rubrica.size() == Rubrica.MAX_DIM);
			return -1;
		}
	}
	
}
