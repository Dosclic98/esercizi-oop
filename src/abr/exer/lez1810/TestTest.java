package abr.exer.lez1810;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import abr.exer.IndexBook;

public class TestTest extends IndexBook {

	@BeforeAll
	public void gen() {
		addNumber("Nicolas", new Number(Number.Prefix.ITALY, "0001112223"));
		addNumber("Nicolage", new Number(Number.Prefix.ITALY, "0001112224"));
		addNumber("Nicolai", new Number(Number.Prefix.ITALY, "0001112225"));
		addNumber("Nic", new Number(Number.Prefix.JAPAN, "0001112226"));
		addNumber("Dupe", new Number(Number.Prefix.ITALY, "0001112227"));
		addNumber("Dupe", new Number(Number.Prefix.ITALY, "0001112228"));
	}

	@Test
	public void testFind() {
		String[] found = find("Nicola.*");
		System.out.println(this);
		if(found.length != 3)
			Assertions.fail("length: "+found.length);
		Assertions.assertEquals(this.size(), 5);
	}

}
