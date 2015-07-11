package com.claimacademy.project4.main.cards;

import com.claimacademy.project4.main.cards.HandUtility.HANDRANK;

import java.util.*;

/**
 * Hand Class builds a hand for each player
 */
public class Hand {
    private ArrayList<Card> cards = new ArrayList<>();
    private int handRank;
    private String handRankString ="";
    private int highCard1;
    private int highCard2;
    private int highCard3;
    private int highCard4;
    private int highCard5;

    private int flushCheck(ArrayList<Card> cards, int rank) {
        boolean flush = false;
        String suit = cards.get(0).getSuit();
        for (Card card : cards) {
            if (card.getSuit().equals(suit)) {
                flush = true;
            } else {
                flush = false;
                break;
            }
        }
        if (flush && rank == HANDRANK.HIGH_CARD.ordinal()) {
            rank = HANDRANK.FLUSH.ordinal();
        } else if (flush && rank == HANDRANK.STRAIGHT.ordinal()) {
            rank = HANDRANK.STRAIGHT_FLUSH.ordinal();
            if (cards.get(0).getCardInt() == HandUtility.VALUE.ACE.getValue()) {
                rank = HANDRANK.ROYAL_FLUSH.ordinal();
                //System.out.println("Wow, you have a royal flush!!!!");
            }
        }

        return rank;
    }

    private int straightCheck(ArrayList<Integer[]> cardArray) {
        int rank = HANDRANK.HIGH_CARD.ordinal();
        for (int i = 0; i < cardArray.size() - 1; i++) {
            if ((cardArray.get(i)[0]) + 1 == cardArray.get(i+1)[0]) {
                rank = HANDRANK.STRAIGHT.ordinal();
            } else {
                rank = HANDRANK.HIGH_CARD.ordinal();
                break;
            }

        }
        return rank;
    }

    private int fourOfAKind_FullHouseCheck(Hand hand, ArrayList<Integer[]> cardArray) {
        int rank = 0;

        for (int i = 0; i < cardArray.size(); i++) {
            if (cardArray.get(i)[1] == 3) {
                rank = HANDRANK.FULL_HOUSE.ordinal();
                hand.setHighCard1(cardArray.get(i)[0]) ;
                if (i == cardArray.size() - 1) {
                    hand.setHighCard2(cardArray.get(i - 1)[0]);
                } else {
                    hand.setHighCard2(cardArray.get(cardArray.size() -1)[0]);
                }
                System.out.println("You have a full house!!! It's "+ hand.getHighCard1() +"s over " + hand.getHighCard2() + "s!!!!!!!!");

                break;

            }else if(cardArray.get(i)[1] == 4){
                rank = HANDRANK.FOUR_OF_A_KIND.ordinal();
                hand.setHighCard1(cardArray.get(i)[0]);
                if (i == cardArray.size() - 1) {
                    hand.setHighCard2(cardArray.get(i-1)[0]);
                } else {
                    hand.setHighCard2(cardArray.get(cardArray.size() - 1)[0]);
                }
                break;
            }
        }


        return rank;
    }


    public void sortCards() {
        Collections.sort(cards, new CardComparator());
    }

    public void printHand() {
        for(Card card : cards){
            System.out.println(card.getCardName() + " of "+ card.getSuit() );
        }
    }

    public String printHandRank() {
        return handRankString;

    }



    public ArrayList<Card> getCards() {
        return cards;
    }

    public int getHandRank() {
        return handRank;
    }

    public int getHighCard1() {
        return highCard1;
    }

    public int getHighCard2() {
        return highCard2;
    }

    public int getHighCard3() {
        return highCard3;
    }

    public int getHighCard4() {
        return highCard4;
    }

    public int getHighCard5() {
        return highCard5;
    }

    public void setHighCard1(int highCard1) {
        this.highCard1 = highCard1;
    }

    public void setHighCard2(int highCard2) {
        this.highCard2 = highCard2;
    }

    public void setHighCard3(int highCard3) {
        this.highCard3 = highCard3;
    }

    public void setHighCard4(int highCard4) {
        this.highCard4 = highCard4;
    }

    public void setHighCard5(int highCard5) {
        this.highCard5 = highCard5;
    }

    public String getHandRankString() {
        return handRankString;
    }

    public void evaluateHand() {
        HashMap<Integer, Integer> cardMap = HandUtility.makeCardMap();
        handRank = 0;
        Integer cardInt, cardAmount;
        for (Card card : cards) {
            cardInt = card.getCardInt();
            cardAmount = cardMap.get(cardInt) + 1;
            cardMap.put(cardInt, cardAmount);
        }
          ArrayList<Integer[]> cardMapList = stripMap(cardMap);
        handRank = rankHand(cardMapList);
        convertRank(handRank);
    }

