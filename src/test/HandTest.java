package test;

import com.claimacademy.project4.main.cards.Card;
import com.claimacademy.project4.main.cards.Hand;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

/**
 * Test for Hands
 */
public class HandTest {
    private Hand hand;


    @Before
    public void initialize() {
        hand = new Hand();

    }


    public void testSize_IsFiveAfterAddingFiveItems() {


        Assert.assertEquals(5, hand.getCards().size());


    }

    @After
    public void tearDown() {

    }

    @Test
    public void testConvertRankString_EqualsPairWhenSentOne() {
        /*handRankString = rankMap.get(handRank)+": " + highCard1 + " and "+ highCard2;*/
        // Hand hand = new Hand();
        hand.convertRank(1);
        Assert.assertEquals("One Pair: null and null.", hand.getHandRankString());

    }

    @Test
    public void testConvertRankString_EqualsTwoPairWhenSentTwo() {
        /*handRankString = rankMap.get(handRank)+": " + highCard1 + " and "+ highCard2;*/
        Hand hand = new Hand();
        hand.convertRank(2);
        Assert.assertEquals("Two Pair: null and null.", hand.getHandRankString());

    }

    @Test
    public void testEvaluateHand_EqualsFourOfAKindWhenSentFourOfTheSameCards() {
        /*handRankString = rankMap.get(handRank)+": " + highCard1 + " and "+ highCard2;*/
        // Hand hand = new Hand();
        hand.getCards().add(new Card("Hearts", "Six", 6));
        hand.getCards().add(new Card("Hearts", "Seven", 6));
        hand.getCards().add(new Card("Hearts", "Eight", 6));
        hand.getCards().add(new Card("Hearts", "Nine", 6));
        hand.getCards().add(new Card("Hearts", "Ten", 5));
        hand.evaluateHand();
        Assert.assertEquals("Four of a Kind: Six and Five.", hand.getHandRankString());

    }

    @Test
    public void testEvaluateHand_correctHighCard1() {
        /*handRankString = rankMap.get(handRank)+": " + highCard1 + " and "+ highCard2;*/
        // Hand hand = new Hand();
        hand.getCards().add(new Card("Hearts", "Six", 6));
        hand.getCards().add(new Card("Hearts", "Seven", 6));
        hand.getCards().add(new Card("Hearts", "Eight", 6));
        hand.getCards().add(new Card("Hearts", "Nine", 6));
        hand.getCards().add(new Card("Hearts", "Ten", 5));
        hand.evaluateHand();
        Assert.assertEquals(6, hand.getHighCard1());

        //hand.getCards().removeAll(hand.getCards());

    }

    @Test
    public void testEvaluateHand_correctHighCard2() {
        hand.getCards().add(new Card("Hearts", "Six", 6));
        hand.getCards().add(new Card("Hearts", "Seven", 6));
        hand.getCards().add(new Card("Hearts", "Eight", 6));
        hand.getCards().add(new Card("Hearts", "Nine", 6));
        hand.getCards().add(new Card("Hearts", "Ten", 5));
        hand.evaluateHand();
        Assert.assertEquals(5, hand.getHighCard2());

    }

    @Test
    public void testEvaluateHand_correctHighCard3_ShouldBeZeroforFourOfAKind() {
        hand.getCards().add(new Card("Hearts", "Six", 6));
        hand.getCards().add(new Card("Hearts", "Seven", 6));
        hand.getCards().add(new Card("Hearts", "Eight", 6));
        hand.getCards().add(new Card("Hearts", "Nine", 6));
        hand.getCards().add(new Card("Hearts", "Ten", 5));
        hand.evaluateHand();
        Assert.assertEquals(0, hand.getHighCard3());

    }

    @Test
    public void testEvaluateHand_correctHandRank_ShouldBeSevenWithFourOfAKind() {
        hand.getCards().add(new Card("Hearts", "Six", 6));
        hand.getCards().add(new Card("Hearts", "Seven", 6));
        hand.getCards().add(new Card("Hearts", "Eight", 6));
        hand.getCards().add(new Card("Hearts", "Nine", 6));
        hand.getCards().add(new Card("Hearts", "Ten", 5));
        hand.evaluateHand();
        Assert.assertEquals(7, hand.getHandRank());

    }

