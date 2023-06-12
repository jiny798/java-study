package BOJ.BFS;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class 토마토 {
    private static int cnt = 0;
    private static int[] dx = {1, -1, 0, 0};
    private static int[] dy = {0, 0, 1, -1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String firstLine = br.readLine();
        StringTokenizer st = new StringTokenizer(firstLine);

        int M = Integer.parseInt(st.nextToken());
        int N = Integer.parseInt(st.nextToken());

        int[][] arr = new int[N][M];
        boolean isZero = true;
        Queue<int[]> que = new LinkedList<>();

        for (int i = 0; i < N; i++) {
            String line = br.readLine();
            st = new StringTokenizer(line);
            for (int j = 0; j < M; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
                if (arr[i][j] == 1) {
                    arr[i][j] = 2;
                    que.add(new int[]{i, j});
                }
                if (arr[i][j] == 0) {
                    isZero = false;
                }
            }
        }
        BFS(que, arr);
        if (isZero) {
            System.out.println("0");
        } else if (checkZero(arr)) {
            System.out.println("-1");
        } else {
            System.out.println(cnt);
        }
    }
    public static boolean checkZero(int[][] arr) {
        boolean tag = false;
        Loop:
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[0].length; j++) {
                if (arr[i][j] == 0) {
                    tag = true;
                    break Loop;
                }
            }
        }
        return tag;
    }

    public static void BFS(Queue<int[]> que, int[][] arr) {
        while (!que.isEmpty()) {
            int size = que.size();
            boolean tag = false;
            for (int i = 0; i < size; i++) {
                int[] point = que.poll();
                int x = point[0];
                int y = point[1];

                for (int k = 0; k < 4; k++) {
                    int nx = x + dx[k];
                    int ny = y + dy[k];
                    if (nx >= 0 && ny >= 0 && nx < arr.length && ny < arr[0].length) {
                        if (arr[nx][ny] == 0) {
                            tag = true;
                            arr[nx][ny] = 2;
                            que.add(new int[]{nx, ny});
                        }
                    }
                }

            }
            if (tag == true) {
                cnt++;
            }
        }
    }
}
