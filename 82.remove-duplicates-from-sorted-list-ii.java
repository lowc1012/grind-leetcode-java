/*
 * @lc app=leetcode id=82 lang=java
 *
 * [82] Remove Duplicates from Sorted List II
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
    public ListNode deleteDuplicates(ListNode head) {
        if (head == null) {
            return head;
        }

        ListNode sentinel = new ListNode(0, head);
        // predecessor = the last node,
        // before the sublist of duplicates
        ListNode pred = sentinel;

        while (head != null) {
            // find the duplicates sublist
            if (head.next != null && head.val == head.next.val) {
                // skip the duplicates
                while (head.next != null && head.val == head.next.val) {
                    head = head.next;
                }
                pred.next = head.next;
            } else {
                pred = pred.next;
            }

            // move forward
            head = head.next;
        }

        return sentinel.next;
    }
}
// @lc code=end

