package PRG.DFS_BFS;

import java.util.LinkedList;
import java.util.Queue;

public class Solution3 {
    public int[] dx = {1,-1,0,0};
    public int[] dy = {0,0,1,-1};
    public int solution(int[][] maps) {
        int x=0,y=0;
        boolean[][] visited = new boolean[maps.length][maps[0].length];
        return  bfs(maps,visited);
    }

    public int bfs(int[][] maps, boolean[][] visited) {
        Queue<int[]> que = new LinkedList<>();
        int[] startPoint = {0,0,1};
        visited[0][0] = true;
        que.add(startPoint);
        while (!que.isEmpty()){
            int[] point = que.poll();
            int x = point[0]; int y = point[1];
            int score = point[2];

            for(int i=0;i<4;i++){
                int nx = x + dx[i];
                int ny = y + dy[i];
                if(nx>=0 && ny>=0 && nx <maps.length && ny<maps[0].length) {
                    if (maps[nx][ny] == 1 && visited[nx][ny] == false) { // 1이고 방문안했으면
                        int[] newPoint = {nx, ny, score + 1}; // 점수 +1 해서 주변의 칸을 큐에 넣기
                        visited[nx][ny] = true;
                        que.add(newPoint);
                        if (nx == maps.length - 1 && ny == maps[0].length - 1) {
                            que.clear();
                            return score + 1;
                        }
                    }
                }
            }
        }
        return -1;
    }
}
