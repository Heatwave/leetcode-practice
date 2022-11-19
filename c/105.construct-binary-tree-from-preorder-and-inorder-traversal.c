#include <stdlib.h>
#include <stdio.h>

/**
 * Definition for a binary tree node.
 */
struct TreeNode
{
    int val;
    struct TreeNode *left;
    struct TreeNode *right;
};

struct TreeNode *buildTree(int *preorder, int preorderSize, int *inorder, int inorderSize)
{
    if (preorderSize == 0 || inorderSize == 0)
        return NULL;
    struct TreeNode *root = (struct TreeNode *)malloc(sizeof(struct TreeNode));
    root->val = preorder[0];

    int leftTreeSize = 0, rightTreeSize = 0;

    for (size_t i = 0; i < inorderSize; i++)
    {
        if (inorder[i] == root->val)
        {
            break;
        }
        leftTreeSize++;
    }

    rightTreeSize = inorderSize - leftTreeSize - 1;

    int *leftTreePreorder = preorder + 1;
    int *rightTreePreorder = preorder + 1 + leftTreeSize;

    int *leftTreeInorder = inorder;
    int *rightTreeInorder = inorder + leftTreeSize + 1;

    root->left = buildTree(leftTreePreorder, leftTreeSize, leftTreeInorder, leftTreeSize);
    root->right = buildTree(rightTreePreorder, rightTreeSize, rightTreeInorder, rightTreeSize);

    return root;
}

void traversal(struct TreeNode *root)
{
    if (root->left != NULL)
    {
        traversal(root->left);
    }

    if (root->right != NULL)
    {
        traversal(root->right);
    }
    printf("%d ", root->val);
}

int main(int argc, char const *argv[])
{
    int preorder[] = {3, 9, 20, 15, 7};
    int inorder[] = {9, 3, 15, 20, 7};
    struct TreeNode *tree = buildTree(preorder, sizeof(preorder) / sizeof(preorder[0]),
                                      inorder, sizeof(inorder) / sizeof(inorder[0]));

    traversal(tree);
    printf("\n");
    return 0;
}
