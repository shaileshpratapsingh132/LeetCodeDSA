import java.util.*;

class Solution {

    // 1. Recursion
    boolean solveRec(int[] nums, int n, int sum) {

        if (sum == 0) return true;
        if (n == 0 || sum < 0) return false;

        boolean exclude = solveRec(nums, n - 1, sum);

        boolean include = solveRec(
            nums, n - 1, sum - nums[n - 1]
        );

        return exclude || include;
    }

    // 2. Memoization
    boolean solveMem(int[] nums, int n, int sum, int[][] dp) {

        if (sum == 0) return true;
        if (n == 0 || sum < 0) return false;

        if (dp[n][sum] != -1) {
            return dp[n][sum] == 1;
        }

        boolean exclude = solveMem(nums, n - 1, sum, dp);

        boolean include = solveMem(
            nums, n - 1, sum - nums[n - 1], dp
        );

        dp[n][sum] = (exclude || include) ? 1 : 0;

        return dp[n][sum] == 1;
    }

    // 3. Tabulation
    boolean solveTab(int[] nums, int n, int sum) {

        boolean[][] dp = new boolean[n + 1][sum + 1];

        for (int i = 0; i <= n; i++) {
            dp[i][0] = true;
        }

        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= sum; j++) {

                boolean exclude = dp[i - 1][j];

                boolean include = false;

                if (nums[i - 1] <= j) {
                    include = dp[i - 1][j - nums[i - 1]];
                }

                dp[i][j] = exclude || include;
            }
        }

        return dp[n][sum];
    }

    // 4. Space Optimization
    boolean solveSpace(int[] nums, int n, int sum) {

        boolean[] dp = new boolean[sum + 1];

        dp[0] = true;

        for (int i = 0; i < n; i++) {

            for (int j = sum; j >= nums[i]; j--) {

                dp[j] = dp[j] || dp[j - nums[i]];
            }
        }

        return dp[sum];
    }

    // LeetCode Main Function
    public boolean canPartition(int[] nums) {

        int total = 0;

        for (int x : nums) {
            total += x;
        }

        if (total % 2 != 0) {
            return false;
        }

        int sum = total / 2;

        // 1. Recursion
        // return solveRec(nums, nums.length, sum);

        // 2. Memoization
        // int[][] dp = new int[nums.length + 1][sum + 1];
        // for (int[] row : dp) {
        //     Arrays.fill(row, -1);
        // }
        // return solveMem(nums, nums.length, sum, dp);

        // 3. Tabulation
        // return solveTab(nums, nums.length, sum);

        // 4. Space Optimization
        return solveSpace(nums, nums.length, sum);
    }
}