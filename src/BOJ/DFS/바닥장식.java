package BOJ.DFS;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class 바닥장식 {
    public static int cnt =0;
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String firstStr = br.readLine();
        String[] st = firstStr.split(" ");

        int x = Integer.parseInt(st[0]);
        int y = Integer.parseInt(st[1]);

        String[][] arr = new String[x][y];
        boolean[][] visited = new boolean[x][y];

        for (int i = 0; i < x; i++) {
            String str = br.readLine();
            for (int j = 0; j < y; j++) {
                arr[i][j] = String.valueOf(str.charAt(j));
            }
        }

        for (int i = 0; i < x; i++) {
            for (int j = 0; j < y; j++) {
                if(visited[i][j] == false){
                    dfs(i,j,arr,visited,false);
                }
            }
        }
        System.out.println(cnt);
    }
    public static void dfs(int x,int y,String[][] arr,boolean[][] visited,boolean isSameBoard){
        visited[x][y] = true;
        if(!isSameBoard) {
            cnt++;
        }
        if(arr[x][y].equals("-")){
            int ny = y+1;
            if(ny>=0 && ny<arr[0].length && arr[x][ny].equals("-")){
                dfs(x,ny,arr,visited,true);
            }
        }else{
            int nx = x+1;
            if(nx>=0 && nx<arr.length && arr[nx][y].equals("|")){
                dfs(nx,y,arr,visited,true);
            }
        }
    }
}
