package com.claimacademy.project4.main.game;

import com.claimacademy.project4.main.cards.Hand;

import java.text.NumberFormat;
import java.util.Comparator;

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
//new class for comparator
    public static class PlayerComparator implements Comparator<Player> {
        @Override
        public int compare(Player player1, Player player2) {
            if (player1.getHand().getHandRank() < player2.getHand().getHandRank()) {
                return 1;
            }else if(player1.getHand().getHandRank() > player2.getHand().getHandRank()) {
                return -1;
            }else {
                if (player1.getHand().getHighCard1() < player2.getHand().getHighCard1()) {
                    return 1;
                } else if (player1.getHand().getHighCard1() > player2.getHand().getHighCard1()) {
                    return -1;
                } else {
                    if (player1.getHand().getHighCard2() < player2.getHand().getHighCard2()) {
                        return 1;
                    } else if (player1.getHand().getHighCard2() > player2.getHand().getHighCard2()) {
                        return -1;
                    }
                    else {
                        if (player1.getHand().getHighCard3() < player2.getHand().getHighCard3()) {
                            return 1;
                        } else if (player1.getHand().getHighCard3() > player2.getHand().getHighCard3()) {
                            return -1;
                        }
                        else {
                            if (player1.getHand().getHighCard4() < player2.getHand().getHighCard4()) {
                                return 1;
                            } else if (player1.getHand().getHighCard4() > player2.getHand().getHighCard4()) {
                                return -1;
                            }
                            else {
                                if (player1.getHand().getHighCard5() < player2.getHand().getHighCard5()) {
                                    return 1;
                                } else if (player1.getHand().getHighCard5() > player2.getHand().getHighCard5()) {
                                    return -1;
                                }
                            }
                        }
                    }
                }
            }

            return 1;
        }
    }
}
