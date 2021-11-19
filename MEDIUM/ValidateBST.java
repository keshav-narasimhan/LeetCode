/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    public boolean isValidBST(TreeNode root) {
        ArrayList<Integer> traversal = new ArrayList<>();
        return inOrder(root, traversal);
    }
    
    private boolean inOrder(TreeNode root, ArrayList<Integer> list) {
        // base cases
        if (root == null) {
            return true;
        }
        
        // recurse on left subtree
        boolean left = inOrder(root.left, list);
        
        // check to see if this is a valid BST
        if (list.size() > 0) {
            if (list.get(list.size() - 1) >= root.val) {
                return false;
            }
        }
        list.add(root.val);
        
        // recurse on right subtree
        boolean right = inOrder(root.right, list);
        
        // return
        return left && right;
    }
    
}
