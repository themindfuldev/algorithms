package test.algorithms.sorting;

import static org.junit.Assert.assertEquals;

import java.util.Arrays;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import algorithms.sorting.FusionSort;

public class FusionSortTest {
	
	private FusionSort<Integer> fusionSort;

	@Before
	public void setUp() throws Exception {
		fusionSort = new FusionSort<>();
	}

	@After
	public void tearDown() throws Exception {
		fusionSort = null;
	}

	@Test
	public void testDirectInsertSort() {
		Integer[] array = new Integer[]{44, 55, 12, 42, 94, 18, 06, 67};
		fusionSort.mergeSort(array);
		
		assertEquals("sorted correctly", "[6, 12, 18, 42, 44, 55, 67, 94]", Arrays.toString(array));
	}

}
