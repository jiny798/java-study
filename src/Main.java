import PRG.DFS_BFS.Solution2;
import PRG.DFS_BFS.Solution3;

public class Main {
    public static void main(String[] args) {

        Solution3 solution = new Solution3();
        int[][] maps = { {1,0,1,1,1},{1,0,1,0,1},{1,0,1,1,1},{1,1,1,0,1},{0,0,0,0,1}};

        System.out.println(solution.solution(maps));

    }
}