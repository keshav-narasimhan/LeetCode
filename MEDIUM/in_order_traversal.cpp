#include <vector>
using namespace std;

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
    vector<int> inorderTraversal(TreeNode* root) {
        vector<int> in_order;
        inOrder(in_order, root);
        return in_order;
    }
    
    void inOrder (vector<int> &in_order, TreeNode* root) {
        if (root == nullptr) {
            return;
        }
        
        inOrder(in_order, root->left);
        in_order.push_back(root->val);
        inOrder(in_order, root->right);
    }
};