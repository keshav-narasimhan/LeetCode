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
    public TreeNode pruneTree(TreeNode root) {
        boolean b = helper(root);
        if (!b) {
            if (root.val == 0 && root.left == null && root.right == null) {
                root = null;
            }
        }
        return root;
    }
    
    private boolean helper(TreeNode root) {
        if (root == null) {
            return false;
        } else if (root.val == 0 && root.left == null && root.right == null) {
            return false;
        } else if (root.val == 1 && root.left == null && root.right == null) {
            return true;
        }
        boolean l = helper(root.left);
        boolean r = helper(root.right);
        if (!l) {
            root.left = null;
        } 
        if (!r) {
            root.right = null;
        }
        return !(!l && !r && root.val == 0);
    }
}
