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
    public ListNode insertionSortList(ListNode head) {
        ListNode d = new ListNode(0);
        ListNode c = head;

        while (c != null) {
            ListNode n = c.next;

            ListNode p = d;

            while (p.next != null && p.next.val < c.val) {
                p = p.next;
            }

            c.next = p.next;
            p.next = c;

            c = n;
        }

        return d.next;
    }
}