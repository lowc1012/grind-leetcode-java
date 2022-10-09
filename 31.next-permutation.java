/*
 * @lc app=leetcode id=31 lang=java
 *
 * [31] Next Permutation
 */

// @lc code=start
class Solution {
    public void nextPermutation(int[] nums) {
        // Find the next permutation
        // example 1: [1, 1, 5] -> return [1, 5, 1]
        // example 2: [3, 2, 1] -> return [1, 2, 3]
        int start = 0, end = nums.length - 1;
        
        // Find strictly decreasing sequence starting from the end of given array
        int pivot;
        for (pivot = nums.length - 2; pivot >= 0; pivot--) {
            if (nums[pivot] < nums[pivot+1]) {
                break;
            }
        }

        // there is no lexicographical larger rearrangement
        if (pivot == -1) {
            // reverse given array
            while (start < end) {
                // swap
                nums[start] = nums[start] + nums[end];
                nums[end] = nums[start] - nums[end];
                nums[start] = nums[start] - nums[end];
                start++;
                end--;
            }
        } else {
            // Find the next greatest number between pivot and the end of array
            int nextGreatestIdx;
            for (nextGreatestIdx = end; nextGreatestIdx > pivot; nextGreatestIdx--) {
                if (nums[nextGreatestIdx] > nums[pivot]) {
                    break;
                }
            }

            // Swap the items which on the next greatest and pivot
            nums[pivot] = nums[pivot] + nums[nextGreatestIdx];
            nums[nextGreatestIdx] = nums[pivot] - nums[nextGreatestIdx];
            nums[pivot] = nums[pivot] - nums[nextGreatestIdx];

            // reverse the subarray from pivot and the end of array
            int left = pivot + 1, right = nums.length - 1;
            while (left < right) {
                // swap
                nums[left] = nums[left] + nums[right];
                nums[right] = nums[left] - nums[right];
                nums[left] = nums[left] - nums[right];
                left++;
                right--;
            }
        }
        
    }
}
// @lc code=end

