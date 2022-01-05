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
    HashMap<Integer, Integer> indexLookUp;
    int preorderIndex;
    int [] preorder;
    int [] inorder;
    
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        // initialize variables
        this.preorder = preorder;
        this.inorder = inorder;
        this.indexLookUp = new HashMap<>();
        this.preorderIndex = 0;
        
        // populate indexLookUp
        for (int i = 0; i < inorder.length; i++) {
            indexLookUp.put(inorder[i], i);
        }
        
        // return the binary tree
        return recursiveBuild(0, inorder.length - 1);
    }
    
    // recursive method to build the binary tree
    private TreeNode recursiveBuild(int leftWindow, int rightWindow) {
        if (leftWindow > rightWindow) {
            return null;
        }
        
        int val = preorder[preorderIndex];
        TreeNode curr = new TreeNode(val);
        preorderIndex++;
        
        int loc = indexLookUp.get(val);
        curr.left = recursiveBuild(leftWindow, loc - 1);
        curr.right = recursiveBuild(loc + 1, rightWindow);
        
        return curr;
    }
}
