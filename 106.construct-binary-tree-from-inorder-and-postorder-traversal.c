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

struct TreeNode *buildTree(int *inorder, int inorderSize, int *postorder, int postorderSize)
{
    if (inorderSize == 0 || postorderSize == 0)
        return NULL;

    struct TreeNode *root = (struct TreeNode *)malloc(sizeof(struct TreeNode));
    root->val = postorder[postorderSize - 1];

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

    int *leftTreeInorder = inorder;
    int *rightTreeInorder = inorder + (leftTreeSize + 1);

    int *leftTreePostorder = postorder;
    int *rightTreePostorder = postorder + leftTreeSize;

    root->left = buildTree(leftTreeInorder, leftTreeSize, leftTreePostorder, leftTreeSize);
    root->right = buildTree(rightTreeInorder, rightTreeSize, rightTreePostorder, rightTreeSize);

    return root;
}

void preorderTraversal(struct TreeNode *root)
{
    printf("%d ", root->val);
    if (root->left != NULL)
    {
        preorderTraversal(root->left);
    }

    if (root->right != NULL)
    {
        preorderTraversal(root->right);
    }
}

int main(int argc, char const *argv[])
{
    int inorder[] = {9, 3, 15, 20, 7};
    int postorder[] = {9, 15, 7, 20, 3};
    struct TreeNode *tree = buildTree(inorder, sizeof(inorder) / sizeof(inorder[0]),
                                      postorder, sizeof(postorder) / sizeof(postorder[0]));

    preorderTraversal(tree);
    printf("\n");
    return 0;
}
