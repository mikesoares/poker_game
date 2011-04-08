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
 * Card Class (for creating Card objects).
 * Each card has a suit (spades, hearts, clubs, or diamonds).
 * Each card has a value (A, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, J, Q, K).
 * Dealing with a standard sized 52-card deck - no jokers.
 */
public class Card {
	// the suits
	public final static int SPADES = 0;
	public final static int HEARTS = 1;
	public final static int CLUBS = 2;
	public final static int DIAMONDS = 3;

	// values of ace and face cards
	public final static int ACE = 1;
	public final static int JACK = 11;
	public final static int QUEEN = 12;
	public final static int KING = 13;

	// each card has a suit and value
	private final int suit;
	private final int value;

	/**
	 * The Card constructor
	 * @param reqVal The requested value of the card
	 * @param reqSuit The requested suit of the card
	 */
	public Card(int reqVal, int reqSuit) {
		value = reqVal;
		suit = reqSuit;
	}

	/**
	 * Returns card's value
	 * @return int card's value
	 */
	public int getVal() {
		return value;
	}

	/**
	 * Returns card's suit
	 * @return int card's suit
	 */
	public int getSuit() {
		return suit;
	}

	/**
	 * Returns card's value as a string
	 * @return String card's value as a string
	 */
	public String getValStr() {
		switch(value) {
			case 1:		return "Ace";
			case 11:	return "Jack";
			case 12:	return "Queen";
			case 13:	return "King";
			default:	return Integer.toString(value);
		}
	}

	/**
	 * Returns card's suit as a string
	 * @return String card's suit as a string
	 */
	public String getSuitStr() {
		switch(suit) {
			case SPADES: return "Spades";
			case HEARTS: return "Hearts";
			case CLUBS: return "Clubs";
			default: return "Diamonds";
		}
	}

	/**
	 * Returns card as a string
	 * @return String card as a string
	 */
	public String toStr() {
		return getValStr() + " of " + getSuitStr();
	}
}
