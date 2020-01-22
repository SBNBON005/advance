public class Card {

    public final static int SPADES = 0;   // Codes for the 4 suits, plus Joker.
    public final static int HEARTS = 1;
    public final static int DIAMONDS = 2;
    public final static int CLUBS = 3;

    public final static int ACE = 1;
    public final static int TWO = 2;
    public final static int THREE = 3;
    public final static int FOUR = 4;
    public final static int FIVE = 5;
    public final static int SIX = 6;
    public final static int SEVEN = 7;
    public final static int EIGHT = 8;
    public final static int NINE = 9;
    public final static int TEN = 10;
    public final static int JACK = 11;
    public final static int QUEEN = 12;
    public final static int KING = 13;

    /**
     * This card's suit, one of the constants SPADES, HEARTS, DIAMONDS,
     * CLUBS.  The suit cannot be changed after the card is
     * constructed.
     */
    private final int suit;

    /**
     * The card's value.  For a normal card, this is one of the values
     * 1 through 13, with 1 representing ACE.  The value cannot be changed after the card
     * is constructed.
     */
    private final int value;

    /**
     * Creates a card with a specified suit and value.
     * @param value the value of the new card.  For a regular card (non-joker),
     * the value must be in the range 1 through 13, with 1 representing an Ace.
     * You can use the constants Card.ACE, Card.JACK, Card.QUEEN, and Card.KING.
     * For a Joker, the value can be anything.
     * @param suit the suit of the new card.  This must be one of the values
     * Card.SPADES, Card.HEARTS, Card.DIAMONDS, Card.CLUBS.
     * @throws IllegalArgumentException if the parameter values are not in the
     * permissible ranges
     */
    public Card(int value, int suit) {
        if (suit != SPADES && suit != HEARTS && suit != DIAMONDS &&
                suit != CLUBS)
            throw new IllegalArgumentException("Illegal playing card suit");
        if ( value < 1 || value > 13)
            throw new IllegalArgumentException("Illegal playing card value");
        this.value = value;
        this.suit = suit;
    }

    /**
     * Returns the suit of this card.
     * @return the suit, which is one of the constants Card.SPADES,
     * Card.HEARTS, Card.DIAMONDS, Card.CLUBS
     */
    public int getSuit() {
        return this.suit;
    }

    /**
     * Returns the value of this card.
     * @return the value, which is one of the numbers 1 through 13, inclusive for
     * a regular card
     */
    public int getValue() {
        return value;
    }

    /**
     * Returns a String representation of the card's suit.
     * @return one of the strings "Spades", "Hearts", "Diamonds", "Clubs"
     */
    public String getSuitAsString() {
        switch ( suit ) {
            case SPADES:   return "Spades";
            case HEARTS:   return "Hearts";
            case DIAMONDS: return "Diamonds";
            case CLUBS:    return "Clubs";
            default:       return "Joker";
        }
    }

    /**
     * Returns a String representation of the card's value.
     * @return for a regular card, one of the strings "Ace", "2",
     * "3", ..., "10", "Jack", "Queen", or "King".
     */
    public String getValueAsString() {
        switch ( this.value ) {
            case 1:   return "Ace";
            case 2:   return "2";
            case 3:   return "3";
            case 4:   return "4";
            case 5:   return "5";
            case 6:   return "6";
            case 7:   return "7";
            case 8:   return "8";
            case 9:   return "9";
            case 10:  return "10";
            case 11:  return "Jack";
            case 12:  return "Queen";
            default:  return "King";
        }
    }

}
