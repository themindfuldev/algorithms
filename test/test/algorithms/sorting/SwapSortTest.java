package test.algorithms.sorting;

import static org.junit.Assert.assertEquals;

import java.util.Arrays;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import algorithms.sorting.SwapSort;

public class SwapSortTest {
	
	private SwapSort<Integer> swapSort;

	@Before
	public void setUp() throws Exception {
		swapSort = new SwapSort<>();
	}

	@After
	public void tearDown() throws Exception {
		swapSort = null;
	}

	@Test
	public void testBubbleSort() {
		Integer[] array = new Integer[]{17,	12,	21,	15,	27,	22,	42,	24,	47,	37,	52,	43};
		swapSort.bubbleSort(array);
		
		assertEquals("sorted correctly", "[12, 15, 17, 21, 22, 24, 27, 37, 42, 43, 47, 52]", Arrays.toString(array));
	}
	
	@Test
	public void testShakeSort() {
		Integer[] array = new Integer[]{17,	12,	21,	15,	27,	22,	42,	24,	47,	37,	52,	43};
		swapSort.shakeSort(array);
		
		assertEquals("sorted correctly", "[12, 15, 17, 21, 22, 24, 27, 37, 42, 43, 47, 52]", Arrays.toString(array));
	}

}
