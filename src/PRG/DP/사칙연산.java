package PRG.DP;

public class 사칙연산 {
    public static int min_result = Integer.MAX_VALUE;
    public static int max_result = Integer.MIN_VALUE;
    int[][][] dp = new int[2][101][101];

    public int solution(String arr[]) {
        int answer = -1;

        int[] numarr = new int[arr.length / 2 + 1];
        String[] oprarr = new String[arr.length / 2];
        int size = 0;
        for (int s = 0, i = 0; i < arr.length; i += 2) {
            numarr[s++] = Integer.parseInt(arr[i]);
            size = s; // 피연산자 개수
        }
        for (int s = 0, i = 1; i < arr.length; i += 2) {
            oprarr[s++] = arr[i];
        }
        for (int i = 0; i < 101; i++) {
            for (int j = 0; j < 101; j++) {
                dp[0][i][j] = Integer.MAX_VALUE;
                dp[1][i][j] = Integer.MIN_VALUE;
            }
        }

        //최소 = 최소+최소 최소-최대
        for (int i = 0; i < size; i++) { //피연산자가 하나인 경우는 자기 자신이 최대이자 최소값이다
            dp[0][i][i] = numarr[i];
            dp[1][i][i] = numarr[i];
        }

        for (int i = 2; i <= size; i++) {//피연산자 개수를 2개부터 묶어서 계산
            for (int j = 0; j <= size - i; j++) { //2개 만큼 묶었을때 총 연산자 개수 -1번 만큼 max,min 값을 구할수있음
                //ex.연산자5개에 2개씩 묶으면 4번 계산
                for (int k = 0; k < i - 1; k++) { // 2개만큼 묶었을때 연산자 1개 계산가능
                    if (oprarr[j + k].equals("+")) {
                        dp[0][j][j + i - 1] = Math.min(dp[0][j][j + k] + dp[0][j + k + 1][j + i - 1], dp[0][j][j + i - 1]);
                        dp[1][j][j + i - 1] = Math.max(dp[1][j][j + k] + dp[1][j + k + 1][j + i - 1], dp[1][j][j + i - 1]);
                    } else {
                        dp[0][j][j + i - 1] = Math.min(dp[0][j][j + k] - dp[1][j + k + 1][j + i - 1], dp[0][j][j + i - 1]);
                        dp[1][j][j + i - 1] = Math.max(dp[1][j][j + k] - dp[0][j + k + 1][j + i - 1], dp[1][j][j + i - 1]);
                    }
                }
            }
        }
        answer = dp[1][0][size - 1];
        return answer;
    }

}
