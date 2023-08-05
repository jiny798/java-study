package BOJ.DFS;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class 빙산 {
    public static int dx[] = {1, -1, 0, 0};
    public static int dy[] = {0, 0, 1, -1};
    public static int N = 0;
    public static int M = 0;
    public static boolean meltable = true;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] firstStr = br.readLine().split(" ");
        int[][] arr = new int[Integer.parseInt(firstStr[0])][Integer.parseInt(firstStr[1])];
        N = arr.length;
        M = arr[0].length;
        for (int i = 0; i < N; i++) {
            String[] str = br.readLine().split(" ");
            for (int j = 0; j < M; j++) {
                arr[i][j] = Integer.parseInt(str[j]);
            }
        }

        int year = 0;
        while (meltable) {
            year++;
            processMelt(arr);
//            printArr(arr);
            if (isDivided(arr)) {
                System.out.println(year);
                break;
            }
        }

        if (!meltable) {
            System.out.println(0);
        }

    }

    public static void processMelt(int[][] arr) {
        int[][] copyArr = new int[N][M];
        meltable = false;
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                int cnt = 0;
                if (arr[i][j] > 0) {
                    meltable = true;
                    for (int k = 0; k < 4; k++) {
                        if (arr[i + dx[k]][j + dy[k]] == 0) {
                            cnt++;
                        }
                    }
                    copyArr[i][j] = cnt;
                }
            }
        }

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                arr[i][j] = arr[i][j] - copyArr[i][j];
                if (arr[i][j] < 0) {
                    arr[i][j] = 0;
                }
            }
        }

    }

    public static boolean isDivided(int[][] arr) {
        boolean[][] visited = new boolean[N][M];
        int dividedCnt = 0;
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (arr[i][j] > 0 && visited[i][j] == false) {
                    dividedCnt++;
                    dfs(i, j, arr, visited);
                }
            }
        }

        if (dividedCnt >= 2) {
            return true;
        } else {
            return false;
        }
    }

    public static void dfs(int x, int y, int[][] arr, boolean[][] visited) {
        visited[x][y] = true;
        for (int k = 0; k < 4; k++) {
            int nx = x + dx[k];
            int ny = y + dy[k];
            if (nx >= 0 && ny >= 0 && nx < N && ny < M) {
                if (visited[nx][ny] == false && arr[nx][ny] > 0) {
                    dfs(nx, ny, arr, visited);
                }
            }

        }
    }

    public static void printArr(int[][] arr) {
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                System.out.print(arr[i][j] + " ");
            }
            System.out.println();
        }
        System.out.println();
    }
}
