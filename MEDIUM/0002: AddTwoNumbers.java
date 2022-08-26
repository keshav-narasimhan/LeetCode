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

/* August 25, 2022 */
class Solution {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode l1_ptr = l1;
        ListNode l2_ptr = l2;
        ListNode result = new ListNode();
        ListNode result_ptr = result;
        int val;
        int carry = 0;
        
        while(l1_ptr != null || l2_ptr != null) {
            val = carry;
            
            if (l1_ptr != null) { val += l1_ptr.val; }
            if (l2_ptr != null) { val += l2_ptr.val; }
            
            carry = val / 10;
            val %= 10;
            
            if (l1_ptr == l1) {
                result_ptr.val = val;
            } else {
                ListNode new_node = new ListNode(val);
                result_ptr.next = new_node;
                result_ptr = new_node;
            }
            
            if(l1_ptr != null) { l1_ptr = l1_ptr.next; }
            if(l2_ptr != null) { l2_ptr = l2_ptr.next; }
        }
        
        if (carry != 0) {
            ListNode new_node = new ListNode(carry);
            result_ptr.next = new_node;
        }
        
        return result;
    }
}

// class Solution {
//     public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
//         if (l1 == null) {
//             return l2;
//         } else if (l2 == null) {
//             return l1;
//         }
        
//         int num = l1.val + l2.val;
//         ListNode result = new ListNode(num % 10);
//         ListNode curr = result;
//         l1 = l1.next;
//         l2 = l2.next;
//         int toAdd = 0;
//         while (l1 != null && l2 != null) {
//             if (num / 10 > 0) {
//                 toAdd = 1;
//             } else {
//                 toAdd = 0;
//             }
            
//             num = l1.val + l2.val + toAdd;
//             curr.next = new ListNode(num % 10);
//             curr = curr.next;
//             l1 = l1.next;
//             l2 = l2.next;
//         }
        
//         if (l1 == null) {
//             while (l2 != null) {
//                 if (num / 10 > 0) {
//                     toAdd = 1;
//                 } else {
//                     toAdd = 0;
//                 }
                
//                 num = l2.val + toAdd;
//                 curr.next = new ListNode(num % 10);
//                 curr = curr.next;
//                 l2 = l2.next;
//             }
            
//         } else if (l2 == null) {
//             while (l1 != null) {
//                 if (num / 10 > 0) {
//                     toAdd = 1;
//                 } else {
//                     toAdd = 0;
//                 }
                
//                 num = l1.val + toAdd;
//                 curr.next = new ListNode(num % 10);
//                 curr = curr.next;
//                 l1 = l1.next;
//             }
//         }
        
//         if (num / 10 > 0) {
//             curr.next = new ListNode(1);
//         }
        
//         return result;
//     }
// }
