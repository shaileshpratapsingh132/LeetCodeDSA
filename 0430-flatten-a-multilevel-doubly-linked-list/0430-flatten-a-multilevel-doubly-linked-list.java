/*
// Definition for a Node.
class Node {
    public int val;
    public Node prev;
    public Node next;
    public Node child;
};
*/

class Solution {
    public Node flatten(Node head) {
        Node cur = head;

        while (cur != null) {
            if (cur.child != null) {
                Node ch = cur.child;
                Node nxt = cur.next;
                cur.next = ch;
                ch.prev = cur;
                cur.child = null;
                Node temp = ch;
                while (temp.next != null) {
                    temp = temp.next;
                }
                temp.next = nxt;

                if (nxt != null) {
                    nxt.prev = temp;
                }
            }

            cur = cur.next;
        }

        return head;
    }
}