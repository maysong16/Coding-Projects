/* Name: May Song
Date: 10/16/17
 */

import java.util.InputMismatchException;
import java.util.Scanner;
public class CharSorter {

    public static String[] alphabeticalSort(String[] userString) { //method to sort characters alphabetically
        int x = 0;
        String temp = ""; //temporary variable to swap
        boolean sortEnd = false;
        while (!sortEnd) {
            sortEnd = true;
            x++;
            for (int i = 0; i < userString.length - x; i++) {
                if (userString[i].charAt(0) > userString[i + 1].charAt(0)) {
                    temp = userString[i];
                    userString[i] = userString[i + 1];
                    userString[i + 1] = temp;
                    sortEnd = false;
                }
            }
        }
        return userString;
    }
    public static void frequencyCount(String[] userString, int[] freq, String[] freqCharacter, int menuOption) { //method to count frequency of each character
        int count = 0;
        int p = 0; //number of distinct characters, removed duplicates
        for (int i = 0; i < userString.length; i++) {
            for (int n = 0; n < userString.length; n++) {
                if (userString[n].charAt(0) == userString[i].charAt(0)) {
                    count++;
                }
            }
            boolean found = false;
            for (int m = 0; m < p; m++) {
                if (freqCharacter[m].charAt(0) == userString[i].charAt(0)) {
                    found = true;
                    break;
                }
            }
            if (found == false) {
                freq[p] = count;
                freqCharacter[p] = userString[i];
                p++;
            }
            count = 0;
        }
        if (menuOption ==1) {
            for (int i = 0; i < p; i++) {
                System.out.println(freqCharacter[i] + " freq: " + freq[i]);
            }
            System.out.println("");
        }
    }

    public static void frequencySort(String[] userString, int[] freq, String[] freqCharacter, int menuOption) { //method to sort characters by frequency, highest to lowest
        int x = 0;
        int temp = 0;
        String tempTwo = ""; //temporary variable to swap
        boolean sortEnd = false;
        while (!sortEnd) {
            sortEnd = true;
            x++;
            for (int i = 0; i < freq.length - x; i++) {
                if (freq[i] < freq[i + 1]) {
                    temp = freq[i];
                    tempTwo = freqCharacter[i];
                    freq[i] = freq[i + 1];
                    freqCharacter[i] = freqCharacter[i + 1];
                    freq[i + 1] = temp;
                    freqCharacter[i + 1] = tempTwo;
                    sortEnd = false;
                }
            }
        }
        System.out.println("The sorted by frequency characters are:");
        System.out.println("");
        for (int i = 0; i < freq.length; i++) {
            if ((freq[i] > 0) && (freqCharacter[i] != null)) { //accounts for null or nonexisting characters
                System.out.println(freqCharacter[i] + " freq: " + freq[i]);
            }
        }
        System.out.println("");
    }

    public static void charTypes(String[] userString) { //method to sort data into four categories, using ascii values
        int textCount = 0; //textual character count
        int numCount = 0; //numeric character count
        int whiteSpaceCount = 0;//whitespace character count
        int symbolCount = 0;//symbolic character count
        int[] userInt = new int[userString.length];
        for (int i = 0; i < userString.length; i++) {
            userInt[i] = userString[i].charAt(0);
            if ((userInt[i] >= 65 && userInt[i] <= 90) || (userInt[i] >= 97 && userInt[i] <= 122)) {
                textCount++;
            } else if ((userInt[i] >= 48 && userInt[i] <= 57)) {
                numCount++;
            } else if (userInt[i] == 32) {
                whiteSpaceCount++;
            } else if ((userInt[i] >= 33 && userInt[i] <= 47) || (userInt[i] >= 58 && userInt[i] <= 64) || (userInt[i] >= 91 && userInt[i] <= 96 || (userInt[i] >= 93 && userInt[i] <= 127))) {
                symbolCount++;
            } else {
                return;
            }
        }
        System.out.println("Textual Character count: " + textCount);
        System.out.println("Numerical Character count: " + numCount);
        System.out.println("WhiteSpace Character count: " + whiteSpaceCount);
        System.out.println("Symbol Character count: " + symbolCount);
        System.out.println("");
    }

    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);
        int size = 0;
        System.out.println("Welcome to Character Sorter Program");
        System.out.println("Please input a string to be sorted");
        String user = input.nextLine();
        size = user.length();
        String userString[] = new String[size]; //userString is a global array
        for (int i = 0; i < size; i++) {
            userString[i] = "" + user.charAt(i);
        }
        int[] freq = new int[userString.length];
        String[] freqCharacter = new String[freq.length];
        int menuOption = 0;
        while (menuOption != 4) {
            System.out.println("Please select the option you would like to see");
            System.out.println("");
            System.out.println("1.Display character frequencies alphabetically");
            System.out.println("2.Display sorted frequencies");
            System.out.println("3.Show types of character frequencies");
            System.out.println("4.Exit");
            try {
                menuOption = input.nextInt();
            switch (menuOption) {
                case 1:
                    alphabeticalSort(userString);
                    frequencyCount(userString, freq, freqCharacter, menuOption);
                    break;
                case 2:
                    frequencyCount(userString, freq, freqCharacter, menuOption); //takes sorted userString from alphabeticalSort
                    frequencySort(userString, freq, freqCharacter, menuOption);
                    break;
                case 3:
                    charTypes(userString);
                    break;
                case 4:
                    System.out.println("Character Sorter Exited Successfully");
                    return;
                default:
                    System.out.println("Error, bad input, please enter a number 1-4");
                    input.nextLine();
                    break;
            }
        }
         catch (InputMismatchException e) {
            System.out.println("Error, bad input, please enter a number 1-4");
            input.nextLine();
        }
        }
    }
}
