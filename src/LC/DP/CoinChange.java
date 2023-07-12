package LC.DP;

public class CoinChange {
    public int coinChange(int[] coins, int amount) {
        int[] Fun = new int[amount + 1];

        Fun[0] = 0;
        for (int i = 1; i <= amount; i++) {
            int min = Integer.MAX_VALUE;

            for (int k = 0; k < coins.length; k++) {
                if (i - coins[k] >= 0) {
                    if (Fun[i - coins[k]] != -1 && min > Fun[i - coins[k]]) {
                        min = Fun[i - coins[k]];
                    }
                }
            }
            if (min == Integer.MAX_VALUE) {
                Fun[i] = -1;
            } else {
                Fun[i] = min + 1;
            }

        }

        return Fun[amount];
    }
}
