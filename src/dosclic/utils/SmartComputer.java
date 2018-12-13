package dosclic.utils;

import java.util.ArrayList;

public class SmartComputer extends Computer {
	ArrayList<String> guessPossibli;
	
	public SmartComputer() {
		super();
		guessPossibli = combValide(combinazioni(Giudice.LUNGHEZZA,Giudice.CHARS));
	}
	
	public ArrayList<String> combinazioni(int lunghezza, ArrayList<Character> chars){
		if(lunghezza==0) {
			ArrayList<String> comb = new ArrayList<String>();
			comb.add("");
			return comb;
		}
		
		ArrayList<String> strTmp = combinazioni(lunghezza-1,chars);
		ArrayList<String> tmp = new ArrayList<String>();
		for(int i=0;i<strTmp.size();i++) {
			for(int j=0;j<chars.size();j++) {
				tmp.add(strTmp.get(i) + chars.get(j));
			}
		}
		return tmp;
	}
	
	public ArrayList<String> combValide(ArrayList<String> guess) {
		ArrayList<String> out = new ArrayList<String>();
		
		for(String i:guess) {
			if(Giudice.valida(i)) out.add(i);
		}
		return out;
	}
	
	
	public String genGuess() {
		ArrayList<String> temp = new ArrayList<String>();
		for(String i:guessPossibli) {
			if(inAccordoTutti(i,tentativi)) {
				temp.add(i);
			}
		}
		guessPossibli = temp;
		// Da qui
		return guessPossibli.get(random()*guessPossibli.size());
	}
	
	public boolean inAccordoTutti(String s, ArrayList<Tentativo> ts) {
		for(Tentativo i:ts) {
			if(!inAccordo(s,i)) return false;
		}
		return true;
	}
	
	public boolean inAccordo(String s, Tentativo tent) {
		if(Giudice.numBulls(s, tent.getGuess()) == tent.getBulls()
		&& Giudice.numMaggots(s, tent.getGuess()) == tent.getMaggots()) {
			return true;
		}
		return false;
	}
	
	public int getLenPoss() {
		return guessPossibli.size();
	}
}
