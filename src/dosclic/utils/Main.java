package dosclic.utils;
import jbook.util.Input;

public class Main {
	public static void main(String[] args) {
		int numGuesses = 0;
		String guess;
		Giudice.init();
		String target = Giudice.genTarget();
		while (true) {
			guess = Input.readString("Indovina la sequenza:");
			if (guess.equals("quit")){
				System.out.println("La risposta e':" + target +"");
				return;	
			}
			if (guess.equals("Mi_arrendo")) {
				System.out.println("La risposta e':" + target +"");
			} else if (!(Giudice.valida(guess))) {
				System.out.println("Stringa non valida");
			} else {
				int bulls = Giudice.numBulls(guess, target);
				int maggots = Giudice.numMaggots(guess, target);
				if (bulls == 4) {
					numGuesses++;
					System.out.println(
							"Hai indovinato in " + numGuesses + " tentativi.  Riprova!"
							);
					target = Giudice.genTarget();
					numGuesses = 0;
				} else {
					numGuesses++;
					System.out.println(bulls + "B  " + maggots + "M");
				}
			}
		}
	}
}
