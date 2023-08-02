package BOJ.DFS;

import java.util.*;
import java.io.*;

public class 단지번호붙이기 {
    static int N;
    static int[] dx = {1, -1, 0, 0};
    static int[] dy = {0, 0, 1, -1};
    static List<Integer> results = new ArrayList<>();
    static int cnt = 0;
    static int n = 0 ;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine()); // 7
        int[][] map = new int[N][N];
        for (int i = 0; i < N; i++) {
            String st = br.readLine(); // 0110100
            String[] arr = st.split("");
            for (int j = 0; j < N; j++) {
                map[i][j] = Integer.parseInt(arr[j]);
            }
        }
        boolean[][] visited = new boolean[N][N]; // false
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if (map[i][j]==1 && visited[i][j] == false){
                    n++;
                    dfs(map,visited,i,j);
                    results.add(cnt);
                    cnt=0;
                }
            }
        }
        System.out.println(n);
        Collections.sort(results);
        for (Integer i : results){
            System.out.println(i);
        }
    }
    public static void dfs(int[][] map,boolean[][] visited,int i,int j){
        map[i][j] = n;
        visited[i][j] = true;
        cnt++;

        if(j+1 < N && visited[i][j+1] == false && map[i][j+1] == 1){ // 우
            dfs(map,visited,i,j+1);
        }
        if(j-1 >= 0 && visited[i][j-1] == false && map[i][j-1] == 1){ // 좌
            dfs(map,visited,i,j-1);
        }
        if(i+1 < N && visited[i+1][j] == false && map[i+1][j] == 1){
            dfs(map,visited,i+1,j);
        }
        if(i-1 >= 0 && visited[i-1][j] == false && map[i-1][j] == 1){
            dfs(map,visited,i-1,j);
        }
    }
}