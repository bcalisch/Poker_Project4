package com.claimacademy.project4.main.game;

import com.claimacademy.project4.main.cards.Card;
import com.claimacademy.project4.main.cards.CardHandler;
import com.claimacademy.project4.main.cards.Deck;

import java.text.NumberFormat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;

/**
 * Created by benjamin on 7/7/15.
 */
public class Table {
    private static NumberFormat currencyFormat = NumberFormat.getCurrencyInstance();
    private ArrayList<Player> players = new ArrayList<>();
    private Deck deck = new Deck();
    private double pot = 0.0;

    public void addPlayer(Player player) {
        players.add(player);


    }

    public void dealHands() {
        int totalCardsNeeded = players.size() * 5;

        if (totalCardsNeeded <= deck.getDeck().size()) {
            Collections.shuffle(deck.getDeck());
            for (int i = 0; i < 5; i++) {
                System.out.println();
                for (Player player : players) {
                    Card thisCard = deck.getDeck().get(0);
                    CardHandler.removeCard(deck.getDeck(), thisCard);
                    CardHandler.addCard(player.getHand().getCards(), thisCard);
                }
            }
        } else {
            System.out.println("There are not enough cards to handle this number of players.");
        }

        for (Player player : players) {
            player.getHand().sortCards();
        }
    }

    public void cleanUp() {
        for (Player player : players) {
            while (player.getHand().getCards().size() > 0) {
                Card thisCard = player.getHand().getCards().get(0);
                CardHandler.removeCard(player.getHand().getCards(), thisCard);
                CardHandler.addCard(deck.getDeck(), thisCard);
            }
        }
        Iterator<Player> playerIterator = players.iterator();
        while (playerIterator.hasNext()){
            Player player = playerIterator.next();
            if (player.getWallet().getCash() <= 0.0){
                playerIterator.remove();
                System.out.println("Player "+ player.getName() + " ran out of money and is out of the game!");
            }
        }

    }

    public void evaluateHands() {
     //   int winningHand = 0;
         for (Player player : players) {
            //  winner = player;
            player.getHand().evaluateHand();
          //  if (player.getHand().getHandRank() > winningHand) {
          //      winningHand = player.getHand().getHandRank();
           // }
            player.printPlayer();
            System.out.println("\t\t\t\t\t\t\t\tHand for "+ player.getName()+": " + player.getHand().printHandRank());
             System.out.println();
        }
//    if(winner != null) {
//            System.out.println("The winner is " + winner.getName() + " with a " + winner.getHand().getHandRankString()+ ": " + winner.getHand().getHighCard1() + ": " + winner.getHand().getHighCard2());
        ArrayList<Player> copyPlayer = cloneArrayList(players);
        Collections.sort(copyPlayer, new PlayerComparator());
         Player winner = players.get(players.indexOf(copyPlayer.get(0)));

        System.out.println("The winner is " + copyPlayer.get(0).getName() + " with a " + copyPlayer.get(0).getHand().getHandRankString() + ": " + copyPlayer.get(0).getHand().getHighCard1() + ": " + copyPlayer.get(0).getHand().getHighCard2());
        winner.getWallet().addCash(getPot());
        removePot(getPot());
    }

    private ArrayList<Player> cloneArrayList(ArrayList<Player> players) {
        ArrayList<Player> tempArrayList = new ArrayList<>();
        for (Player player : players){
            tempArrayList.add(player);
        }

        return tempArrayList;
    }

    public ArrayList<Player> getPlayers() {
        return players;
    }

    public double getPot() {
        return pot;
    }

    public void addPot(double pot) {
        this.pot += pot;
    }

    public void removePot(double pot) {
        this.pot -= pot;
    }



    public void placeBets(int anteNum) {
        for (Player player : players) {
            player.getWallet().removeCash(anteNum);
            addPot(anteNum);
        }
    }
}
