package com.claimacademy.project4.main.game;

import com.claimacademy.project4.main.cards.Hand;

import java.text.NumberFormat;

/**
 * Created by benjamin on
 */
public class Player {
    private static NumberFormat currencyFormat = NumberFormat.getCurrencyInstance();
    private String name;
    private Wallet wallet = new Wallet();
    private Hand hand = new Hand();


    public Player(String name){
        this.name = name;
    }

    public Wallet getWallet() {
        return wallet;
    }

    public String getName() {
        return name;
    }

    public Hand getHand() {
        return hand;
    }

    public void printPlayer() {
        System.out.println(name+": " );
        System.out.println("Wallet: " + currencyFormat.format(wallet.getCash()));
        hand.printHand();
    }
}
