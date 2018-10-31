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
	public static int aggiungiFinale(String string) {
		if(rubrica.size() < Rubrica.MAX_DIM && rubrica.contains(string) == false) {
			rubrica.add(string);
			return 1;
		}
		else if(rubrica.size() < Rubrica.MAX_DIM && rubrica.contains(string) == true) {
			return 0;
		}
		else {
			assert(rubrica.size() == Rubrica.MAX_DIM);
			return -1;
		}
	}

	public static int search(String string) {
		for(int i=0;i<rubrica.size();i=i+1)
		{
			if(rubrica.contains(string)) {
				return i;
			}
		}
		return -1;
	}
	
}