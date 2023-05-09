package PRG.DFS_BFS;

import java.util.ArrayList;
import java.util.List;

public class Solution7 {
    public static int dx[] = {1,-1,0,0};
    public static int dy[] = {0,0,1,-1};
    public int solution(int[][] game_board, int[][] table) {
        int width = game_board[0].length; //
        int height = game_board.length; // 2면 나중에 +1, 3이면 +2만큼 오른쪽으로 이동
        List<int[][]> boardList = new ArrayList<>();
        boardList.add(game_board); //첫번째판 담기

        for (int k=0; k < 3 ; k++) { //보드판을 3개 더 제작. 90도 회전 3번
            int[][] temp_board = new int[height][width];
            int[][] board = boardList.get(k); //이전에 있던 보드판에서 꺼내어 복사
            for (int i = 0; i < height; i++) {
                for (int j = 0; j < width; j++) {
                    if (board[i][j] == 1) { // 1,2
                        int x = j;
                        int y = -i + height-1;
                        temp_board[x][y] = 1;
                    }
                }
            }
            boardList.add(temp_board);
        }



        return 0;
    }
    public String dfs(int x,int y,int[][] arr,boolean[][] checked){
        for (int k =0;k<4;k++){
            int nx = x+dx[k];
            int ny = y+dy[k];
            if(nx>0 && ny>0 && nx< arr.length && ny<arr[0].length){
                if(arr[nx][ny]==1 && checked[nx][ny]==false){
                    dfs(nx,ny)
                }
            }
        }

        return null;
    }

}


//    public void printArr(int[][] arr){
//        for(int i=0 ;i<arr.length ; i++){
//            for(int j=0 ; j<arr[0].length ; j++){
//                System.out.print(arr[i][j] + " ");
//            }
//            System.out.println();
//        }
//    }