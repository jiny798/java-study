package BOJ.DFS;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashMap;

public class 텀프로젝트 {
    public static int cnt = 0;
    public static int N = 0;
    public static HashMap<Integer,Integer> map ;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int num = Integer.parseInt(br.readLine());
        while (num != 0 ) {
            num--;
            cnt = 0;
            map = new HashMap<>();
            N = Integer.parseInt(br.readLine());
            boolean[] visited = new boolean[N];

            int[] arr = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::valueOf).toArray();

            for (int i = 0; i < N; i++) {
                if (visited[i] == false) {
                    visited[i] = true;
                    map.put(i, 1);
                    dfs(i, i, arr, visited);
                }
            }
            System.out.println(N - cnt);
        }
    }

    public static void dfs(int startIndex, int i, int[] arr, boolean[] visited) {
        visited[i] = true;
        if (i == arr[i] - 1) {
            cnt++;
            return;
        }

        if (startIndex == arr[i] - 1) {
            cnt += map.get(startIndex);
            return;
        }
        map.put(startIndex,map.get(startIndex)+1);

        if(visited[arr[i]-1] == false){
            dfs(startIndex,arr[i]-1,arr,visited);
        }

    }
}
