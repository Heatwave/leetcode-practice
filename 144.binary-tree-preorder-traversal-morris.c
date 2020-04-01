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

/**
 * Note: The returned array must be malloced, assume caller calls free().
 */
int *preorderTraversal(struct TreeNode *root, int *returnSize)
{
    *returnSize = 0;

    int *result = (int *)malloc(sizeof(int) * 999);

    if (root == NULL)
    {
        return result;
    }

    struct TreeNode *node = root;
    while (node != NULL)
    {
        if (node->left == NULL)
        {
            result[(*returnSize)++] = node->val;
            node = node->right;
        }
        else
        {
            struct TreeNode *predecessor = node->left;
            while ((predecessor->right != NULL) && (predecessor->right != node))
                predecessor = predecessor->right;

            if (predecessor->right == NULL)
            {
                result[(*returnSize)++] = node->val;
                predecessor->right = node;
                node = node->left;
            }
            else
            {
                predecessor->right = NULL;
                node = node->right;
            }
        }
    }

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

    struct TreeNode *rootLeft = (struct TreeNode *)malloc(sizeof(struct TreeNode));
    rootLeft->val = 6;
    rootLeft->left = NULL;
    rootLeft->right = NULL;

    struct TreeNode *root = (struct TreeNode *)malloc(sizeof(struct TreeNode));
    root->val = 1;
    root->left = rootLeft;
    root->right = rootRight;

    int resultSize = 0;

    int *result = preorderTraversal(root, &resultSize);

    printArr(result, resultSize);

    free(result);
    free(rootRightLeftLeft);
    free(rootRightLeftRight);
    free(rootRightLeft);
    free(rootRight);
    free(rootLeft);
    free(root);
}
