/*
 * @lc app=leetcode id=155 lang=java
 *
 * [155] Min Stack
 */

// @lc code=start
class MinStack {
    private class Node {
        int value;
        int minVal;
        Node next;

        private Node(int value, int minVal, Node next) {
            this.value = value;
            this.minVal = minVal;
            this.next = next;
        }
    }

    private Node head;

    public MinStack() {
        
    }
    
    public void push(int val) {
        if (head == null) {
            head = new Node(val, val, null);
        } else {
            head = new Node(val, Math.min(val, head.minVal), head);
        }
    }
    
    public void pop() {
        head = head.next;
    }
    
    public int top() {
        return head.value;
    }
    
    public int getMin() {
        return head.minVal;
    }
}

/**
 * Your MinStack object will be instantiated and called as such:
 * MinStack obj = new MinStack();
 * obj.push(val);
 * obj.pop();
 * int param_3 = obj.top();
 * int param_4 = obj.getMin();
 */
// @lc code=end

