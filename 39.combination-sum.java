/*
 * @lc app=leetcode id=39 lang=java
 *
 * [39] Combination Sum
 */

// @lc code=start
class Solution {

    private List<List<Integer>> result;

    private int[] input;

    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        // input array consist of distinct integers
        input = candidates;
        // init result array
        result = new ArrayList<>();

        // sort the input array
        Arrays.sort(candidates);

        // use backtrack to try out all possible combinations
        backtrack(new ArrayList(), 0, target);

        return result;
    }

    private void backtrack(List<Integer> track, int start, int target) {
        if (target < 0) {
            return;
        }

        // desired result
        if (target == 0) {
            result.add(new ArrayList(track));
            return;
        }

        for (int i = start; i < input.length; i++) {
            track.add(input[i]);
            backtrack(track, i, target - input[i]);
            track.remove(track.size()-1);
        }
    }
}
// @lc code=end

