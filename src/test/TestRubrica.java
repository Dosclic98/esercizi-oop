package test;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.rules.ExpectedException;

import rubrica.Contatto;
import rubrica.EccezioneRubrica;
import rubrica.EccezioneRubricaFull;
import rubrica.EccezioneRubricaExists;
import rubrica.Rubrica;

public class TestRubrica {
	Rubrica rubrica1;
	Rubrica rubrica2;
	ExpectedException exception;
	@Before
	public void testCreazione() {
		rubrica1 = new Rubrica("Impiegati",3);
		rubrica2 = new Rubrica("Direttori",3);
		assertTrue(rubrica1.numEl()==0);
		assertTrue(rubrica2.numEl()==0);
	}
	
	@Test
	public void aggiuntaCorr() throws EccezioneRubrica{
		assertEquals(1,rubrica1.aggiungi("Mario","MarioRossi@gmail.com","123456,654321,567890"));
		assertEquals(1,rubrica2.aggiungi("Mario","MarioRossi@gmail.com","123456,654321,567890"));
	}

	@Test
	public void agiungiFull() throws EccezioneRubrica{
		add(rubrica1);
		rubrica1.aggiungi("Luigi","LuigiRossi@gmail.com","123456,654321,567890");
		exception.expect(EccezioneRubricaFull.class);
		fail();
	}

	@Test
	public void agiungiExist() throws EccezioneRubrica{
		add1(rubrica1);
		rubrica1.aggiungi("Luca","LucaRossi@gmail.com","123456,654321,567890");
		exception.expect(EccezioneRubricaExists.class);
		fail();
	}
	
	
	public void add(Rubrica rub) throws EccezioneRubrica{
		rub.aggiungi("Mario","MarioRossi@gmail.com","123456,654321,567890");
		rub.aggiungi("Luca","LucaRossi@gmail.com","123456,654321,567890");
		rub.aggiungi("Enzo","EnzoRossi@gmail.com","123456,654321,567890");
	}

	public void add1(Rubrica rub) throws EccezioneRubrica{
		rub.aggiungi("Mario","MarioRossi@gmail.com","123456,654321,567890");
		rub.aggiungi("Luca","LucaRossi@gmail.com","123456,654321,567890");
	}
	
	@Test
	public void aggiuntaRif() throws EccezioneRubrica{
		Contatto n1 = new Contatto("Mario","MarioRossi@gmail.com","123456,654321,567890");
		assertEquals(1,rubrica1.aggiungi(n1));
		assertEquals(1,rubrica2.aggiungi(n1));
		assertTrue(rubrica1.toString().equals("[Mario,MarioRossi@gmail.com,[123456, 654321, 567890]]"));
		assertTrue(rubrica1.toString().equals("[Mario,MarioRossi@gmail.com,[123456, 654321, 567890]]"));
		// Modifico il contatto e verifico che sia cambiato in entrambe le rubriche
		n1.setEmail("Mario86@gmail.com");
		n1.inserisciNumTel("348291");
		assertTrue(rubrica1.toString().equals("[Mario,Mario86@gmail.com,[123456, 654321, 567890, 348291]]"));
		assertTrue(rubrica1.toString().equals("[Mario,Mario86@gmail.com,[123456, 654321, 567890, 348291]]"));

	}
	
	@Test
	public void cercaNome() throws EccezioneRubrica{
		assertEquals(1,rubrica1.aggiungi("Mario","MarioRossi@gmail.com","123456,654321,567890"));
		assertEquals(1,rubrica1.cercaPerNome("Mar").size());
		assertEquals(0,rubrica1.cercaPerNome("Luc").size());
	}

	@Test
	public void cercaEmail() throws EccezioneRubrica{
		assertEquals(1,rubrica1.aggiungi("Mario","MarioRossi@gmail.com","123456,654321,567890"));
		assertEquals(1,rubrica1.cercaPerEmail("Mar").size());
		assertEquals(0,rubrica1.cercaPerEmail("Luc").size());		
	}

	@Test
	public void elmininaNome() throws EccezioneRubrica{
		assertEquals(1,rubrica1.aggiungi("Mario","MarioRossi@gmail.com","123456,654321,567890"));
		assertTrue(rubrica1.eliminaPerNome("Mar"));
		assertEquals(0,rubrica1.numEl());
	}

	@Test
	public void eliminaEmail() throws EccezioneRubrica{
		assertEquals(1,rubrica1.aggiungi("Luca","MarioRossi@gmail.com","123456,654321,567890"));
		assertTrue(rubrica1.eliminaPerEmail("Mar"));
		assertEquals(0,rubrica1.numEl());		
	}
	
	@After
	public void reset() {
		rubrica1 = null;
		rubrica2 = null;
	}

}
