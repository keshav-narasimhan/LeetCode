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
    public List<Integer> getAllElements(TreeNode root1, TreeNode root2) {
        PriorityQueue<Integer> elems = new PriorityQueue<>();
        getElems(elems, root1);
        getElems(elems, root2);
        
        List<Integer> ordered = new ArrayList<>();
        while (!elems.isEmpty()) {
            ordered.add(elems.poll());
        }
        
        return ordered;
    }
    
    private void getElems(PriorityQueue<Integer> elems, TreeNode root) {
        if (root == null) {
            return;
        } else {
            getElems(elems, root.left);
            elems.add(root.val);
            getElems(elems, root.right);
        }
    }
}
