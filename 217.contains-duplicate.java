/*
 * @lc app=leetcode id=217 lang=java
 *
 * [217] Contains Duplicate
 */

// @lc code=start
class Solution {
    public boolean containsDuplicate(int[] nums) {
        // use HashSet
        Set<Integer> set = new HashSet<Integer>();
        for (int i : nums) {
            Integer element = i;
            if (set.contains(element)) {
                return true;
            }
            set.add(element);
        }
        return false;
    }
}
// @lc code=end

