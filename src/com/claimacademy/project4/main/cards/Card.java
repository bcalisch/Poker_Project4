package com.claimacademy.project4.main.cards;

/**
 * Card Class holds the card name, suit, and the numerical value
 */
public class Card {
    private String suit;
    private String cardValue;
    private int  cardInt;


    public Card(String suit, String value, int cardInt) {
        this.suit = suit;
        this.cardValue = value;
        this.cardInt = cardInt;
    }

    public void printCard() {

        System.out.print(cardValue + " of " + suit);

    }

    public String getSuit() {
        return suit;
    }

    public String getCardName() {
        return cardValue;
    }

    public int getCardInt() {
        return cardInt;
    }
}
