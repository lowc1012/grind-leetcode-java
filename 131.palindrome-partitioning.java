/*
 * @lc app=leetcode id=131 lang=java
 *
 * [131] Palindrome Partitioning
 */

// @lc code=start
class Solution {
    private List<List<String>> result;

    private String input;

    public List<List<String>> partition(String s) {
        // input array is not empty
        input = s;

        result = new ArrayList<List<String>>();

        backtrack(new ArrayList<String>(), 0);

        return result;
    }

    private void backtrack(List<String> track, int start) {
        // add desired result into result
        // when start >= number of characters in input string
        if (start >= input.length()) {
            result.add(new ArrayList<String>(track));
        }

        // [start, end] := {[0, 0], [0, 1], [0, 2], [1, 1], [1, 2], [2, 2]}
        for (int end = start; end < input.length(); end++) {
            if (isPalindrome(input, start, end)) {
                track.add(input.substring(start, end + 1));
                backtrack(track, end + 1);
                track.remove(track.size()-1);
            }
        }
        
    }

    private boolean isPalindrome(String str, int start, int end) {
        while (start < end) {
            if (str.charAt(start++) != str.charAt(end--)) {
                return false;
            }
        }
        return true;
    }
    
}
// @lc code=end

