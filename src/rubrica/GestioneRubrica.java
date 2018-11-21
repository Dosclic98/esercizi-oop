package rubrica;

import java.util.ArrayList;
import java.util.HashMap;

public class GestioneRubrica {
	private static HashMap <String, Rubrica> listaRubriche;

	public static void inizializza() {
		listaRubriche = new HashMap <String, Rubrica>();
	}
	
	public static int crea(String nomeRubrica, int dimRubrica) {
		if(listaRubriche.containsKey(nomeRubrica)) return -1;
		listaRubriche.put(nomeRubrica, new Rubrica(nomeRubrica, dimRubrica));
		return 1;
	}
	
	public static int cancella(String nomeRubrica) {
		if(listaRubriche.containsKey(nomeRubrica)) {
			listaRubriche.remove(nomeRubrica);
			return 1;
		}
		return -1;
	}
	
	public static int aggiungi(String nomeRubrica, String contatto) {
		if(!listaRubriche.containsKey(nomeRubrica)) return -2;
		return listaRubriche.get(nomeRubrica).aggiungi(contatto);
	}
	
	public static ArrayList<String> cerca(String nomeRubrica, String prefix){
		if(!listaRubriche.containsKey(nomeRubrica)) return null;
		return listaRubriche.get(nomeRubrica).cerca(prefix);
	}
	
	public static int rimuovi(String nomeRubrica, String prefix) {
		if(!listaRubriche.containsKey(nomeRubrica)) return -1;
		if(listaRubriche.get(nomeRubrica).elimina(prefix)) return 1;
		return 0;
	}
	
	public static String toString(String nomeRubrica) {
		if(!listaRubriche.containsKey(nomeRubrica)) return "";
		return listaRubriche.get(nomeRubrica).toString();
	}
	
	public static int numEl(String nomeRubrica) {
		if(!listaRubriche.containsKey(nomeRubrica)) return -1;
		return listaRubriche.get(nomeRubrica).numEl();
	}
	
	public static void reset() {
		listaRubriche = null;
	}
}
