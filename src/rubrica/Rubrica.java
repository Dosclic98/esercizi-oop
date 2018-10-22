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
	public static int search(String string) {
		for(int i=0;i<rubrica.size();i=i+1)
		{
			if(string.equals(rubrica.get(i))) {
				return i;
			}
		}
		return -1;
	}
	
}
