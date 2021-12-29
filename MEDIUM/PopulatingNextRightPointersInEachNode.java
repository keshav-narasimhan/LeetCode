/*
// Definition for a Node.
class Node {
    public int val;
    public Node left;
    public Node right;
    public Node next;

    public Node() {}
    
    public Node(int _val) {
        val = _val;
    }

    public Node(int _val, Node _left, Node _right, Node _next) {
        val = _val;
        left = _left;
        right = _right;
        next = _next;
    }
};
*/

class Solution {
    public Node connect(Node root) {
        // base case => the root is null
        if (root == null) {
            return root;
        }
        
        // root's next should be null
        root.next = null;
        
        // recursively call on child nodes of root
        helper(root.left, root, true);
        helper(root.right, root, false);
        
        // return the modified binary tree
        return root;
    }
    
    private void helper(Node curr, Node parent, boolean left) {
        // recursive base case
        if (curr == null) {
            return;
        }
        
        // curr = left child of parent
        if (left) {
            // left child's next is simply the parent's right child
            curr.next = parent.right;
        }
        // curr = right child of parent
        else {
            if (parent.next != null) {
                // right child's next is the parent's next's left child (if it exists)
                curr.next = parent.next.left;
            } else {
                // rightmost node in the layer should have a next of null
                curr.next = null;
            }
        }
        
        // recursively call on child nodes
        helper(curr.left, curr, true);
        helper(curr.right, curr, false);
    }
}
