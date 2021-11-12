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
    public ListNode removeElements(ListNode head, int val) {
        // if head is empty, return null
        if (head == null) {
            return head;
        }
        
        // link to prev node
        ListNode prev = null;
        // link to curr node
        ListNode curr = head;
        // link to new head node, if needed
        ListNode h = head;
        
        // loop through entire LL
        while (curr != null) {
            // if the vals don't match, move to next node
            if (curr.val != val) {
                prev = curr;
                curr = curr.next;
            } else {
                // if the node to be removed is the head, assign a new head & delete the curr head
                if (prev == null) {
                    ListNode c = curr;
                    curr = curr.next;
                    c.next = null;
                    h = curr;
                }
                // set the prev node's next link to the current node's next link
                else {
                    prev.next = curr.next;
                    curr = curr.next;
                }
            }
        }
        
        return h;
    }
}
