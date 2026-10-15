
class Solution {
    public String smallestGoodBase(String n) {
        long num = Long.parseLong(n);

        for (int m = 59; m >= 1; m--) {
            long l = 2;
            long r = num - 1;

            while (l <= r) {
                long k = l + (r - l) / 2;
                long sum = 1;
                boolean overflow = false;

                for (int i = 0; i < m; i++) {
                    if (sum > (num - 1) / k) {
                        overflow = true;
                        break;
                    }
                    sum = sum * k + 1;
                }

                if (overflow || sum > num) {
                    r = k - 1;
                } else if (sum < num) {
                    l = k + 1;
                } else {
                    return String.valueOf(k);
                }
            }
        }

        return String.valueOf(num - 1);
    }
}