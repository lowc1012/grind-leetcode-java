/*
 * @lc app=leetcode id=1 lang=java
 *
 * [1] Two Sum
 */

// @lc code=start
class Solution {
    public int[] twoSum(int[] nums, int target) {
        // 2 <= nums.length <= 104
        Map<Integer, Integer> m = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            Integer k = m.get(new Integer(target - nums[i]));
            if (k != null) {
                return new int[]{k, i};
            }
            m.put(nums[i], i);
        }
        return new int[0];
    }
}
// @lc code=end

