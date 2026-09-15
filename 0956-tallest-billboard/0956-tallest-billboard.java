import java.util.*;

class Solution {

    public int tallestBillboard(int[] rods) {

        int sum = 0;

        for (int x : rods) {
            sum += x;
        }

        int[] dp = new int[sum + 1];

        Arrays.fill(dp, -1);

        dp[0] = 0;

        for (int rod : rods) {

            int[] old = dp.clone();

            for (int d = 0; d <= sum; d++) {

                if (old[d] == -1)
                    continue;

                // Rod ko skip karna
                dp[d] = Math.max(dp[d], old[d]);

                // Rod ko taller support mein add karna
                if (d + rod <= sum) {
                    dp[d + rod] = Math.max(
                        dp[d + rod],
                        old[d]
                    );
                }

                // Rod ko shorter support mein add karna
                int nd = Math.abs(d - rod);

                int h = old[d] + Math.min(d, rod);

                dp[nd] = Math.max(dp[nd], h);
            }
        }

        return dp[0];
    }
}