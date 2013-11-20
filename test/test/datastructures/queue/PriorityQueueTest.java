package test.datastructures.queue;

import static org.junit.Assert.assertEquals;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import datastructures.queue.PriorityQueue;

public class PriorityQueueTest {
	
	PriorityQueue<Integer> queue;
	
	@Before
	public void setUp() {
		queue = new PriorityQueue<>();
	}
	
	@After
	public void tearDown() {
		queue = null;
	}
	
	@Test
	public void testAll() {
		queue.insert(30, 1);
		queue.insert(20, 1);
		queue.insert(23, 1);
		queue.insert(33, 1);
		queue.insert(30, 2);
		queue.insert(35, 3);
		queue.insert(50, 0);
		queue.insert(40, 0);
		queue.insert(30, 0);
		
		assertEquals("Verifying insert", "[0]->30->40->50\n[1]->20->23->30->33\n[2]->30\n[3]->35\n", queue.print());
		assertEquals("Verifying findMinimum", new Integer(30), queue.findMinimum(0));
		assertEquals("Verifying deleteMinimum", new Integer(20), queue.deleteMinimum(1));
		assertEquals("Verifying insert", "[0]->30->40->50\n[1]->23->30->33\n[2]->30\n[3]->35\n", queue.print());
	}
}
