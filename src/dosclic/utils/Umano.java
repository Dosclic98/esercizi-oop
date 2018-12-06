package dosclic.utils;
import jbook.util.*;

public class Umano extends Giocatore {

	@Override
	public String genTarget() {
		String target = Input.readString("Inserire la stringa da indovinare: ");
		System.out.println(target);
		while(!Giudice.valida(target)) {
			target = Input.readString("Stringa non valida reinserirla: ");
			System.out.println(target);
		}
		return target;
	}

	@Override
	public String genGuess() {
		String guess = Input.readString("Inserire la stringa: ");
		while(!Giudice.valida(guess)) {
			guess = Input.readString("Stringa non valida reinserirla: ");
		}
		return guess;		
	}

}
