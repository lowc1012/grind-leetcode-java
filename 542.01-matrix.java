/*
 * @lc app=leetcode id=542 lang=java
 *
 * [542] 01 Matrix
 */

// @lc code=start
class Solution {

    private class Point {
        int x;
        int y;
        Point(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

    private int[][] dirs = new int[][]{{1, 0}, {-1, 0}, {0, 1}, {0, -1}};

    public int[][] updateMatrix(int[][] mat) {
        // BFS => queue

        int m = mat.length;
        int n = mat[0].length;

        Queue<Point> queue = new LinkedList<>();
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (mat[i][j] == 1) {
                    mat[i][j] = -1;
                } else {
                    queue.offer(new Point(i, j));
                }
            }
        }

        // BFS start from each 0 cell
        int len = 0;
        while (!queue.isEmpty()) {
            len++;
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                Point curPoint = queue.poll();
                for (int[] dir : dirs) {
                    int ii = curPoint.x + dir[0];
                    int jj = curPoint.y + dir[1];

                    if (ii >= 0 && jj >= 0 && ii < m && jj < n) {
                        if (mat[ii][jj] == -1) {
                            mat[ii][jj] = len;
                            queue.offer(new Point(ii, jj));
                        }
                    }
                }
            }
        }

        return mat;
    }

     
}
// @lc code=end

