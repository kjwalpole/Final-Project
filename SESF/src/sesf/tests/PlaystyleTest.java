package sesf.tests;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

import SquadFinder.OutOfRangeException;
import SquadFinder.Playstyle;

class PlaystyleTest {

	@Test
	void testPlaystyleIntString() throws OutOfRangeException {
		// ARRANGE
		Playstyle myPlaystyle = new Playstyle(4, "Calm");
		String actual, expected;
		expected = "Calm and prefers difficulty 4: Challenging";
		// ACT
		actual = myPlaystyle.printPlaystyle();
		// ASSERT
		assertEquals(expected, actual);
	}

	@Test
	void testGetDiff() throws OutOfRangeException {
		// ARRANGE
		Playstyle myPlaystyle = new Playstyle(4, "Calm");
		int actual, expected;
		expected = 4;
		// ACT
		actual = myPlaystyle.getDiff();
		// ASSERT
		assertEquals(expected, actual);
	}

	@Test
	void testSetDiff() throws OutOfRangeException {
		// ARRANGE
		Playstyle myPlaystyle = new Playstyle();
		int actual, expected;
		expected = 6;
		// ACT
		myPlaystyle.setDiff(expected);
		actual = myPlaystyle.getDiff();
		// ASSERT
		assertEquals(expected, actual);
	}

	@Test
	void testGetDiffTitle() throws OutOfRangeException {
		// ARRANGE
		Playstyle myPlaystyle = new Playstyle(4, "Calm");
		String actual, expected;
		expected = "Challenging";
		// ACT
		actual = myPlaystyle.getDiffTitle();
		// ASSERT
		assertEquals(expected, actual);
	}

	@Test
	void testGetAttitude() throws OutOfRangeException {
		// ARRANGE
		Playstyle myPlaystyle = new Playstyle(4, "Calm");
		String actual, expected;
		expected = "Calm";
		// ACT
		actual = myPlaystyle.getAttitude();
		// ASSERT
		assertEquals(expected, actual);
	}

	@Test
	void testSetAttitude() throws OutOfRangeException {
		// ARRANGE
		Playstyle myPlaystyle = new Playstyle(4, "Calm");
		String actual, expected;
		expected = "Goofy";
		// ACT
		myPlaystyle.setAttitude(expected);
		actual = myPlaystyle.getAttitude();
		// ASSERT
		assertEquals(expected, actual);
	}

	@Test
	void testPrintPlaystyle() throws OutOfRangeException {
		// ARRANGE
		Playstyle myPlaystyle = new Playstyle(4, "Calm");
		String actual, expected;
		expected = "Calm and prefers difficulty 4: Challenging";
		// ACT
		actual = myPlaystyle.printPlaystyle();
		// ASSERT
		assertEquals(expected, actual);
	}

	@Test
	void testGetTudeKey() throws OutOfRangeException {
		Playstyle myPlaystyle = new Playstyle(4, "Calm");
		int actual, expected;
		expected = 1;
		// ACT
		actual = myPlaystyle.getTudeKey();
		// ASSERT
		assertEquals(expected, actual);
	}

	@Test
	void testSetTudeKey() throws OutOfRangeException {
		Playstyle myPlaystyle = new Playstyle(4, "Calm");
		int actual, expected;
		expected = 4;
		// ACT
		myPlaystyle.setAttitude("Team Oriented");
		actual = myPlaystyle.getTudeKey();
		// ASSERT
		assertEquals(expected, actual);
	}

}
