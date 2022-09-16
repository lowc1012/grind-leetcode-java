/*
 * @lc app=leetcode id=45 lang=java
 *
 * [45] Jump Game II
 */

// @lc code=start
class Solution {
    public int jump(int[] nums) {
        int count = 0, farthest = 0;
        int currEnd = 0, visited = 0;

        // visited pointer expands to end of the given array
        while (visited < nums.length - 1) {
            // track the farthest
            for (int i = currEnd; i <= visited; i++) {
                farthest = Math.max(farthest, i + nums[i]);
            }

            // renew currEnd and visited
            currEnd = visited + 1;
            visited = farthest;

            count++;
        }
        return count;
    }
}
// @lc code=end

