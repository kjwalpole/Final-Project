package SquadFinder;

/**
 * Player class for use with the Super Earth Squad Finder
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

public class Player {
	// members
	private String name; // player's user name
	private int level; // player's level
	Playstyle style;

	// constructors
	// default
	public Player() {
		this.name = "";
		this.level = 0;
	}

	/**
	 * @param name
	 * @param level define player without playstyle class
	 * @throws OutOfRangeException
	 */
	public Player(String name, int level) throws OutOfRangeException {
		this.name = name;
		this.setLevel(level);
	}

	/**
	 * @param name
	 * @param level
	 * @param style define player with playstyle class
	 * @throws OutOfRangeException
	 */
	public Player(String name, int level, Playstyle style) throws OutOfRangeException {
		this.name = name;
		this.setLevel(level);
		this.style = style;
	}

	// getters and setters

	/**
	 * @return name
	 */
	public String getName() {
		return name;
	}

	/**
	 * @param name
	 */
	public void setName(String name) {
		this.name = name;
	}

	/**
	 * @return level
	 */
	public int getLevel() {
		return level;
	}

	/**
	 * @param level range of levels from 1 to 150
	 */
	public void setLevel(int level) throws OutOfRangeException {
		if (level > 0 && level < 151) {
			this.level = level;
		} else {
			throw new OutOfRangeException();
		}
	}

	/**
	 * @return playstyle
	 */
	public Playstyle getStyle() {
		return style;
	}

	/**
	 * @param Playstyle
	 */
	public void setStyle(Playstyle style) {
		this.style = style;
	}

	public String printPlayer() {
		String item = "";
		item += "User: " + this.getName() + "\nLevel: " + this.getLevel() + "\n" + this.getName() + " is "
				+ style.printPlaystyle();
		return item;
	}

}
