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
 * Deck Class (for creating Deck objects).
 * Standard-sized 52-card deck
 */
public class Deck {
	// will be constructed as a 52-Card array
	private Card[] theDeck;

	// cards left in the deck
	private int cardsDealt;

	/**
	 * The Deck constructor
	 */
	public Deck() {
		theDeck = new Card[52];	// create our empty array for the cards
		cardsDealt = 0;		// initialize # of cards dealt to 0
		int count = 0;		// to keep track of how many cards have been created in the deck so far

		// create the deck 
		for(int suit = 0; suit < 4; suit++) {
			for(int val = 1; val <= 13; val++) {
				theDeck[count] = new Card(val, suit);
				count++;
			}
		}
	}

	/**
	 * Shuffle the deck
	 */
	public void shuffle() {
		Random random = new Random();	// random number generator
		int pos = 0;			// to determine the position of the card later on
		Card temp;			// temporary card holder

		// ok, let's shuffle
		for(int i = 0; i < cardsLeft(); i++) {
			pos = random.nextInt(cardsLeft());
			
			// and now comes the swap
			temp = theDeck[i];
			theDeck[i] = theDeck[pos];
			theDeck[pos] = temp;
		}
	}

	/**
	 * Cut the deck
	 */
	public void cut() {
		Random random = new Random();			// random number generator
		int rand = random.nextInt(cardsLeft());	// find a place in the deck to cut
		int cont = 0;					// used to continue filling up the 2nd array
		Card temp1[] = new Card[rand];			// temporary card holder
		Card temp2[] = new Card[cardsLeft()-rand];	// temporary card holder

		// ok, let's copy over cards
		for(int i = 0; i < cardsLeft(); i++) {
			if(i >= rand) {
				temp2[cont] = theDeck[i];
				cont++;
			} else {
				temp1[i] = theDeck[i];
			}
		}

		cont = 0;

		// ok, let's copy over cards
		for(int i = 0; i < cardsLeft(); i++) {
			if(i < (cardsLeft()-rand)) {
				theDeck[i] = temp2[i];
			} else {
				theDeck[i] = temp1[cont];
				cont++;
			}
		}
	}

	/**
	 * Returns a card from the top of what's remaining in the deck
	 * @return Card
	 */
	public Card deal() {
		if(cardsDealt == theDeck.length) {
			throw new IllegalArgumentException("No more cards in deck.");
		}

		cardsDealt++;
		return theDeck[cardsDealt-1];
	}

	/**
	 * Returns the number of cards left in the deck
	 * @return number of cards left
	 */
	public int cardsLeft() {
		return theDeck.length-cardsDealt;
	}
}
