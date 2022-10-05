/*
 * @lc app=leetcode id=994 lang=java
 *
 * [994] Rotting Oranges
 */

// @lc code=start
class Solution {
    public int orangesRotting(int[][] grid) {
        // every minute fresh orange which adjacent to a rotten orange becomes rotten
        // there is any fresh orange when it finished => return -1

        // The first thing that came to my mind is BFS
        // We can use BFS to find adjacent nodes every minute(iteration)
        int count = 0;
        int n = grid.length;
        int m = grid[0].length;

        // not visited: -1, visited: 0
        int[][] time = new int[n][m];

        Queue<int[]> queue = new LinkedList<>();
        
        // insert all rotten oranges
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                time[i][j] = -1;
                if (grid[i][j] == 2) {
                    queue.add(new int[]{i, j});
                    time[i][j] = 0;
                }
            }
        }

        while (!queue.isEmpty()) {
            int[] node = queue.poll();
            int x = node[0];
            int y = node[1];

            // move down
            if(x+1 < n && time[x+1][y] == -1 && grid[x+1][y] == 1) {
                queue.add(new int[]{x+1, y});
                time[x+1][y] = time[x][y] + 1;
            }

            // move up
            if(x-1 >= 0 && time[x-1][y] == -1 && grid[x-1][y] == 1) {
                queue.add(new int[]{x-1, y});
                time[x-1][y] = time[x][y] + 1;
            }

            // move left
            if(y-1 >= 0 && time[x][y-1] == -1 && grid[x][y-1] == 1) {
                queue.add(new int[]{x, y-1});
                time[x][y-1] = time[x][y] + 1;
            }

            // move right
            if(y+1 < m && time[x][y+1] == -1 && grid[x][y+1] == 1) {
                queue.add(new int[]{x, y+1});
                time[x][y+1] = time[x][y] + 1;
            }
        }

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (grid[i][j] == 1) {
                    if (time[i][j] == -1) {
                        return -1;
                    }
                    count = Math.max(count, time[i][j]);
                }
            }
        }
        return count;
    }
}
// @lc code=end

