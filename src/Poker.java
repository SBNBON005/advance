public class Poker {

    public final static int NUMBER_OF_CARDS = 5;

    public static boolean isFlush( Hand h )
    {
        if ( h.getCardCount() != NUMBER_OF_CARDS )
            return(false);   // Make sure we have 5 cards....

        h.sortBySuit();     // Sort the cards by the suit values

        return( h.getCard(0).getSuit() == h.getCard(4).getSuit() );   // All cards has same suit
    }

    public static boolean isStraight( Hand h )
    {
        int i, testRank;

        if ( h.getCardCount() != NUMBER_OF_CARDS )
            return(false);

        h.sortByValue();  // Sort the poker hand by the rank of each card

      /* ===========================
         Check if hand has an Ace
         =========================== */
        if ( h.getCard(4).getValue() == 1 )
        {
         /* =================================
            Check straight using an Ace
            ================================= */
            boolean a = h.getCard(0).getValue() == 2 && h.getCard(1).getValue() == 3 &&
                    h.getCard(2).getValue() == 4 && h.getCard(3).getValue() == 5 ;
            boolean b = h.getCard(0).getValue() == 10 && h.getCard(1).getValue() == 11 &&
                    h.getCard(2).getValue()== 12 && h.getCard(3).getValue() == 13 ;

            return ( a || b );
        }
        else
        {
         /* ===========================================
            General case: check for increasing values
            =========================================== */
            testRank = h.getCard(0).getValue() + 1;

            for ( i = 1; i < 5; i++ )
            {
                if ( h.getCard(i).getValue() != testRank )
                    return(false);        // Straight failed...

                testRank++;   // Next card in hand
            }

            return(true);        // Straight found !
        }
    }

    public static boolean is4s( Hand h )
    {
        boolean a1, a2;

        if ( h.getCardCount() != NUMBER_OF_CARDS )
            return(false);

        h.sortByValue();         // Sort by rank first

      /* ------------------------------------------------------
         Check for: 4 cards of the same rank
	            + higher ranked unmatched card
	 ------------------------------------------------------- */
        a1 = h.getCard(0).getValue() == h.getCard(1).getValue() &&
                h.getCard(1).getValue()== h.getCard(2).getValue()&&
                h.getCard(2).getValue() == h.getCard(3).getValue() ;


      /* ------------------------------------------------------
         Check for: lower ranked unmatched card
	            + 4 cards of the same rank
	 ------------------------------------------------------- */
        a2 = h.getCard(1).getValue() == h.getCard(2).getValue() &&
                h.getCard(2).getValue() == h.getCard(3).getValue() &&
                h.getCard(3).getValue() == h.getCard(4).getValue() ;

        return ( a1 || a2 );
    }

    public static boolean isFullHouse( Hand h )
    {
        boolean a1, a2;

        if ( h.getCardCount() != NUMBER_OF_CARDS )
            return(false);

        h.sortByValue();      // Sort by rank first

      /* ------------------------------------------------------
         Check for: x x x y y
	 ------------------------------------------------------- */
        a1 = h.getCard(0).getValue() == h.getCard(1).getValue()&&
                h.getCard(1).getValue() == h.getCard(2).getValue() &&
                h.getCard(3).getValue() == h.getCard(4).getValue();

      /* ------------------------------------------------------
         Check for: x x y y y
	 ------------------------------------------------------- */
        a2 = h.getCard(0).getValue() == h.getCard(1).getValue() &&
                h.getCard(2).getValue()== h.getCard(3).getValue()&&
                h.getCard(3).getValue() == h.getCard(4).getValue();

        return( a1 || a2 );
    }


    public static boolean is3s( Hand h )
    {
        boolean a1, a2, a3;

        if ( h.getCardCount() != NUMBER_OF_CARDS )
            return(false);

        if ( is4s(h) || isFullHouse(h) )
            return(false);        // The hand is not 3 of a kind (but better)

        h.sortByValue();

      /* ------------------------------------------------------
         Check for: x x x a b
	 ------------------------------------------------------- */
        a1 = h.getCard(0).getValue() == h.getCard(1).getValue() &&
                h.getCard(1).getValue() == h.getCard(2).getValue() ;

      /* ------------------------------------------------------
         Check for: a x x x b
	 ------------------------------------------------------- */
        a2 = h.getCard(1).getValue() == h.getCard(2).getValue() &&
                h.getCard(2).getValue() == h.getCard(3).getValue() ;

      /* ------------------------------------------------------
         Check for: a b x x x
	 ------------------------------------------------------- */
        a3 = h.getCard(2).getValue() == h.getCard(3).getValue() &&
                h.getCard(3).getValue() == h.getCard(4).getValue() ;

        return( a1 || a2 || a3 );
    }

    public static boolean is22s( Hand h )
    {
        boolean a1, a2, a3;

        if ( h.getCardCount() != NUMBER_OF_CARDS )
            return(false);

        if ( is4s(h) || isFullHouse(h) || is3s(h) )
            return(false);        // The hand is not 2 pairs (but better)

        h.sortByValue();

      /* --------------------------------
         Checking: a a  b b x
	 -------------------------------- */
        a1 = h.getCard(0).getValue() == h.getCard(1).getValue() &&
                h.getCard(2).getValue() == h.getCard(3).getValue() ;

      /* ------------------------------
         Checking: a a x  b b
	 ------------------------------ */
        a2 = h.getCard(0).getValue() == h.getCard(1).getValue() &&
                h.getCard(3).getValue() == h.getCard(4).getValue() ;

      /* ------------------------------
         Checking: x a a  b b
	 ------------------------------ */
        a3 = h.getCard(1).getValue() == h.getCard(2).getValue() &&
                h.getCard(3).getValue() == h.getCard(4).getValue() ;

        return( a1 || a2 || a3 );
    }

    public static boolean is2s( Hand h )
    {
        boolean a1, a2, a3, a4;

        if ( h.getCardCount() != NUMBER_OF_CARDS )
            return(false);

        if ( is4s(h) || isFullHouse(h) || is3s(h) || is22s(h) )
            return(false);        // The hand is not one pair (but better)

        h.sortByValue();

      /* --------------------------------
         Checking: a a x y z
	 -------------------------------- */
        a1 = h.getCard(0).getValue() == h.getCard(1).getValue() ;

      /* --------------------------------
         Checking: x a a y z
	 -------------------------------- */
        a2 = h.getCard(1).getValue() == h.getCard(2).getValue() ;

      /* --------------------------------
         Checking: x y a a z
	 -------------------------------- */
        a3 = h.getCard(2).getValue() == h.getCard(3).getValue() ;

      /* --------------------------------
         Checking: x y z a a
	 -------------------------------- */
        a4 = h.getCard(3).getValue() == h.getCard(4).getValue() ;

        return( a1 || a2 || a3 || a4 );
    }


    public static String evaluateHand( Hand h )
    {
        if ( isFlush(h) && isStraight(h) )
            return "Straight Flush";
        else if ( is4s(h) )
            return "Four of a Kind";
        else if ( isFullHouse(h) )
            return "Full House";
        else if ( isFlush(h) )
            return "Flush";
        else if ( isStraight(h) )
            return "Straight";
        else if ( is3s(h) )
            return "Three of a Kind";
        else if ( is22s(h) )
            return "Two Pair";
        else if ( is2s(h) )
            return "One Pair";
        else
            return "High Cards";
    }

    static Hand dealHand(Deck deck, int numberOfCards) {
        if (numberOfCards < 1)
            throw new IllegalArgumentException("Only greater 1 values allowed ");

        Hand hand = new Hand();
        for ( int value = 0; value < numberOfCards; value++ ) {
            hand.addCard(deck.dealCard());
        }
        hand.sortByValue();
        return hand;
    }
}
