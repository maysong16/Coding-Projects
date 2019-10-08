/* Name: May Song
Date: 9/27/17
 */

import java.util.InputMismatchException;
import java.util.Scanner;

public class BlackJack {
    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);
        //variable declarations
        int gameNumber = 0;
        int playerHand = 0;
        int dealerHand = 0;
        int card = 0;
        int menuOption = 0;
        int playerWins = 0;
        int dealerWins = 0;
        int numTies = 0;

        boolean exitFlag = false; //exitFlag = menu option is 4
        boolean gameOver = false; //end of game
        while (exitFlag == false) { //while loop for when menu options are 1-3
            System.out.println("");
            System.out.println("START GAME # " + (gameNumber+1) ); //gameNumber +1 accounts for when menu option "print statistics" is chosen, since it doesn't count as a concluded game
            card = (int) (Math.random() * 13) + 1; //generates a random number from 1-13
            if (card == 1) { //if else statements for face cards, card is given a value of 10
                System.out.println("Your card is an ACE!");
            } else if (card == 11) {
                System.out.println("Your card is a JACK!");
                card = 10;
            } else if (card == 12) {
                System.out.println("Your card is a QUEEN!");
                card = 10;
            } else if (card == 13) {
                System.out.println("Your card is a KING!");
                card = 10;
            } else {
                System.out.println("Your card is a " + card + "!");
            }
            playerHand += card;
            System.out.println("Your hand is: " + playerHand);
            System.out.println("");
            gameOver = false;

            while (gameOver == false) {

                System.out.println("");
                System.out.println("");
                System.out.println("1.Get another card");
                System.out.println("2.Hold hand");
                System.out.println("3.Print statistics");
                System.out.println("4.Exit");
                System.out.println("");
                System.out.print("Choose an option: ");

                try {
                    menuOption = input.nextInt();
                    System.out.println("");

                    if (menuOption >= 1 && menuOption <= 4) { //invalid input when menu option is an integer but is not 1-4
                        if (menuOption == 1) {
                            card = (int) (Math.random() * 13) + 1;
                            if (card == 1) {
                                System.out.println("Your card is an ACE!");
                            } else if (card == 11) {
                                System.out.println("Your card is a JACK!");
                                card = 10;
                            } else if (card == 12) {
                                System.out.println("Your card is a QUEEN!");
                                card = 10;
                            } else if (card == 13) {
                                System.out.println("Your card is a KING!");
                                card = 10;
                            } else {
                                System.out.println("Your card is a " + card + "!");
                            }
                            playerHand += card;
                            System.out.println("Your hand is: " + playerHand);
                            System.out.println("");

                            if (playerHand == 21) {
                                System.out.println("BLACKJACK! You win!");
                                playerWins++;
                                playerHand = 0;
                                dealerHand = 0;
                                gameOver = true; //finishes game
                                System.out.println("");
                            }
                            if (playerHand > 21) {
                                System.out.println("You exceeded 21! You lose :(");
                                dealerWins++;
                                playerHand = 0;
                                dealerHand = 0;
                                gameOver = true;
                                System.out.println("");
                            }
                        }

                        if (menuOption == 2) {
                            dealerHand = (int) (Math.random() * (26 - 16)) + 16;
                            System.out.println("Dealer's Hand: " + dealerHand);
                            System.out.println("Your hand is: " + playerHand);
                            System.out.println("");
                            if (dealerHand > 21) {
                                System.out.println("You win!");
                                playerWins++;
                                playerHand = 0;
                                dealerHand = 0;
                                gameOver = true;
                                System.out.println("");
                            } else if (dealerHand == playerHand) {
                                System.out.println("It's a tie! No one wins!");
                                numTies++;
                                playerHand = 0;
                                dealerHand = 0;
                                gameOver = true;
                                System.out.println("");
                            } else if (playerHand > dealerHand) {
                                System.out.println("You win!");
                                playerWins++;
                                playerHand = 0;
                                dealerHand = 0;
                                gameOver = true;
                                System.out.println("");
                            } else {
                                System.out.println("Dealer wins!");
                                dealerWins++;
                                playerHand = 0;
                                dealerHand = 0;
                                gameOver = true;
                                System.out.println("");
                            }
                        }
                        if (menuOption == 3) {
                            System.out.println("Number of Player wins: " + playerWins);
                            System.out.println("Number of Dealer wins: " + dealerWins);
                            System.out.println("Number of tie games: " + numTies);
                            System.out.println("Total # of games played is: " + gameNumber);
                            System.out.printf("%s%5.1f%n", "Percentage of Player wins: ", (((double) playerWins / (double) gameNumber) * 100.0));
                        }
                        if (menuOption == 4) {
                            gameOver = true;
                        }

                    } else {
                        System.out.println("Invalid input!");
                        System.out.println("Please enter an integer value between 1 and 4.");
                        System.out.println("");
                    }

                } catch (InputMismatchException e) { //catches input that aren't integers

                    System.err.println("Invalid input!");
                    System.err.println("Please enter an integer value between 1 and 4.");
                    input.nextLine();
                }
            }
            gameNumber++;
            if (menuOption == 4) {
                exitFlag = true;
            }
        }
        return;
    }
}

