package test;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import dosclic.utils.Giudice;
import dosclic.utils.SmartComputer;

public class TestSmartComputer {
	public SmartComputer smcomp;
	
	@Before
	public void init() {
		Giudice.init();
		smcomp = new SmartComputer();
	}
	
	@Test
	public void testLen() {
		assertEquals(5040,smcomp.getLenPoss());
	}
	
	@After
	public void reset() {
		Giudice.reset();
		smcomp = null;
	}
}
