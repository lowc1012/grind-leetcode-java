/*
 * @lc app=leetcode id=19 lang=java
 *
 * [19] Remove Nth Node From End of List
 */

// @lc code=start
/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode fast = head;
        ListNode slow = head;

        // Finding nth node from end of list
        // This question is equal to finding (lenthOfList - n + 1) from head of list
        // fast node moves n steps forward first
        for (int i = 0; i < n; i++) {
            fast = fast.next;
        }

        // (important) if we want to remove head node
        if (fast == null) {
            head = head.next;
            return head;
        }

        // then two pointers move forward until fast is at end of list
        // slow will move (lenthOfList - n) steps forward
        while (fast.next != null) {
            slow = slow.next;
            fast = fast.next;
        }
        
        // slow.next is our target, remove it
        slow.next = slow.next.next;
        return head;
    }
}
// @lc code=end

