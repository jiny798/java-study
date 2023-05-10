package BOJ.DFS;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;

public class Main {
    static int cnt=0;
    static int counter=0;
    public static int dx[] ={1,-1,0,0};
    public static int dy[] = {0,0,1,-1};
    public static void main(String[] args) throws IOException {
        ArrayList<Integer> result = new ArrayList<>();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[][] arr = new int[N][N];
        boolean[][] checked = new boolean[N][N];

        for(int i=0 ; i<N ; i++){
            String str = br.readLine();
            for (int j=0 ; j<N ; j++){
                arr[i][j] = Integer.parseInt(str.substring(j,j+1));
            }
        }

        for(int i=0 ; i<N ; i++){
            for(int j=0 ; j<N ; j++){
                if(arr[i][j] == 1 && checked[i][j] == false){
                    cnt++;
                    counter=0;
                    dfs(i,j,arr,checked);
                    result.add(counter);
                }
            }
        }
        Collections.sort(result,(o1, o2) -> {
                return o1-o2;
        });
        System.out.println(cnt);
        for(int tmp : result){
            System.out.println(tmp);
        }
    }

    public static void dfs(int x,int y,int[][] arr,boolean[][] checked){
        checked[x][y] = true;
        arr[x][y] =cnt;
        counter++;
        for(int k=0;k<4;k++){
            int nx = x +dx[k];
            int ny = y +dy[k];
            if(nx>=0&&ny>=0 && nx<arr.length&& ny< arr.length){
                if(!checked[nx][ny] && arr[nx][ny]==1){
                    dfs(nx,ny,arr,checked);
                }
            }
        }
    }
}
