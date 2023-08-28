public class Main {
    static final String INPUT_CLARIFICATION_MESSAGE = "Please enter a number between 0 and 100";
    static final String GREATER_ANSWER_MESSAGE = "Your guess is greater than correct answer, please try again";
    static final String SMALLER_ANSWER_MESSAGE = "Your guess is smaller than correct answer, please try again";
    static final String CORRECT_ANSWER_MESSAGE = "Your guess is correct! Congratulations";
    static final String INPUT_EXAGGERATION_WARNING = "Your guess is greater than 100! Please try again";
    static final String INPUT_UNDERSTATEMENT_WARNING = "Your guess is smaller than 0! Please try again";
    static final String ALPHABETIC_INPUT_WARNING = "You entered alphabetic answer! Please try again";

    static int correctNumber = (int) (Math.random() * (100 + 1) + 0);

    public static int getNewNumber() {
        return (int) (Math.random() * (100 + 1) + 0);
    }

    public static void runGame() {
        UserInput.display(INPUT_CLARIFICATION_MESSAGE);
        int userGuess = UserInput.get();
        if (userGuess != -1) {
        UserInput.isCorrect(userGuess, correctNumber);
    } else {
            runGame();
        }
    }

    public static void endGame() {
        UserInput.display("Do you want to play again?");
        UserInput.display("Press 1 to continue, 0 to exit the game");
        int userAnswer = UserInput.keyboardReader();
        if (userAnswer == 1) {
         correctNumber = getNewNumber();
         runGame();
        } else {
            UserInput.display("Bye bye!");
            System.exit(0);
        }
    }

    public static void main(String[] args) {
        runGame();
    }
}
