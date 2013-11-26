package test.algorithms.string;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import algorithms.string.CharacterBridge;

public class CharacterBridgeTest {

	private CharacterBridge characterBridge;

	@Before
	public void setUp() throws Exception {
		characterBridge = new CharacterBridge();
	}

	@After
	public void tearDown() throws Exception {
		characterBridge = null;
	}

	@Test
	public void test() {
		assertEquals("+++++-ba--c++--+++++-", characterBridge.makeCharacterBridge("a--aa-ba--cbb--c---c-"));
	}

}