    @Test
    public void testEvaluateHand_correctHighCard1_TwoPair() {
        /*handRankString = rankMap.get(handRank)+": " + highCard1 + " and "+ highCard2;*/
        // Hand hand = new Hand();
        hand.getCards().add(new Card("Hearts", "", 6));
        hand.getCards().add(new Card("Hearts", "", 6));
        hand.getCards().add(new Card("Hearts", "", 7));
        hand.getCards().add(new Card("Hearts", "", 5));
        hand.getCards().add(new Card("Hearts", "", 5));
        hand.evaluateHand();
        Assert.assertEquals(6, hand.getHighCard1());

        //hand.getCards().removeAll(hand.getCards());

    }

    @Test
    public void testEvaluateHand_correctHighCard2_TwoPair() {
        hand.getCards().add(new Card("Hearts", "", 6));
        hand.getCards().add(new Card("Hearts", "", 6));
        hand.getCards().add(new Card("Hearts", "", 7));
        hand.getCards().add(new Card("Hearts", "", 5));
        hand.getCards().add(new Card("Hearts", "", 5));
        hand.evaluateHand();
        Assert.assertEquals(5, hand.getHighCard2());

    }

    @Test
    public void testEvaluateHand_correctHighCard3__TwoPair() {
        hand.getCards().add(new Card("Hearts", "", 6));
        hand.getCards().add(new Card("Hearts", "", 6));
        hand.getCards().add(new Card("Hearts", "", 7));
        hand.getCards().add(new Card("Hearts", "", 5));
        hand.getCards().add(new Card("Hearts", "", 5));
        hand.evaluateHand();
        Assert.assertEquals(7, hand.getHighCard3());

    }
    @Test
    public void testEvaluateHand_correctHighCard4__TwoPair() {
        hand.getCards().add(new Card("Hearts", "", 6));
        hand.getCards().add(new Card("Hearts", "", 6));
        hand.getCards().add(new Card("Hearts", "", 7));
        hand.getCards().add(new Card("Hearts", "", 5));
        hand.getCards().add(new Card("Hearts", "", 5));
        hand.evaluateHand();
        Assert.assertEquals(0, hand.getHighCard4());

    }

    @Test
    public void testEvaluateHand_correctHandRank_TwoPair() {
        hand.getCards().add(new Card("Hearts", "", 6));
        hand.getCards().add(new Card("Hearts", "", 6));
        hand.getCards().add(new Card("Hearts", "", 7));
        hand.getCards().add(new Card("Hearts", "", 7));
        hand.getCards().add(new Card("Hearts", "", 5));
        hand.evaluateHand();
        Assert.assertEquals(2, hand.getHandRank());

    }
    @Test
    public void testEvaluateHand_correctHighCard1_ThreeOfAKind() {
        /*handRankString = rankMap.get(handRank)+": " + highCard1 + " and "+ highCard2;*/
        // Hand hand = new Hand();
        hand.getCards().add(new Card("Hearts", "", 6));
        hand.getCards().add(new Card("Hearts", "", 6));
        hand.getCards().add(new Card("Hearts", "", 7));
        hand.getCards().add(new Card("Hearts", "", 6));
        hand.getCards().add(new Card("Hearts", "", 5));
        hand.evaluateHand();
        Assert.assertEquals(6, hand.getHighCard1());

        //hand.getCards().removeAll(hand.getCards());

    }

    @Test
    public void testEvaluateHand_correctHighCard2_ThreeOfAKind() {
        hand.getCards().add(new Card("Hearts", "", 6));
        hand.getCards().add(new Card("Hearts", "", 6));
        hand.getCards().add(new Card("Hearts", "", 7));
        hand.getCards().add(new Card("Hearts", "", 6));
        hand.getCards().add(new Card("Hearts", "", 5));
        hand.evaluateHand();
        Assert.assertEquals(7, hand.getHighCard2());

    }

