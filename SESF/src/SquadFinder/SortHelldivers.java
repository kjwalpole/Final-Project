package SquadFinder;

import java.util.LinkedList;
import java.util.Queue;

/**
 * accept Queue of players from Driver Insertion sort players by difficulty poll
 * users from sorted Queue into LinkedLists of four Add those LinkedLists of
 * four into a LinkedList of squads return the LinkedList of squads
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

public class SortHelldivers {
	public static LinkedList<Player> sortHelldivers(Queue q) {
		LinkedList<Player> sortedPlayers = new LinkedList<>();
		int qSize = q.size();
		Player[] arr = new Player[qSize];

		// move players into an array to be sorted
		for (int i = 0; i < qSize; i++) {
			arr[i] = (Player) q.poll();
		}
		int n = arr.length;
		// insertion sort algorithm by difficulty
		for (int i = 1; i < n; ++i) {
			Player currentPlayer = (Player) arr[i];
			int key = currentPlayer.getStyle().getDiff();
			int j = i - 1;

			while (j >= 0 && arr[j].getStyle().getDiff() > key) {
				arr[j + 1] = arr[j];
				j = j - 1;
			}
			arr[j + 1] = currentPlayer;
		}
		for (int k = 0; k < arr.length; ++k) {
			sortedPlayers.add(arr[k]);
		}
		return sortedPlayers;
	}

	public static LinkedList<LinkedList> assignSquad(LinkedList<Player> l) {
		int sqSize = 4;
		LinkedList<LinkedList> squadList = new LinkedList();

		// loop for sqSize putting Players into a LinkedList
		while (l.size() > 0) {
			LinkedList<Player> squad = new LinkedList();
			while (squad.size() < sqSize) {
				squad.add(l.poll());
			}
			squadList.add(squad);
		}
		return squadList;
	}

	public static LinkedList<Player> findPlayerSquad(LinkedList<LinkedList> squads, Player user) {
		LinkedList<Player> targetSquad = new LinkedList<Player>();
		for (LinkedList s : squads) {
			LinkedList<Player> squad = s;
			for (Player player : squad) {
				if (player.equals(user)) {
					targetSquad = squad;
					break;
				}
			}
		}
		return targetSquad;
	}
}
