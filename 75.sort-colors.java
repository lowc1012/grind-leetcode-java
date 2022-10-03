/*
 * @lc app=leetcode id=75 lang=java
 *
 * [75] Sort Colors
 */

// @lc code=start
class Solution {
    public void sortColors(int[] nums) {
        int idx = 0;
        int white = 0, blue = 0;
        for (int n : nums) {
            if (n == 0) {
                nums[idx] = 0;
                idx++;
            } else if (n == 1) {
                white++;
            } else {
                blue++;
            }
        }

        while (white != 0) {
            nums[idx] = 1;
            idx++;
            white--;
        }

        while (blue != 0) {
            nums[idx] = 2;
            idx++;
            blue--;
        }
    }
}
// @lc code=end

