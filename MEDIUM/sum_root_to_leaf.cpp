
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
    int doMath(TreeNode *root, int curr) {
        if (root == nullptr) {
            return curr;
        }
        if (root->left == nullptr && root->right == nullptr) {
            return (curr * 10) + root->val;
        }
        
        int left = 0;
        int right = 0;
        if (root->left != nullptr) {
            left = doMath(root->left, (curr * 10) + root->val);
        }
        if (root->right != nullptr) {
            right = doMath(root->right, (curr * 10) + root->val);
        }
        return left + right;
    }
    
    int sumNumbers(TreeNode* root) {
        return doMath(root, 0);
    }
};
