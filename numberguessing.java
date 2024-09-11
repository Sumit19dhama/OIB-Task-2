import java.util.*;

public class numberguessing {
    static ArrayList<Integer> scoreBoard = new ArrayList<Integer>();
    public static void main(String[] args) {
        numberguessing playOption = new numberguessing();
        playOption.mainMenu(scoreBoard);
    }
    public void mainMenu(ArrayList<Integer> scoreBoard) {
        numberguessing playOption = new numberguessing();
        Scanner sc = new Scanner(System.in);
        System.out.println("--------------------------------");
        System.out.println("  Welcome to the number game");
        System.out.println("--------------------------------");

        System.out.println("      1) Play the Game");
        System.out.println("      2) Score Board");
        System.out.println("      3) Quit the game");
        System.out.println("-------------------------------");
        try {
            System.out.println("  Select anyone from above!");
            System.out.print("              ");
            int choice = sc.nextInt();
            switch (choice) {
                case 1:
                    System.out.print("\n"+"Select the range of number... ");
                    int numberRange = sc.nextInt();
                    int randomNumber = playOption.randomNumber(numberRange);
                    playOption.guessNumber(randomNumber);
                    break;
                case 2:
                    playOption.displayScoreBoard();
                    break;
                case 3:
                    System.out.println("\n"+"Thanks for playing the game!");
                    System.exit(1);
                    break;
                default:
                    throw new InputMismatchException("Invalid number entry.Could you please Try again later!");
            }
        }catch(InputMismatchException e){
            System.err.println("\n"+e.getMessage() +"\n");
            mainMenu(scoreBoard);
        }
    }
    public int randomNumber(int numberRange) {
        Random random = new Random();
        int randomNumber = random.nextInt(numberRange) + 1;
        return randomNumber;
    }
    public void guessNumber(int randomNumber) {
        Scanner sc = new Scanner(System.in);
        int userGuess;
        int tryno = 0;
        do {
            System.out.print("Enter your guess number: ");
            userGuess = sc.nextInt();
            tryno++;
            if (userGuess > randomNumber) {
                System.out.println("       Lower!");
            }
            else{
                if (userGuess < randomNumber) {
                System.out.println("       Higher!");
                }
            }
        } while (randomNumber != userGuess);
        System.out.println(" ");
        if (tryno == 1) {
            System.out.println("     Congratulations!");
            System.out.println("You answered number is right in " + tryno + " try!");
        } else {
            System.out.println("     Congratulations!");
            System.out.println("You answered number is right in " + tryno + " tries!");
        }
        scoreBoard.add(tryno);
        System.out.println(" ");

        mainMenu(scoreBoard);
    }
    public void displayScoreBoard() {
        System.out.println("-------------------------------------------------");
        System.out.println("                  Score Board                    ");
        System.out.println("-------------------------------------------------");
        System.out.println("Your fastest games today out of all tries is: " + "\n");
        Collections.sort(scoreBoard);
        for (Integer scores : scoreBoard) {
            System.out.println("   Finished the number game in " + scores + " tries");
        }
        System.out.println(" ");
        mainMenu(scoreBoard);
    }
}
