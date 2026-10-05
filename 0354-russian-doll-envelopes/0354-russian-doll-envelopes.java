import java.util.*;

class Solution {
    public int maxEnvelopes(int[][] env) {
        
        Arrays.sort(env, (a, b) -> {
            if (a[0] == b[0])
                return b[1] - a[1];
            return a[0] - b[0];
        });

        int[] lis = new int[env.length];
        int len = 0;

        for (int[] e : env) {
            int h = e[1];

            int l = 0, r = len;

            while (l < r) {
                int m = l + (r - l) / 2;

                if (lis[m] < h)
                    l = m + 1;
                else
                    r = m;
            }

            lis[l] = h;

            if (l == len)
                len++;
        }

        return len;
    }
}