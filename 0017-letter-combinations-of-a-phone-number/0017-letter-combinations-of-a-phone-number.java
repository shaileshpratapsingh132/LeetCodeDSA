import java.util.*;

class Solution {

    String[] mp = {
        "", "", "abc", "def", "ghi",
        "jkl", "mno", "pqrs", "tuv", "wxyz"
    };

    List<String> ans = new ArrayList<>();

    void solve(String d, int i, String s) {

        if (i == d.length()) {
            ans.add(s);
            return;
        }

        String str = mp[d.charAt(i) - '0'];

        for (int j = 0; j < str.length(); j++) {

            solve(d, i + 1, s + str.charAt(j));
        }
    }

    public List<String> letterCombinations(String digits) {

        if (digits.length() == 0) {
            return ans;
        }

        solve(digits, 0, "");

        return ans;
    }
}