#include <iostream>
#include <queue>
#include <string>

using namespace std;

/**
 * Definition for a binary tree node.
 */
struct TreeNode
{
    int val;
    TreeNode *left;
    TreeNode *right;
    TreeNode(int x) : val(x), left(NULL), right(NULL) {}
};

class Codec
{
public:
    // Encodes a tree to a single string.
    string serialize(TreeNode *root)
    {
        if (root == NULL)
            return "[]";

        string result = "[";
        queue<TreeNode *> q;

        q.push(root);
        while (!q.empty())
        {
            size_t size = q.size();
            bool isAllNULL = true;
            while (size-- > 0)
            {
                TreeNode *node = q.front();
                q.pop();
                if (node != NULL)
                {
                    result += to_string(node->val) + ",";

                    q.push(node->left);
                    q.push(node->right);
                    isAllNULL = false;
                }
                else
                {
                    result += "null,";
                }
            }
            if (isAllNULL)
                break;
        }

        size_t pos = result.find_last_of("0123456789");
        result = result.substr(0, pos + 1) + "]";

        return result;
    }

    // Decodes your encoded data to tree.
    TreeNode *deserialize(string data)
    {
        if (data == "[]")
            return NULL;

        string s = data;
        s = s.substr(1, s.size() - 2);

        queue<TreeNode *> v;

        int val = stoi(s);
        struct TreeNode *root = new TreeNode(val);
        v.push(root);

        struct TreeNode *node;
        bool isLeft = true;

        while (!s.empty())
        {
            node = v.front();

            int commaPos = s.find(',');
            if (commaPos == string::npos)
                break;
            s = s.substr(commaPos + 1);
            if (tolower(s[0]) != 'n')
            {
                val = stoi(s);
                if (isLeft)
                {
                    node->left = new TreeNode(val);
                    v.push(node->left);
                }
                else
                {
                    node->right = new TreeNode(val);
                    v.push(node->right);
                }
            }
            if (!isLeft)
                v.pop();
            isLeft = !isLeft;
        }

        return root;
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

    // Your Codec object will be instantiated and called as such:
    Codec codec;
    string data = codec.serialize(tree);
    cout << data << endl;
    TreeNode *root = codec.deserialize(data);
    data = codec.serialize(root);
    cout << data;

    return 0;
}
