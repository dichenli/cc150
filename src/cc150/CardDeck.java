/**
 * 
 */
package cc150;
import java.util.ArrayList;
/**
 * @author dichenli
 * Design the data structures for a generic deck of cards. Explain how you would
 * subclass the data structures to implement blackjack.
 *
 */
public class CardDeck {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		CardDeck deck = new CardDeck();
		for(int i = 0; i < 54; i++) {
			System.out.println(deck.cards[i]);
		}
	}
	
	Card[] cards;
	public final int number = 54;
	
	public CardDeck() {
		cards = new Card[number];
		int i = 0;
		
		for(Rank rank : Rank.values()) {
			if(rank == Rank.JOKER) {
				cards[i++] = new Card(Rank.JOKER, Suit.BLACKJOKER);
				cards[i++] = new Card(Rank.JOKER, Suit.REDJOKER);
				continue;
			}
			
			for(Suit suit : Suit.values()) {
				if(suit == Suit.BLACKJOKER || suit == Suit.REDJOKER) {
					continue;
				}
				cards[i] = new Card(rank, suit);
//				System.out.println(cards[i]);
				i++;
			}
		}
	}
	
	private class Card {
		Suit suit;
		Rank rank;
		
		private Card(Rank rank, Suit suit) {
			this.suit = suit;
			this.rank = rank;
		}
		
		@Override
		public String toString() {
			return suit.getName() + rank.getName();
		}
	}

	enum Suit {
		HEART("heart"), 
		DIAMOND("diamond"), 
		CLUB("club"), 
		SPADE("spade"), 
		BLACKJOKER("black joker"),
		REDJOKER("red joker");
		
		private final String name;
		
		private Suit(String name) {
			this.name = name;
		}
		
		public String getName() {
			return name;
		}
	}
	
	enum Rank {
		ACE("A"),
		TWO("2"),
		THREE("3"),
		FOUR("4"),
		FIVE("5"),
		SIX("6"),
		SEVEN("7"),
		EIGHT("8"),
		NINE("9"),
		TEN("10"),
		PRINCE("J"),
		QUEEN("Q"),
		KING("K"),
		JOKER("joker");
		
		private final String name;
		
		Rank(String name) {
			this.name = name;
		}
		
		String getName() {
			return name;
		}
	}
}
