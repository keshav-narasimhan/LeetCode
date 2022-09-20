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
    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        // handle base cases
        if (list1 == null) {
            return list2;
        } else if (list2 == null) {
            return list1;
        }
        
        // figure out starting point for merged list
        ListNode head;
        ListNode list1Ptr = list1;
        ListNode list2Ptr = list2;
        if (list1.val <= list2.val) {
            head = list1;
            list1Ptr = list1.next;
        } else {
            head = list2;
            list2Ptr = list2.next;
        }        
        ListNode mergePtr = head;
        
        // determine the rest of the list
        while (list1Ptr != null || list2Ptr != null) {
            if (list1Ptr != null && list2Ptr != null) {
                if (list1Ptr.val <= list2Ptr.val) {
                    mergePtr.next = list1Ptr;
                    list1Ptr = list1Ptr.next;
                } else {
                    mergePtr.next = list2Ptr;
                    list2Ptr = list2Ptr.next;
                }
                mergePtr = mergePtr.next;
            } else if (list1Ptr != null) {
                mergePtr.next = list1Ptr;
                break;
            } else {
                mergePtr.next = list2Ptr;
                break;
            }
        }
        
        // return the head of the merged list
        return head;
    }
}
