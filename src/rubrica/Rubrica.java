package rubrica;

import java.util.ArrayList;

public class Rubrica {
	private ArrayList<Contatto> rubrica;
	public final int MAX_DIM;
	public final String nome;
	
	public Rubrica(String nome, int maxSize) {
		this.nome = nome;
		MAX_DIM = maxSize;
		rubrica = new ArrayList<Contatto>();
	}
	
	public int aggiungi(Contatto c) throws EccezioneRubrica{
		if(rubrica.contains(c)) throw new EccezioneRubrica("Elemento presente");
		if(rubrica.size() == MAX_DIM) throw new EccezioneRubrica("Massima dimensione raggiunta");
		rubrica.add(c);
		return 1;
	}
	// Da chiedere se cambiare il throws
	public int aggiungi(String nome, String email, String tel) throws EccezioneRubrica{
		return aggiungi(new Contatto(nome,email,tel));
	}	
	
	public int aggiungi(String nome, String email) throws EccezioneRubrica{
		return aggiungi(new Contatto(nome,email));
	}
	
	public int aggiungi(String nome) throws EccezioneRubrica {
		return aggiungi(new Contatto(nome));
	}
	
	public ArrayList<Contatto> cercaPerNome(String s){
		ArrayList<Contatto> container = new ArrayList<Contatto>();
		for(int i=0; i<rubrica.size(); i++) {
			if(rubrica.get(i).nome.startsWith(s)) container.add(rubrica.get(i));
		}
		return container;
	}
	
	public ArrayList<Contatto> cercaPerEmail(String s){
		ArrayList<Contatto> container = new ArrayList<Contatto>();
		for(int i=0; i<rubrica.size(); i++) {
			if(rubrica.get(i).getEmail().startsWith(s)) container.add(rubrica.get(i));
		}
		return container;
		
	}
	
	public boolean eliminaPerNome(String s) {
		boolean flag = false;
		for(int i=0; i<rubrica.size(); i++) {
			if(rubrica.get(i).nome.startsWith(s)) {
				flag = true;
				rubrica.remove(i);
			}
		}
		return flag;
	}
	
	public boolean eliminaPerEmail(String s) {
		boolean flag = false;
		for(int i=0; i<rubrica.size(); i++) {
			if(rubrica.get(i).getEmail().startsWith(s)) {
				flag = true;
				rubrica.remove(i);
			}
		}		
		return flag;
	}
	
	public int numEl() {
		return rubrica.size();
	}
	
	public String toString() {
		String s = new String("[");
		for(int i=0; i<rubrica.size(); i++) {
			s = s + rubrica.get(i).toString();
		}
		s = s + "]";
		return s;
	}
}
