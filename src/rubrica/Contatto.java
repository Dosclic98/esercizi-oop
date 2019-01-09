package rubrica;

import java.util.ArrayList;
import java.util.Arrays;

public class Contatto {
	public final String nome;
	private String email;
	private ArrayList <String> telefoni;
	
	public Contatto(String nome, String email, String tels) throws EccezioneContatto {
		if(!nome.matches("^([ a-zA-Z]+)")) throw new EccezioneContatto("Nome Contatto invalido");
		else this.nome = nome;
		
		if(!(email.matches("^[a-zA-Z]+" + "@" + "[a-zA-Z]+" + "\\." + "[a-zA-Z]+") || email.matches(""))) throw new EccezioneContatto("Email Contatto invalido");
		else this.email = email;
		
		if(!(tels.matches("^[0-9]{6}+" + "(,[0-9]{6})*") || tels.matches(""))) throw new EccezioneContatto("Numero Contatto invalido");
		else this.telefoni = new ArrayList<String>(Arrays.asList(tels.split(",")));
	}
	
	public Contatto(String nome, String email) throws EccezioneContatto {
		this(nome,email,"");
	}
	
	public Contatto(String nome) throws EccezioneContatto {
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
	
	public String toStringFile() {
		StringBuilder str = new StringBuilder();
		str.append(nome + ",");
		str.append(email + ",");
		for(int i=0;i<telefoni.size()-1;i++) {
			str.append(telefoni.get(i) + ";");
		}
		str.append(telefoni.get(telefoni.size()-1));
		
		return str.toString();
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
