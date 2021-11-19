/*
// Definition for a Node.
class Node {
    int val;
    Node next;
    Node random;

    public Node(int val) {
        this.val = val;
        this.next = null;
        this.random = null;
    }
}
*/

class Solution {
    public Node copyRandomList(Node head) {
        if (head == null) {
            return null;
        }
        
        HashMap<Node, Node> copyList = new HashMap<>();
        Node oldHead = head;
        while (oldHead != null) {
            Node newNode = new Node(oldHead.val);
            copyList.put(oldHead, newNode);
            
            oldHead = oldHead.next;
        }
        
        oldHead = head;
        Node newHead = copyList.get(oldHead);
        
        while(oldHead != null) {
            Node next = null;
            if (oldHead.next != null) {
                next = copyList.get(oldHead.next);
            }
            
            Node random = null;
            if (oldHead.random != null) {
                random = copyList.get(oldHead.random);
            }
            
            Node curr = copyList.get(oldHead);
            curr.next = next;
            curr.random = random;
            
            oldHead = oldHead.next;
        }
        
        return newHead;
    }
}
