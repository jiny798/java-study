package PRG.graph;

import java.util.LinkedList;
import java.util.Queue;

class Solution {
    public int solution(int n, int[][] edge) {
        boolean[] visited = new boolean[n + 1];
        boolean[][] arr = new boolean[n + 1][n + 1]; // edge의 길이는 n보다 클수 있어서 메모리 초과 발생 가능
        for (int i = 0; i < edge.length; i++) {
            int x = edge[i][0];
            int y = edge[i][1];
            arr[x][y] = true;
            arr[y][x] = true;
        }
        Queue<Integer> que = new LinkedList<>();
        que.add(1);
        visited[1] = true;
        return bfs(que, arr, visited);

    }

    public int bfs(Queue<Integer> que, boolean[][] arr, boolean[] visited) {
        int size = 0;
        while (!que.isEmpty()) {
            size = que.size();
            for (int i = 0; i < size; i++) {
                int num = que.poll();
                for (int index = 1; index <= visited.length - 1; index++) {
                    if (arr[num][index] == true && visited[index] == false) {
                        visited[index] = true;
                        que.add(index);
                    }
                }
            }
        }
        return size;

    }
}
