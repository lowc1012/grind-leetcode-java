/*
 * @lc app=leetcode id=453 lang=java
 *
 * [453] Minimum Moves to Equal Array Elements
 */

// @lc code=start
class Solution {
    public int minMoves(int[] nums) {
        // In each move, increase n - 1 elements of array by 1
        // We should not choose current maximum element to increase

        // In other words, in each move, we need to decrease the
        // current max element by one util every element becomes min element.

        // The problem become: count difference between other elements with
        // our min element in the array.
        int min = nums[0], result = 0;
        for (int n : nums) {
            min = Math.min(min, n);
        }

        for (int n : nums) {
            result += n - min;
        }
        return result;
    }
}
// @lc code=end

