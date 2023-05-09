package PRG.DFS_BFS;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Solution7 {
    static int[] dx = {1,0,-1,0};
    static int[] dy = {0,1,0,-1};
    static int logint = 0;
    static String logstring ="";
    static int logint2 = 0;
    static String logstring2 ="";

    public int solution(int[][] game_board, int[][] table) {
        int answer = -1;
        int result = 0;

        for(int i=0;i<game_board.length;i++){
            for(int j=0;j<game_board.length;j++){
                logstring ="x";
                if(game_board[i][j]==0){
                    logint = 0;
                    logstring ="";
                    game_board[i][j]=1;
                    gameboard_dfs(i,j,game_board);
                    System.out.println("gameboard"+logstring);


                    int ne=4;
                    loop:
                    while(ne!=0){ //table에 퍼즐들 하나씩 체크
                        ne--;
                        int[][] vis= new int[table.length][table.length];

                        for(int a=0;a<table.length;a++){
                            for(int b=0;b<table.length;b++){

                                if(table[a][b]==1 && vis[a][b]==0){
                                    logint2 = 0;
                                    logstring2 ="";
                                    vis[a][b]=1;
                                    table_bfs(a,b,table,vis);
                                    if(logstring.equals(logstring2)){
                                        System.out.println("logstring22 ="+logstring2);
                                        //table[a][b] 에서 시작해서 모두 0으로 만든다
                                        table[a][b]=0;
                                        zero_table(a,b,table);
                                        String str = logstring2;
                                        result++;
                                        int p=0;
                                        for(int s=0;s<str.length();s++){
                                            if(str.charAt(s) == '-'){
                                                continue;
                                            }
                                            p++;
                                            if(p==3){
                                                p=0;
                                                result++;
                                            }
                                        }

                                        break loop;
                                    }
                                }

                            }
                        }

                        table_rotate(table);


                    }//while 끝

                }
            }
        }

        return result;
    }
    public static void gameboard_dfs(int a,int b, int[][] game_board){
        for(int k=0;k<4;k++){
            int nx = a + dx[k];
            int ny = b + dy[k];
            if(nx>=0&&ny>=0&& nx<game_board.length&&ny<game_board.length){
                if(game_board[nx][ny]==0){
                    logint++;
                    logstring=logstring+logint+dx[k]+dy[k];
                    game_board[nx][ny]=1;
                    gameboard_dfs(nx,ny,game_board);
                    logint--;

                }
            }
        }
    }

    public static void table_bfs(int a,int b, int[][] table,int[][] vis){
        for(int k=0;k<4;k++){
            int nx = a + dx[k];
            int ny = b + dy[k];

            if(nx>=0&&ny>=0&& nx<table.length&&ny<table.length){
                if(table[nx][ny]==1 && vis[nx][ny]==0){
                    logint2++;
                    logstring2=logstring2+logint2+dx[k]+dy[k];
                    vis[nx][ny]=1;
                    table_bfs(nx,ny,table,vis);
                    logint2--;

                }
            }
        }
    }
    public static void zero_table(int a,int b,int[][] table){
        for(int k=0;k<4;k++){
            int nx = a + dx[k];
            int ny = b + dy[k];

            if(nx>=0&&ny>=0&& nx<table.length&&ny<table.length){
                if(table[nx][ny]==1){
                    table[nx][ny]=0;
                    zero_table(nx,ny,table);
                }
            }
        }

    }


    public static void table_rotate(int[][] arr){
        int[][] vist =new int[arr.length][arr.length];
        // int[][] newarr = new int[arr.length][arr.length];

        for(int i=0;i<arr.length;i++){
            for(int j=0;j<arr.length;j++){

                if(arr[i][j]>=1&&vist[i][j]==0){
                    arr[i][j]=arr[i][j]-1;  // 현재 위치 없애고
                    vist[i][j] = 1;

                    if(arr[j][arr.length-1-i]==1){ //옮길 위치에 이미 블록이 있다면
                        vist[j][arr.length-1-i]=0;
                        arr[j][arr.length-1-i]=arr[j][arr.length-1-i]+1;
                    }else{
                        vist[j][arr.length-1-i]=1;
                        arr[j][arr.length-1-i]=arr[j][arr.length-1-i]+1;
                    }


                }

            }
        }

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