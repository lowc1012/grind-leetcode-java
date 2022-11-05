/*
 * @lc app=leetcode id=127 lang=java
 *
 * [127] Word Ladder
 */

// @lc code=start
class Solution {
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        // 1. We can view the collection with beginWord, endWord and wordList as
        // an undirected graph. The question boils down to find the min steps
        // from beginWord to endWord. (BFS)

        Set<String> set = new HashSet<>(wordList);
        Queue<String> queue = new LinkedList<>();
        queue.add(beginWord);
        int result = 1;

        while (!queue.isEmpty()) {
            int size = queue.size();
            // iterate words in queue
            for (int i = 0; i < size; i++) {
                String curr = queue.poll();

                // replace each char in the current word
                int currWordLength = curr.length();
                for (int j = 0; j < currWordLength; j++) {
                    // store the char at index j for restoring the word
                    char tmp = curr.charAt(j);
                    
                    // repalce the char with 'a' ~ 'z', TC: (M)
                    for (char letter = 'a'; letter <= 'z'; letter++) {
                        curr = curr.substring(0, j) + letter + curr.substring(j+1, currWordLength);
                        if (set.contains(curr)) {
                            if (curr.equals(endWord)) {
                                return result + 1;
                            }
                            queue.add(curr);
                            set.remove(curr);
                        }
                    }

                    // restore the current word
                    curr = curr.substring(0, j) + tmp + curr.substring(j+1, currWordLength);
                }
            }

            // move 1 step forward to endWord
            result += 1;
        }

        return 0;
    }
}
// @lc code=end

