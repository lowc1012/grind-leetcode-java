/*
 * @lc app=leetcode id=98 lang=java
 *
 * [98] Validate Binary Search Tree
 */

// @lc code=start
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
    public boolean isValidBST(TreeNode root) {
        // recursion
        // Time complexity: O(N), Space complexity: O(1)
        return validate(root, Long.MAX_VALUE, Long.MIN_VALUE);
    }

    private boolean validate(TreeNode node, long max, long min) {
        if (node == null) {
            return true;
        }

        if (node.val >= max || node.val <= min) {
            return false;
        }

        return validate(node.left, node.val, min) && validate(node.right, max, node.val);
    }
}
// @lc code=end

