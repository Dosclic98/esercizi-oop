package abr.exer;

import java.io.InputStream;
import java.util.Scanner;

public final class InputParser {

	final Scanner scan;

	public InputParser(InputStream str) {
		scan = new Scanner(System.in);
	}

	public int fetchInt() {
		Integer retn = null;
		while(retn == null) {
			System.out.print(" > ");
			try {
				retn = Integer.valueOf(scan.next());
			} catch(NumberFormatException ex) { failReading(ex); }
		}
		return retn;
	}

	public float fetchFloat() {
		Float retn = null;
		while(retn == null) {
			System.out.print(" > ");
			try {
				retn = Float.valueOf(scan.next());
			} catch(NumberFormatException ex) { failReading(ex); }
		}
		return retn;
	}

	public void failReading(NumberFormatException ex) {
		System.out.println("Invalid number format.");
	}

}
