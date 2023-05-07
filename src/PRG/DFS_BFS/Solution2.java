package PRG.DFS_BFS;

public class Solution2 {
    public static int cnt =0;
    public int solution(int n, int[][] computers) {
        // n = 3 ,  [ [1,1,0] , [1,1,0] , [0,0,1]] 인 경우 return 2
        boolean[] checked = new boolean[n];
        for (int i=0;i<computers.length;i++){
            if(checked[i]==false){ // 방문하지 않은 점이면 방문
                cnt++;
                dfs(i,checked,computers);
            }
        }
        return cnt;
    }

    public void dfs(int visitNum,boolean[] checked,int[][] computers){
        checked[visitNum] = true; // 방문 처리

        for(int i=0;i<computers[visitNum].length;i++){
            if(visitNum==i)continue; // 자기자신이면 패스
            if(computers[visitNum][i]==1 && checked[i]==false){ //연결되어 있고 방문하지 않은 곳이면
                dfs(i,checked,computers);
            }
        }
    }

}
