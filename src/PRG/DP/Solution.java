package PRG.DP;

import java.util.*;

class Solution {
    public int solution(int[] money) { // [1,2,3,4,5]

        int size = money.length;
        int[] dp = new int[size];

        dp[0] = money[0];
        dp[1] = getMoreBigNum(money[0],money[1]);
        int dpSize = size-2;
        for(int n=2;n<=dpSize;n++){
            dp[n] = getMoreBigNum(dp[n-1],money[n]+dp[n-2]); // n-1 까지만
        }

        int[] dp2 = new int[size];
        dp2[0] =0;
        dp2[1] = money[1];
        int dp2Size = size-1;
        for(int n=2;n<=dp2Size;n++){
            dp2[n] = getMoreBigNum(dp2[n-1],money[n]+dp2[n-2]);
        }


        return getMoreBigNum(dp[dpSize],dp2[dp2Size]);
    }
    public int getMoreBigNum(int a ,int b){
        if(a<b){
            return b;
        }else{
            return a;
        }
    }
}
