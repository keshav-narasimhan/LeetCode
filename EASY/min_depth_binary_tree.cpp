
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
    int minDepth(TreeNode* root) {
        if (root == nullptr) {
            return 0;
        }
        return helper(root);
    }
    
    int helper(TreeNode *root) {
        if (root->left == nullptr && root->right == nullptr) {
            return 1;
        }
        int left = 0;
        int right = 0;
        if (root->left != nullptr) {
            left = 1 + helper(root->left);
        }
        if (root->right != nullptr) {
            right = 1 + helper(root->right);
        } 
        
        if (left != 0 && right != 0) {
            if (left < right) {
                return left;
            }
            else {
                return right;
            }
        }
        else if (left == 0) {
            return right;
        }
        else {
            return left;
        }
        
    }
};