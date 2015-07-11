package com.claimacademy.project4.main.cards;

import java.util.ArrayList;

/**
 * Created by benjamin on 7/7/15.
 */
public class Deck{

    private ArrayList<Card> deck = new ArrayList<>();



    public Deck(){
        for(HandUtility.SUIT suit:HandUtility.SUIT.values()){
            for(HandUtility.VALUE value : HandUtility.VALUE.values()){
                deck.add(new Card(suit.DISPLAYNAME, value.DISPLAYNAME, value.VALUE));
            }
        }

    }

    public ArrayList<Card> getDeck(){
        return deck;
    }
}
