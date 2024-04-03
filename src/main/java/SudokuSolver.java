public class SudokuSolver {
    public boolean isSafe(int[][] board, int row, int column, int digit) {
        for (int d = 0; d < board.length; d++) {
            if (board[row][d] == digit) {
                return false;
            }
        }

        for (int r = 0; r < board.length; r++) {
            if (board[r][column] == digit) {
                return false;
            }
        }
        int sqrt = (int)Math.sqrt(board.length);
        int boxRowStart = row - row % sqrt;
        int boxColStart = column - column % sqrt;

        for (int r = boxRowStart;
             r < boxRowStart + sqrt; r++)
        {
            for (int d = boxColStart;
                 d < boxColStart + sqrt; d++)
            {
                if (board[r][d] == digit)
                {
                    return false;
                }
            }
        }
        return true;
    }
    public boolean solveSudoku(
            int[][] board, int n)
    {
        int row = -1;
        int column = -1;
        boolean isEmpty = true;
        for (int i = 0; i < n; i++)
        {
            for (int j = 0; j < n; j++)
            {
                if (board[i][j] == 0)
                {
                    row = i;
                    column = j;

                    isEmpty = false;
                    break;
                }
            }
            if (!isEmpty) {
                break;
            }
        }

        if (isEmpty)
        {
            return true;
        }

        for (int digit = 1; digit <= n; digit++)
        {
            if (isSafe(board, row, column, digit))
            {
                board[row][column] = digit;
                if (solveSudoku(board, n))
                {
                    return true;
                }
                else
                {
                    board[row][column] = 0;
                }
            }
        }
        return false;
    }
}
