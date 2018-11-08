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
	public void cercaRubricaVuota() {
		assertEquals(0, Rubrica.cerca("Sat").size());
		assertEquals(0, Rubrica.numEl()); // Non ci sono stringhe
	}
	@Test
	public void testSearchFirts() {
		assertEquals(1,Rubrica.aggiungiFinale("Giovanni=1233456"));
		assertEquals(1,Rubrica.aggiungiFinale("Maria=654321"));
		assertEquals(1,Rubrica.aggiungiFinale("Paolo=1233456"));
		assertEquals(1,Rubrica.cerca("Giov").size());
	}
	@Test
	public void testSearchHalf() {
		assertEquals(1,Rubrica.aggiungiFinale("Giovanni=1233456"));
		assertEquals(1,Rubrica.aggiungiFinale("Maria=654321"));
		assertEquals(1,Rubrica.aggiungiFinale("Giulia=1233456"));
		assertEquals(1,Rubrica.cerca("Mar").size());
	}
	@Test
	public void testSearchLast() {
		assertEquals(1,Rubrica.aggiungiFinale("Giovanni=1233456"));
		assertEquals(1,Rubrica.aggiungiFinale("Maria=654321"));
		assertEquals(1,Rubrica.aggiungiFinale("Paolo=987654321"));
		assertEquals(1,Rubrica.cerca("Pao").size());
	}
}
