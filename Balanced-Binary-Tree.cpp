/**
 * Definition for a binary tree node.
 * struct TreeNode {
 *     int val;
 *     TreeNode *left;
 *     TreeNode *right;
 *     TreeNode() : val(0), left(nullptr), right(nullptr) {}
 *     TreeNode(int x) : val(x), left(nullptr), right(nullptr) {}
 *     TreeNode(int x, TreeNode *left, TreeNode *right) : val(x), left(left), right(right) {}
 * };
 */
class Solution {
public:
    int height(TreeNode* root, int &diff){
        if(root==NULL){
            return 0;
        }

        int left = height(root->left, diff);
        int right = height(root->right, diff);

        diff = max(diff, abs(left- right));
        if(diff>1) return diff;
        return 1+max(left, right);
    }
    bool isBalanced(TreeNode* root) {
        int diff = 0;
        height(root, diff);
        return (diff>1)?false:true;
    }
};