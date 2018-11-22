package test;

import static org.junit.Assert.assertTrue;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import rubrica.Contatto;

public class TestContatto {
	
	Contatto prova;
	
	@Before
	public void crea() {
		prova = new Contatto("Mario","MarioRossi@gmail.com","123456,654321,567890");
		assertTrue(prova.nome.equals("Mario"));
		assertTrue(prova.getEmail().equals("MarioRossi@gmail.com"));
		assertTrue(prova.numTel().equals("[123456, 654321, 567890]"));
	}
	
	@Test
	public void prova() {
		
	}
	
	@After
	public void reset() {
		prova = null;
	}
	

}
