/*
Name: May Song
Date: 11/10/17
 */
import java.util.Scanner;
import java.util.InputMismatchException;
import java.lang.NegativeArraySizeException;
public class Main {
    public static void main(String[] args) {
        int numPokemon = 0;
        boolean validNum = true;
        System.out.println("Welcome to your new PokeDex!");
        Scanner input = new Scanner(System.in);
        while(validNum) {
            System.out.print("How many Pokemon are in your region: ");
            try {
                numPokemon = input.nextInt();
                if(numPokemon<0){
                    throw new NegativeArraySizeException("That is not a valid number. Try again.");
                }
                System.out.println("");
                System.out.println("Your new Pokedex can hold " + numPokemon + " Pokemon. Let's start using it!");
                System.out.println("");
                validNum = false;
            } catch (InputMismatchException|NegativeArraySizeException e) {
                validNum = true;
                System.out.println("That is not a valid number. Try again.");
                input.nextLine();
                System.out.println("");
            }
        }
        Pokedex myPokedex = new Pokedex(numPokemon);
        int menuOption = 0;
        String species = "";
        while (menuOption != 6) {
            System.out.println("1. List Pokemon");
            System.out.println("2. Add Pokemon");
            System.out.println("3. Check a Pokemon's Stats");
            System.out.println("4. Evolve Pokemon");
            System.out.println("5. Sort Pokemon");
            System.out.println("6. Exit");
            System.out.println("");
            System.out.print("What would you like to do? ");

            try {
                menuOption = input.nextInt();
                System.out.println("");
                switch (menuOption) {
                    case 1:
                        myPokedex.listPokemon(true);
                        break;
                    case 2:
                        System.out.print("Please enter the Pokemon's Species: ");
                        species = input.next();
                        myPokedex.addPokemon(species);
                        break;
                    case 3:
                        System.out.print("Please enter the Pokemon of interest: ");
                        species = input.next();
                        myPokedex.checkStats(species);
                        break;
                    case 4:
                        System.out.print("Please enter the Pokemon of interest: ");
                        species = input.next();
                        myPokedex.evolvePokemon(species);
                        break;
                    case 5:
                        myPokedex.listPokemon(false);
                        myPokedex.sortPokedex();
                        break;
                    case 6:
                        return;
                    default:
                        System.out.println("That is not a valid choice. Try again.");
                        input.nextLine();
                        break;
                }
            } catch (InputMismatchException e) {
                System.out.println("That is not a valid choice. Try again.");
                input.nextLine();
            }
        }
    }
}
