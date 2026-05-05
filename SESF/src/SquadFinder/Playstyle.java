package SquadFinder;

import java.util.Random;

/**
 * Playstyle class for use with the Super Earth Squad Finder
 * 
 * @author Keegan Walpole
 * @version 1.0
 * @since 1.0
 */
/*
 * OS: Windows 11 24H2 Build: 26100.7462 IDE: [Eclipse 25] Copyright : This is
 * my own original work based on specifications issued by our instructor
 * Academic Honesty: I attest that this is my original work. I have not used
 * unauthorized source code, either modified or unmodified, nor used generative
 * AI as a final draft. I have not given other fellow student(s) access to my
 * program.
 */

public class Playstyle {
	// members
	private int diff = 0; // Preferred Difficulty
	private int tudeKey = 0; // Attitude as an int
	private String diffTitle = new String(); // Title of the indicated difficulty
	private String attitude = new String(); // attitude when playing
	Random rand = new Random();

	// Constructors
	// Default
	public Playstyle() {
		this.diff = 0;
		this.diffTitle = null;
		this.attitude = null;
	}

	/**
	 * @param diff
	 * @param attitude
	 * @throws OutOfRangeException
	 */
	public Playstyle(int diff, String attitude) throws OutOfRangeException {
		setDiff(diff);
		setAttitude(attitude);
	}

	// Getters & Setters

	/**
	 * @return difficulty as an int
	 */
	public int getDiff() {
		return diff;
	}

	/**
	 * @param diff, difficulty only goes from 1 to 10
	 */
	public void setDiff(int diff) throws OutOfRangeException {
		// check if diff is within the acceptable range
		if (diff > 0 && diff < 11) {
			this.diff = diff;
			// set diffTitle to be the string associated with the difficulty
			// 1:Trivial | 2:Easy | 3:Medium | 4:Challenging | 5:Hard | 6:Extreme |
			// 7:Suicide Mission | 8:Impossible | 9:Helldive | 10:Super Helldive
			switch (diff) {
			case 1:
				this.diffTitle = "Trivial";
				break;
			case 2:
				this.diffTitle = "Easy";
				break;
			case 3:
				this.diffTitle = "Medium";
				break;
			case 4:
				this.diffTitle = "Challenging";
				break;
			case 5:
				this.diffTitle = "Hard";
				break;
			case 6:
				this.diffTitle = "Extreme";
				break;
			case 7:
				this.diffTitle = "Suicide Mission";
				break;
			case 8:
				this.diffTitle = "Impossible";
				break;
			case 9:
				this.diffTitle = "Helldive";
				break;
			case 10:
				this.diffTitle = "Super Helldive";
				break;
			}

		} else if (diff == 0) {
			// generate random difficulty
			int randDiff = rand.nextInt((10 - 1) + 1) + 1;
			this.setDiff(randDiff);

		} else
			throw new OutOfRangeException();
	}

	/**
	 * @return diffTitle as a string
	 */
	public String getDiffTitle() {
		return diffTitle;
	}

	/**
	 * @return attitude as a string
	 */
	public String getAttitude() {
		return attitude;
	}

	/**
	 * @param attitude String denoting how the player acts while playing Accepted
	 *                 attitudes are: Calm, Serious, Goofy, Team Oriented
	 */
	public void setAttitude(String attitude) throws OutOfRangeException {
		// Check if input is a valid attitude
		if (attitude.equals("random")) {
			// System.out.println("Random Attitude Selected");
			int randTude = rand.nextInt((4 - 1) + 1) + 1;
			switch (randTude) {
			case 1:
				this.setAttitude("Calm");
				this.setTudeKey(1);
				break;
			case 2:
				this.setAttitude("Serious");
				this.setTudeKey(2);
				break;
			case 3:
				this.setAttitude("Goofy");
				this.setTudeKey(3);
				break;
			case 4:
				this.setAttitude("Team Oriented");
				this.setTudeKey(4);
				break;
			}
		} else if (attitude.equals("Calm")) {
			this.attitude = attitude;
			this.setTudeKey(1);
		} else if (attitude.equals("Serious")) {
			this.attitude = attitude;
			this.setTudeKey(2);
		} else if (attitude.equals("Goofy")) {
			this.attitude = attitude;
			this.setTudeKey(3);
		} else if (attitude.equals("Team Oriented")) {
			this.attitude = attitude;
			this.setTudeKey(4);
		} else
			throw new OutOfRangeException();

	}

	public String printPlaystyle() {
		String item = new String();
		item = getAttitude() + " and prefers difficulty " + getDiff() + ": " + getDiffTitle();
		return item;
	}

	public int getTudeKey() {
		return tudeKey;
	}

	public void setTudeKey(int tudeKey) {
		this.tudeKey = tudeKey;
	}

}
