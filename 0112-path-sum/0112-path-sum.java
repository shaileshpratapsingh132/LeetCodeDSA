/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    public boolean hasPathSum(TreeNode root, int targetSum) {
        return solve(root, targetSum, 0);
    }

    public boolean solve(TreeNode root, int target, int sum) {
        if (root == null) {
            return false;
        }

        sum = sum + root.val;

        // Root-to-leaf path complete
        if (root.left == null && root.right == null) {
            return sum == target;
        }

        boolean leftAns = solve(root.left, target, sum);
        boolean rightAns = solve(root.right, target, sum);

        return leftAns || rightAns;
    }
}