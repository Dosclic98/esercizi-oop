package rubrica;

import java.util.ArrayList;

public class Rubrica {
	private static int numRubriche=0;
	
	private ArrayList<String> rubrica;
	public final int MAX_DIM;
	public final String nome;
	
	public Rubrica(String nome, int maxDim) {
		this.nome = nome;
		MAX_DIM = maxDim;
		rubrica = new ArrayList<String>();
		numRubriche++;
	}
	
	public Rubrica() {
		this("Rubrica" + numRubriche,5);
	}
	
	public int getNum() {
		return numRubriche;
	}

	public int numEl() {
		return rubrica.size();
	}

	public int aggiungi(String string) {
		if(rubrica.size() >= MAX_DIM) return -1;
		if(rubrica.contains(string)) return 0;
		rubrica.add(string);
		return 1;
	}

	public ArrayList<String> cerca(String string) {
		ArrayList<String> sottoRubrica = new ArrayList<String>();
		for(int i=0;i<rubrica.size();i++) {
			if(rubrica.get(i).startsWith(string)) sottoRubrica.add(rubrica.get(i));
		}
		return sottoRubrica;
	}

	public boolean elimina(String string) {
		boolean cond = false;
		int i=0;
		while(i<rubrica.size()) {
			if(rubrica.get(i).startsWith(string)) {
				rubrica.remove(i);
				cond = true;
			}
			else i++;
		}
		return cond;
	}

	public String toString() {
		return rubrica.toString();
	}
	
}