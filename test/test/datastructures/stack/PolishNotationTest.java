package test.datastructures.stack;

import static org.junit.Assert.assertEquals;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import datastructures.stack.PolishNotation;

public class PolishNotationTest {
	
	PolishNotation polishNotation;
	
	@Before
	public void setUp() {
		polishNotation = new PolishNotation();
	}
	
	@After
	public void tearDown() {
		polishNotation = null;
	}
	
	@Test
	public void testConvertInfixToPrefix() {
		assertEquals("Verifying basic case", "+12", polishNotation.convertInfixToPrefix("1+2"));
		assertEquals("Verifying intermediate case", "+1-*23/$456", polishNotation.convertInfixToPrefix("1+2*3-4$5/6"));
		assertEquals("Verifying advanced case", "+-*$ABCD//EF+GH", polishNotation.convertInfixToPrefix("A$B*C-D+E/F/(G+H)"));
	}
}
