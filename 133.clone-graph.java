/*
 * @lc app=leetcode id=133 lang=java
 *
 * [133] Clone Graph
 */

// @lc code=start
/*
// Definition for a Node.
class Node {
    public int val;
    public List<Node> neighbors;
    public Node() {
        val = 0;
        neighbors = new ArrayList<Node>();
    }
    public Node(int _val) {
        val = _val;
        neighbors = new ArrayList<Node>();
    }
    public Node(int _val, ArrayList<Node> _neighbors) {
        val = _val;
        neighbors = _neighbors;
    }
}
*/

class Solution {
    public Node cloneGraph(Node node) {
        if (node == null) {
            return node;
        }

        // old node maps to new node
        // Space time complexity: O(V)
        Map<Node, Node> nodeMap = new HashMap<>();
        
        // Use BFS -> Time complexity: O(V+E)
        Queue<Node> queue = new LinkedList<>();
        nodeMap.put(node, new Node(node.val));
        queue.add(node);

        while (!queue.isEmpty()) {
            Node visitedNode = queue.poll();
            for (Node neighbor : visitedNode.neighbors) {
                if (!nodeMap.containsKey(neighbor)) {
                    nodeMap.put(neighbor, new Node(neighbor.val));
                    queue.add(neighbor);
                }

                // get new node and add its neighbors
                Node newNode = nodeMap.get(visitedNode);
                newNode.neighbors.add(nodeMap.get(neighbor));
            }
        }

        return nodeMap.get(node);
    }
}
// @lc code=end

