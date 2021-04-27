
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
    bool isSymmetric(TreeNode* root) {
        return findSymmetric(root->left, root->right);
    }
    
    bool findSymmetric(TreeNode *first, TreeNode *sec) {
        if (first == nullptr && sec == nullptr) {
            return true;
        }
        
        if (first != nullptr && sec != nullptr && first->val == sec->val) {
            bool left_right = findSymmetric(first->left, sec->right);
            bool right_left = findSymmetric(first->right, sec->left);
            if (left_right && right_left) {
                return true;
            }
            return false;
        }
        else {
            return false;
        }
    }
};