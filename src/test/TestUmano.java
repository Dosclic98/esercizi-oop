package test;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import dosclic.utils.Umano;
import dosclic.utils.Giudice;

public class TestUmano {
	public Umano uman = null;
	
	@Before
	public void init() {
		Giudice.init();
		uman = new Umano();
	}
	
	@Test
	public void testGenTar() {
		assertTrue(Giudice.valida( uman.getTarget() ));
	}

	@Test
	public void testGenGuess() {
		assertTrue(Giudice.valida( uman.genGuess() ));
	}
	
	@Test
	public void testTent() {
		uman.addTentativo("1234", 0, 0);
		assertEquals("Tentativo 0: [guess=1234, bulls=0, maggots=0]\n",uman.toString());
	}
	
	@After
	public void reset() {
		uman = null;
		Giudice.reset();
	}
	
}
