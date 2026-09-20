public class Backtracking {

    public static void subsets(String str, int i, String newStr) {
        // base case
        if (i == str.length()) {
            if (newStr.length() == 0) {
                System.out.print("null");
            } else {
                System.out.println(newStr);
            }
            return;
        }
        // recursion
        subsets(str, i + 1, newStr + str.charAt(i));
        subsets(str, i + 1, newStr);
    }

    public static void findPermutation(String str, String ans) {
        // base case
        if (str.length() == 0) {
            System.out.println(ans);
            return;
        }
        // recursion
        for (int i = 0; i < str.length(); i++) {
            char ch = str.charAt(i);
            String newStr = str.substring(0, i) + str.substring(i + 1);
            findPermutation(newStr, ans + ch);
        }
    }

    public static int count = 0;

    // nQueens problem
    public static boolean nQueens(char board[][], int row) {
        if (row == board.length) {
            // printBoard(board);
            // count++;
            return true;
        }
        for (int j = 0; j < board.length; j++) {
            if (isSafe(board, row, j)) {
                board[row][j] = 'Q';
                if (nQueens(board, row + 1)) {
                    return true;
                }
            }
            board[row][j] = 'x';
        }
        return false;
    }

    public static boolean isSafe(char board[][], int row, int col) {
        // bottom to top
        for (int i = row; i >= 0; i--) {
            if (board[i][col] == 'Q') {
                return false;
            }
        }
        // bottom to left conner
        for (int i = row, j = col; i >= 0 && j >= 0; i--, j--) {
            if (board[i][j] == 'Q') {
                return false;
            }
        }
        // bottom to right conner

        for (int i = row, j = col; i >= 0 && j < board.length; i--, j++) {
            if (board[i][j] == 'Q') {
                return false;
            }
        }
        return true;
    }

    // print board
    public static void printBoard(char board[][]) {
        System.out.println("---------chess board -------------");
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board.length; j++) {
                System.out.print(board[i][j] + " ");
            }
            System.out.println();
        }
    }

    // Grid Ways problem
    public static int gridWays(int i, int j, int n, int m) {
        // base case
        if (i == n - 1 && j == m - 1) {
            return 1;
        } else if (i == n || j == m) {
            return 0;
        }
        // recursion part
        int w1 = gridWays(i + 1, j, n, m);
        int w2 = gridWays(i, j + 1, n, m);
        return w1 + w2;
    }

    public static int fact(int n) {
        if (n == 0)
            return 1;
        return n * fact(n - 1);
    }

    public static int gridWays2(int n, int m) {

        return fact(n - 1) + fact(m - 1) / fact(n - 1) * fact(m - 1);
    }

    public static boolean sudokuSolver(int sudoku[][], int row, int col) {
        // base case
        if (row == 9) {
            return true;
        }

        // actual recursion
        int nextRow = row;
        int nextCol = col + 1;

        if (col + 1 == 9) {
            nextRow = row + 1;
            nextCol = 0;
        }

        if (sudoku[row][col] != 0) {
            return sudokuSolver(sudoku, nextRow, nextCol);
        }

        for (int digit = 1; digit <= 9; digit++) {
            if (isSafePlace(sudoku, row, col, digit)) {
                sudoku[row][col] = digit;
                if (sudokuSolver(sudoku, nextRow, nextCol)) {
                    return true;
                }
            }
            sudoku[row][col] = 0;
        }

        return false;
    }

    public static boolean isSafePlace(int sudoku[][], int row, int col, int digit) {

        // check row
        for (int i = 0; i <= 8; i++) {
            if (sudoku[i][col] == digit) {
                return false;
            }
        }

        // check col
        for (int j = 0; j <= 8; j++) {
            if (sudoku[row][j] == digit) {
                return false;
            }
        }

        // check 3x3 grid

        int sr = (row / 3) * 3;
        int sc = (col / 3) * 3;

        for (int i = sr; i < sr + 3; i++) {
            for (int j = sc; j < sc + 3; j++) {
                if (sudoku[i][j] == digit) {
                    return false;
                }
            }
        }
        return true;
    }

    public static void printSudoku(int sudoku[][]) {
        for (int i = 0; i < sudoku.length; i++) {
            for (int j = 0; j < sudoku[0].length; j++) {
                System.out.print(sudoku[i][j] + " ");
            }
            System.out.println();
        }
    }

    public static void main(String args[]) {
        // subsets problem 01-------------------
        // subsets("abc", 0, "");

        // subsets problem 02 -------------------
        // findPermutation("abc", "");

        // NQueens problem 03 -------------------
        // int n = 4;
        // char board[][] = new char[n][n];

        // for (int i = 0; i < n; i++) {
        // for (int j = 0; j < n; j++) {
        // board[i][j] = 'x';
        // }
        // }
        // if (nQueens(board, 0)) {
        // printBoard(board);
        // }
        // System.out.print("Total ways: " + count);

        // grid ways problem 04-------------------
        // int n = 3;
        // int m = 3;
        // int ways = gridWays(0, 0, n, m);
        // System.out.println("Total Grid Ways: " + ways);

        // System.out.println("Total Grid Ways: " + gridWays2(n, m));
        // System.out.println(fact(5));

        int sudoku[][] = {
                { 0, 0, 8, 0, 0, 0, 0, 0, 0 },
                { 4, 9, 0, 1, 5, 7, 0, 0, 2 },
                { 0, 0, 3, 0, 0, 4, 1, 9, 0 },
                { 1, 8, 5, 0, 6, 0, 0, 2, 0 },
                { 0, 0, 0, 0, 2, 0, 0, 6, 0 },
                { 9, 6, 0, 4, 0, 5, 3, 0, 0 },
                { 0, 3, 0, 0, 7, 2, 0, 0, 4 },
                { 0, 4, 9, 0, 3, 0, 0, 5, 7 },
                { 8, 2, 7, 0, 0, 9, 0, 1, 3 },
        };
        boolean result = sudokuSolver(sudoku, 0, 0);

        if (result) {
            System.out.println("Sudoku exist");
            printSudoku(sudoku);
        } else {
            System.out.println("Sudoku not exist");
        }

    }
}
