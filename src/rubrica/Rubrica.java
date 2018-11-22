package rubrica;

import java.util.ArrayList;

public class Rubrica {
	private static ArrayList<Contatto> rubrica;
	public final int MAX_DIM;
	public final String nome;
	
	public Rubrica(String nome, int maxSize) {
		this.nome = nome;
		MAX_DIM = maxSize;
		rubrica = new ArrayList<Contatto>();
	}
	
	public int aggiungi(Contatto c) {
		if(rubrica.contains(c)) return 0;
		if(rubrica.size() == MAX_DIM) return -1;
		rubrica.add(c);
		return 1;
	}
	
	public  int aggiungi(String nome, String email) {
		return aggiungi(new Contatto(nome,email));
	}
	
	public  int aggiungi(String nome) {
		return aggiungi(new Contatto(nome));
	}
	
	public  ArrayList<Contatto> cercaPerNome(String s){
		
	}
	
	public  ArrayList<Contatto> cercaPerEmail(String s){
		
	}
	
	public  boolean eliminaPerNome(String s) {
		
	}
	
	public  boolean eliminaPerEmail(String s) {
		
	}
}
