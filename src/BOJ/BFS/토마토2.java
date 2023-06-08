package BOJ.BFS;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class 토마토2 {
    public static int cnt = 0;
    public static int[] dx = {1, -1, 0, 0, 0, 0};
    public static int[] dy = {0, 0, 1, -1, 0, 0};
    public static int[] dh = {0, 0, 0, 0, 1, -1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String str = br.readLine();
        StringTokenizer st = new StringTokenizer(str);

        int M = Integer.parseInt(st.nextToken());
        int N = Integer.parseInt(st.nextToken());
        int H = Integer.parseInt(st.nextToken());

        int[][][] arr = new int[H][N][M];
        Queue<int[]> que = new LinkedList<>();


        for (int h = 0; h < H; h++) {
            for (int i = 0; i < N; i++) {
                st = new StringTokenizer(br.readLine());
                for (int j = 0; j < M; j++) {
                    arr[h][i][j] = Integer.parseInt(st.nextToken());
                    if (arr[h][i][j] == 1) {
                        arr[h][i][j] = 2;
                        que.add(new int[]{i, j, h});
                    }
                }
            }
        }
        BFS(que, arr);
        if (!isRipe(arr)) { // 다익은게 아니면
            System.out.println("-1");
        } else {
            System.out.println(cnt);
        }

    }

    public static boolean isRipe(int[][][] arr) {
        boolean tag = true;
        Loop:
        for (int h = 0; h < arr.length; h++) {
            for (int i = 0; i < arr[0].length; i++) {
                for (int j = 0; j < arr[0][0].length; j++) {
                    if (arr[h][i][j] == 0) {
                        tag = false;
                        break Loop;
                    }
                }
            }
        }
        return tag;
    }

    public static void BFS(Queue<int[]> que, int[][][] arr) {
        while (!que.isEmpty()) {
            int size = que.size();
            boolean isColorChanged = false;
            for (int s = 0; s < size; s++) {
                int[] numArr = que.poll();
                int x = numArr[0];
                int y = numArr[1];
                int h = numArr[2];

                for (int k = 0; k < 6; k++) {
                    int nx = x + dx[k];
                    int ny = y + dy[k];
                    int nh = h + dh[k];
                    if (nx >= 0 && ny >= 0 && nh >= 0 && nh < arr.length && nx < arr[0].length && ny < arr[0][0].length) {
                        if (arr[nh][nx][ny] == 0) {
                            arr[nh][nx][ny] = 2;
                            isColorChanged = true;
                            que.add(new int[]{nx, ny, nh});
                        }
                    }
                }

            }
            if (isColorChanged) {
                cnt++;
            }
        }
    }

}
