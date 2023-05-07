package PRG.DFS_BFS;

public class Solution4 {

    public static int minCnt=Integer.MAX_VALUE; // 최소 횟수
    public static String targetStr;
    public int solution(String begin, String target, String[] words) {
        //hit,cog    [hot,dot,dog,lot,log,cog]
        targetStr = target;
        boolean[] checked = new boolean[words.length];
        for(int i=0;i<words.length;i++){
            if(isChangeable(begin,words[i]) && checked[i]==false){
                checked[i] = true;
                dfs(words[i],words,i,checked,1);
                checked[i] = false;
            }
        }
        if(minCnt == Integer.MAX_VALUE){
            return 0;
        }
        return minCnt;
    }
    public void dfs(String str,String[] words,int index,boolean[] checked,int cnt){
        if(str.equals(targetStr)){
            if(minCnt > cnt){
                minCnt = cnt;
            }
        }
        for(int i=0;i<words.length;i++){
            if(isChangeable(str,words[i]) && checked[i]==false){
                checked[i] = true;
                dfs(words[i],words,i,checked,cnt+1);
                checked[i] = false;
            }
        }

    }
    public boolean isChangeable(String begin,String target){
        int count =0;
        for(int i=0 ; i<begin.length() ; i++){
            String s1 = begin.substring(i,i+1);
            String s2 = target.substring(i,i+1);
            if(s1.equals(s2)){
                count++;
            }
        }
        if(count == begin.length() - 1){
            return true; //변환 가능
        }
        return false; //변환 불가
    }
}
