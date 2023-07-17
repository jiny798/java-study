package LC.DP;

public class Minimum_Path_Sum {
    public int minPathSum(int[][] grid) {

        int n = grid.length; //세로 길이
        int m = grid[0].length; // 가로 길이
        int[][] F = new int[n][m];

        //F[n-1][m-1] = min(F[n-2][m-1],F[n-1][m-2])+F[n-1][m-1] ;
        F[0][0] = grid[0][0];
        for (int i = 1; i < m; i++) {
            F[0][i] = grid[0][i] + F[0][i - 1];
        }
        for (int i = 1; i < n; i++) {
            F[i][0] = grid[i][0] + F[i - 1][0];
        }

        for (int i = 1; i < n; i++) {
            for (int j = 1; j < m; j++) {
                F[i][j] = Math.min(F[i - 1][j], F[i][j - 1]) + grid[i][j];
            }
        }

        return F[n - 1][m - 1];

    }
}
