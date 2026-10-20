
import java.util.*;

class Solution {
    public List<String> removeInvalidParentheses(String s) {
        List<String> ans = new ArrayList<>();
        Set<String> vis = new HashSet<>();
        Queue<String> q = new LinkedList<>();

        q.offer(s);
        vis.add(s);
        boolean found = false;

        while (!q.isEmpty()) {
            String cur = q.poll();

            if (isValid(cur)) {
                ans.add(cur);
                found = true;
            }

            if (found) {
                continue;
            }

            for (int i = 0; i < cur.length(); i++) {
                char ch = cur.charAt(i);

                if (ch != '(' && ch != ')') {
                    continue;
                }

                String next = cur.substring(0, i)
                        + cur.substring(i + 1);

                if (vis.add(next)) {
                    q.offer(next);
                }
            }
        }

        return ans;
    }

    private boolean isValid(String s) {
        int count = 0;

        for (char ch : s.toCharArray()) {
            if (ch == '(') {
                count++;
            } else if (ch == ')') {
                count--;

                if (count < 0) {
                    return false;
                }
            }
        }

        return count == 0;
    }
}
