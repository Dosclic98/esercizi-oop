package dosclic.util;

import jbook.util.*; 

public class Main {
	public static void main(String args[]) {
		float far;
		float cels;
		far = Input.readFloat("Inserire il valore in Fareneith: ");
		cels = (far-32)*(5.0f/9);
		System.out.println("La temperatura convertita è: " + cels);
	}

}
