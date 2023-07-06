package PRG.DP;

public class 정수삼각형 {
    public int solution(int[][] triangle) {
        int answer = 0;
        int max = 0;
        if (triangle.length == 1) {
            return triangle[0][0];
        }
        for (int i = 1; i < triangle.length; i++) {
            for (int j = 0; j < triangle[i].length; j++) {

                if (j == 0) { //맨 좌측
                    triangle[i][j] = triangle[i - 1][0] + triangle[i][j];
                } else if (j == i) { //맨 우측
                    triangle[i][j] = triangle[i - 1][j - 1] + triangle[i][j];
                } else {
                    triangle[i][j] = triangle[i][j] + maxfun(triangle[i - 1][j - 1], triangle[i - 1][j]);
                }
            }
        }
        for (int k = 0; k < triangle[triangle.length - 1].length; k++) {
            if (triangle[triangle.length - 1][k] > max) {
                max = triangle[triangle.length - 1][k];
            }
        }
        return max;
    }

    public static int maxfun(int a, int b) {
        if (a < b) {
            return b;
        } else {
            return a;
        }
    }
}
