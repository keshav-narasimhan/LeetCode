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
    public ListNode oddEvenList(ListNode head) {
       
        // base case(s)
        if (head == null || head.next == null || head.next.next == null) {
            return head;
        }
        
        ListNode curr = head;
        ListNode forward = head.next;
        ListNode firstEven = forward;
        ListNode save;
        
        while(forward != null && forward.next != null) {
            save = forward.next;
            forward.next = forward.next.next;
            curr.next = save;
            curr = curr.next;
            forward = forward.next;
        }
        
        curr.next = firstEven;
        
        // return head of re-ordered LL
        return head;
    }
}
