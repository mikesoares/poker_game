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

/**
 * Player Class (for creating players).
 */
public class Player {
	// the player's hand - I could use a vector, but an array of size 2 will suffice just fine for this
	private Card[] hand;
	private int numCards;

	/**
	 * The Player constructor
	 * @param Card first card
	 * @param Card second card
	 */
	public Player() {
		reset();
	}

	/**
	 * Adds a card to the player's hand
	 * @param The deck
	 */
	public void takeCard(Deck a) {
		if(numCards == 2) {
			throw new IllegalArgumentException("Player already has max number of cards in hand.");
		}

		hand[numCards] = a.deal();
		numCards++;
	}

	/**
	 * Player folds hands
	 */
	public void fold() {
		numCards = -1;
	}

	/**
	 * Resets the player's hand
	 */
	public void reset() {
		hand = new Card[2];
		numCards = 0;
	}

	/**
	 * Returns the number of cards the player currently has in hand
	 * @return int number of cards in hand
	 */
	public int getNumCards() {
		return numCards;
	}

	/**
	 * Returns the card in the position requested
	 * @return Card card requested
	 */
	public Card getCard(int pos) {
		if(numCards == -1) {
			throw new IllegalArgumentException("Player folded.");
		} else if(pos < 0 || pos > 1 || numCards == 0 || (pos == 1 && numCards ==1)) {
			throw new IllegalArgumentException("Card does not exist.");
		} else if(pos == 1 && numCards == 1) {
			throw new IllegalArgumentException("Player should take another card.");
		}

		return hand[pos];
	}

	/**
	 * Returns the player's hand as text
	 * @return String Player's hand
	 */
	public String toStr() {
		String handStr = "";

		if(numCards == -1) {			// folded
			return "\tFolded";
		}

		for(int i = 0; i < numCards; i++) {	// output all cards in hand
			if(i != 0) {
				handStr += "\n";
			}
			handStr += "\t" + hand[i].toStr();
		}

		return handStr;
	}

	/*
	public int evaluate(Card[] tableCards) {
		// check for flush
			// if royal flush, return highest possible score
			// if straight flush, temporarily store score as four of a kind might exist
			// if regular flush, temporarily store score as four of a kind might exist

		// check for four of a kind
			// if exists, return four of a kind score

		// check for full house
			// if exists, return full house score

		// at this point, if a regular flush exists, we can return the score for it

		// check for straight
			// if exists, return straight score

		// check for three of a kind
			// if exists, return three of a kind score

		// check for two pairs
			// if exists, return two pairs score

		// check for one pair
			// if exists, return one pair score

		// return 0 if no valid hand
	}
	*/
}
