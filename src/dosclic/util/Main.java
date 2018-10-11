package dosclic.util;
import java.awt.Point;
import jbook.util.Input;

public class Main {
	public static void main(String[] args) {
		Point p1 = new Point(Input.readInt("Inserire la x del primo punto: "), Input.readInt("Inserire la y del primo punto: "));
		Point p2 = new Point(Input.readInt("Inserire la x del secondo punto: "), Input.readInt("Inserire la y del secondo punto: "));
		

		double distance = p1.distance(p2);
		System.out.println("La distanza tra i due punti è: " + distance);
	}
}
