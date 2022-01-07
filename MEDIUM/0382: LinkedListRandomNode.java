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

    ListNode head;
    int length;
    Random rand;
    
    public Solution(ListNode head) {
        this.head = head;
        this.rand = new Random();
       
        ListNode curr = head;
        int size = 1;
        while(curr != null) {
            curr = curr.next;
            size++;
        }
        
        this.length = size;
    }
    
    public int getRandom() {
        int randomNode = rand.nextInt(length - 1);
        
        int index = 0;
        ListNode curr = this.head;
        while (index < randomNode) {
            index++;
            curr = curr.next;
        }
        
        return curr.val;
    }
}

/**
 * Your Solution object will be instantiated and called as such:
 * Solution obj = new Solution(head);
 * int param_1 = obj.getRandom();
 */
