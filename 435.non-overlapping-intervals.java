/*
 * @lc app=leetcode id=435 lang=java
 *
 * [435] Non-overlapping Intervals
 */

// @lc code=start
class Solution {
    public int eraseOverlapIntervals(int[][] intervals) {
        // return minimum number of intervals you need
        // to remove to make the rest of the intervals non-overlapping
        // take array [[1,2],[2,3],[3,4],[1,3]] for example

        // Sort intervals
        List<int[]> intervalList = Arrays.asList(intervals);
        Collections.sort(intervalList, new Comparator<int[]>() {
            @Override
            public int compare(final int[] intervalA, int[] intervalB) {
                return intervalA[1] - intervalB[1];
            }
        });
        // [[1,2],[1,3],[2,3],[3,4]]

        // Greedy algorithm
        int result = 0;
        int end = intervalList.get(0)[1];
        for (int i = 1; i < intervalList.size(); i++) {
            // overlapping
            if (end > intervalList.get(i)[0]) {
                result++;
            } else {
                end = intervalList.get(i)[1];
            }
        }
        return result;
    }
}
// @lc code=end

