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
    vector<int> postorderTraversal(TreeNode* root) {
        vector<int> post_order;
        postOrder(post_order, root);
        return post_order;
    }
    void postOrder (vector<int> &post_order, TreeNode* root) {
        if (root == nullptr) {
            return;
        }
        postOrder(post_order, root->left);
        postOrder(post_order, root->right);
        post_order.push_back(root->val);
    }
};