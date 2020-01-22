import org.junit.Test;


public class CardTest {

    @Test(expected = IllegalArgumentException.class)
    public void testIllegalCards() {
        new Card(14, Card.HEARTS);
    }
}