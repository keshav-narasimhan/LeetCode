// Definition for singly-linked list.
class ListNode {
	int val;
	ListNode next;
	ListNode(int x) { val = x; }
}


public class DeleteNodeinLinkedList 
{
	public void deleteNode(ListNode node) {
        
        ListNode temp = node.next;
        node.val = temp.val;
        node.next = temp.next;
        temp.next = null;
        
    }
}
