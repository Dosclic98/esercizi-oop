package test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import dosclic.utils.Computer;
import dosclic.utils.Giudice;
public class TestComputer {
	public Computer comp = null;
	
	@Before
	public void init() {
		Giudice.init();
		comp = new Computer();
	}

	@Test
	public void testGenTar() {
		assertTrue(Giudice.valida( comp.getTarget() ));
	}

	@Test
	public void testGenGuess() {
		assertTrue(Giudice.valida( comp.genGuess() ));
	}
	
	@Test
	public void testTent() {
		comp.addTentativo("1234", 0, 0);
		assertEquals("Tentativo 0: [guess=1234, bulls=0, maggots=0]\n",comp.toString());
	}
	
	@After
	public void reset() {
		comp = null;
		Giudice.reset();
	}
}
