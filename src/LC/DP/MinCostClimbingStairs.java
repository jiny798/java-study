package LC.DP;

// 리트코드 746번
public class MinCostClimbingStairs {
    public int minCostClimbingStairs(int[] cost) {
        // [10,15,20,30,35] b = 5
        // DP[5] = ( DP[3] + cost[3] ) , ( DP[4] + cost[4] )
        int top = cost.length;
        int[] dp = new int[top + 1];

        dp[0] = 0;
        dp[1] = 0;

        for (int i = 2; i <= top; i++) {
            dp[i] = Math.min(dp[i - 1] + cost[i - 1], dp[i - 2] + cost[i - 2]);
        }

        return dp[top];
    }
}
