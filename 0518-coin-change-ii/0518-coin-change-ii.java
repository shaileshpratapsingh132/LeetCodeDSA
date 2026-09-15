class Solution {

    // 1. Recursion
    int solveRec(int[] coins, int n, int sum) {
        if (sum == 0) return 1;
        if (sum < 0 || n == 0) return 0;

        int exclude = solveRec(coins, n - 1, sum);
        int include = solveRec(coins, n, sum - coins[n - 1]);

        return exclude + include;
    }

    // 2. Top-Down Memoization
    int solveMem(int[] coins, int n, int sum, int[][] dp) {
        if (sum == 0) return 1;
        if (sum < 0 || n == 0) return 0;

        if (dp[n][sum] != -1) {
            return dp[n][sum];
        }

        int exclude = solveMem(coins, n - 1, sum, dp);
        int include = solveMem(coins, n, sum - coins[n - 1], dp);

        dp[n][sum] = exclude + include;

        return dp[n][sum];
    }

    // 3. Bottom-Up Tabulation
    int solveTab(int[] coins, int n, int sum) {
        int[][] dp = new int[n + 1][sum + 1];

        for (int i = 0; i <= n; i++) {
            dp[i][0] = 1;
        }

        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= sum; j++) {

                // Exclude
                dp[i][j] = dp[i - 1][j];

                // Include
                if (coins[i - 1] <= j) {
                    dp[i][j] += dp[i][j - coins[i - 1]];
                }
            }
        }

        return dp[n][sum];
    }

    // 4. Space Optimized DP
    int solveSpace(int[] coins, int n, int sum) {
        int[] dp = new int[sum + 1];

        dp[0] = 1;

        for (int i = 0; i < n; i++) {
            for (int j = coins[i]; j <= sum; j++) {
                dp[j] += dp[j - coins[i]];
            }
        }

        return dp[sum];
    }

    // LeetCode Main Function
    public int change(int amount, int[] coins) {

        // 1. Recursion
        // return solveRec(coins, coins.length, amount);

        // 2. Memoization
        // int[][] dp = new int[coins.length + 1][amount + 1];
        // for (int i = 0; i <= coins.length; i++) {
        //     java.util.Arrays.fill(dp[i], -1);
        // }
        // return solveMem(coins, coins.length, amount, dp);

        // 3. Tabulation
        // return solveTab(coins, coins.length, amount);

        // 4. Space Optimization
        return solveSpace(coins, coins.length, amount);
    }
}