    @Test
    public void testEvaluateHand_correctHighCard3__ThreeOfAKind() {
        hand.getCards().add(new Card("Hearts", "", 6));
        hand.getCards().add(new Card("Hearts", "", 6));
        hand.getCards().add(new Card("Hearts", "", 7));
        hand.getCards().add(new Card("Hearts", "", 6));
        hand.getCards().add(new Card("Hearts", "", 5));
        hand.evaluateHand();
        Assert.assertEquals(5, hand.getHighCard3());

    }
    @Test
    public void testEvaluateHand_correctHighCard4__ThreeOfAKind() {
        hand.getCards().add(new Card("Hearts", "", 6));
        hand.getCards().add(new Card("Hearts", "", 6));
        hand.getCards().add(new Card("Hearts", "", 7));
        hand.getCards().add(new Card("Hearts", "", 6));
        hand.getCards().add(new Card("Hearts", "", 5));
        hand.evaluateHand();
        Assert.assertEquals(0, hand.getHighCard4());

    }

    @Test
    public void testEvaluateHand_correctHandRank_Pair() {
        hand.getCards().add(new Card("Hearts", "", 6));
        hand.getCards().add(new Card("Hearts", "", 8));
        hand.getCards().add(new Card("Hearts", "", 7));
        hand.getCards().add(new Card("Hearts", "", 6));
        hand.getCards().add(new Card("Hearts", "", 5));
        hand.evaluateHand();
        Assert.assertEquals(1, hand.getHandRank());

    }
    @Test
    public void testEvaluateHand_correctHighCard1_Pair() {
        /*handRankString = rankMap.get(handRank)+": " + highCard1 + " and "+ highCard2;*/
        // Hand hand = new Hand();
        hand.getCards().add(new Card("Hearts", "", 6));
        hand.getCards().add(new Card("Hearts", "", 8));
        hand.getCards().add(new Card("Hearts", "", 7));
        hand.getCards().add(new Card("Hearts", "", 6));
        hand.getCards().add(new Card("Hearts", "", 5));
        hand.evaluateHand();
        Assert.assertEquals(6, hand.getHighCard1());

        //hand.getCards().removeAll(hand.getCards());

    }

    @Test
    public void testEvaluateHand_correctHighCard2_Pair() {
        hand.getCards().add(new Card("Hearts", "", 6));
        hand.getCards().add(new Card("Hearts", "", 8));
        hand.getCards().add(new Card("Hearts", "", 7));
        hand.getCards().add(new Card("Hearts", "", 6));
        hand.getCards().add(new Card("Hearts", "", 5));
        hand.evaluateHand();
        Assert.assertEquals(8, hand.getHighCard2());

    }

    @Test
    public void testEvaluateHand_correctHighCard3__Pair() {
        hand.getCards().add(new Card("Hearts", "", 6));
        hand.getCards().add(new Card("Hearts", "", 8));
        hand.getCards().add(new Card("Hearts", "", 7));
        hand.getCards().add(new Card("Hearts", "", 6));
        hand.getCards().add(new Card("Hearts", "", 5));
        hand.evaluateHand();
        Assert.assertEquals(7, hand.getHighCard3());

    }
    @Test
    public void testEvaluateHand_correctHighCard4__Pair() {
        hand.getCards().add(new Card("Hearts", "", 6));
        hand.getCards().add(new Card("Hearts", "", 8));
        hand.getCards().add(new Card("Hearts", "", 7));
        hand.getCards().add(new Card("Hearts", "", 6));
        hand.getCards().add(new Card("Hearts", "", 5));
        hand.evaluateHand();
        Assert.assertEquals(5, hand.getHighCard4());

    }

