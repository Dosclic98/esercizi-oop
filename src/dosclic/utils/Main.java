package dosclic.utils;
import jbook.util.Input;

public class Main {
	public static void main(String[] args) {
		String inp = Input.readString("Inserire la stringa: ");
		char c = Input.readChar("Inserire il carattere: ");
		StringBuilder built = new StringBuilder(inp);
		
		for(int i=0;i<inp.length();i++) {
			/* Ho assunto che il programma dovesse sostituire tutte le occorrenze 
			   di un carattere senza essere case sensitive */
			if(Character.toLowerCase(inp.charAt(i)) == Character.toLowerCase(c)) {
				built.setCharAt(i, '?');
			}
		}
		inp = built.toString();
		System.out.println("La stringa convertita è: " + inp);
	}
}
