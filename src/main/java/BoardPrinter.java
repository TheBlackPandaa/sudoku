public class BoardPrinter {
    public void BoardPrinter(int[][] board) {
        for (int[] ints : board) {
            System.out.print("|");
            for (int j = 0; j < board.length; j++) {
                System.out.print(ints[j] + "|");
            }
            System.out.print('\n');
        }
    }
}
