package test.datastructures.list;

import static org.junit.Assert.assertEquals;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import datastructures.list.LinearList;
import datastructures.list.LinkedLinearList;

public class LinkedCircularLinearListTest {
	
	LinearList<Integer> list;
	
	@Before
	public void setUp() {
		list = new LinkedLinearList<>();
	}
	
	@After
	public void tearDown() {
		list = null;
	}

	@Test
	public void testInsert() {
		list.insert(2);
		list.insert(3);
		list.insert(1);
		list.insert(5);
		list.insert(4);
		list.insert(0);
		list.insert(7);
		list.insert(3);
		list.insert(0);		
		assertEquals("Verifying adding", "0,3,7,0,4,5,1,3,2", list.print());
		assertEquals("Verifying size", 9, list.size());
	}
	
	@Test
	public void testGet() {
		list.insert(2);
		list.insert(1);
		list.insert(1);
		
		assertEquals("Getting valid element", new Integer(2), list.get(2));
		assertEquals("Getting invalid element positive", null, list.get(5));
		assertEquals("Getting invalid element negative", null, list.get(-2));
	}
	
	@Test
	public void testRemoveElement() {
		list.insert(1);
		list.insert(1);
		list.insert(2);
		list.insert(0);
		
		assertEquals("Removing invalid element", false, list.remove(new Integer(8)));
		assertEquals("Removing valid element", true, list.remove(new Integer(2)));
		assertEquals("Verifying removal of valid element", "0,1,1", list.print());
		assertEquals("Verifying size", 3, list.size());
		
		assertEquals("Removing duplicated element", true, list.remove(new Integer(1)));
		assertEquals("Verifying removal of duplicated element", "0,1", list.print());
		assertEquals("Verifying size", 2, list.size());
		
		assertEquals("Removing first element", true, list.remove(new Integer(0)));
		assertEquals("Verifying removal of first element", "1", list.print());
		assertEquals("Verifying size", 1, list.size());
		
		assertEquals("Removing last element", true, list.remove(new Integer(1)));
		assertEquals("Verifying removal of last element", "", list.print());
		assertEquals("Verifying size", 0, list.size());
	}
	
	@Test
	public void testRemoveIndex() {
		list.insert(1);
		list.insert(1);
		list.insert(2);
		list.insert(0);
		
		assertEquals("Removing invalid element", null, list.remove(8));
		assertEquals("Removing valid element", new Integer(2), list.remove(1));
		assertEquals("Verifying removal of valid element", "0,1,1", list.print());
		assertEquals("Verifying size", 3, list.size());
		
		assertEquals("Removing duplicated element", new Integer(1), list.remove(2));
		assertEquals("Verifying removal of duplicated element", "0,1", list.print());
		assertEquals("Verifying size", 2, list.size());
		
		assertEquals("Removing first element", new Integer(0), list.remove(0));
		assertEquals("Verifying removal of first element", "1", list.print());
		assertEquals("Verifying size", 1, list.size());
		
		assertEquals("Removing last element", new Integer(1), list.remove(0));
		assertEquals("Verifying removal of last element", "", list.print());
		assertEquals("Verifying size", 0, list.size());
	}

}
