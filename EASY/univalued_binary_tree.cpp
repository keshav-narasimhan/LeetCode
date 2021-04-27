
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
    bool isUnivalTree(TreeNode* root) {
        if (root == nullptr) {
            return false;
        }
        return helper(root, root->val);
    }
    
    bool helper(TreeNode *root, int val) {
        if (root == nullptr) {
            return true;
        }
        if (root->val == val) {
            bool left = helper(root->left, val);
            bool right = helper(root->right, val);
            
            if (left && right) {
                return true;
            }
            else {
                return false;
            }
        }
        else {
            return false;
        }
    }
};