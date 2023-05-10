package PRG.DFS_BFS;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Solution7 {
    public static int dx[] = {1,-1,0,0};
    public static int dy[] = {0,0,1,-1};
    public static String log="";
    public static int logInt =0;
    public static int cnt=0;

    public int solution(int[][] game_board, int[][] table) {
        int answer= 0;
        int width = game_board[0].length; //
        int height = game_board.length; // 2면 나중에 +1, 3이면 +2만큼 오른쪽으로 이동
        Map<String,Integer> map = new HashMap<>();
        boolean[][] checked = new boolean[height][width];

        //table의 퍼즐 정보를 저장 - 퍼즐로그, 퍼즐 칸수
        for(int i =0;i<height;i++){
            for (int j=0;j<width;j++){
                if(table[i][j]==1 && checked[i][j]==false) {
                    log = "";
                    cnt=0;
                    dfs(i, j, table, checked);
                    System.out.println(log+"--");
                    map.put(log,cnt);
                }
            }
        }

        int[][] temp_arr = game_board; //처음 임시보드는 게임보드 참조
        for(int k=0;k<4;k++){
            checked = new boolean[height][width];
            for(int i=0;i<height;i++){
                for(int j=0;j<width;j++){
                    if(temp_arr[i][j]==0) { // 0 비어있는 칸이면 조사
                        log = "";
                        gameBoardDfs(i, j, temp_arr, checked);
                        if (map.get(log) == null) { //조사한 퍼즐로그가 table에 있는지 확인
                            continue;
                        } else {
                            answer += map.get(log); //있으면 카운트 합산
                            map.remove(log);
                            blockDfs(i,j,temp_arr);
                        }
                    }
                }
            }
            printArr(temp_arr);
            //끝나고 game_board 퍼즐 90도 돌리기
            int[][] board = new int[height][width];
            for (int i = 0; i < height; i++) {
                for (int j = 0; j < width; j++) {
                    if (temp_arr[i][j] == 1) { // 1,2
                        int x = j;
                        int y = -i + height-1;
                        board[x][y] = 1;
                    }
                }
            }
            temp_arr=board; //임시보드는 90도 돌린 보드 참조
            System.out.println();

        }


        return answer;
    }
    public void dfs(int x,int y,int[][] arr,boolean[][] checked){
        checked[x][y] = true;
        cnt++;
        for (int k =0;k<4;k++){
            int nx = x+dx[k];
            int ny = y+dy[k];

            if(nx>=0 && ny>=0 && nx < arr.length && ny < arr[0].length){
                if(arr[nx][ny]==1 && checked[nx][ny]==false){
                    log+=logInt;
                    log+=generateLog(k); // 방향에 따라 로그 추가
                    logInt++;
                    dfs(nx,ny,arr,checked);
                    log+="e";
                    logInt--;

                }
            }
        }
    }

    public void gameBoardDfs(int x,int y,int[][] arr,boolean[][] checked){
        checked[x][y] = true;
        for (int k =0;k<4;k++){
            int nx = x+dx[k];
            int ny = y+dy[k];

            if(nx>=0 && ny>=0 && nx < arr.length && ny < arr[0].length){
                if(arr[nx][ny]==0 && checked[nx][ny]==false){
                    log+=logInt;
                    log+=generateLog(k); // 방향에 따라 로그 추가
                    logInt++;
                    gameBoardDfs(nx,ny,arr,checked);
                    log+="e";
                    logInt--;
                }
            }
        }
    }
    public void blockDfs(int i,int j,int[][] arr){ //해당 점부터 주변점 1로 블락처리
        arr[i][j] = 1;
        for (int k =0;k<4;k++){
            int nx = i+dx[k];
            int ny = j+dy[k];
            if(nx>=0 && ny>=0 && nx < arr.length && ny < arr[0].length){
                if(arr[nx][ny]==0){
                    blockDfs(nx,ny,arr);
                }
            }
        }
    }


    public String generateLog(int k){
        if(k==0){
            return "Down";
        }
        if(k==1){
            return "Up";
        }
        if(k==2){
            return "Right";
        }
        if(k==3){
            return "Left";
        }
        return null;
    }
        public void printArr(int[][] arr){
        for(int i=0 ;i<arr.length ; i++){
            for(int j=0 ; j<arr[0].length ; j++){
                System.out.print(arr[i][j] + " ");
            }
            System.out.println();
        }
    }

}


