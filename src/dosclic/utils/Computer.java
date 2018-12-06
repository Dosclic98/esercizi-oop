package dosclic.utils;

import java.util.ArrayList;

public class Computer extends Giocatore {
	public Computer() {
		super();
	}
	
	@Override
	public String genTarget() {
		ArrayList<Character> cpy = new ArrayList<Character>(Giudice.CHARS);
		
		StringBuilder target = new StringBuilder(Giudice.LUNGHEZZA);
		int ran = 0;
		for(int j=0;j<Giudice.LUNGHEZZA;j++) {
			ran = ((int)(Math.random() * (cpy.size()))) ; 
			target.append(cpy.get(ran));
			cpy.remove(ran);
		}
		return target.toString();
	}

	@Override
	public String genGuess() {
		return genTarget();
	}
}
