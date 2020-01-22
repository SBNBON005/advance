public class EntryPoint {
    public static void main(String[] args){

        Deck deck = new Deck();
        deck.shuffle();

        Hand hand = Poker.dealHand(deck, 5);
        hand.show();
        System.out.print("\n" + Poker.evaluateHand(hand));

    }
}
