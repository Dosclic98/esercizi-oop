package dosclic.utils;

import java.util.ArrayList;


public class Giudice {
	public final static int LUNGHEZZA = 4;
	public static final ArrayList<Character> CHARS = new ArrayList<Character>();
	
	public static void init() {
		CHARS.add('0');
		CHARS.add('1');
		CHARS.add('2');
		CHARS.add('3');
		CHARS.add('4');
		CHARS.add('5');
		CHARS.add('6');
		CHARS.add('7');
		CHARS.add('8');
		CHARS.add('9');
	}
	
	
	public static void reset() {
		CHARS.clear();
	}
	
	private static boolean validChars(String string) {
		for(int i=0;i<string.length();i++) {
			if(!CHARS.contains(string.charAt(i))) {
				System.out.println("Carateri invalidi");
				return false;
			}
		}
		return true;
	}
	
	private static boolean validRepeat(String string) {
		for(int i=0;i<string.length();i++) {
			for(int j=0;j<string.length();j++) {
				if(j!=i && string.charAt(i) == string.charAt(j)) {
					// System.out.println("Ripetizione");
					return false;
				}
			}
		}
		return true;
	}
	
	public static boolean valida(String string) {
		return ((string.length() == LUNGHEZZA) && validChars(string) && validRepeat(string));
	}


	public static int numBulls(String string, String string2) {
		int numBulls = 0;
		for(int i=0;i<string2.length();i++) {
			if(string.charAt(i) == string2.charAt(i)) numBulls++;
		}
		return numBulls;
	}


	public static int numMaggots(String string, String string2) {
		int numMaggots = 0;
		for(int i=0;i<string.length();i++) {
			for(int j = 0;j<string2.length();j++) {
				if((string.charAt(i)==string2.charAt(j)) && (i!=j)) numMaggots++;
			}
		}
		return numMaggots;
	}
	
	public static String genTarget() {
		ArrayList<Character> cpy = new ArrayList<Character>(CHARS);
		
		StringBuilder target = new StringBuilder(LUNGHEZZA);
		int ran = 0;
		for(int j=0;j<LUNGHEZZA;j++) {
			ran = ((int)(Math.random() * (cpy.size()))) ; 
			target.append(cpy.get(ran));
			cpy.remove(ran);
		}
		return target.toString();
	}

}
