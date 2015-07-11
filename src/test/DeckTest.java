package test;

import com.claimacademy.project4.main.cards.Deck;
import junit.framework.TestCase;

/**
 * Testing the Deck
 */
public class DeckTest extends TestCase {

    public void testSizeOfNewDeckIs52(){
        Deck testDeck = new Deck();

        assertEquals(52, testDeck.getDeck().size());

    }

    public void testPrintDeck() throws Exception {

    }

    public void testGetDeck() throws Exception {

    }
}