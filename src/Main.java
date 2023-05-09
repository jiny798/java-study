import PRG.DFS_BFS.Solution2;
import PRG.DFS_BFS.Solution3;
import PRG.DFS_BFS.Solution5;
import PRG.DFS_BFS.Solution7;

public class Main {
    public static void main(String[] args) {

        int[][] game_board = {{1,1,0,0,1,0},{0,0,1,0,1,0},{0,1,1,0,0,1},{1,1,0,1,1,1},{1,0,0,0,1,0},{0,1,1,1,0,0}};
        int[][] ta = {{1,0,0,1,1,0},{1,0,1,0,1,0},{0,1,1,0,1,1},{0,0,1,0,0,0},{1,1,0,1,1,0},{0,1,0,0,0,0}};
        Solution7 solution7 = new Solution7();
        int a =       solution7.solution(game_board,ta);
        System.out.println(a);
    }
}