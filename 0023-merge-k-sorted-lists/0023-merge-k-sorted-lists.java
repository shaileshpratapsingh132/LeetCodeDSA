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
import java.util.PriorityQueue;

class Solution {
    public ListNode mergeKLists(ListNode[] lists) {
        PriorityQueue<ListNode> pq = new PriorityQueue<>(
            (a, b) -> a.val - b.val
        );

        for (ListNode n : lists) {
            if (n != null) {
                pq.add(n);
            }
        }

        ListNode d = new ListNode(0);
        ListNode t = d;

        while (!pq.isEmpty()) {
            ListNode n = pq.poll();

            t.next = n;
            t = t.next;

            if (n.next != null) {
                pq.add(n.next);
            }
        }

        return d.next;
    }
}