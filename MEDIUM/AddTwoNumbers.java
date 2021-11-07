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
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        if (l1 == null) {
            return l2;
        } else if (l2 == null) {
            return l1;
        }
        
        int num = l1.val + l2.val;
        ListNode result = new ListNode(num % 10);
        ListNode curr = result;
        l1 = l1.next;
        l2 = l2.next;
        int toAdd = 0;
        while (l1 != null && l2 != null) {
            if (num / 10 > 0) {
                toAdd = 1;
            } else {
                toAdd = 0;
            }
            
            num = l1.val + l2.val + toAdd;
            curr.next = new ListNode(num % 10);
            curr = curr.next;
            l1 = l1.next;
            l2 = l2.next;
        }
        
        if (l1 == null) {
            while (l2 != null) {
                if (num / 10 > 0) {
                    toAdd = 1;
                } else {
                    toAdd = 0;
                }
                
                num = l2.val + toAdd;
                curr.next = new ListNode(num % 10);
                curr = curr.next;
                l2 = l2.next;
            }
            
        } else if (l2 == null) {
            while (l1 != null) {
                if (num / 10 > 0) {
                    toAdd = 1;
                } else {
                    toAdd = 0;
                }
                
                num = l1.val + toAdd;
                curr.next = new ListNode(num % 10);
                curr = curr.next;
                l1 = l1.next;
            }
        }
        
        if (num / 10 > 0) {
            curr.next = new ListNode(1);
        }
        
        return result;
    }
}
