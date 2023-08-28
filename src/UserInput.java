import java.util.InputMismatchException;
import java.util.Scanner;

public class UserInput extends Main{
    private static boolean isValid(int input) {
            if (input >= 0 && input <= 100) {
                return true;
            } else if (input < 0) {
                display(INPUT_UNDERSTATEMENT_WARNING);
                return false;

            } else {
                display(INPUT_EXAGGERATION_WARNING);
                return false;
            }
    }

    public static int get() {
        int inp = keyboardReader();
        if (isValid(inp)) {
            display("Thank you!");
            return inp;
        }
        return -1;
    }

    // this function took the input from user, check if it's valid and check if it's correct answer;
    // if it's not --> is a user answer higher or lower than correct;
    // + recursion
    public static void isCorrect(int userGuess, int correctAnswer) {
        if (userGuess == correctAnswer) {
            display(CORRECT_ANSWER_MESSAGE);
            endGame();
        }
        else if (userGuess < correctAnswer) {
            display(SMALLER_ANSWER_MESSAGE);
            runGame();
        }
        else {
            display(GREATER_ANSWER_MESSAGE);
            runGame();
        }
    }

    public static int keyboardReader() {
        try {
            Scanner keyboard = new Scanner(System.in);
            return keyboard.nextInt();
        } catch (InputMismatchException e) {
            display(ALPHABETIC_INPUT_WARNING);
            runGame();
        }
        return 0;
    }

    public static void display(String txt) {
        System.out.println(txt);
    }
}