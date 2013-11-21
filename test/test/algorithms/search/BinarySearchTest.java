package test.algorithms.search;

import static org.junit.Assert.assertEquals;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import algorithms.search.BinarySearch;

public class BinarySearchTest {
	private BinarySearch<Integer> binarySearch;

	@Before
	public void setUp() {
		binarySearch = new BinarySearch<>();
	}
	
	@After
	public void tearDown() {
		binarySearch = null;
	}
	
	@Test
	public void testBinarySearch() {
		binarySearch.add(10);
		binarySearch.add(20);
		binarySearch.add(30);
		binarySearch.add(40);
		binarySearch.add(50);
		binarySearch.add(60);
		binarySearch.add(70);
		binarySearch.add(80);
		binarySearch.add(90);
		
		assertEquals("Testing for valid number", 6, binarySearch.binarySearch(70));
		assertEquals("Testing for invalid number", -1, binarySearch.binarySearch(72));
	}
}
