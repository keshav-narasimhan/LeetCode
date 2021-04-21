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
    vector<int> preorderTraversal(TreeNode* root) {
        vector<int> pre_order;
        preOrder(pre_order, root);
        return pre_order;
    }
    void preOrder (vector<int> &pre_order, TreeNode* root) {
        if (root == nullptr) {
            return;
        }
        pre_order.push_back(root->val);
        preOrder(pre_order, root->left);
        preOrder(pre_order, root->right);
    }
};