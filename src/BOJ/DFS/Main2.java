package BOJ.DFS;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main2 {

    public  static  int[] dx = {1,-1,0,0};
    public static int[] dy = {0,0,1,-1};
    public static int cnt = 0 ;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());

        int[][] arr = new int[n][n];
        boolean[][] visited = new boolean[n][n]; //false

        for (int i = 0; i < n; i++){
            String str = br.readLine();
            for(int j = 0 ; j < n ; j++){
                arr[i][j] = Integer.parseInt(str.substring(j,j+1));
            }
        }

        for (int i = 0; i < n; i++){
            for(int j = 0 ; j < n ; j++){
                if(arr[i][j] == 1 && visited[i][j] == false){
                    cnt++;
                    dfs(i,j,arr,visited);
                }
            }
        }


    }
    public static void dfs(int x, int y,int[][] arr,boolean[][] visited){
        visited[x][y] = true;
        arr[x][y] = cnt;
        for(int k = 0 ; k<4 ; k++){
            int nx = x + dx[k]; // 1,-1,0,0
            int ny = y + dy[k]; // 0 0 1 -1

            if(nx>=0 && ny>=0 && nx< arr.length && ny < arr[0].length ){
                if(arr[nx][ny] == 1&& visited[nx][ny] == false){
                    dfs(nx,ny,arr,visited);
                }
            }

        }

    }
}
