import java.util.Random;
import java.util.Scanner;

public class UC3TicTacToe {
    static boolean isHumanTurn;
    static char humanSymbol;
    static char computerSymbol;
    static String currentPlayer;
    static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        char[][] board = createEmptyBoard();
        tossAndAssignSymbols();
        displayTossResult();
        printBoard(board);

        int slot = getUserSlot();
        System.out.println("Slot entered: " + slot);
    }

    public static char[][] createEmptyBoard() {
        char[][] board = new char[3][3];

        for (int row = 0; row < board.length; row++) {
            for (int col = 0; col < board[row].length; col++) {
                board[row][col] = '-';
            }
        }

        return board;
    }

    public static void tossAndAssignSymbols() {
        Random random = new Random();
        isHumanTurn = random.nextBoolean();

        if (isHumanTurn) {
            humanSymbol = 'X';
            computerSymbol = 'O';
            currentPlayer = "Human";
        } else {
            humanSymbol = 'O';
            computerSymbol = 'X';
            currentPlayer = "Computer";
        }
    }

    public static void displayTossResult() {
        System.out.println("Toss result: " + currentPlayer + " plays first.");
        System.out.println("Human symbol: " + humanSymbol);
        System.out.println("Computer symbol: " + computerSymbol);
        System.out.println();
    }

    public static void printBoard(char[][] board) {
        for (int row = 0; row < board.length; row++) {
            for (int col = 0; col < board[row].length; col++) {
                System.out.print(board[row][col] + " ");
            }
            System.out.println();
        }
    }

    public static int getUserSlot() {
        System.out.print("Enter slot number (1-9): ");
        return scanner.nextInt();
    }
}
