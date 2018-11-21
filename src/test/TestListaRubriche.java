package test;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import rubrica.GestioneRubrica;

public class TestListaRubriche {
	
	@Before
	public void inizializza() {
		GestioneRubrica.inizializza();
	}
	
	@Test
	public void creazione() {
		assertEquals(1,GestioneRubrica.crea("Impiegati", 3));
		assertEquals(1,GestioneRubrica.crea("Direttori", 3));
		assertEquals(-1,GestioneRubrica.crea("Impiegati", 3));
		assertEquals(-1,GestioneRubrica.crea("Direttori", 3));
	}
	
	@Test
	public void aggiunta() {
		agg();
		assertEquals(1,GestioneRubrica.aggiungi("Impiegati", "Giovanni=123456"));
		assertEquals(1,GestioneRubrica.aggiungi("Impiegati", "Mattia = 345216789"));
		assertEquals(1,GestioneRubrica.aggiungi("Impiegati", "Roberta = 312789560"));
		assertEquals(-1,GestioneRubrica.aggiungi("Impiegati", "Luca = 345216789"));
		
		assertEquals(1,GestioneRubrica.aggiungi("Direttori", "Giovanni=123456"));
		assertEquals(0,GestioneRubrica.aggiungi("Direttori", "Giovanni=123456"));
		
		assertEquals(-2,GestioneRubrica.aggiungi("Dipendenti", "Giovanni=123456"));
	}
	
	@Test
	public void ricerca() {
		aggFill();
		assertEquals(null,GestioneRubrica.cerca("Dipendenti", "Gio"));
		assertEquals(1,GestioneRubrica.cerca("Impiegati", "Gio").size());
		assertEquals(2,GestioneRubrica.cerca("Direttori", "Gio").size());
		assertEquals(0,GestioneRubrica.cerca("Impiegati", "Mar").size());
	}
	
	@Test
	public void rimozione() {
		aggFill();
		assertEquals(1, GestioneRubrica.rimuovi("Impiegati", "Gio"));
		assertEquals(0, GestioneRubrica.rimuovi("Impiegati", "Luc"));
		assertEquals(-1, GestioneRubrica.rimuovi("Dipendenti", "Luc"));
	}
	
	@Test
	public void stampa() {
		aggFill();
		assertEquals("",GestioneRubrica.toString("Dipendenti"));
		assertEquals("[Giovanni=123456, Mattia = 345216789, Roberta = 312789560]", GestioneRubrica.toString("Impiegati"));
		assertEquals("[Giovanni=123456, Roberta = 312789560, Giovanna=123456]", GestioneRubrica.toString("Direttori"));
	}
	
	@Test
	public void elementi() {
		aggFill();
		assertEquals(-1,GestioneRubrica.numEl("Dipendenti"));
		assertEquals(3,GestioneRubrica.numEl("Impiegati"));
		assertEquals(3,GestioneRubrica.numEl("Direttori"));
	}
	
	@After
	public void reset() {
		GestioneRubrica.reset();
	}
	
	public void agg() {
		GestioneRubrica.crea("Impiegati", 3);
		GestioneRubrica.crea("Direttori", 3);
	}
	
	public void aggFill() {
		GestioneRubrica.crea("Impiegati", 3);
		GestioneRubrica.crea("Direttori", 3);
		
		GestioneRubrica.aggiungi("Impiegati", "Giovanni=123456");
		GestioneRubrica.aggiungi("Impiegati", "Mattia = 345216789");
		GestioneRubrica.aggiungi("Impiegati", "Roberta = 312789560");
		
		GestioneRubrica.aggiungi("Direttori", "Giovanni=123456");
		GestioneRubrica.aggiungi("Direttori", "Roberta = 312789560");
		GestioneRubrica.aggiungi("Direttori", "Giovanna=123456");
	}
}
