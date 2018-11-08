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

	public static int aggiungiFinale(String string) {
		if(rubrica.size() >= MAX_DIM) {
			return -1;
		}
		if(rubrica.contains(string)) {
			return 0;
		}
		rubrica.add(string);
		return 1;
	}
	// Da rifare
	public static ArrayList<String> cerca(String string) {
		ArrayList<String> sottoRubrica = new ArrayList<String>();
		for(int i=0;i<rubrica.size();i++) {
			if(rubrica.get(i).startsWith(string)) sottoRubrica.add(rubrica.get(i));
		}
		return sottoRubrica;
	}
	
}
