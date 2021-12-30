/**
 * Definition for singly-linked list.
 * class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */
public class Solution {
    public boolean hasCycle(ListNode head) {
        // simple base cases
        if (head == null || head.next == null) {
            return false;
        }
        
        // have two pointers, one that moves slower than the other
        ListNode slowPtr = head;
        ListNode fastPtr = head.next;
        
        // loop while the pointers don't point to the same node (indicating a cycle)
        while(slowPtr != fastPtr) {
            // increment the slow pointer by 1 each iteration => if null, no cycle
            slowPtr = slowPtr.next;
            if (slowPtr == null) {
                return false;
            }
            
            // increment the fast pointer by 2 each iteration => if null, no cycle
            fastPtr = fastPtr.next;
            if (fastPtr == null || fastPtr.next == null) {
                return false;
            }
            fastPtr = fastPtr.next;
        }
        
        // the slow pointer & the fast pointer pointed to the same node => cycle in the LL
        return true;
    }
}
