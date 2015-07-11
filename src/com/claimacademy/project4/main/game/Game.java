package com.claimacademy.project4.main.game;

import java.text.NumberFormat;
import java.util.Scanner;

/**
 * Created by benjamin on 7/7/15.
 */
public class Game {
    private static NumberFormat currencyFormat = NumberFormat.getCurrencyInstance();

    public static void main(String[] args) {

        String name = "";
        boolean runGame = true;
        int numberOfPlayers = 0;
        int anteNum = 0, startingWallet = 0;

        GameMenu.printWelcome();

        while (name.length() < 2) {
            name = GameMenu.gatherGameInformation();
        }
        while (numberOfPlayers < 1) {
            numberOfPlayers = GameMenu.gatherNumPlayers();
        }
        while (anteNum < 1) {
            anteNum = GameMenu.gatherAnte();
        }
        while (startingWallet < 1) {
            startingWallet = GameMenu.gatherWallet();
        }
        Table table = new Table();

        setupGame(table, name, numberOfPlayers, (anteNum * startingWallet));

        while (runGame) {
            if (table.getPlayers().get(0).getName().equals(name)) {


                table.placeBets(anteNum);
                System.out.println("Pot: " + currencyFormat.format(table.getPot()));
                table.dealHands();
                table.evaluateHands();
                table.cleanUp();
                runGame = startGame(table);
            }
            else{
                System.out.println("You have lost the game!  Good Bye!");
                runGame = false;
            }
        }


    }

    private static boolean startGame(Table table) {
        if (table.getPlayers().size() > 1) {
            Scanner playAgain = new Scanner(System.in);
            String playAgainInput;
            boolean anotherGame;
            System.out.println("Would you like to play another game(Yes or No)?");
            playAgainInput = playAgain.nextLine().toLowerCase();

            switch (playAgainInput) {
                case ("yes"):
                    System.out.println("OK!");
                    anotherGame = true;
                    break;
                case ("no"):
                    System.out.println("GoodBYE");
                    anotherGame = false;
                    break;
                default: {
                    System.out.println("I don't understand, please try again!");
                    anotherGame = false;
                    break;
                }
            }


            return anotherGame;
        } else {
            return false;
        }
    }

    private static void setupGame(Table table, String name, int numberOfPlayers, int startingWallet) {

        table.addPlayer(new Player(name));
        for (int i = 1; i <= numberOfPlayers; i++) {
            table.addPlayer(new Player("Computer " + i));
        }
        for (Player player : table.getPlayers()) {
            player.getWallet().addCash((startingWallet));
        }
    }

}
