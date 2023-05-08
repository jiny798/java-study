package PRG.DFS_BFS;

public class Solution6 {
    public static int[] dx ={1,-1,0,0};
    public static int[] dy ={0,0,1,-1};
    public static int MIN_DISTANCE = Integer.MAX_VALUE;
    public static int ITEM_X ;
    public static int ITEM_Y ;

    public int solution(int[][] rectangle, int characterX, int characterY, int itemX, int itemY) {
        ITEM_X=itemX*2;
        ITEM_Y=itemY*2;
        int[][] arr = new int[101][101];
        for (int i=0;i<rectangle.length;i++){
            drawRect(rectangle[i][0]*2,rectangle[i][1]*2,rectangle[i][2]*2,rectangle[i][3]*2,arr);
        }
        dfs(characterX*2,characterY*2,arr,0);

        return MIN_DISTANCE/2;
    }

    public void dfs(int x,int y,int[][] arr , int count){
        if(x==ITEM_X && y==ITEM_Y){
            if(MIN_DISTANCE > count){
                MIN_DISTANCE=count;
            }
            return;
        }
        arr[x][y] = 3;

        for(int i=0;i<4;i++){
            int nx = x+dx[i];
            int ny = y+dy[i];
            if(nx>0 && ny>0 && nx< arr.length && ny<arr[0].length){
                if(arr[nx][ny]==1){
                    dfs(nx,ny,arr,count+1);
                }
            }
        }
    }

    public void drawRect(int x,int y,int x2,int y2,int[][] arr){
        //테두리 1로 변경, 벽돌(2)가있으면 패스
        for(int i=x ; i <= x2 ; i++){
            if(arr[i][y]!=2){
                arr[i][y] = 1;
            }
            if(arr[i][y2]!=2){
                arr[i][y2] = 1;
            }
        }
        for (int i=y; i <= y2 ; i++){
            if(arr[x][i]!=2) {
                arr[x][i] = 1;
            }
            if(arr[x2][i]!=2) {
                arr[x2][i] = 1;
            }
        }

        //내부 벽돌(2)로 변경
        for(int i=x+1 ; i < x2 ; i++){
            for(int j=y+1 ; j < y2 ;j++){
                arr[i][j]=2;
            }
        }
    }
}
