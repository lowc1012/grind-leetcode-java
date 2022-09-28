/*
 * @lc app=leetcode id=113 lang=java
 *
 * [113] Path Sum II
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
    private List<List<Integer>> result;

    public List<List<Integer>> pathSum(TreeNode root, int targetSum) {
        result = new ArrayList<>();
        if (root != null) {
            backtrack(root, targetSum, new ArrayList<>());
        }

        return result;
    }

    private void backtrack(TreeNode node, int targetSum, List<Integer> path) {
        if (node == null) {
            return;
        }
        path.add(node.val);

        // arrive at leaf node
        if (node.left == null && node.right == null && targetSum == node.val) {
                result.add(new ArrayList(path));
        } else {
            backtrack(node.left, targetSum-node.val, path);
            backtrack(node.right, targetSum-node.val, path);
        }
        path.remove(path.size()-1);
    }
}
// @lc code=end

