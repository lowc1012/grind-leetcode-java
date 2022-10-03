/*
 * @lc app=leetcode id=238 lang=java
 *
 * [238] Product of Array Except Self
 */

// @lc code=start
class Solution {
    public int[] productExceptSelf(int[] nums) {
        // approach 1: prefix product and postfix product
        // nums : [1, 2, 3, 4]
        int[] result = new int[nums.length];
        int prefix = 1;
        for (int i = 0; i < nums.length; i++) {
            result[i] = prefix;
            prefix = prefix * nums[i];
        }
        // result is [1, 1, 2, 6]
        // (prefix product)[ prefix, (1)
        //                   prefix * nums[0], (1 * 1)
        //                   prefix * nums[0] * nums[1], (1 * 1 * 2)
        //                   prefix * nums[0] * nums[1] * nums[2] (1 * 1 * 2 * 3)
        //                 ]

        int postfix = 1;
        for (int i = nums.length - 1; i >= 0; i--) {
            result[i] = postfix * result[i];
            postfix = postfix * nums[i];
        }
    
        return result;
    }   
}
// @lc code=end

