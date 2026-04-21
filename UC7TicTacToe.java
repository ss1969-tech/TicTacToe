import java.util.Random;
import java.util.Scanner;

public class UC7TicTacToe {
    static boolean isHumanTurn;
    static char humanSymbol;
    static char computerSymbol;
    static String currentPlayer;
    static Scanner scanner = new Scanner(System.in);
    static Random random = new Random();

    public static void main(String[] args) {
        char[][] board = createEmptyBoard();
        tossAndAssignSymbols();
        displayTossResult();
        printBoard(board);

        if (isHumanTurn) {
            int slot = getUserSlot();
            int row = getRowFromSlot(slot);
            int col = getColFromSlot(slot);
            boolean validMove = isValidMove(board, row, col);

            System.out.println("Slot entered: " + slot);
            System.out.println("Row index: " + row);
            System.out.println("Column index: " + col);
            System.out.println("Move valid: " + validMove);

            if (validMove) {
                placeMove(board, row, col, humanSymbol);
                System.out.println("Move accepted.");
            } else {
                System.out.println("Move rejected.");
            }
        } else {
            computerMove(board);
        }

        printBoard(board);
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

    public static int getRowFromSlot(int slot) {
        return (slot - 1) / 3;
    }

    public static int getColFromSlot(int slot) {
        return (slot - 1) % 3;
    }

    public static boolean isValidMove(char[][] board, int row, int col) {
        boolean isWithinBounds = row >= 0 && row < 3 && col >= 0 && col < 3;
        if (!isWithinBounds) {
            return false;
        }

        return board[row][col] == '-';
    }

    public static void placeMove(char[][] board, int row, int col, char symbol) {
        board[row][col] = symbol;
    }

    public static void computerMove(char[][] board) {
        if (!hasMovesLeft(board)) {
            System.out.println("No valid moves left for computer.");
            return;
        }

        while (true) {
            int slot = random.nextInt(9) + 1;
            int row = getRowFromSlot(slot);
            int col = getColFromSlot(slot);

            if (isValidMove(board, row, col)) {
                placeMove(board, row, col, computerSymbol);
                System.out.println("Computer chose slot: " + slot);
                System.out.println("Computer move placed.");
                return;
            }
        }
    }

    public static boolean hasMovesLeft(char[][] board) {
        for (int row = 0; row < board.length; row++) {
            for (int col = 0; col < board[row].length; col++) {
                if (board[row][col] == '-') {
                    return true;
                }
            }
        }
        return false;
    }
}
