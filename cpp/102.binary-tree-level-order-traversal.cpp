#include <iostream>
#include <vector>
#include <queue>
using namespace std;

//Definition for a binary tree node.
struct TreeNode
{
    int val;
    TreeNode *left;
    TreeNode *right;
    TreeNode(int x) : val(x), left(NULL), right(NULL) {}
};

class Solution
{
public:
    vector<vector<int>> levelOrder(TreeNode *root)
    {
        vector<vector<int>> result;
        if (root == nullptr)
        {
            return result;
        }

        struct TreeNode *t = root;
        queue<TreeNode *> q;
        q.push(root);
        int level = 0;
        while (!q.empty())
        {
            vector<int> levelResult;
            int levelLength = q.size();
            while (levelLength-- > 0)
            {
                t = q.front();
                levelResult.push_back(t->val);
                q.pop();

                if (t->left != nullptr)
                {
                    q.push(t->left);
                }

                if (t->right != nullptr)
                {
                    q.push(t->right);
                }
            }
            level++;
            result.push_back(levelResult);
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
    struct TreeNode *treeRightRight = new TreeNode(5);

    tree->left = treeLeft;
    tree->right = treeRight;
    treeLeft->left = treeLeftLeft;
    treeRight->right = treeRightRight;

    Solution solution;
    vector<vector<int>> result = solution.levelOrder(tree);

    for (auto it = result.begin(); it != result.end(); ++it)
    {
        vector<int> levelResult = *it;
        for (auto jt = levelResult.begin(); jt != levelResult.end(); ++jt)
        {
            cout << *jt << " ";
        }
        cout << endl;
    }
    return 0;
}
