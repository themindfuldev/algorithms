package test.algorithms.sorting;

import static org.junit.Assert.assertEquals;

import java.util.Arrays;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import algorithms.sorting.SelectionSort;

public class SelectionSortTest {
	
	private SelectionSort<Integer> selectionSort;

	@Before
	public void setUp() throws Exception {
		selectionSort = new SelectionSort<>();
	}

	@After
	public void tearDown() throws Exception {
		selectionSort = null;
	}

	@Test
	public void testSelectSort() {
		Integer[] array = new Integer[]{17,	12,	21,	15,	27,	22,	42,	24,	47,	37,	52,	43};
		selectionSort.selectSort(array);
		
		assertEquals("sorted correctly", "[12, 15, 17, 21, 22, 24, 27, 37, 42, 43, 47, 52]", Arrays.toString(array));
	}
	
	@Test
	public void testHeapSort() {
		Integer[] array = new Integer[]{17,	12,	21,	15,	27,	22,	42,	24,	47,	37,	52,	43};
		selectionSort.heapSort(array);
		
		assertEquals("sorted correctly", "[12, 15, 17, 21, 22, 24, 27, 37, 42, 43, 47, 52]", Arrays.toString(array));
	}

}
