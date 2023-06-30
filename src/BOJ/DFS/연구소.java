package BOJ.DFS;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class 연구소 {
    public static int[] dx = {1, -1, 0, 0};
    public static int[] dy = {0, 0, 1, -1};
    public static ArrayList<int[]> virusList = new ArrayList<>();
    public static int MAX_SAFE_RESULT = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String line1 = br.readLine();
        String[] tokens = line1.split(" ");
        int m = Integer.parseInt(tokens[0]);
        int n = Integer.parseInt(tokens[1]);
        int[][] arr = new int[m][n];

        for (int i = 0; i < m; i++) {
            String line = br.readLine();
            String[] token = line.split(" ");
            for (int j = 0; j < n; j++) {
                arr[i][j] = Integer.parseInt(token[j]);
                if (arr[i][j] == 2) {
                    virusList.add(new int[]{i, j});
                }
            }
        }
        BT(0, 0, arr, 0);

        System.out.println(MAX_SAFE_RESULT);

    }

    public static void BT(int x, int y, int[][] arr, int cnt) {
        if (cnt == 3) {
//            printArr(arr);
            int[][] copyArr = copyArr(arr);
            spreadVirus(copyArr);
            int result = calculateArea(copyArr);
            if (MAX_SAFE_RESULT < result) {
                MAX_SAFE_RESULT = result;
            }
            return;
        }

        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[0].length; j++) {
                if (arr[i][j] == 0) {
                    arr[i][j] = 1;
                    cnt++;
                    BT(i, j, arr, cnt);
                    cnt--;
                    arr[i][j] = 0;
                }
            }
        }
    }

    public static int[][] copyArr(int[][] arr) {
        int[][] copyArr = new int[arr.length][arr[0].length];

        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[0].length; j++) {
                copyArr[i][j] = arr[i][j];
            }
        }
        return copyArr;
    }

    public static void spreadVirus(int[][] arr) {
        for (int[] numArr : virusList) {
            int x = numArr[0];
            int y = numArr[1];
            dfs(x, y, arr);
        }
    }

    public static void dfs(int x, int y, int[][] arr) {
        arr[x][y] = 2;
        for (int k = 0; k < 4; k++) {
            int nx = x + dx[k];
            int ny = y + dy[k];
            if (nx >= 0 && ny >= 0 && nx < arr.length && ny < arr[0].length) {
                if (arr[nx][ny] == 0) {
                    dfs(nx, ny, arr);
                }
            }

        }
    }

    public static int calculateArea(int[][] arr) {
        int cnt = 0;
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[0].length; j++) {
                if (arr[i][j] == 0) {
                    cnt++;
                }
            }
        }
        return cnt;
    }

    public static void printArr(int[][] arr) {
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[0].length; j++) {
                System.out.print(arr[i][j] + " ");
            }
            System.out.println();
        }

        System.out.println();
    }

}
