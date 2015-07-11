package com.claimacademy.project4.main.game;

import java.util.InputMismatchException;
import java.util.Scanner;

/**
 * Created by benjamin on 7/9/15.
 */
public class GameMenu {

    public static void printWelcome() {
        System.out.println();
        System.out.println("\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t**************************************************************");
        System.out.println("\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t|                                                            |");
        System.out.println("\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t|        _________   _________   _________   __________      |");
        System.out.println("\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t|       /         \\ /         \\ /         \\ /          \\     | ");
        System.out.println("\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t|       |A        | |A        | |A        | |A         |     | ");
        System.out.println("\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t|       |    ,    | |   _ _   | |    _    | |          |     | ");
        System.out.println("\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t|       |   / \\   | |  / ^ \\  | |   (_)   | |    /\\    |     | ");
        System.out.println("\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t|       |  (_ _)  | |  \\   /  | |  (_)_)  | |   <  >   |     | ");
        System.out.println("\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t|       |   /_\\   | |   \\ /   | |   /_\\   | |    \\/    |     | ");
        System.out.println("\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t|       |         | |    `    | |         | |          |     | ");
        System.out.println("\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t|       |        A| |        A| |        A| |         A|     | ");
        System.out.println("\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t|       \\_________/ \\_________/ \\_________/ \\__________/     | ");
        System.out.println("\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t|                                                            |");
        System.out.println("\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t|                                                            |");
        System.out.println("\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t|                   Welcome to Poker Hands!!!!               |");
        System.out.println("\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t**************************************************************");
        System.out.println();

        printGameSetup();
    }

    public static void printGameSetup() {
        Scanner startGame = new Scanner(System.in);
        String startText;
        System.out.println("\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t Type 'Begin' to start a new game!");
        startText = startGame.nextLine().toLowerCase();
        switch(startText){
            case("begin"):{
                System.out.println("Great, let's begin!");
               break;
            }
            default:{
                System.out.println("I'm sorry, but I didn't understand your question. Please try again.");
                printGameSetup();
            }

        }
    }
    public static String gatherGameInformation() {
        String name;

            Scanner scanName = new Scanner(System.in);
            System.out.println("Ok, please enter your name:");
            name = scanName.nextLine().toLowerCase();
            name = name.substring(0, 1).toUpperCase() + name.substring(1, name.length());
            System.out.println("Glad you are with us, " + name + "!");

        return name;
    }



    public static int gatherWallet() {
        int walletAmount =0;
        Scanner scanAnte = new Scanner(System.in);
        System.out.printf("Please enter the minimum number of rounds you would like to play");
        try {
            walletAmount = scanAnte.nextInt();
        } catch (NumberFormatException | InputMismatchException e) {
            System.out.println("That was not a valid integer value.  Please try again");
            return 0;
        }
        return walletAmount;

    }

    public static int gatherAnte() {
        int anteNum;
        Scanner scanAnte = new Scanner(System.in);
        System.out.printf("Please enter how much you would like to bid each round");
        try {
            anteNum = scanAnte.nextInt();
        }catch (NumberFormatException | InputMismatchException e) {
            System.out.println("That was not a valid integer value.  Please try again");
            return 0;
        }
        return anteNum;
    }

    public static int gatherNumPlayers() {
        int numOfPlayers =0;
        Scanner scanNumPlayers = new Scanner(System.in);
        System.out.println("How many players would you like at your table?  Please choose 2-5.");
        try {
            numOfPlayers = scanNumPlayers.nextInt();
            if(numOfPlayers >1 && numOfPlayers < 6){

                return numOfPlayers;
            }else{
                System.out.println("You did not give me good information.  Please try again.");
                return 0;

            }
        } catch (NumberFormatException | InputMismatchException e) {
            System.out.println("That was not a valid integer value.  Please try again");
            return 0;
            //return numOfPlayers;InputMismatchException
        }


      //  return numOfPlayers;
    }
}
