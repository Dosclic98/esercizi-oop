package test;

import static org.junit.Assert.*;
import rubrica.Rubrica;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class TestRubricaStatica {

	@Before
	public void creazione() {
//		System.out.println("BEFORE");
		Rubrica.crea();
	}

	@After
	public void resetRubrica() {
//		System.out.println("AFTER");
	}

	@Test
	public void testCreazione() {
//		System.out.println("CREAZIONE");
		assertTrue(Rubrica.numEl() == 0);
	}

	@Test
	public void testAggiungi() {
//		System.out.println("AGGIUNGI");
		assertEquals(1, Rubrica.aggiungi("Giovanni=123456"));
		assertEquals(1, Rubrica.numEl());
		assertEquals(1, Rubrica.aggiungi("Mattia = 345216789"));
		assertEquals(2, Rubrica.numEl());
	}

	@Test
	public void testAggiuntaMassima() {
//		System.out.println("AGGIUNTA_MASSIMA");
		assertEquals(1, Rubrica.aggiungi("Mattia = 345216789"));
		assertEquals(1, Rubrica.numEl());
		assertEquals(1, Rubrica.aggiungi("Roberta = 312789560"));
		assertEquals(2, Rubrica.numEl());
		assertEquals(1, Rubrica.aggiungi("Alice = 333214576"));
		assertEquals(3, Rubrica.numEl());
		assertEquals(1, Rubrica.aggiungi("Matteo = 312456712"));
		assertEquals(4, Rubrica.numEl());
		assertEquals(1, Rubrica.aggiungi("Enzo = 367891239"));
		assertEquals(5, Rubrica.numEl());
	}

	@Test
	public void testAggiuntaOltreLimite() {
//		System.out.println("AGGIUNTA_OLTRE_LIMITE");
		assertEquals(1, Rubrica.aggiungi("Martina = 346789123"));
		assertEquals(1, Rubrica.numEl());
		assertEquals(1, Rubrica.aggiungi("Sara = 331452673"));
		assertEquals(2, Rubrica.numEl());
		assertEquals(1, Rubrica.aggiungi("Lucia = 333123789"));
		assertEquals(3, Rubrica.numEl());
		assertEquals(1, Rubrica.aggiungi("Margherita = 334331245"));
		assertEquals(4, Rubrica.numEl());
		assertEquals(1, Rubrica.aggiungi("Noemi = 345123879"));
		assertEquals(5, Rubrica.numEl());
		assertEquals(1, Rubrica.aggiungi("Graziella = 331456234"));
		assertEquals(6, Rubrica.numEl());
		assertEquals(-1, Rubrica.aggiungi("Paolo = 331456234"));
		assertEquals(6, Rubrica.numEl());
	}

	@Test
	public void testAggiuntaGiaPresente() {
//		System.out.println("AGGIUNTA_GIA_PRESENTE");
		Rubrica.aggiungi("Martina = 346789123");
		assertEquals(1, Rubrica.numEl());
		Rubrica.aggiungi("Sara = 331452673");
		assertEquals(2, Rubrica.numEl());
		Rubrica.aggiungi("Marco = 345678123");
		assertEquals(3, Rubrica.numEl());
		assertEquals(0, Rubrica.aggiungi("Martina = 346789123"));
		assertEquals(3, Rubrica.numEl());
		assertEquals(0, Rubrica.aggiungi("Marco = 345678123"));
		assertEquals(3, Rubrica.numEl());
	}

	@Test
	public void cercaRubricaVuota() {
//		System.out.println("CERCA_VUOTA");
		assertEquals(0, Rubrica.cerca("Sat").size());
		assertEquals(0, Rubrica.numEl()); // Non ci sono stringhe
	}
	
	@Test
	public void testRicerca() {
//		System.out.println("RICERCA");
		addElementiRubricaStatica(); // Aggiunge 6 elementi alla rubrica
		assertEquals(2, Rubrica.cerca("Giov").size()); // Presente come primo e
														// ultimo
		assertEquals(1, Rubrica.cerca("Sara").size());
		assertEquals(0, Rubrica.cerca("Sat").size()); // Non ci sono stringhe
														// con questo prefisso
		assertEquals(0, Rubrica.cerca("123").size()); // ma ce ne sono che lo
														// contengono
		assertEquals(3, Rubrica.cerca("G").size());
		assertEquals(1, Rubrica.cerca("Giorgio=7689453201").size());
		assertEquals(0, Rubrica.cerca("Giorgio=7689453200").size()); // Confrontare
																		// con
																		// precedente
		assertEquals(6, Rubrica.cerca("").size()); // Tutte le stringhe inizano
													// con la stringa vuota
	}

	@Test
	public void testEliminaVuota() {
//		System.out.println("ELIMINA_VUOTA");
		assertFalse(Rubrica.elimina("Giov"));
		assertEquals(0, Rubrica.numEl()); // Non ci sono stringhe
		assertFalse(Rubrica.elimina("")); // Li rimuove tutti
		assertEquals(0, Rubrica.numEl()); // Non ci sono piu' stringhe
	}

	@Test
	public void testElimina() {
//		System.out.println("ELIMINA");
		addElementiRubricaStatica(); // Aggiunge 6 elementi alla rubrica
		assertTrue(Rubrica.elimina("")); // Li rimuove tutti
		assertEquals(0, Rubrica.numEl()); // Non ci sono piu' stringhe
		addElementiRubricaStatica(); // Ri-aggiunge 6 elementi alla rubrica
		assertTrue(Rubrica.elimina("Giov"));
		assertEquals(4, Rubrica.numEl());
		assertFalse(Rubrica.elimina("Sat"));
		assertEquals(4, Rubrica.numEl());
		assertFalse(Rubrica.elimina("Giorgio=7689453200"));
		assertEquals(4, Rubrica.numEl());
		assertTrue(Rubrica.elimina("Giorgio=7689453201"));
		assertEquals(3, Rubrica.numEl());
		assertTrue(Rubrica.elimina("E"));
		assertTrue(Rubrica.elimina("S"));
		assertTrue(Rubrica.elimina("P"));
		assertEquals(0, Rubrica.numEl());
	}

	private void addElementiRubricaStatica() {
		Rubrica.aggiungi("Giovanni=0123456789");
		Rubrica.aggiungi("Enzo=4593782610");
		Rubrica.aggiungi("Paola=0123456789");
		Rubrica.aggiungi("Sara=0354768912");
		Rubrica.aggiungi("Giorgio=7689453201");
		Rubrica.aggiungi("Giovanni=0123456784");
	}
}