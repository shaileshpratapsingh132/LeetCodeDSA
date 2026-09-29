class Solution {
    public int myAtoi(String s) {
        int i = 0;
        int n = s.length();

        // 1. Skip spaces
        while (i < n && s.charAt(i) == ' ') {
            i++;
        }

        // 2. Check sign
        int sign = 1;

        if (i < n && (s.charAt(i) == '+' || s.charAt(i) == '-')) {
            if (s.charAt(i) == '-')
                sign = -1;
            i++;
        }

        // 3. Convert digits
        int ans = 0;

        while (i < n && Character.isDigit(s.charAt(i))) {
            int d = s.charAt(i) - '0';

            // 4. Check overflow
            if (ans > (Integer.MAX_VALUE - d) / 10) {
                if (sign == 1)
                    return Integer.MAX_VALUE;
                else
                    return Integer.MIN_VALUE;
            }

            ans = ans * 10 + d;
            i++;
        }

        return ans * sign;
    }
}