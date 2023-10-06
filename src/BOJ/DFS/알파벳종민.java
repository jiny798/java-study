package BOJ.DFS;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

public class 알파벳종민 {
    static int[] dx = {1, -1, 0, 0};
    static int[] dy = {0, 0, 1, -1};
    static int result = Integer.MIN_VALUE;
    static int max = 1;
    static int R;
    static int C;
    static char[][] map;
    static HashMap<Character,Boolean> checkMap = new HashMap<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st = new StringTokenizer(br.readLine());
        R = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());
        map = new char[R][C];

        for (int i = 0; i < R; i++) { // 2
            String lines = br.readLine();
            for (int j = 0; j < C; j++) { //4
                map[i][j] = lines.charAt(j);
            }
        }
                // CACB
                // DATB

        checkMap.put(map[0][0],true); // C - TRUE
        dfs(0, 0);

        sb.append(result);
        System.out.println(sb);
    }

    private static void dfs(int x, int y) { // 0 , 0 , 1
        if(result < max){
            result = max;
        }

        for (int i = 0; i < 4; i++) {
            int nx = x + dx[i];
            int ny = y + dy[i];
            if (nx >= 0 && ny >= 0 && nx < R && ny < C) {
                if (checkMap.get(map[nx][ny]) == null){
                    checkMap.put(map[nx][ny],true);
                    max++;
                    dfs(nx,ny);
                    checkMap.remove(map[nx][ny]); //C-true, A-null, D - null
                    max--;
                }
            }
        }
    }
}
