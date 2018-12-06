package dosclic.utils;

public class Tentativo {
	private String guess;
	private int numBulls;
	private int numMaggots;
	
	public Tentativo(String string, int bulls, int maggots) {
		guess = string;
		numBulls = bulls;
		numMaggots = maggots;
	}
	
	public String getGuess() {
		return guess;
	}
	public int getBulls() {
		return numBulls;
	}
	public int getMaggots() {
		return numMaggots;
	}
	
	public String toString() {
		return "[guess=" + guess + ", bulls=" + numBulls 
				+ ", maggots=" + numMaggots + "]";
	}
	
}
