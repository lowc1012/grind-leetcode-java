/*
 * @lc app=leetcode id=5 lang=java
 *
 * [5] Longest Palindromic Substring
 */

// @lc code=start
class Solution {
    public String longestPalindrome(String s) {
        // expand from midle
        int len = s.length();
        int left = 0, right = 0, len1 = 0, len2 = 0;
        int maxLen = 0;
        
        for (int i = 0; i < len; i++) {
            len1 = expandFromMiddle(i, i, s);

            len2 = expandFromMiddle(i, i+1, s);

            maxLen = Math.max(len1, len2);

            if (maxLen > (right - left)) {
                left = i - (maxLen-1) / 2;
                right = i + maxLen / 2;
            }
        }

        return s.substring(left, right+1);
    }

    private int expandFromMiddle(int left, int right, String s) {
        if (right < left) {
            return 0;
        }

        while (left >= 0 && right < s.length() && s.charAt(left) == s.charAt(right)) {
            left -= 1;
            right += 1;
        }
        return (right - left + 1) - 2; // accept 
    }
}
// @lc code=end

