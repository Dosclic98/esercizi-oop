package lambda;

import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class UsoClassiAnonime {

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
		
		Collections.sort(persone, new Comparator<Persona>() {
			public int compare(Persona p1, Persona p2) {
				return p1.getCognome().compareTo(p2.getCognome());
			}
		});
		
		// Step2: Definire un metodo che stampa tutti gli elementi
		printConCondizione(persone, new Condizione() {
			public boolean test(Persona p) {
				return true;
			}
		});


		// Step 3: Definire un metodo che stampa tutte le persone che
		// hanno il cognome che inizi per "S"
		System.out.println("Stampo quelli senza S");
		
		
		// Step 4.1: Definire un metodo che stampa gli elementi della
		// lista persone che soddisfano un predicato (considare la
		// interfaccia Condizione).
		// Step 4.2 Usare il metodo per definire la stampa tutte le persone che
		// hanno il cognome che inizi per "S":
		//     4.2.1 prima definendo una classe che implementa l'interfaccia
		//     4.2.2 poi usando una classe anonima
		printConCondizione(persone, new Condizione() {
			public boolean test(Persona p) {
				return p.getCognome().startsWith("s");
			}
		});
		
		

	}
	
	
	private static void printConCondizione(List<Persona> persone, Condizione c) {
		for(Persona i : persone) {
			if(c.test(i)) System.out.println(i);
		}		
	}
}

interface Condizione{
	public abstract boolean test(Persona p);
}
	
	