package SquadFinder;

/** Program to generate list of random players, add users info to the list, and sort them into squads of four contained within a linkedlist
 * program returns a string of the user's assigned squad
 * @author Keegan Walpole 
 * @version 1.0
 * @since 1.0
*/
/*  
* OS: Windows 11 24H2 Build: 26100.7462
* IDE: [Eclipse 25]
* Copyright : This is my own original work 
* based on specifications issued by our instructor
* Academic Honesty: I attest that this is my original work.
* I have not used unauthorized source code, either modified or
* unmodified, nor used generative AI as a final draft. 
* I have not given other fellow student(s) access to my program.
*/

import java.util.LinkedList;
import java.util.Queue;

/**
 * Runs SESF code in a single method that can be called in HellGUI
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

public class HellProgram {
	public String hellProgram(String user, int lvl, int diff, String attitude) throws OutOfRangeException {
		RandUsername ru = new RandUsername();
		int randDiff = 0;
		int numPlayers = 100000 - 1;
		String randAttitude = "random";

		Queue<Player> playerQ = new LinkedList<>();

		// UI will prompt player for their playstyle, asking for their preferred
		// difficulty level and having a dropdown menu of attitudes to choose from
		// Possible attitudes: Calm, Serious, Goofy, Team Oriented
		Player userPlayer = new Player(user, lvl);
		Playstyle userStyle = new Playstyle(diff, attitude);
		userPlayer.setStyle(userStyle);

		// add user to playerList
		playerQ.add(userPlayer);

		// Loop to generate multiple random users
		for (int i = 0; i < numPlayers; i++) {
			String randUser = ru.genRUser();
			int randLevel = ru.randLvl();
			Playstyle randStyle = new Playstyle(randDiff, randAttitude);
			Player randPlayer = new Player(randUser, randLevel, randStyle);
			playerQ.add(randPlayer);
		}

		// sort playerList
		SortHelldivers sh = new SortHelldivers();
		LinkedList<Player> sortedPlayers = sh.sortHelldivers(playerQ);

		// assign players to squads
		LinkedList<LinkedList> squads = sh.assignSquad(sortedPlayers);

		// find user's squad
		LinkedList<Player> userSquad = sh.findPlayerSquad(squads, userPlayer);

		// turn players squad into a string
		int i = 1;
		String squadReport = new String();
		for (Player player : userSquad) {
			squadReport += "Player " + i + ":\n" + player.printPlayer() + "\n\n";
			i += 1;
		}

		return squadReport;

	}

}
