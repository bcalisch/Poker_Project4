package test;

import com.claimacademy.project4.main.cards.Card;
import junit.framework.TestCase;


/**
 *
 */
public class CardTest extends TestCase {


    Card card = new Card("Hearts", "Six", 6);

    public void testPrintCard() throws Exception {

        card.printCard();

    }

    public void testGetSuit() throws Exception {

    }

    public void testGetCardName() throws Exception {

    }
}