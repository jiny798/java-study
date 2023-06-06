package PRG.kakao.DFS;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

public class Solution {
    public static int dx[] = {1, -1, 0, 0};
    public static int dy[] = {0, 0, 1, -1};
    public static int cnt = 0;
    public static int point = 0;
    ArrayList<Integer> list = new ArrayList<>();
    public int[] solution(int m, int n, int[][] picture) {
        //m 세로 n 가로
        int numberOfArea = 0;
        int maxSizeOfOneArea = 0;
        cnt = 0;
        point = 0;
        boolean[][] visited = new boolean[m][n];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (picture[i][j] >= 1 && visited[i][j] == false) {
                    cnt++;
                    dfs(i, j, picture[i][j], picture, visited);
                    list.add(point);
                    point = 0;
                }
            }
        }
        Collections.sort(list);
        int[] answer = new int[2];
        answer[0] = cnt;
        answer[1] = list.get(list.size() - 1);
        return answer;
    }

    public void dfs(int x, int y, int target, int[][] picture, boolean[][] visited) {
        visited[x][y] = true;
        point++;

        for (int k = 0; k < 4; k++) {
            int nx = x + dx[k];
            int ny = y + dy[k];
            if (nx >= 0 && ny >= 0 && nx < picture.length && ny < picture[0].length) {
                if (visited[nx][ny] == false && picture[nx][ny] == target) {
                    dfs(nx, ny, target, picture, visited);
                }
            }
        }
    }
}
