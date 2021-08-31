package matrix;

public class LefttoRight {

    public static int N = 3;
    public static void main(String ar[]) {
        int[][] A = new int[][]{
                {10, 7, 5},
                {5, 17, 3},
                {14, 3, 2}
        };

        if (solveNQUtil(A, 0) == false) {
            System.out.printf("Solution does not exist");
            return;
        }

    }
    static void printSolution(int A[][]) {

        for (int i = 0; i < N; i++)  {
            for (int j = 0; j < N; j++)
                System.out.printf(" %d ", A[i][j]);
            System.out.printf("\n");
        }
    }

    static boolean isSafe(int A[][], int row, int col) {
        int i, j;

        /* Check this row on left side */
        for (i = 0; i < col; i++)
            if (A[row][i] == 1)
                return false;

        /* Check upper diagonal on left side */
        for (i = row, j = col; i >= 0 && j >= 0; i--, j--)
            if (A[i][j] == 1)
                return false;

        /* Check lower diagonal on left side */
        for (i = row, j = col; j >= 0 && i < N; i++, j--)
            if (A[i][j] == 1)
                return false;

        return true;
    }

    static void solveNQ() {
        int A[][] = new int[N][N];

        if (solveNQUtil(A, 0) == false) {
            System.out.printf("Solution does not exist");
            return ;
        }

        return ;
    }

    static boolean solveNQUtil(int A[][], int col) {
        if (col == N) {
            printSolution(A);
            return true;
        }

        boolean res = false;
        for (int i = 0; i < N; i++) {
            if ( isSafe(A, i, col) ) {
                A[i][col] = 1;
                res = solveNQUtil(A, col + 1) || res;
                A[i][col] = 0; // BACKTRACK
            }
        }
        return res;
    }

}
