package lambda;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class UsoLambda {
	
	public static void main(String[] args) {
		List<Persona> persone = Arrays.asList(
				new Persona("Mario", "Rossi", 35), 
				new Persona("Lucy","Parker", 22), 
				new Persona("Gianni", "Bianchi", 20),
				new Persona("Fabio", "Marchi", 40),
				new Persona("John","Simpson", 18),
				new Persona("Adele", "Sorgi", 20));
	
		// Step 1 Ordinare la Lista persone per cognome usando 
		// Collection.sort il cui secondo parametro e' di tipo 
		// Comparator<T>
		
		Collections.sort(persone, 
			(Persona p1,Persona p2) ->
				p1.getCognome().compareTo(p2.getCognome()) );
		
		printPersoneConCondizione(persone,p->true);
		System.out.println("Stampo quelli senza S");
		printPersoneConCondizione(persone,p->p.getCognome().startsWith("S"));
	}

	private static void printPersoneConCondizione(List<Persona> persone, Condizione c) {
		for(Persona i : persone) {
			if(c.test(i)) System.out.println(i);
		}		
	}
	
}
