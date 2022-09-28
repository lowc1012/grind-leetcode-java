/*
 * @lc app=leetcode id=56 lang=java
 *
 * [56] Merge Intervals
 */

// @lc code=start
class Solution {
    public int[][] merge(int[][] intervals) {
        List<int[]> result = new LinkedList<>();
        Arrays.sort(intervals,
            (a, b) -> Integer.compare(a[0], b[0])
        );
        int start = intervals[0][0];
        int end = intervals[0][1];
        for (int[] interval : intervals) {
            if (interval[0] > end) {
                result.add(new int[]{start, end});
                start = interval[0];
                end = interval[1];
            } else {
                end = Math.max(end, interval[1]);
            }
        }
        result.add(new int[]{start, end});
        return result.toArray(new int[0][]);
    }
}
// @lc code=end

