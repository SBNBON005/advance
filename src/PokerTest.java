import static org.junit.Assert.assertEquals;
import org.junit.Test;

public class PokerTest {

    @Test
    public void testEvaluateRoyalFlush() {
        final int[] suits = {
                Card.CLUBS,
                Card.DIAMONDS,
                Card.HEARTS,
                Card.SPADES,
        };
        for (int suit : suits) {
            Hand hand = new Hand();
            hand.addCard(new Card(Card.KING, suit));
            hand.addCard(new Card(Card.QUEEN, suit));
            hand.addCard(new Card(Card.JACK, suit));
            hand.addCard(new Card(Card.TEN, suit));
            hand.addCard(new Card(Card.ACE, suit));

            assertEquals("Flush", Poker.evaluateHand(hand));
        }
    }

    @Test
    public void testEvaluateSevenHigh() {
        Hand hand = new Hand();
        hand.addCard(new Card(Card.SEVEN, Card.HEARTS));
        hand.addCard(new Card(Card.FIVE, Card.CLUBS));
        hand.addCard(new Card(Card.FOUR, Card.DIAMONDS));
        hand.addCard(new Card(Card.THREE, Card.SPADES));
        hand.addCard(new Card(Card.TWO, Card.HEARTS));

        assertEquals("High Cards", Poker.evaluateHand(hand));
    }

    @Test
    public void testEvaluatePair() {
        Hand hand = new Hand();
        hand.addCard(new Card(Card.TWO, Card.HEARTS));
        hand.addCard(new Card(Card.TWO, Card.DIAMONDS));
        hand.addCard(new Card(Card.THREE, Card.CLUBS));
        hand.addCard(new Card(Card.FOUR, Card.CLUBS));
        hand.addCard(new Card(Card.FIVE, Card.CLUBS));

        assertEquals("One Pair", Poker.evaluateHand(hand));

    }

    @Test
    public void testDealingFiveHandPoker() {
        Deck deck = new Deck();
        assertEquals(5, Poker.dealHand(deck, 5).getCardCount());

    }
}