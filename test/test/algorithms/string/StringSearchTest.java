package test.algorithms.string;
import static org.junit.Assert.assertEquals;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import algorithms.string.StringSearch;

public class StringSearchTest {
	StringSearch stringSearch;
	
	@Before
	public void setUp() {
		stringSearch = new StringSearch();
	}
	
	@After
	public void tearDown() {
		stringSearch = null;
	}
	
	@Test
	public void testKMP() {
		assertEquals("pattern matching", true, stringSearch.KMP("paralelepipedo", "ped"));	
		assertEquals("pattern not matching", false, stringSearch.KMP("paralelepipedo", "per"));
	}
}
