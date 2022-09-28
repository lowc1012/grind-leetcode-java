/*
 * @lc app=leetcode id=787 lang=java
 *
 * [787] Cheapest Flights Within K Stops
 */

// @lc code=start
class Solution {
    private int price;
    private int[][] adjacencyMatrix;
    private Queue<int[]> queue;
    private Map<Integer, Integer> minCostMap;

    public int findCheapestPrice(int n, int[][] flights, int src, int dst, int k) {
        price = Integer.MAX_VALUE;

        // because 1 <=  n <= 100 (in stead of using Hashmap for speed optimization)
        adjacencyMatrix = new int[100][100];
        for (int[] flight : flights) {
            adjacencyMatrix[flight[0]][flight[1]] = flight[2];
        }

        // use a hashmap to track the min cost of flight <dst, cost>
        minCostMap = new HashMap<>();

        // use queue to implement BFS algo
        queue = new LinkedList<>();
        queue.offer(new int[]{src, 0});

        // use BFS to travseral the graph
        BFS(dst, k);

        return price == Integer.MAX_VALUE ? -1 : price;
    }

    private void BFS(int dst, int k) {
        // k = 1, flights = 2
        while (!queue.isEmpty() && k >= -1) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                int[] curr = queue.poll();

                if (curr[0] == dst) {
                    price = Math.min(price, curr[1]);
                } else {
                    
                    for (int a = 0; a < 100; a++) {
                        // check whether there is a flight
                        if (adjacencyMatrix[curr[0]][a] > 0) {
                            int estimatedCost = adjacencyMatrix[curr[0]][a] + curr[1];
                            // (important) Pruning
                            if ( (estimatedCost < price) && 
                                (!minCostMap.containsKey(a) || minCostMap.get(a) > estimatedCost)
                            ) {
                                queue.offer(new int[]{a, estimatedCost});
                                minCostMap.put(a, estimatedCost);
                            }
                        }

                    }
                }
            }
            k--;
        }
    }
}
// @lc code=end