    @Test
    public void testEvaluateHand_correctHighCard5_Pair() {
        hand.getCards().add(new Card("Hearts", "", 6));
        hand.getCards().add(new Card("Hearts", "", 8));
        hand.getCards().add(new Card("Hearts", "", 7));
        hand.getCards().add(new Card("Hearts", "", 6));
        hand.getCards().add(new Card("Hearts", "", 5));
        hand.evaluateHand();
        Assert.assertEquals(0, hand.getHighCard5());

    }

    @Test
    public void testEvaluateHand_correctHandRank_NOTStraightBUTStraightFlush() {
        hand.getCards().add(new Card("Hearts", "", 6));
        hand.getCards().add(new Card("Hearts", "", 8));
        hand.getCards().add(new Card("Hearts", "", 7));
        hand.getCards().add(new Card("Hearts", "", 9));
        hand.getCards().add(new Card("Hearts", "", 5));
        hand.evaluateHand();
        Assert.assertNotEquals("StraighFlush: "+ hand.getHandRankString(),4, hand.getHandRank());

    }
    @Test
    public void testEvaluateHand_correctHandRank_Straight() {
        hand.getCards().add(new Card("Clubs", "", 6));
        hand.getCards().add(new Card("Hearts", "", 8));
        hand.getCards().add(new Card("Hearts", "", 7));
        hand.getCards().add(new Card("Hearts", "", 9));
        hand.getCards().add(new Card("Hearts", "", 5));
        hand.evaluateHand();
        Assert.assertEquals(4, hand.getHandRank());

    }
    @Test
    public void testEvaluateHand_correctHighCard1_Straight() {
        /*handRankString = rankMap.get(handRank)+": " + highCard1 + " and "+ highCard2;*/
        // Hand hand = new Hand();
        hand.getCards().add(new Card("Hearts", "", 6));
        hand.getCards().add(new Card("Hearts", "", 8));
        hand.getCards().add(new Card("Hearts", "", 7));
        hand.getCards().add(new Card("Hearts", "", 9));
        hand.getCards().add(new Card("Hearts", "", 5));
        hand.evaluateHand();
        Assert.assertEquals(9, hand.getHighCard1());

        //hand.getCards().removeAll(hand.getCards());

    }

    @Test
    public void testEvaluateHand_correctHighCard2_Straight() {
        hand.getCards().add(new Card("Hearts", "", 6));
        hand.getCards().add(new Card("Hearts", "", 8));
        hand.getCards().add(new Card("Hearts", "", 7));
        hand.getCards().add(new Card("Hearts", "", 9));
        hand.getCards().add(new Card("Hearts", "", 5));
        hand.evaluateHand();
        Assert.assertEquals(8, hand.getHighCard2());

    }

    @Test
    public void testEvaluateHand_correctHighCard3__Straight() {
        hand.getCards().add(new Card("Hearts", "", 6));
        hand.getCards().add(new Card("Hearts", "", 8));
        hand.getCards().add(new Card("Hearts", "", 7));
        hand.getCards().add(new Card("Hearts", "", 9));
        hand.getCards().add(new Card("Hearts", "", 5));
        hand.evaluateHand();
        Assert.assertEquals(7, hand.getHighCard3());

    }
    @Test
    public void testEvaluateHand_correctHighCard4__Straight() {
        hand.getCards().add(new Card("Hearts", "", 6));
        hand.getCards().add(new Card("Hearts", "", 8));
        hand.getCards().add(new Card("Hearts", "", 7));
        hand.getCards().add(new Card("Hearts", "", 9));
        hand.getCards().add(new Card("Hearts", "", 5));
        hand.evaluateHand();
        Assert.assertEquals(6, hand.getHighCard4());

    }

    @Test
    public void testEvaluateHand_correctHighCard5_Straight() {
        hand.getCards().add(new Card("Hearts", "", 6));
        hand.getCards().add(new Card("Hearts", "", 8));
        hand.getCards().add(new Card("Hearts", "", 7));
        hand.getCards().add(new Card("Hearts", "", 9));
        hand.getCards().add(new Card("Hearts", "", 5));
        hand.evaluateHand();
        Assert.assertEquals(5, hand.getHighCard5());

    }
}