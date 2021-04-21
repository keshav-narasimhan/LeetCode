#include <vector>
using namespace std;

// Definition for a Node.
class Node {
public:
    int val;
    vector<Node*> children;

    Node() {}

    Node(int _val) {
        val = _val;
    }

    Node(int _val, vector<Node*> _children) {
        val = _val;
        children = _children;
    }
};

class Solution {
public:
    vector<int> preorder(Node* root) {
        vector<int> pre_order;
        preOrder(pre_order, root);
        return pre_order;
    }
    void preOrder (vector<int> &pre_order, Node *root) {
        if (root == nullptr) {
            return;
        }
        
        pre_order.push_back(root->val);
        for (auto child: root->children) {
            preOrder(pre_order, child);
        }
    }
};