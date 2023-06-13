package BOJ.DFS;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 그림 {

    public static int dx[] = {1,-1,0,0};
    public static int dy[] = {0,0,1,-1};
    public static int maxNum = 0;
    public static int count = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str = br.readLine();
        StringTokenizer st = new StringTokenizer(str);
        int x = Integer.parseInt(st.nextToken());
        int y = Integer.parseInt(st.nextToken());
        int[][] arr = new int[x][y];

        for(int i = 0 ; i<x ; i++){
            String s = br.readLine();
            st = new StringTokenizer(s);
            for (int j=0 ; j<y ; j++){
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        int drawCnt =0;
        for(int i = 0 ; i<x ; i++){
            for (int j=0 ; j<y ; j++){
                if(arr[i][j] == 1) {
                    drawCnt++;
                    dfs(i,j,arr);
                }
                if(count!=0){
                    if(maxNum < count) maxNum = count;
                    count=0;
                }
            }
        }
        System.out.println(drawCnt);
        System.out.println(maxNum);
    }
    public static void dfs(int x,int y,int[][] arr){
        arr[x][y] = 2;
        count++;
        for(int k = 0 ;k<4;k++){
            int nx = x + dx[k];
            int ny = y + dy[k];
            if(nx>=0 && ny>=0 && nx< arr.length && ny < arr[0].length){
                if(arr[nx][ny]==1){
                    dfs(nx,ny,arr);
                }
            }
        }
    }
}
