package test.algorithms.sorting;

import java.util.Arrays;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import algorithms.sorting.InsertionSort;
import static org.junit.Assert.assertEquals;

public class InsertionSortTest {
	
	private InsertionSort<Integer> insertionSort;

	@Before
	public void setUp() throws Exception {
		insertionSort = new InsertionSort<>();
	}

	@After
	public void tearDown() throws Exception {
		insertionSort = null;
	}

	@Test
	public void testDirectInsertSort() {
		Integer[] array = new Integer[]{44, 55, 12, 42, 94, 18, 06, 67};
		insertionSort.directInsertSort(array);
		
		assertEquals("sorted correctly", "[6, 12, 18, 42, 44, 55, 67, 94]", Arrays.toString(array));
	}

	@Test
	public void testShellSort() {
		Integer[] array = new Integer[]{17,	12,	21,	15,	27,	22,	42,	24,	47,	37,	52,	43};
		insertionSort.shellSort(array, 2);
		
		assertEquals("sorted correctly", "[12, 15, 17, 21, 22, 24, 27, 37, 42, 43, 47, 52]", Arrays.toString(array));
	}

}
