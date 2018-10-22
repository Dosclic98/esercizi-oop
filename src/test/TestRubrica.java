package test;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;
import rubrica.Rubrica;

public class TestRubrica {

	@Before
	public void testCreazione() {
		Rubrica.crea();
		assertTrue(Rubrica.numEl()==0);
	}
	
	@Test
	public void testAggiungi() {
		assertEquals(1, Rubrica.aggiungiFinale("Giovanni=1233456")); // oppure
		// assertTrue(Rubrica.aggiungi("Giovanni=1233456")==1);
		assertEquals(1, Rubrica.numEl()); // oppure
		// assertTrue(Rubrica.numEl()==1);
	}
	
	@Test
	public void testAggiungiContr() {
		// Aggiungo MAX_DIM + 1 elementi e verifico che alla fine sia ritornato -1
		// e che ci siano solo MAX_DIM elementi
		assertEquals(1,Rubrica.aggiungiFinale("Giovanni=1233456"));
		assertEquals(1,Rubrica.aggiungiFinale("Mario=1233456"));
		assertEquals(1,Rubrica.aggiungiFinale("Enzo=1233456"));
		assertEquals(-1,Rubrica.aggiungiFinale("Paolo=1233456"));
		assertEquals(Rubrica.MAX_DIM, Rubrica.numEl());
	}
	
	@Test
	public void testAggiungiRet() {
		assertEquals(1,Rubrica.aggiungiFinale("Giovanni=1233456"));
		assertEquals(1,Rubrica.aggiungiFinale("Maria=654321"));
		assertEquals(0,Rubrica.aggiungiFinale("Giovanni=1233456"));
		assertEquals(2,Rubrica.numEl());
	}
	
	@Test
	public void testSearchVoid() {
		assertEquals(-1,Rubrica.search("Giovanni=1233456"));
		assertTrue(0 == Rubrica.numEl());
	}
	@Test
	public void testSearchFirts() {
		assertEquals(1,Rubrica.aggiungiFinale("Giovanni=1233456"));
		assertEquals(0,Rubrica.search("Giovanni=1233456"));
		assertTrue(1 == Rubrica.numEl());
	}
	@Test
	public void testSearchHalf() {
		assertEquals(1,Rubrica.aggiungiFinale("Giovanni=1233456"));
		assertEquals(1,Rubrica.aggiungiFinale("Maria=1233456"));
		assertEquals(1,Rubrica.aggiungiFinale("Luigi=1233456"));
		assertEquals(1,Rubrica.search("Maria=1233456"));
		assertTrue(3 == Rubrica.numEl());
	}
	@Test
	public void testSearchLast() {
		assertEquals(1,Rubrica.aggiungiFinale("Giovanni=1233456"));
		assertEquals(1,Rubrica.aggiungiFinale("Luigi=1233456"));
		assertEquals(1,Rubrica.aggiungiFinale("Maria=1233456"));
		assertEquals(2,Rubrica.search("Maria=1233456"));
		assertTrue(3 == Rubrica.numEl());
	}
	@Test
	public void testSearchFull() {
		assertEquals(1,Rubrica.aggiungiFinale("Giovanni=1233456"));
		assertEquals(1,Rubrica.aggiungiFinale("Luigi=1233456"));
		assertEquals(1,Rubrica.aggiungiFinale("Maria=1233456"));
		assertEquals(-1,Rubrica.search("Luca=1233456"));
		assertTrue(3 == Rubrica.numEl());
	}
	
}
