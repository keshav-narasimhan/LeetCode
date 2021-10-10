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
    public int kthSmallest(TreeNode root, int k) {
        ArrayList<Integer> vals = new ArrayList<>();
        preorderTraversal(root, vals);
        return vals.get(k - 1);
    }
    
    private void preorderTraversal(TreeNode root, ArrayList <Integer> vals) {
        if (root == null) {
            return;
        } else {
            preorderTraversal(root.left, vals);
            vals.add(root.val);
            preorderTraversal(root.right, vals);
        }
    }
}
