package test.algorithms.backtracking;

import static org.junit.Assert.assertEquals;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import algorithms.backtracking.HanoiTower;

public class HanoiTowerTest {
	private HanoiTower hanoiTower;

	@Before
	public void setUp() {
		hanoiTower = new HanoiTower();
	}
	
	@After
	public void tearDown() {
		hanoiTower = null;
	}
	
	@Test
	public void testConvertInfixToPrefix() {
		String solution3 = "1->3\n1->2\n3->2\n1->3\n2->1\n2->3\n1->3\n";
		assertEquals("Testing for 3 disks", solution3, hanoiTower.hanoi(3, 1, 3));
	}
}
