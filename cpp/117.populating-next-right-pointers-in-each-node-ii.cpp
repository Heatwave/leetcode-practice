#include <iostream>
#include <queue>
using namespace std;

class Node
{
  public:
    int val;
    Node *left;
    Node *right;
    Node *next;

    Node() : val(0), left(NULL), right(NULL), next(NULL) {}

    Node(int _val) : val(_val), left(NULL), right(NULL), next(NULL) {}

    Node(int _val, Node *_left, Node *_right, Node *_next)
        : val(_val), left(_left), right(_right), next(_next) {}
};

class Solution
{
  public:
    Node *connect(Node *root)
    {
        if (root == NULL)
            return NULL;

        queue<Node *> q;
        q.push(root);

        while (!q.empty())
        {
            for (size_t i = q.size(); i > 0; i--)
            {
                Node *tree = q.front();
                cout << tree->val << endl;
                q.pop();

                if (i - 1 > 0)
                    tree->next = q.front();

                if (tree->left != NULL)
                    q.push(tree->left);
                if (tree->right != NULL)
                    q.push(tree->right);
            }
        }
        return root;
    }
};

int main(int argc, char const *argv[])
{
    Node *tree = new Node(1);
    Node *treeLeft = new Node(2);
    Node *treeRight = new Node(3);
    Node *treeLeftLeft = new Node(4);
    Node *treeRightRight = new Node(5);

    tree->left = treeLeft;
    tree->right = treeRight;
    treeLeft->left = treeLeftLeft;
    treeRight->right = treeRightRight;

    Solution solution;
    solution.connect(tree);

    return 0;
}
