public class Sudoku {

    public static final int BOARD_SIZE = 9;

    public static void main(String[] args) {
        int[][] board =
                {
                        {7,0,2,0,5,0,6,0,0},
                        {0,0,0,0,0,3,0,0,0},
                        {1,0,0,0,0,9,5,0,0},
                        {8,0,0,0,0,0,0,9,0},
                        {0,4,3,0,0,0,7,5,0},
                        {0,9,0,0,0,0,0,0,8},
                        {0,0,9,7,0,0,0,0,5},
                        {0,0,0,2,0,0,0,0,0},
                        {0,0,7,0,4,0,2,0,3}
                };


        if (solveSudoku(board)){
            System.out.println("Sudoku is solved");
            printSudoku(board);
        }else{
            System.out.println("It is imposible to solve sudoku");
        }
    }

    private static void printSudoku(int[][] board) {
        for (int i = 0; i < BOARD_SIZE; i++) {
            for (int j = 0; j < BOARD_SIZE; j++) {
                System.out.print(board[i][j]);
                if (j %3 == 2) {
                    System.out.print("|");
                }

            }
            System.out.println();
            System.out.println("------------");
        }
    }

    public static boolean checkRow(int[][] board,int row, int number) {
        for (int i = 0; i < BOARD_SIZE; i++) {
            if (board[row][i] == number)
                return false;
        }
        return true;
    }

    public static boolean checkColumn(int[][] board,int column, int number) {
        for (int i = 0; i < BOARD_SIZE; i++) {
            if (board[i][column] == number)
                return false;
        }
        return true;
    }

    public static boolean checkBox(int[][] board, int row, int column, int number) {
        int localRow = row - row % 3;
        int localColumn = column - column % 3;
        for (int i = localRow; i < localRow + 3 ; i++) {
            for (int j = localColumn; j < localColumn + 3 ; j++){
                if (board[i][j] == number)
                    return false;
            }
        }
         return  true;
    }

    public static boolean isValidPlacement(int[][] board, int row, int column, int number) {
        return checkBox(board,row, column, number) && checkRow(board, row, number) && checkColumn(board, column, number);
    }

    public static boolean solveSudoku(int[][] board) {
        for (int row = 0; row < BOARD_SIZE; row++) {
            for (int column = 0; column < BOARD_SIZE; column++) {
                if (board[row][column] == 0){
                    for (int number = 1; number < 10; number++) {
                        if (isValidPlacement(board, row, column, number)) {
                            board[row][column] = number;
                            if (solveSudoku(board)) {
                                return true;
                            }
                            else {
                                board[row][column] = 0;
                            }
                        }
                    }
                    return false;
                }
            }
        }
     return true;
    }
}
