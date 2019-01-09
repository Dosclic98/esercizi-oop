package rubrica;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
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
		if(rubrica.contains(c)) throw new EccezioneRubricaExists();
		if(rubrica.size() == MAX_DIM) throw new EccezioneRubricaFull();
		rubrica.add(c);
		return 1;
	}
	// Da chiedere se cambiare il throws
	public int aggiungi(String nome, String email, String tel) throws EccezioneRubrica, EccezioneContatto{
		return aggiungi(new Contatto(nome,email,tel));
	}	
	
	public int aggiungi(String nome, String email) throws EccezioneRubrica, EccezioneContatto{
		return aggiungi(new Contatto(nome,email));
	}
	
	public int aggiungi(String nome) throws EccezioneRubrica, EccezioneContatto{
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
	
	public String toStringFile() {
		StringBuilder s = new StringBuilder();
		for(int i=0; i<rubrica.size(); i++) {
			s.append(rubrica.get(i).toStringFile() + "\n");
		}
		
		return s.toString();		
	}
	
	public void writeOnFile(){
		try {
			PrintWriter out = new PrintWriter(new File(nome + ".txt"));			out.print(toStringFile());
			
			out.close();
		}
		catch(IOException e){
			e.printStackTrace();
		}
	}
	
}
