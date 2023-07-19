package BOJ.BFS;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.stream.Stream;

public class 숨바꼭질 {
    public static int minCnt = Integer.MAX_VALUE;
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String str = br.readLine();
        int[] arr = Stream.of(str.split(" ")).mapToInt(Integer::parseInt).toArray();

        int N = arr[0];
        int K = arr[1];
        int[] visited = new int[100000];
        visited[N] = 1;
        if (N>=1) {
            visited[N-1] = 1;
            dfs(N - 1, K, 1,visited);
            visited[N-1] = 0;
        }

        if (N <= 99999) {
            visited[N+1] = 1;
            dfs(N + 1, K, 1,visited);
            visited[N+1] = 0;
        }

        if (N <= 50000) {
            visited[N*2] = 1;
            dfs(N * 2, K, 1,visited);
        }
        System.out.println(minCnt);

    }

    public static void dfs(int distance , int K, int cnt,int[] visited ){
        if(distance == K){
            if(minCnt > cnt){
                minCnt = cnt;
            }
            return;
        }
        if(distance>=1&& visited[distance-1] == 0) {
            visited[distance-1] = 1;
            dfs(distance - 1, K, cnt + 1,visited);
            visited[distance-1] = 0;
        }
        if (distance <= 99999 && visited[distance+1] == 0) {
            visited[distance+1] = 1;
            dfs(distance + 1, K, cnt + 1,visited);
            visited[distance+1] = 0;
        }
        if (distance <= 50000 && visited[distance*2] == 0) {
            visited[distance*2] = 1;
            dfs(distance * 2, K, cnt + 1,visited);
            visited[distance*2] = 0;
        }
    }
}
