#include <vector>
#include <string>
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
    vector<string> binaryTreePaths(TreeNode* root) {
        vector<string> paths;
        string p;
        getPaths(paths, root, p);
        return paths;
    }
    void getPaths(vector<string> &paths, TreeNode *root, string &p) {
        if (root == nullptr) {
            return;
        }
        
        if (root->right == nullptr && root->left == nullptr) {
            p += to_string(root->val);
            paths.push_back(p);
            return;
        }
        
        p += to_string(root->val) + "->";
        string left = p;
        string right = p;
        getPaths(paths, root->left, left);
        getPaths(paths, root->right, right);
    }
};