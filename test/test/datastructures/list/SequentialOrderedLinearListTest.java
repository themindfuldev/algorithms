package test.datastructures.list;

import org.junit.Test;

import datastructures.list.LinearList;
import datastructures.list.SequentialOrderedLinearList;

public class SequentialOrderedLinearListTest {

	@Test
	public void testAddLast() {
		LinearList<Integer> list = new SequentialOrderedLinearList<>();
		
		list.addLast(2);
		list.addLast(3);
		list.addLast(1);
		list.addLast(5);
		list.addLast(4);
		
		System.out.println(list.print());
	}

}
