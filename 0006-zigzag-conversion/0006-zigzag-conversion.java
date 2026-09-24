class Solution {
    public String convert(String s, int n) {
        if (n == 1 || n >= s.length())
            return s;

        StringBuilder[] r = new StringBuilder[n];

        for (int i = 0; i < n; i++)
            r[i] = new StringBuilder();

        int row = 0;
        int dir = 1;

        for (char c : s.toCharArray()) {
            r[row].append(c);

            if (row == n - 1)
                dir = -1;
            else if (row == 0)
                dir = 1;

            row += dir;
        }

        StringBuilder ans = new StringBuilder();

        for (int i = 0; i < n; i++)
            ans.append(r[i]);

        return ans.toString();
    }
}