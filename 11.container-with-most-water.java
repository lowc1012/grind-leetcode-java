/*
 * @lc app=leetcode id=11 lang=java
 *
 * [11] Container With Most Water
 */

// @lc code=start
class Solution {
    // TC: O(n), SC: O(1)
    public int maxArea(int[] height) {
        int result = 0, h = 0, w = 0, container = 0;

        // use two pointers and greedy algorithm
        int left = 0, right = height.length - 1;

        while (left < right) {
            // calculate the container
            h = Math.min(height[left], height[right]);
            w = right - left;
            container = h * w;
            if (container > result) {
                result = container;
            }

            // (greedy) move the pointer such that there will be
            // possible to gain larger amount of container
            if (height[right] > height[left]) {
                left++;
            } else {
                right--;
            }
        }
        return result;
    }
}
// @lc code=end

