/*
	This program is free software: you can redistribute it and/or modify
	it under the terms of the GNU General Public License as published by
	the Free Software Foundation, either version 3 of the License, or
	(at your option) any later version.

	This program is distributed in the hope that it will be useful,
	but WITHOUT ANY WARRANTY; without even the implied warranty of
	MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
	GNU General Public License for more details.

	You should have received a copy of the GNU General Public License
	along with this program.  If not, see <http://www.gnu.org/licenses/>.
*/

import java.util.Random;

/**
 * Game class
 * Runs our small Poker game - sample functionality
 * No hand evaluations implemented - only bits and pieces of pseudocode
 */
public class Game { 
	/**
	 * Our main function
	 * Example of how the Card, Deck, and Player classes can be used
	 */
	public static void main(String[] args) {
		Deck deck = new Deck();					// get a new deck
		Player players[] = new Player[5];			// we have 5 players that would like to play
		Card tableCards[] = new Card[5];			// our table cards

		for(int i = 0; i < 5; i++) {				// have them all sit down at the table
			players[i] = new Player();
		}	

		System.out.println("Welcome to \"The Poker Game\".");

		// let's play 3 rounds of poker
		for(int rnd = 0; rnd < 3; rnd++) {
			System.out.println("Starting Round " + (rnd+1) + "...");
			System.out.println("Shuffling the deck.");
			deck.shuffle();					// shuffle the deck

			System.out.println("Cutting the deck.");
			deck.cut();					// cut the deck
			
			for(int i = 0; i < 2; i++) {			// deal 2 cards to each of them, one at a time like in a real game
				for(int j = 0; j < players.length; j++) {
					players[j].takeCard(deck);
					deck.shuffle();			// why not? :P
					deck.cut();			// why not? :P
				}
			}

			System.out.println("Table cards:");

			for(int i = 0; i < players.length; i++) {	// deal the 5 table cards and display them
				tableCards[i] = deck.deal();
				System.out.println("\t" + tableCards[i].toStr());
			}

			Random rand = new Random();
			players[rand.nextInt(players.length)].fold();	// random player folds

			for(int i = 0; i < players.length; i++) {	// output all players' hands
				System.out.println("Player " + i + " has: \n" + players[i].toStr());
			}

			// pseudocode: call evaluate on each player to evaluate each hand
			// player with highest "score" or "rank" wins
			// check values of cards when there is a tie
			// otherwise players in tie all win

			for(int i = 0; i < players.length; i++) {	// reset the players' hands
				players[i].reset();
			}

			System.out.println("End of Round " + (rnd+1) + ".");
		}

		System.out.println("End of \"The Poker Game\".");

		// test some error conditions
		deck = new Deck();
		Player newplayer = new Player();

/*		System.out.println("Try dealing 53 cards. Should throw an exception.");
		int count = deck.cardsLeft()+1;
		for(int i = 0; i < count; i++) {
			System.out.println(deck.deal().toStr());
		}
*/

/*		System.out.println("Try taking 3 cards from deck. Should throw an exception.");		
		for(int i = 0; i < 3; i++) {
			newplayer.takeCard(deck);
			System.out.println(newplayer.getCard(i).toStr());
		}
*/

/*		System.out.println("Try getting non-existent card info. Should throw an exception.");		
		System.out.println(newplayer.getCard(0).toStr());
*/

/*		newplayer.takeCard(deck);
		System.out.println("Try getting 2nd card info when hasn't been drawn. Should throw an exception.");		
		System.out.println(newplayer.getCard(1).toStr());
*/
	}
}
