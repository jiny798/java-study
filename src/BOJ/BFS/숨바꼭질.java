package BOJ.BFS;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.stream.Stream;

public class 숨바꼭질 {
    public static void main(String[] args) throws IOException {
        int answer = 0;
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String str = br.readLine();
        int[] arr = Stream.of(str.split(" ")).mapToInt(Integer::parseInt).toArray();

        int N = arr[0];
        int K = arr[1];

        boolean[] visited = new boolean[100001];

        UserPoint userPoint = new UserPoint(N, 0);
        visited[N] = true;

        Queue<UserPoint> que = new LinkedList<>();
        que.add(userPoint);

        while (!que.isEmpty()) {
            UserPoint findUser = que.poll();
            int x = findUser.x;
            int cnt = findUser.cnt;

            if (x == K) {
                answer = cnt;
                break;
            }

            if (x >= 1 && visited[x - 1] == false) {
                que.add(new UserPoint(x - 1, cnt + 1));
                visited[x - 1] = true;
            }
            if (x <= 99999 && visited[x + 1] == false) {
                que.add(new UserPoint(x + 1, cnt + 1));
                visited[x + 1] = true;

            }
            if (x <= 50000 && visited[x * 2] == false) {
                que.add(new UserPoint(x * 2, cnt + 1));
                visited[x * 2] = true;
            }
        }
        System.out.println(answer);
    }

    static class UserPoint {
        public int x;
        public int cnt;

        UserPoint(int a, int b) {
            x = a;
            cnt = b;
        }
    }

}
