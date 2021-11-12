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
    public ListNode mergeKLists(ListNode[] lists) {
        if (lists.length == 0) {
            return null;
        }
        
        PriorityQueue<ListNodeCompare> q = new PriorityQueue<>();
        for (int i = 0; i < lists.length; i++) {
            if (lists[i] != null) {
                q.add(new ListNodeCompare(lists[i]));
            }
        }
        
        if (q.isEmpty()) {
            return null;
        }
        
        ListNode head = q.poll().getNode();
        if (head.next != null) {
            q.add(new ListNodeCompare(head.next));
        }
        ListNode curr = head;
        while (!q.isEmpty()) {
            ListNode l = q.poll().getNode();
            if (l.next != null) {
                q.add(new ListNodeCompare(l.next));
            }
            curr.next = l;
            curr = curr.next;
        }
        
        return head;
    }
}

class ListNodeCompare implements Comparable<ListNodeCompare> {
    private ListNode node;
    
    public ListNodeCompare(ListNode node) {
        this.node = node;
    }
    
    public ListNode getNode() {
        return this.node;
    }
    
    @Override
    public int compareTo(ListNodeCompare other) {
        if (this.node.val > other.node.val) {
            return 1;
        } else {
            return -1;
        }
    }
}
