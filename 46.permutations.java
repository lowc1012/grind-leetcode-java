/*
 * @lc app=leetcode id=46 lang=java
 *
 * [46] Permutations
 */

// @lc code=start
class Solution {
    private List<List<Integer>> result;
    private List<Integer> track;

    public List<List<Integer>> permute(int[] nums) {

        result = new ArrayList<>();

        backtrack(nums, 0);

        return result;
    }

    private void backtrack(int[] nums, int start) {

        if (start == nums.length - 1) {
            track = Arrays.stream(nums).boxed().collect(Collectors.toList());
            result.add(track);
        }

        for (int i = start; i < nums.length; i++) {
            int tmp = nums[i];
            nums[i] = nums[start];
            nums[start] = tmp;

            backtrack(nums, start+1);

            tmp = nums[i];
            nums[i] = nums[start];
            nums[start] = tmp;
        }

    }



    // private List<List<Integer>> result;
    // private List<Integer> track;

    // public List<List<Integer>> permute(int[] nums) {
    //     // input array is not empty
    //     // initialize the result and input
    //     result = new ArrayList<>();

    //     // use backtrack to find out all possible result
    //     backtrack(nums, 0);

    //     return result;
    // }

    // private void backtrack(int[] nums, int start) {
    //     if (start == nums.length-1) {
    //         track = Arrays.stream(nums).boxed().collect(Collectors.toList());
    //         result.add(track);
    //     }

    //     for (int i = start; i < nums.length; i++) {
    //         // swap two integers in given array
    //         int tmp = nums[i];       
    //         nums[i] = nums[start];
    //         nums[start] = tmp;

    //         backtrack(nums, start + 1);

    //         tmp = nums[i];       
    //         nums[i] = nums[start];
    //         nums[start] = tmp;
    //     }
    // }
}
// @lc code=end

