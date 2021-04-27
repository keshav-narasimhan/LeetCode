
// Definition for a binary tree node.
struct TreeNode {
    int val;
    TreeNode *left;
    TreeNode *right;
    TreeNode() : val(0), left(nullptr), right(nullptr) {}
    TreeNode(int x) : val(x), left(nullptr), right(nullptr) {}
    TreeNode(int x, TreeNode *left, TreeNode *right) : val(x), left(left), right(right) {}
 };

class Solution {
public:
    int goodNodes(TreeNode* root) {
        return helper(root, -10001);
    }
    
    int helper(TreeNode *root, int max) {
        if (root == nullptr) {
            return 0;
        }
        if (root->val >= max) {
            return 1 + helper(root->left, root->val) + helper(root->right, root->val);
        }
        else {
            return helper(root->left, max) + helper(root->right, max);
        }
    }
};