/*
 * @lc app=leetcode id=3 lang=java
 *
 * [3] Longest Substring Without Repeating Characters
 */

// @lc code=start
class Solution {
    // TC: O(n) because there is a for loop
    public int lengthOfLongestSubstring(String s) {
        // initialize
        int result = 0;
        
        // use HashSet to record the characters
        Set<Character> set = new HashSet<Character>();
    
        // use two pointers to implement "sliding window"
        int left = 0;
        for (int right = left; right < s.length(); right++) {
            Character c = s.charAt(right);

            // check whether there are repeating characters
            boolean isContains = set.contains(c);
            // use while loop to remove repeating charaters
            while (isContains) {
                set.remove(new Character(s.charAt(left)));
                left++;
                isContains = set.contains(c);
            }

            // add the charater into set
            set.add(c);

            // update the result if longest length is changed
            result = Math.max(result, right - left + 1);
        }

        return result;
    }
}
// @lc code=end

