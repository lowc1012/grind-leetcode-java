/*
 * @lc app=leetcode id=287 lang=java
 *
 * [287] Find the Duplicate Number
 */

// @lc code=start
class Solution {
    public int findDuplicate(int[] nums) {
        // Use binary search approach, TC: O(nlogn), SC: O(1)

        // nums = [2, 3, 4, 2, 1] 
        int start = 1;
        int end = nums.length - 1;

        while (start < end) {
            int count = 0;
            // guess a number (mid) is duplicated
            int mid = start + (end - start) / 2;
            
            // use for loop to calculate count
            for (int n : nums) {
                if (n <= mid) {
                    count++;
                }
            }

            // according to the Pigeonhole Principle (鴿籠原理)
            // if count > mid, duplicated number is in interval [start, mid]
            // else, [mid+1, end]
            if (count > mid) {
                end = mid;
            } else {
                start = mid + 1;
            }
        }
        return start;
    }
}
// @lc code=end

