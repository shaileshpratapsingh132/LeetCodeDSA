class Solution {

    public int countSubstrings(String s) {
        int totalCount = 0;
        for (int i = 0; i < s.length(); i++) {
            int j = i;
            int oddAns = expand(s, i, j);
            j = i + 1;
            int evenAns = expand(s, i, j);
            totalCount = totalCount + oddAns + evenAns;
        }
        return totalCount;
    }
    public int expand(String s, int left, int right) {
        int count = 0;
        while (left >= 0 && right < s.length()
                && s.charAt(left) == s.charAt(right)) {
            count++;
            left--;
            right++;
        }
        return count;
    }
}