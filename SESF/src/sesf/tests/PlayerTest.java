package sesf.tests;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

import SquadFinder.OutOfRangeException;
import SquadFinder.Player;
import SquadFinder.Playstyle;

class PlayerTest {

	@Test
	void testPlayer() {
		// ARRANGE
		Player p = new Player();
		String actualName, expectedName;
		int actualLevel, expectedLevel;
		expectedName = "";
		expectedLevel = 0;
		// ACT
		actualName = p.getName();
		actualLevel = p.getLevel();
		// ASSERT
		assertEquals(expectedName, actualName);
		assertEquals(expectedLevel, actualLevel);
	}

	@Test
	void testPlayerStringInt() throws OutOfRangeException {
		// ARRANGE
		Player p = new Player("John", 25);
		String actualName, expectedName;
		int actualLevel, expectedLevel;
		expectedName = "John";
		expectedLevel = 25;
		// ACT
		actualName = p.getName();
		actualLevel = p.getLevel();
		// ASSERT
		assertEquals(expectedName, actualName);
		assertEquals(expectedLevel, actualLevel);
	}

	@Test
	void testPlayerStringIntPlaystyle() throws OutOfRangeException {
		// ARRANGE
		Playstyle s = new Playstyle(4, "Calm");
		Player p = new Player("John", 25, s);
		Playstyle actualPs, expectedPs;
		String actualName, expectedName;
		int actualLevel, expectedLevel;
		expectedName = "John";
		expectedLevel = 25;
		expectedPs = s;
		// ACT
		actualName = p.getName();
		actualLevel = p.getLevel();
		actualPs = p.getStyle();
		// ASSERT
		assertEquals(expectedName, actualName);
		assertEquals(expectedLevel, actualLevel);
		assertEquals(expectedPs, actualPs);
	}

	@Test
	void testGetName() {
		// ARRANGE
		Player p = new Player();
		p.setName("John");
		String actualName, expectedName;
		expectedName = "John";
		// ACT
		actualName = p.getName();
		// ASSERT
		assertEquals(expectedName, actualName);
	}

	@Test
	void testSetName() {
		// ARRANGE
		Player p = new Player();
		String actualName, expectedName;
		expectedName = "John";
		// ACT
		p.setName(expectedName);
		actualName = p.getName();
		// ASSERT
		assertEquals(expectedName, actualName);
	}

	@Test
	void testGetLevel() {
		// ARRANGE
		Player p = new Player();
		int actual, expected;
		expected = 0;
		// ACT
		actual = p.getLevel();
		// ASSERT
		assertEquals(expected, actual);
	}

	@Test
	void testSetLevel() throws OutOfRangeException {
		// ARRANGE
		Player p = new Player();
		int actual, expected;
		expected = 47;
		// ACT
		p.setLevel(expected);
		actual = p.getLevel();
		// ASSERT
		assertEquals(expected, actual);
	}

	@Test
	void testGetStyle() throws OutOfRangeException {
		// ARRANGE
		Playstyle s = new Playstyle(4, "Calm");
		Player p = new Player("John", 4, s);
		Playstyle expected, actual;
		expected = s;
		// ACT
		actual = p.getStyle();
		// ASSERT
		assertEquals(expected, actual);
	}

	@Test
	void testSetStyle() throws OutOfRangeException {
		// ARRANGE
		Playstyle s = new Playstyle(4, "Calm");
		Player p = new Player();
		Playstyle expected, actual;
		expected = s;
		// ACT
		p.setStyle(s);
		actual = p.getStyle();
		// ASSERT
		assertEquals(expected, actual);
	}

	@Test
	void testPrintPlayer() throws OutOfRangeException {
		// ARRANGE
		Playstyle s = new Playstyle(4, "Calm");
		Player p = new Player("John", 47, s);
		String expected, actual;
		expected = "User: John\nLevel: 47\nJohn is Calm and prefers difficulty 4: Challenging";
		// ACT
		actual = p.printPlayer();
		// ASSERT
		assertEquals(expected, actual);
	}

}
