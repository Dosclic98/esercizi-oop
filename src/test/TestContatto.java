package test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;

import org.junit.After;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

import rubrica.Contatto;
import rubrica.EccezioneContatto;

public class TestContatto {
	
	Contatto prova;
	@Rule
	public ExpectedException exception = ExpectedException.none();
	
	@Before
	public void crea() throws EccezioneContatto {
		prova = new Contatto("Mario","MarioRossi@gmail.com","123456,654321,567890");
		assertTrue(prova.nome.equals("Mario"));
		assertTrue(prova.getEmail().equals("MarioRossi@gmail.com"));
		assertTrue(prova.numTel().equals("[123456, 654321, 567890]"));
	}
	
	@Test
	public void testExceptionNome() throws EccezioneContatto {
		exception.expect(EccezioneContatto.class);
		exception.expectMessage("Nome Contatto invalido");
		prova = new Contatto("Marco23");
		fail();
	}

	@Test
	public void testExceptionEmail() throws EccezioneContatto {
		exception.expect(EccezioneContatto.class);
		exception.expectMessage("Email Contatto invalido");
		prova = new Contatto("Marco","MarcoRossi@123.com");
		fail();
		
	}

	@Test
	public void testExceptionTelefono() throws EccezioneContatto {
		exception.expect(EccezioneContatto.class);
		exception.expectMessage("Numero Contatto invalido");
		prova = new Contatto("Marco","MarcoRossi@gmail.com","123456,ciao");
		fail();
		
	}

	
	@Test
	public void testEquals() throws EccezioneContatto {
		// Controlla se il contatto c'�
		Contatto confr = new Contatto("Mario","MarioRossi@gmail.com","123456,654321,567890");
		assertTrue(prova.equals(confr));
		// Controlla se non da errori dato un contatto nullo
		confr=null;
		assertFalse(prova.equals(confr));

		confr= new Contatto("Luca","LucaBianchi@gmail.com","123456,654321,567890");
		assertFalse(prova.equals(confr));
	}

	@Test
	public void testTel() {
		prova.inserisciNumTel("678901");
		assertEquals("[123456, 654321, 567890, 678901]",prova.numTel());
		prova.eliminaNumTel("567890");
		assertEquals("[123456, 654321, 678901]",prova.numTel());
		prova.eliminaNumTel("567896");
		assertEquals("[123456, 654321, 678901]",prova.numTel());
	}
	
	@Test
	public void testEmail() {
		prova.setEmail("LucaBianchi@libero.it");
		assertTrue(prova.getEmail().equals("LucaBianchi@libero.it"));
	}
	
	@After
	public void reset() {
		prova = null;
	}
	

}
