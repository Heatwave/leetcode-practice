#include <stdio.h>
#include <stdlib.h>

/**
 * Definition for a binary tree node.
 */
struct TreeNode
{
    int val;
    struct TreeNode *left;
    struct TreeNode *right;
};

void traversalTree(struct TreeNode *node, int *result, int *returnSize)
{
    if (node->left != NULL)
    {
        traversalTree(node->left, result, returnSize);
    }

    if (node->right != NULL)
    {
        traversalTree(node->right, result, returnSize);
    }

    result[(*returnSize)++] = node->val;
}

/**
 * Note: The returned array must be malloced, assume caller calls free().
 */
int *postorderTraversal(struct TreeNode *root, int *returnSize)
{
    *returnSize = 0;

    int *result = (int *)malloc(sizeof(int) * 999);

    if (root == NULL)
    {
        return result;
    }

    traversalTree(root, result, returnSize);

    return result;
}

void printArr(int v[], int len)
{
    int i;
    for (i = 0; i < len; i++)
        printf("%d ", v[i]);
    printf("\n");
}

int main()
{
    struct TreeNode *rootRightLeftRight = (struct TreeNode *)malloc(sizeof(struct TreeNode));
    rootRightLeftRight->val = 4;
    rootRightLeftRight->left = rootRightLeftRight->right = NULL;

    struct TreeNode *rootRightLeftLeft = (struct TreeNode *)malloc(sizeof(struct TreeNode));
    rootRightLeftLeft->val = 5;
    rootRightLeftLeft->left = rootRightLeftLeft->right = NULL;

    struct TreeNode *rootRightLeft = (struct TreeNode *)malloc(sizeof(struct TreeNode));
    rootRightLeft->val = 3;
    rootRightLeft->left = rootRightLeftLeft;
    rootRightLeft->right = rootRightLeftRight;

    struct TreeNode *rootRight = (struct TreeNode *)malloc(sizeof(struct TreeNode));
    rootRight->val = 2;
    rootRight->left = rootRightLeft;
    rootRight->right = NULL;

    struct TreeNode *root = (struct TreeNode *)malloc(sizeof(struct TreeNode));
    root->val = 1;
    root->left = NULL;
    root->right = rootRight;

    int resultSize = 0;

    int *result = postorderTraversal(root, &resultSize);

    printArr(result, resultSize);

    free(result);
    free(rootRightLeftRight);
    free(rootRightLeftLeft);
    free(rootRightLeft);
    free(rootRight);
    free(root);
}
