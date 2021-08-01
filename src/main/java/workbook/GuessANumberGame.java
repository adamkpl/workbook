package workbook;

import java.text.DecimalFormat;
import java.util.InputMismatchException;
import java.util.Random;
import java.util.Scanner;

public class GuessANumberGame {
    public static void main(String[] args) {

        boolean finish = false;
        int tries = 0;
        int triesValid = 0;
        int triesInvalid = 0;

        while (!finish) {
            // game here
            // App selects a random number
            int app_random_number = new Random().nextInt(4);
            //System.out.println("Cheat mode on: " + app_random_number);

            System.out.print("Guess a number [0-3]: ");
            Scanner scanner = new Scanner(System.in);
            int myGuess;

            try {
                myGuess = scanner.nextInt();
            } catch (InputMismatchException e) {
                System.out.println("Invalid input. The game is going to draw a random number for You.");
                myGuess = new Random().nextInt(3);
                System.out.println("The game drew: " + myGuess);
            }

            //todo assert if input is a number in a selected range, if not, repeat again

            // Assert if correct
            if (app_random_number == myGuess) {
                System.out.println("Correct!");
                triesValid++;
            } else {
                System.out.println("Incorrect. Better luck next time!");
                triesInvalid++;
            }

            System.out.println("Play again? [Y/N]");
            Scanner quit = new Scanner(System.in);
            String quitAnswer = quit.nextLine().toLowerCase().substring(0, 1);

            //todo assert if input is Y/N - if not, repeat the question
            finish = !quitAnswer.equals("y");
            tries++;
        }

        System.out.println("*** GAME OVER ***");
        System.out.println("Tries: " + tries);
        System.out.println("Correct: " + triesValid);
        System.out.println("Incorrect: " + triesInvalid);
        double successRatio = ((float) triesValid / (float) tries) * 100;
        DecimalFormat df = new DecimalFormat("#");
        System.out.println("Success ratio: " + df.format(successRatio) + "%");

    }

}