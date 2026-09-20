class Solution {

    // 1. Recursion
    boolean solve(String s1, String s2, String s3,
                  int i, int j, int k) {

        if (i == s1.length() &&
            j == s2.length() &&
            k == s3.length()) {
            return true;
        }

        boolean f = false;

        if (i < s1.length() &&
            k < s3.length() &&
            s1.charAt(i) == s3.charAt(k)) {

            f = f || solve(s1, s2, s3, i + 1, j, k + 1);
        }

        if (j < s2.length() &&
            k < s3.length() &&
            s2.charAt(j) == s3.charAt(k)) {

            f = f || solve(s1, s2, s3, i, j + 1, k + 1);
        }

        return f;
    }


    // 2. Memoization
    boolean solveTD(String s1, String s2, String s3,
                    int i, int j, int k, int[][][] dp) {

        if (i == s1.length() &&
            j == s2.length() &&
            k == s3.length()) {
            return true;
        }

        if (dp[i][j][k] != -1) {
            return dp[i][j][k] == 1;
        }

        boolean f = false;

        if (i < s1.length() &&
            k < s3.length() &&
            s1.charAt(i) == s3.charAt(k)) {

            f = f || solveTD(
                    s1, s2, s3,
                    i + 1, j, k + 1, dp
            );
        }

        if (j < s2.length() &&
            k < s3.length() &&
            s2.charAt(j) == s3.charAt(k)) {

            f = f || solveTD(
                    s1, s2, s3,
                    i, j + 1, k + 1, dp
            );
        }

        dp[i][j][k] = f ? 1 : 0;

        return f;
    }


    // 3. Bottom-Up Tabulation
    boolean solveBU(String s1, String s2, String s3) {

        int m = s1.length();
        int n = s2.length();
        int p = s3.length();

        if (m + n != p) {
            return false;
        }

        int[][][] dp = new int[m + 1][n + 1][p + 1];

        dp[m][n][p] = 1;

        for (int i = m; i >= 0; i--) {

            for (int j = n; j >= 0; j--) {

                for (int k = p; k >= 0; k--) {

                    if (i == m && j == n && k == p) {
                        continue;
                    }

                    boolean f = false;

                    if (i < m &&
                        k < p &&
                        s1.charAt(i) == s3.charAt(k)) {

                        f = f || dp[i + 1][j][k + 1] == 1;
                    }

                    if (j < n &&
                        k < p &&
                        s2.charAt(j) == s3.charAt(k)) {

                        f = f || dp[i][j + 1][k + 1] == 1;
                    }

                    dp[i][j][k] = f ? 1 : 0;
                }
            }
        }

        return dp[0][0][0] == 1;
    }


    // LeetCode
    public boolean isInterleave(String s1, String s2, String s3) {

        // Recursion
        // return solve(s1, s2, s3, 0, 0, 0);

        // Memoization
        // int[][][] dp = new int[
        //     s1.length() + 1
        // ][
        //     s2.length() + 1
        // ][
        //     s3.length() + 1
        // ];

        // for (int[][] a : dp) {
        //     for (int[] b : a) {
        //         java.util.Arrays.fill(b, -1);
        //     }
        // }

        // return solveTD(
        //     s1, s2, s3,
        //     0, 0, 0, dp
        // );

        // Tabulation
        return solveBU(s1, s2, s3);
    }
}