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
		return 0;
	}

	public Object aggiungi(String string) {
		// TODO Auto-generated method stub
		return null;
	}
	
}