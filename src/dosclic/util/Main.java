package dosclic.util;
import jbook.util.*;
public class Main {
	static final int ROWS = 5;
	static final int COLS = 3;

	public static void main(String args[]) {
		
		int[][] mtrx = new int[ROWS][COLS];
		
		for(int i=0;i<ROWS;i++) {
			for(int j=0;j<COLS;j++) {
				mtrx[i][j] = Input.readInt("Inserire l'intero (" + (i+1) + "," + (j+1) +"): "); 	
			}
		}
		printMatrix(mtrx);
	}
	public static void printMatrix(int mtrx[][]) {
		for(int i=0;i<ROWS;i++) {
			for(int j=0;j<COLS;j++) {
				System.out.print(mtrx[i][j] + " "); 	
			}
			System.out.println("");
		}		
	}
}
