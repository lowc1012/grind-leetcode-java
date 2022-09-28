/*
 * @lc app=leetcode id=76 lang=java
 *
 * [76] Minimum Window Substring
 */

// @lc code=start
class Solution {
    public String minWindow(String s, String t) {
        if (s.length() == 0 || t.length() == 0) {
            return "";
        }

        // use HashMap to record the <Character, present count> in String t
        Map<Character, Integer> countMap = new HashMap<>();
        for (char c : t.toCharArray()) {
            countMap.put(c, countMap.getOrDefault(c, 0) + 1);
        }

        // use another HashMap to keeps a count of all the unique characters
        // in the current window
        Map<Character, Integer> windowCounts = new HashMap<>();

        // use numUniqueChar to check how many unique characters in t are present
        // in the current window
        int numUniqueChar = 0;

        int[] ans = {-1, 0, 0};

        // two pointers to implement sliding window
        int left = 0, right = 0;

        // iterate String s
        while (right < s.length()) {
            Character c = s.charAt(right);

            // Add a character pointed by right into current window
            windowCounts.put(c, windowCounts.getOrDefault(c, 0) + 1);

            // check the frequency, if the number of character present in s
            // is same as in t, then plus numUniqueChar
            if (countMap.containsKey(c) &&
                countMap.get(c).intValue() == windowCounts.get(c).intValue()) {
                numUniqueChar++;
            }

            // if numUniqueChar = number of unique characters presented in t
            // 
            while (left <= right && numUniqueChar == countMap.size()) {
                c = s.charAt(left);

                // save the smallest window size
                if (ans[0] == -1 || right - left + 1 < ans[0]) {
                    ans[0] = right - left + 1;
                    ans[1] = left;
                    ans[2] = right;
                }

                // remove the num pointed by left from current window
                windowCounts.put(c, windowCounts.get(c)-1);
                if (countMap.containsKey(c) &&
                    windowCounts.get(c).intValue() < countMap.get(c).intValue()) {
                    numUniqueChar--;
                }

                // move left pointer ahead, look for a new window
                left++;
            }
            // Keep expanding the window (move right pointer ahead)
            right++;
        }

        if (ans[0] == -1) {
            return "";
        }
        return s.substring(ans[1], ans[2] + 1);
    }
}
// @lc code=end

