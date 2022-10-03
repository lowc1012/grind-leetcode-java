/*
 * @lc app=leetcode id=150 lang=java
 *
 * [150] Evaluate Reverse Polish Notation
 */

// @lc code=start
class Solution {
    public int evalRPN(String[] tokens) {
        // use stack -> SC: O(n)
        Stack<String> stack = new Stack<>();
        
        // TC: O(n)
        for (String token : tokens) {
            if (token.equals("+") || token.equals("-") || token.equals("*") || token.equals("/")) {
                int a = Integer.parseInt(stack.pop());
                int b = Integer.parseInt(stack.pop());
                switch (token) {
                    case "+":
                        stack.push(Integer.toString(b+a));
                        break;
                    case "-":
                        stack.push(Integer.toString(b-a));
                        break;
                    case "*":
                        stack.push(Integer.toString(b*a));
                        break;
                    case "/":
                        stack.push(Integer.toString(b/a));
                        break;
                    default:
                        break;
                }

            } else {
                stack.push(token);
            }
        }

        return Integer.parseInt(stack.pop());
    }
}
// @lc code=end

