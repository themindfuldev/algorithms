package test.datastructures.tree;

import static org.junit.Assert.assertEquals;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import datastructures.tree.BinaryTree;

public class BinaryTreeTest {
	
	BinaryTree<Integer> tree;
	
	@Before
	public void setUp() {
		tree = new BinaryTree<>();
	}
	
	@After
	public void tearDown() {
		tree = null;
	}
	
	@Test
	public void testPrintInOrder() {
		tree.insert(5);
		tree.insert(3);
		tree.insert(8);
		tree.insert(7);
		
		assertEquals("printing in order", "3, 5, 7, 8", tree.printInOrder());
	}
	
	@Test
	public void testPrintBreadth() {
		tree.insert(5);
		tree.insert(3);
		tree.insert(8);
		tree.insert(7);
		
		assertEquals("printing in breadth", "5, 3, 8, 7", tree.printBreadth());
	}
	
	@Test
	public void testFindMinimum() {
		tree.insert(5);
		tree.insert(3);
		tree.insert(8);
		tree.insert(7);
		tree.insert(4);
		tree.insert(2);
		tree.insert(6);
		
		assertEquals("finding minimum", new Integer(2), tree.findMinimum());
	}
	
	@Test
	public void testFindMaximum() {
		tree.insert(5);
		tree.insert(3);
		tree.insert(8);
		tree.insert(7);
		tree.insert(2);
		tree.insert(6);
		tree.insert(4);
		
		assertEquals("finding maximum", new Integer(8), tree.findMaximum());
	}
	
	@Test
	public void testDelete() {
		tree.insert(5);
		tree.insert(3);
		tree.insert(8);
		tree.insert(7);
		tree.insert(2);
		tree.insert(6);
		tree.insert(4);
		
		tree.delete(5);
		assertEquals("deleting root node", "7, 3, 8, 2, 4, 6", tree.printBreadth());
		tree.delete(8);
		assertEquals("deleting node with children", "7, 3, 6, 2, 4", tree.printBreadth());
		tree.delete(2);
		assertEquals("deleting leaf node", "7, 3, 6, 4", tree.printBreadth());
		tree.delete(1);
		assertEquals("deleting invalid node", "7, 3, 6, 4", tree.printBreadth());
	}
	
	@Test
	public void testPredecessor() {
		tree.insert(5);
		tree.insert(3);
		tree.insert(8);
		tree.insert(7);
		tree.insert(2);
		tree.insert(6);
		tree.insert(4);
		
		assertEquals("verifying predecessor", new Integer(4), tree.predecessor(5));
	}
	
	@Test
	public void testSuccessor() {
		tree.insert(5);
		tree.insert(3);
		tree.insert(8);
		tree.insert(7);
		tree.insert(2);
		tree.insert(6);
		tree.insert(4);
		
		assertEquals("verifying sucessor", new Integer(7), tree.successor(6));
	}
	
}