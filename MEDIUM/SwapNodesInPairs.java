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
    public ListNode swapPairs(ListNode head) {
        // return null if head is empty
        if (head == null || head.next == null) {
            return head;
        }
        
        // reference to node before the pair
        ListNode prev = null;
        // reference to 'first' node in pair
        ListNode first = head;
        // reference to 'second' node in pair
        ListNode second = head.next;
        // reference to new 'head' of LL
        ListNode h = head;
        // reference to node after the pair
        ListNode next = null;
        
        // loop to iterate over LL
        while (second != null) {
            // reference to node right after pair
            next = second.next;
            
            // execute swap
            second.next = first;
            first.next = next;
            
            // make element before pair point to second
            if (prev != null) {
                prev.next = second;
            } 
            // assign new head of LL
            else {
                h = second;
            }
            
            // reached end of list of 'next' is null
            if (next == null) {
                break;
            } 
            // increment our pointers
            else {
                second = next.next;
                prev = first;
                first = next;
            }
        }
        
        return h;
    }
}
