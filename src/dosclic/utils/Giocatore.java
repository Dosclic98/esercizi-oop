package dosclic.utils;

import java.util.ArrayList;

public abstract class Giocatore {
	protected String target;
	protected ArrayList<Tentativo> tentativi;
	
	public Giocatore() {
		inizializza();
	}
	
	public void inizializza() {
		target = genTarget();
		tentativi = new ArrayList<Tentativo>();
	}
	
	public String getTarget() {
		return target;
	}
	
	public boolean addTentativo(String guess, int bulls, int maggots) {
		if(bulls+maggots > 4) return false;
		
		Tentativo nuovo = new Tentativo(guess,bulls,maggots);
		tentativi.add(nuovo);
		return true;
	}
	
	public String toString() {
		String tents = new String();
		for(int i=0;i<tentativi.size();i++) {
			tents = "Tentativo " + i + ": " + tentativi.get(i).toString() + "\n";
		}
		return tents;
	}
	
	public abstract String genTarget();
	public abstract String genGuess();
}
