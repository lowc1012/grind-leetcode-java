/*
 * @lc app=leetcode id=78 lang=java
 *
 * [78] Subsets
 */

// @lc code=start
class Solution {

    private List<List<Integer>> result;

    private int[] input;

    public List<List<Integer>> subsets(int[] nums) {
        // nums is not empty and the elements are unique
        // use backtracking to try out all posible subsets.
        
        result = new ArrayList<>();

        input = nums;

        backtrack(new ArrayList(), 0);

        return result;
    }

    private void backtrack(List<Integer> track, int start) {
        result.add(new ArrayList(track));

        for (int i = start; i < input.length; i++) {
            track.add(input[i]);
            backtrack(track, i + 1);
            track.remove(track.size()-1);
        }
    }

}
// @lc code=end

