package PRG.DFS_BFS;

public class Solution {

    public static int cnt=0;
    public int solution(int[] numbers, int target) {
        dfs(numbers,0,0,target); // numbers = [ 4, 1, 2, 1 ]
        return cnt;
    }

    public void dfs(int[] numbers,int index,int result,int target){
        if(index == numbers.length){
            if(result == target){
                cnt++;
                return;
            }else{
                return;
            }
        }
        int positiveNum = numbers[index];
        int negativeNum = -numbers[index];

        index = index+1;
        dfs(numbers,index,result+positiveNum,target);
        dfs(numbers,index,result+negativeNum,target);
    }

}
