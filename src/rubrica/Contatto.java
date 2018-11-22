package rubrica;

import java.util.ArrayList;
import java.util.Arrays;

public class Contatto {
	public final String nome;
	private String email;
	private ArrayList <String> telefoni;
	
	public Contatto(String nome, String email, String tels) {
		this.nome = nome;
		this.email = email;
		this.telefoni = new ArrayList<String>(Arrays.asList(tels.split(",")));
	}
	
	public Contatto(String nome, String email) {
		this(nome,email,"");
	}
	
	public Contatto(String nome) {
		this(nome,"","");
	}
	
	public String getEmail() {
		return email;
	}  
	
	public void setEmail(String newEmail) {
		email = newEmail;
	}
	
	public void inserisciNumTel(String num){
		if(!telefoni.contains(num))telefoni.add(num);
	}

	public void eliminaNumTel(String num){
		telefoni.remove(num);
	}
	
	public String numTel() {
		return telefoni.toString();
	}
	
	public String toString() {
		return (nome + "," + email + "," + telefoni.toString());
	}
	
	public boolean equals(Object contatto) {
		
		if(this==contatto) return true;
		if(contatto==null) return false;
		
		if(contatto instanceof Contatto)
		{
			Contatto contact = (Contatto)contatto;
			if(nome == null) {
				if(contact.nome != null) return false;
			}
			if(nome.equals(contact.nome)) return true;
			return false;
		}
		return false;
	}
	
}
