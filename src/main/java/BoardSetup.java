import java.util.Scanner;

public class BoardSetup {

    int[][] board = new int[9][9];

    public int[][] boardFill() throws InvalidInputException {
        BoardPrinter print = new BoardPrinter();
        boolean boardReady = false;
        String input;
        Scanner sc = new Scanner(System.in);
        int column;
        int row;
        int digit;
        while (!boardReady) {
            System.out.println("Enter a digit into column like : 1 2 3 = column 1 row 2 digit 3 all numbers must be in 1 - 9 range");
            input = sc.nextLine();
            if (input.equals("SUDOKU") || input.equals("sudoku")) {
                boardReady = true;
            } else {
                String strippedInput = input.replaceAll(" ", "");
                column = Character.getNumericValue(input.charAt(0));
                row = Character.getNumericValue(input.charAt(1));
                digit = Character.getNumericValue(input.charAt(2));
                if(column < 1 || column > 9 || row < 1 || row > 9 || digit < 1 || digit > 9) {
                    throw new InvalidInputException("Input out of range");
                }
                board[row - 1][column - 1] = digit;
                print.BoardPrinter(board);
            }
        }
        return board;
    }
}
