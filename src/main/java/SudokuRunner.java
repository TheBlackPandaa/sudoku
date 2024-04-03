public class SudokuRunner {

    public SudokuRunner() throws InvalidInputException{
        BoardSetup setup = new BoardSetup();
        BoardPrinter printer = new BoardPrinter();
        int[][] filledBoard = setup.boardFill();
        int n = filledBoard.length;
        SudokuSolver solver = new SudokuSolver();
        if(solver.solveSudoku(filledBoard, n)){
            printer.BoardPrinter(filledBoard);
        }else{
            System.out.println("No solution");
        }
    }
}
