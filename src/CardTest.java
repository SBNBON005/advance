import org.junit.Test;
import static org.junit.Assert.assertEquals;


public class CardTest {

    @Test(expected = IllegalArgumentException.class)
    public void testIllegalCards() {
        new Card(14, Card.HEARTS);
    }

    @Test
    public void testGetSuit() {
        assertEquals(Card.DIAMONDS, new Card(14, Card.DIAMONDS).getSuit());
        assertEquals(Card.SPADES, new Card(14, Card.SPADES).getSuit());
        assertEquals(Card.CLUBS, new Card(14, Card.CLUBS).getSuit());
        assertEquals(Card.HEARTS, new Card(14, Card.HEARTS).getSuit());
    }
}