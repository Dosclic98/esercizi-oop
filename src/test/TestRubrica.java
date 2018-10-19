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
		assertEquals(1, Rubrica.aggiungi("Giovanni=1233456")); // oppure
		// assertTrue(Rubrica.aggiungi("Giovanni=1233456")==1);
		assertEquals(1, Rubrica.numEl()); // oppure
		// assertTrue(Rubrica.numEl()==1);
	}
	
	@Test
	public void testAggiungiContr() {
		int res=0;
		// Aggiungo MAX_DIM + 1 elementi e verifico che alla fine sia ritornato -1
		// e che ci siano solo MAX_DIM elementi
		for(int i=0;i<=Rubrica.MAX_DIM+1;i++) {
			res = Rubrica.aggiungi("Giovanni=1233456");
		}
		assertEquals(Rubrica.MAX_DIM, Rubrica.numEl());
		assertTrue(res==-1);
	}
	
	@Test
	public void testAggiungiRet() {
		int res = 2;
		res = Rubrica.aggiungiFinale("Giovanni=1233456");
		res = Rubrica.aggiungiFinale("Maria=654321");
		res = Rubrica.aggiungiFinale("Giovanni=1233456");
		assertTrue(res==0);
		assertEquals(2,Rubrica.numEl());
	}
}
