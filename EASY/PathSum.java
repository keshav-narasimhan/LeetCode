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
    public boolean hasPathSum(TreeNode root, int targetSum) {
        // return output of recursive helper method
        return helper(root, targetSum);
    }
    
    private boolean helper(TreeNode root, int target) {
        // return false if root = null
        if (root == null) {
            return false;
        } 
        // check to see if the path's sum is 0 when you arrive at a leaf node
        else if (root.left == null && root.right == null) {
            if (target - root.val == 0) {
                return true;
            } else {
                return false;
            }
        }
        
        // if not at a leaf node, continue down the tree by recursively calling on left/right subtrees
        return helper(root.left, target - root.val) || helper(root.right, target - root.val);
    }
}
