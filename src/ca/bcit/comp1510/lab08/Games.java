package ca.bcit.comp1510.lab08;

import java.util.Scanner;
import java.util.Random;

/** Games class for playing various games.
 * 
 * @author Sohee Hwang
 * @version 2023
 * 
 */
public class Games {
    
    /** Instance variable for user.*/
    private int score;
    
    /** Instance variable for user .*/
    private Scanner scan;
    
    /** Instance variable  for random objects.*/
    private Random rand;
    
    /**
     * Constructor : user score to 0, 
     * instantiates Scanner object and Random object.
     */
    public Games() {
        score = 0;
        scan = new Scanner(System.in); 
        rand = new Random();
    }
    
    /**
    * Drives the program.
    * @param args unused
    */
    public static void main(String[] args) {
        Games myGame = new Games();
        myGame.play();
    }
    
    /**
     * Play method for the games.
     */
    public void play() {
        final int three = 3;
        final int four = 4;
        int choice = 0;
        while (choice != four) {
            System.out.println("Welcome to the Games program! "
                    + "\nMake your choice (enter a number):"
                    + "\n1. See your score"
                    + "\n2. Guess a number"
                    + "\n3. Play Rock, Paper, Scissors"
                    + "\n4. Quit");
            choice = scan.nextInt();
            scan.nextLine();
            if (choice == 1) {
                System.out.println("Your score is: " + score);
            } else if (choice == 2) {
                guessANumber();
            } else if (choice == three) {
                rockPaperScissors();
            } else if (choice == four) {
                System.out.println("You have existed the program, Goodbye!");
            }
        }
    }
    
    /**
     * Method for guessing a random number.
     */
    public void guessANumber() {
        final int hundredOne = 101;
        final int five = 5;
        int numberToGuess = rand.nextInt(hundredOne);
     
        System.out.println("I've picked a random number between 0 and 100."
                + "\nCan you guess it?");
        int guessCount = 0;
        while (true) {
            guessCount++;
            System.out.print("Guess the number: ");
            int guess = scan.nextInt();
            if (guess < numberToGuess) {
                System.out.println("Too low, guess again!");
            } else if (guess > numberToGuess) {
                System.out.println("Too high, guess again!");
            } else {
                System.out.println("RIGHT!");
                if (guessCount <= five) {
                    System.out.println("Five points!");
                    score += five;
                }
                break;
            }
        }
    }
    
    /**
     * Method for playing rock paper scissors.
     */
    public void rockPaperScissors() {
        final int three = 3;
        final int five = 5;
        String[] options = {"ROCK", "PAPER", "SCISSORS"};
        String computerOption = options[rand.nextInt(three)];
        String userOption = "";

        System.out.println("I've picked one of ROCK, PAPER, and SCISSORS");

        while (!userOption.equals("ROCK") && !userOption.equals("PAPER") 
                && !userOption.equals("SCISSORS")) {
            System.out.println("Which one do you choose?");
            userOption = scan.nextLine().toUpperCase();
            if (!userOption.equals("ROCK") && !userOption.equals("PAPER") 
                    && !userOption.equals("SCISSORS")) {
                System.out.println("That's not a valid choice! Try again!");
            }
        }

        switch (userOption) {
            case "ROCK":
                if (computerOption.equals("SCISSORS")) {
                    System.out.println("Yes! " + userOption 
                            + " smashes " + computerOption);
                    score += five;
                } else if (computerOption.equals("PAPER")) {
                    System.out.println("Nope, I picked " + computerOption
                            + "\n" + computerOption 
                            + " wraps " + userOption);
                    score -= three;
                } else {
                    System.out.println("It's a tie!");
                }
                break;
            case "PAPER":
                if (computerOption.equals("ROCK")) {
                    System.out.println("Yes! " + userOption
                            + " wraps " + computerOption);
                    score += five;
                } else if (computerOption.equals("SCISSORS")) {
                    System.out.println("Nope, I picked " + computerOption
                            + "\n" + computerOption 
                            + " cut " + userOption);
                    score -= three;
                } else {
                    System.out.println("It's a tie!");
                }
                break;
            case "SCISSORS":
                if (computerOption.equals("PAPER")) {
                    System.out.println("Yes! " + userOption 
                            + " cut " + computerOption);
                    score += five;
                } else if (computerOption.equals("ROCK")) {
                    System.out.println("Nope, I picked " + computerOption
                            + "\n" + computerOption 
                            + " smashes " + userOption);
                    score -= three;
                } else {
                    System.out.println("It's a tie!");
                }
                break;
            default:
                break;
        }
    }

}
