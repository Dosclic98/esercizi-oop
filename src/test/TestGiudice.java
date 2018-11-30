package test;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import dosclic.utils.Giudice;

public class TestGiudice {

	@Before
	public void init() {
		Giudice.init();
	}
	
	@Test
	public void testLunghezza() {
		assertTrue(Giudice.valida("1456"));
		assertFalse(Giudice.valida("e6"));
		assertFalse(Giudice.valida(""));
		assertFalse(Giudice.valida("097523"));
	}
	
	@Test
	public void testCaratteriLunghezza() {
		assertTrue(Giudice.valida("3617"));     
		assertFalse(Giudice.valida("i907"));     
		assertFalse(Giudice.valida("567!"));     
		assertFalse(Giudice.valida("ab%t"));     
	}
	
	@Test
	public void testValida() {
		assertFalse(Giudice.valida("1111"));
		assertFalse(Giudice.valida("0999"));
		assertFalse(Giudice.valida("8718"));
		assertTrue(Giudice.valida("1234"));
		assertTrue(Giudice.valida("8719"));
	}

	@Test
	public void testBulls() {
		assertTrue(Giudice.numBulls("1234", "5678")==0);
		assertTrue(Giudice.numBulls("1234", "1876")==1);
		assertTrue(Giudice.numBulls("1234", "9874")==1);
		assertTrue(Giudice.numBulls("1234", "9243")==1);
		assertTrue(Giudice.numBulls("9876", "5573")==1);
		assertTrue(Giudice.numBulls("1234", "1256")==2);
		assertTrue(Giudice.numBulls("1234", "1537")==2);
		assertTrue(Giudice.numBulls("1234","1764")==2);
		assertTrue(Giudice.numBulls("1234", "8237")==2);
		assertTrue(Giudice.numBulls("1234", "9834")==2);
		assertTrue(Giudice.numBulls("9264", "9261")==3);
		assertTrue(Giudice.numBulls("9264", "9284")==3);
		assertTrue(Giudice.numBulls("9264", "9764")==3);
		assertTrue(Giudice.numBulls("9264", "5264")==3);
		assertTrue(Giudice.numBulls("9264", "9264")==4);
		assertTrue(Giudice.numBulls("8725", "8725")==4);	
	}
	
	@Test
	public void testTarget() {
		assertTrue(Giudice.valida(Giudice.genTarget()));
		System.out.println(Giudice.genTarget());
		assertTrue(Giudice.valida(Giudice.genTarget()));
		System.out.println(Giudice.genTarget());
	}
	
	@Test
	public void testMaggots(){
		// System.out.println(Giudice.numMaggots("1234", "1234"));
		assertTrue(Giudice.numMaggots("1234", "1234")==0);
		assertTrue(Giudice.numMaggots("1234", "4321")==4);
		assertTrue(Giudice.numMaggots("8234", "3746")==2);
		assertTrue(Giudice.numMaggots("8234", "9763")==1);
		assertTrue(Giudice.numMaggots("1234", "2345")==3);
	}

	@After
	public void reset() {
		Giudice.reset();
	}

}