    public void convertRank(int handRank) {
        HashMap rankMap = HandUtility.makeHandRankMap();
        HashMap valueMap = HandUtility.makeValueMap();
        handRankString = rankMap.get(handRank)+": " + valueMap.get(highCard1) + " and "+ valueMap.get(highCard2)+".";
    }

    private int rankHand(ArrayList<Integer[]> cardMap) {
        ArrayList<Integer[]> cardArray = cardMap;
        int rank = HANDRANK.HIGH_CARD.ordinal(), i = 0, arraySize = cardArray.size();


        if (arraySize == 5) {
            rank = straightCheck(cardArray);
            highCard1 = cardArray.get(4)[0];
            highCard2 = cardArray.get(3)[0];
            highCard3 = cardArray.get(2)[0];
            highCard4 = cardArray.get(1)[0];
            highCard5 = cardArray.get(0)[0];
            if (rank == HANDRANK.HIGH_CARD.ordinal()) {
                //   System.out.println("You have only a high card of " + highCard1);
            } else {
                //  System.out.println("                        You have a straight!!!! with a " + highCard1);
            }
            rank = flushCheck(cards, rank);
        } else if (arraySize == 4) {
            rank = HANDRANK.ONE_PAIR.ordinal();
            pairCheck(cardArray);
        } else if (arraySize == 3) {
            rank = twoPair_threeOfAKindCheck(cardArray);
        }else if (arraySize ==2){
            rank = fourOfAKind_FullHouseCheck(this, cardArray);
        }

        //   System.out.println();
        return rank;
    }

    private int twoPair_threeOfAKindCheck(ArrayList<Integer[]> cardArray) {
        int rank = 0, pairCount =0;
        for (int i = 0; i < cardArray.size(); i++) {
            if(cardArray.get(i)[1] == 3){
                highCard3 =0;
                rank = HANDRANK.THREE_OF_A_KIND.ordinal();
                highCard1 = cardArray.get(i)[0];
                if (i == 1) {
                    highCard2 = cardArray.get(2)[0];
                    highCard3 = cardArray.get(0)[0];
                } else if (i == 2){
                    highCard2 = cardArray.get(1)[0];
                    highCard3 = cardArray.get(0)[0];
                }else if (i == 0){
                    highCard2 = cardArray.get(2)[0];
                    highCard3 = cardArray.get(1)[0];
                }
                break;
            }else if (cardArray.get(i)[1] == 2){
                if (pairCount < 1){
                    pairCount++;
                    highCard2 = cardArray.get(i)[0];
                }
                else{
                    highCard1 = cardArray.get(i)[0];
                    rank = HANDRANK.TWO_PAIR.ordinal();
                }
            }else if(cardArray.get(i)[1] ==1){
                highCard3 = cardArray.get(i)[0];
            }

        }
        return rank;
    }

    private void pairCheck(ArrayList<Integer[]> cardArray) {
        for (int j = 0; j < cardArray.size(); j++) {
            if (cardArray.get(j)[1].equals(2)) {
                highCard1 = cardArray.get(j)[0];
                if (j == 3) {
                    highCard2 = cardArray.get(2)[0];
                    highCard3 = cardArray.get(1)[0];
                    highCard4 = cardArray.get(0)[0];
                } else if (j==2){
                    highCard2 = cardArray.get(3)[0];
                    highCard3 = cardArray.get(1)[0];
                    highCard4 = cardArray.get(0)[0];

                }else if (j==1){
                    highCard2 = cardArray.get(3)[0];
                    highCard3 = cardArray.get(2)[0];
                    highCard4 = cardArray.get(0)[0];
                }
                else if (j==0){
                    highCard2 = cardArray.get(3)[0];
                    highCard3 = cardArray.get(2)[0];
                    highCard4 = cardArray.get(1)[0];
                }
            }

        }
        // System.out.println("You have a pair of " + highCard1 + "s with a " + highCard2 + " Kicker");
    }

    private ArrayList<Integer[]> stripMap(HashMap cardMap) {
        ArrayList<Integer[]> arInt = new ArrayList<>();
        Iterator<Map.Entry<Integer, Integer>> iterator = cardMap.entrySet().iterator();
        while (iterator.hasNext()) {
            Map.Entry<Integer, Integer> entry = iterator.next();
            if (entry.getValue() > 0) {
                arInt.add(new Integer[]{entry.getKey(), entry.getValue()});
            }
        }
        return arInt;
    }

    static class CardComparator implements Comparator<Card> {
        @Override
        public int compare(Card card1, Card card2) {
            if (card1.getCardInt() > card2.getCardInt()) return -1;
            return 1;
        }
    }


}
