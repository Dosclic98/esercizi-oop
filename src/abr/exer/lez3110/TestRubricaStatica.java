package abr.exer.lez3110;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

/** Versione remastered 2.0 plus della classe di test fornita 'sul Dir' */
public class TestRubricaStatica {

	public IRubrica rubrica;

	@BeforeEach
	public void creazione() {
//		System.out.println("BEFORE");
		rubrica = new Rubrica();
	}

	@Test
	public void testCreazione() {
//		System.out.println("CREAZIONE");
		assertTrue(rubrica.numEl() == 0);
	}

	@Test
	public void testAggiungi() {
//		System.out.println("AGGIUNGI");
		assertEquals(1, rubrica.aggiungi("Giovanni=123456"));
		assertEquals(1, rubrica.numEl());
		assertEquals(1, rubrica.aggiungi("Mattia = 345216789"));
		assertEquals(2, rubrica.numEl());
	}

	@Test
	public void testAggiuntaMassima() {
//		System.out.println("AGGIUNTA_MASSIMA");
		assertEquals(1, rubrica.aggiungi("Mattia = 345216789"));
		assertEquals(1, rubrica.numEl());
		assertEquals(1, rubrica.aggiungi("Roberta = 312789560"));
		assertEquals(2, rubrica.numEl());
		assertEquals(1, rubrica.aggiungi("Alice = 333214576"));
		assertEquals(3, rubrica.numEl());
		assertEquals(1, rubrica.aggiungi("Matteo = 312456712"));
		assertEquals(4, rubrica.numEl());
		assertEquals(1, rubrica.aggiungi("Enzo = 367891239"));
		assertEquals(5, rubrica.numEl());
	}

	@Test
	public void testAggiuntaOltreLimite() {
//		System.out.println("AGGIUNTA_OLTRE_LIMITE");
		assertEquals(1, rubrica.aggiungi("Martina = 346789123"));
		assertEquals(1, rubrica.numEl());
		assertEquals(1, rubrica.aggiungi("Sara = 331452673"));
		assertEquals(2, rubrica.numEl());
		assertEquals(1, rubrica.aggiungi("Lucia = 333123789"));
		assertEquals(3, rubrica.numEl());
		assertEquals(1, rubrica.aggiungi("Margherita = 334331245"));
		assertEquals(4, rubrica.numEl());
		assertEquals(1, rubrica.aggiungi("Noemi = 345123879"));
		assertEquals(5, rubrica.numEl());
		assertEquals(1, rubrica.aggiungi("Graziella = 331456234"));
		assertEquals(6, rubrica.numEl());
		assertEquals(-1, rubrica.aggiungi("Paolo = 331456234"));
		assertEquals(6, rubrica.numEl());
	}

	@Test
	public void testAggiuntaGiaPresente() {
//		System.out.println("AGGIUNTA_GIA_PRESENTE");
		rubrica.aggiungi("Martina = 346789123");
		assertEquals(1, rubrica.numEl());
		rubrica.aggiungi("Sara = 331452673");
		assertEquals(2, rubrica.numEl());
		rubrica.aggiungi("Marco = 345678123");
		assertEquals(3, rubrica.numEl());
		assertEquals(0, rubrica.aggiungi("Martina = 346789123"));
		assertEquals(3, rubrica.numEl());
		assertEquals(0, rubrica.aggiungi("Marco = 345678123"));
		assertEquals(3, rubrica.numEl());
	}

	@Test
	public void cercaRubricaVuota() {
//		System.out.println("CERCA_VUOTA");
		assertEquals(0, rubrica.cerca("Sat").size());
		assertEquals(0, rubrica.numEl()); // Non ci sono stringhe
	}

	@Test
	public void testRicerca() {
//		System.out.println("RICERCA");
		addElementiRubricaStatica(); // Aggiunge 6 elementi alla rubrica
		assertEquals(2, rubrica.cerca("Giov").size()); // Presente come primo e
														// ultimo
		assertEquals(1, rubrica.cerca("Sara").size());
		assertEquals(0, rubrica.cerca("Sat").size()); // Non ci sono stringhe
														// con questo prefisso
		assertEquals(0, rubrica.cerca("123").size()); // ma ce ne sono che lo
														// contengono
		assertEquals(3, rubrica.cerca("G").size());
		assertEquals(1, rubrica.cerca("Giorgio=7689453201").size());
		assertEquals(0, rubrica.cerca("Giorgio=7689453200").size()); // Confrontare
																		// con
																		// precedente
		assertEquals(6, rubrica.cerca("").size()); // Tutte le stringhe inizano
													// con la stringa vuota
	}

	@Test
	public void testEliminaVuota() {
//		System.out.println("ELIMINA_VUOTA");
		assertFalse(rubrica.elimina("Giov"));
		assertEquals(0, rubrica.numEl()); // Non ci sono stringhe
		assertFalse(rubrica.elimina("")); // Li rimuove tutti
		assertEquals(0, rubrica.numEl()); // Non ci sono piu' stringhe
	}

	@Test
	public void testElimina() {
//		System.out.println("ELIMINA");
		addElementiRubricaStatica(); // Aggiunge 6 elementi alla rubrica
		assertTrue(rubrica.elimina("")); // Li rimuove tutti
		assertEquals(0, rubrica.numEl()); // Non ci sono piu' stringhe
		addElementiRubricaStatica(); // Ri-aggiunge 6 elementi alla rubrica
		assertTrue(rubrica.elimina("Giov"));
		assertEquals(4, rubrica.numEl());
		assertFalse(rubrica.elimina("Sat"));
		assertEquals(4, rubrica.numEl());
		assertFalse(rubrica.elimina("Giorgio=7689453200"));
		assertEquals(4, rubrica.numEl());
		assertTrue(rubrica.elimina("Giorgio=7689453201"));
		assertEquals(3, rubrica.numEl());
		assertTrue(rubrica.elimina("E"));
		assertTrue(rubrica.elimina("S"));
		assertTrue(rubrica.elimina("P"));
		assertEquals(0, rubrica.numEl());
	}

	private void addElementiRubricaStatica() {
		rubrica.aggiungi("Giovanni=0123456789");
		rubrica.aggiungi("Enzo=4593782610");
		rubrica.aggiungi("Paola=0123456789");
		rubrica.aggiungi("Sara=0354768912");
		rubrica.aggiungi("Giorgio=7689453201");
		rubrica.aggiungi("Giovanni=0123456784");
	}
}