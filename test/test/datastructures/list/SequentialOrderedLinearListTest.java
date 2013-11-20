package test.datastructures.list;

import static org.junit.Assert.*;

import org.junit.Test;

import datastructures.list.LinearList;
import datastructures.list.SequentialOrderedLinearList;

public class SequentialOrderedLinearListTest {

	@Test
	public void testAll() {
		LinearList<Integer> list = new SequentialOrderedLinearList<>();
		
		list.insertLast(2);
		list.insertLast(3);
		list.insertLast(1);
		list.insertLast(5);
		list.insertLast(4);
		list.insertLast(0);
		list.insertLast(7);
		list.insertLast(3);
		list.insertLast(0);		
		assertEquals("Adding and listing", "0,0,1,2,3,3,4,5,7", list.print());
		
		list.remove(new Integer(5));
		assertEquals("Removing", "0,0,1,2,3,3,4,7", list.print());
		
		list.remove(new Integer(0));
		assertEquals("Removing duplicated element", "0,1,2,3,3,4,7", list.print());
	}

}
