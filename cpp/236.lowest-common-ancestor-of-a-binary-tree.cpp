#include <iostream>
#include <vector>

using namespace std;

struct TreeNode
{
    int val;
    TreeNode *left;
    TreeNode *right;
    TreeNode(int x) : val(x), left(NULL), right(NULL) {}
};

class Solution
{
  private:
    int pVal, qVal;
    vector<struct TreeNode *> v;
    vector<struct TreeNode *> pAncestor;
    vector<struct TreeNode *> qAncestor;

    void preorderTraversal(TreeNode *node)
    {
        v.push_back(node);
        if (node->val == pVal)
        {
            pAncestor = v;
        }
        if (node->val == qVal)
        {
            qAncestor = v;
        }

        if (node->left != NULL)
            preorderTraversal(node->left);
        if (node->right != NULL)
            preorderTraversal(node->right);

        v.pop_back();
    }

  public:
    TreeNode *lowestCommonAncestor(TreeNode *root, TreeNode *p, TreeNode *q)
    {
        pVal = p->val;
        qVal = q->val;
        preorderTraversal(root);

        TreeNode *result = NULL;

        int i = pAncestor.size() - 1, j = qAncestor.size() - 1;

        for (; i >= 0; i--)
        {
            for (int k = j; k >= 0; k--)
            {
                if (qAncestor[k]->val == pAncestor[i]->val)
                {
                    result = qAncestor[k];
                    break;
                }
            }
            if (result != NULL)
                break;
        }

        return result;
    }
};

int main(int argc, char const *argv[])
{
    struct TreeNode *tree = new TreeNode(1);
    struct TreeNode *treeLeft = new TreeNode(2);
    struct TreeNode *treeRight = new TreeNode(3);
    struct TreeNode *treeLeftLeft = new TreeNode(4);
    struct TreeNode *treeLeftRight = new TreeNode(5);
    struct TreeNode *treeRightLeft = new TreeNode(6);
    struct TreeNode *treeRightRight = new TreeNode(7);
    struct TreeNode *treeLeftRightLeft = new TreeNode(8);
    struct TreeNode *treeLeftRightRight = new TreeNode(9);

    tree->left = treeLeft;
    tree->right = treeRight;
    treeLeft->left = treeLeftLeft;
    treeLeft->right = treeLeftRight;
    treeRight->left = treeRightLeft;
    treeRight->right = treeRightRight;
    treeLeftRight->left = treeLeftRightLeft;
    treeLeftRight->right = treeLeftRightRight;

    Solution solution;
    struct TreeNode *ancestor = solution.lowestCommonAncestor(tree, treeLeftRight, treeLeftRightRight);
    cout << "ancestor: " << ancestor->val << endl;

    return 0;
}
