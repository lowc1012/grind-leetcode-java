/*
 * @lc app=leetcode id=2086 lang=java
 *
 * [2086] Minimum Number of Buckets Required to Collect Rainwater from Houses
 */

// @lc code=start
class Solution {
    public int minimumBuckets(String street) {
        // 'H': House, '.': empty space, 'B': Bucket
        // street is not empty string
        StringBuilder sb = new StringBuilder(street);
        int len = street.length();
        int result = 0;
        for (int i = 0; i < len; i++) {
            if (sb.charAt(i) == 'H') {
                int left = i - 1, right = i + 1;
                
                if (left >= 0 && sb.charAt(left) == 'B') {
                    continue;
                }

                if (right < len && sb.charAt(right) == '.') {
                    sb.setCharAt(right, 'B');
                    result++;
                } else if (left >= 0 && sb.charAt(left) == '.') {
                    sb.setCharAt(left, 'B');
                    result++;
                } else {
                    return -1;
                }
            }
        }
        return result;
    }
}
// @lc code=end

