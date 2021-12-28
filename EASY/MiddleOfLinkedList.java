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
    public ListNode middleNode(ListNode head) {
        // base cases
        if (head == null || head.next == null) {
            return head;
        }
        
        // local variables for finding the middle with a single traversal
        int cnt = 2;
        ListNode pointer = head.next;
        ListNode middle = head.next;
        
        // update 'middle' every 2 shifts of 'pointer'
        while(pointer != null) {
            pointer = pointer.next;
            cnt++;
            if (cnt % 2 == 0 && pointer != null) {
                middle = middle.next;
            }
        }
        
        // return the middle of the LL
        return middle;
    }
}
