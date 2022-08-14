/*
 * @lc app=leetcode id=57 lang=java
 *
 * [57] Insert Interval
 */

// @lc code=start
class Solution {
    public int[][] insert(int[][] intervals, int[] newInterval) {
        // input is a non-overlapping intervals , [start i, end i]
        // input is sorted in asc by start i

        // initialize
        List<int[]> leftIntervals = new ArrayList<>();
        List<int[]> rightIntevals = new ArrayList<>();
        
        int start = newInterval[0];
        int end = newInterval[1];

        for (int[] interval : intervals) {
            if (start > interval[1]) {
                leftIntervals.add(interval);
                
            } else if (interval[0] > end) {
                rightIntevals.add(interval);
                
            } else {
                // overlapping, update the newInterval
                start = Math.min(start, interval[0]);
                end = Math.max(end, interval[1]);
            }
        }

        // merge intervals
        leftIntervals.add(new int[]{start, end});
        leftIntervals.addAll(rightIntevals);

        int[][] result = new int[leftIntervals.size()][2];
        for (int i = 0; i < leftIntervals.size(); i++) {
            result[i] = leftIntervals.get(i);
        }
        return result;
    }
}
// @lc code=end

