package PRG.DP;

public class 등굣길 {
    public int solution(int m, int n, int[][] puddles) {
        int[][] arr = new int[n][m];
        init(m, n, arr, puddles);
        for (int i = 1; i < n; i++) {
            for (int j = 1; j < m; j++) {
                if (arr[i][j] >= 0) {
                    int sum = 0;
                    if (arr[i][j - 1] > 0) {
                        sum += arr[i][j - 1];
                    }
                    if (arr[i - 1][j] > 0) {
                        sum += arr[i - 1][j];
                    }
                    arr[i][j] = sum % 1000000007;
                }
            }
        }

        return arr[n - 1][m - 1];
    }

    public void init(int m, int n, int[][] arr, int[][] puddles) {
        for (int i = 0; i < puddles.length; i++) {

            int x = puddles[i][0] - 1;
            int y = puddles[i][1] - 1;
            arr[y][x] = -1;

        }
        for (int i = 1; i < m; i++) {
            if (arr[0][i] == -1) {
                break;
            }
            arr[0][i] = 1;
        }
        for (int i = 1; i < n; i++) {
            if (arr[i][0] == -1) {
                break;
            }
            arr[i][0] = 1;
        }
    }
}
