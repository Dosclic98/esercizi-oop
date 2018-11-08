package test;

import static org.junit.Assert.*;
import rubrica.Rubrica;

import org.junit.Before;
import org.junit.Test;

public class TestRubrica {
	public Rubrica container = new Rubrica();

	@Before
	public void creazione() {
		assertEquals(5,container.MAX_DIM);
		int num  = container.getNum();
		assertEquals("Rubrica" + --num, container.nome);
	}

	@Test
	public void testCreazione() {
		assertTrue(container.numEl() == 0);
	}

	@Test
	public void testAggiungi() {
		assertEquals(1, container.aggiungi("Giovanni=123456"));
		assertEquals(1, container.numEl());
		assertEquals(1, container.aggiungi("Mattia = 345216789"));
		assertEquals(2, container.numEl());
	}

	@Test
	public void testAggiuntaMassima() {
		assertEquals(1, container.aggiungi("Mattia = 345216789"));
		assertEquals(1, container.numEl());
		assertEquals(1, container.aggiungi("Roberta = 312789560"));
		assertEquals(2, container.numEl());
		assertEquals(1, container.aggiungi("Alice = 333214576"));
		assertEquals(3, container.numEl());
		assertEquals(1, container.aggiungi("Matteo = 312456712"));
		assertEquals(4, container.numEl());
		assertEquals(1, container.aggiungi("Enzo = 367891239"));
		assertEquals(5, container.numEl());
	}

	@Test
	public void testAggiuntaOltreLimite() {
		assertEquals(1, container.aggiungi("Martina = 346789123"));
		assertEquals(1, container.numEl());
		assertEquals(1, container.aggiungi("Sara = 331452673"));
		assertEquals(2, container.numEl());
		assertEquals(1, container.aggiungi("Lucia = 333123789"));
		assertEquals(3, container.numEl());
		assertEquals(1, container.aggiungi("Margherita = 334331245"));
		assertEquals(4, container.numEl());
		assertEquals(1, container.aggiungi("Noemi = 345123879"));
		assertEquals(5, container.numEl());
		assertEquals(-1, container.aggiungi("Graziella = 331456234"));
		assertEquals(5, container.numEl());
	}

	@Test
	public void testAggiuntaGiaPresente() {
		container.aggiungi("Martina = 346789123");
		assertEquals(1, container.numEl());
		container.aggiungi("Sara = 331452673");
		assertEquals(2, container.numEl());
		container.aggiungi("Marco = 345678123");
		assertEquals(3, container.numEl());
		assertEquals(0, container.aggiungi("Martina = 346789123"));
		assertEquals(3, container.numEl());
		assertEquals(0, container.aggiungi("Marco = 345678123"));
		assertEquals(3, container.numEl());
	}

	@Test
	public void cercaRubricaVuota() {
		assertEquals(0, container.cerca("Sat").size());
		assertEquals(0, container.numEl()); // Non ci sono stringhe
	}

	@Test
	public void testRicerca() {
		addElementiRubrica(); // Aggiunge 5 elementi alla rubrica
		assertEquals(1, container.cerca("Giov").size()); // Presente come primo
				
		assertEquals(1, container.cerca("Sara").size());
		assertEquals(0, container.cerca("Sat").size()); // Non ci sono stringhe
														// con questo prefisso
		assertEquals(0, container.cerca("123").size()); // ma ce ne sono che lo
														// contengono
		assertEquals(2, container.cerca("G").size());
		assertEquals(1, container.cerca("Giorgio=7689453201").size());
		assertEquals(0, container.cerca("Giorgio=7689453200").size()); // Confrontare
																		// con
																		// precedente
		assertEquals(5, container.cerca("").size()); // Tutte le stringhe inizano
													// con la stringa vuota
	}

	@Test
	public void testEliminaVuota() {
		assertFalse(container.elimina("Giov"));
		assertEquals(0, container.numEl()); // Non ci sono stringhe
		assertFalse(container.elimina("")); // Li rimuove tutti
		assertEquals(0, container.numEl()); // Non ci sono piu' stringhe
	}

	@Test
	public void testElimina() {
		addElementiRubrica(); // Aggiunge 5 elementi alla rubrica
		assertTrue(container.elimina("")); // Li rimuove tutti
		assertEquals(0, container.numEl()); // Non ci sono piu' stringhe
		addElementiRubrica(); // Ri-aggiunge 5 elementi alla rubrica
		assertTrue(container.elimina("Giov"));
		assertEquals(4, container.numEl());
		assertFalse(container.elimina("Sat"));
		assertEquals(4, container.numEl());
		assertFalse(container.elimina("Giorgio=7689453200"));
		assertEquals(4, container.numEl());
		assertTrue(container.elimina("Giorgio=7689453201"));
		assertEquals(3, container.numEl());
		assertTrue(container.elimina("E"));
		assertTrue(container.elimina("S"));
		assertTrue(container.elimina("P"));
		assertEquals(0, container.numEl());
	}
	@Test
	public void testStampaVuota() {
		assertEquals("[]",container.toString());
	}
	@Test
	public void testStampa3Elem() {
		container.aggiungi("Mario=1234598765");
		container.aggiungi("Luca=1638598765");
		container.aggiungi("Enrico=1638598765");
		assertEquals("[Mario=1234598765, Luca=1638598765, Enrico=1638598765]",container.toString());
	}	
	@Test
	public void testStampaPiena() {
		addElementiRubrica();
		assertEquals("[Giovanni=0123456789, Enzo=4593782610, Paola=0123456789, Sara=0354768912, Giorgio=7689453201]",container.toString());
	}
	private void addElementiRubrica() {
		container.aggiungi("Giovanni=0123456789");
		container.aggiungi("Enzo=4593782610");
		container.aggiungi("Paola=0123456789");
		container.aggiungi("Sara=0354768912");
		container.aggiungi("Giorgio=7689453201");
	}
}