#include <stdlib.h>
#include <stdio.h>
#include <string.h>

struct TreeNode
{
    int val;
    struct TreeNode *left;
    struct TreeNode *right;
};

#define ARRAY_SIZE 999

void helper(struct TreeNode *node, int level, int **result, int *returnColumnSizes, int *returnSize)
{
    if (level > *returnSize)
    {
        result[level] = (int *)malloc(sizeof(int) * ARRAY_SIZE);
        *returnSize = level;
    }

    result[level][returnColumnSizes[level]] = node->val;
    returnColumnSizes[level] += 1;

    if (node->left != NULL)
    {
        helper(node->left, level + 1, result, returnColumnSizes, returnSize);
    }

    if (node->right != NULL)
    {
        helper(node->right, level + 1, result, returnColumnSizes, returnSize);
    }
}

/**
 * Return an array of arrays of size *returnSize.
 * The sizes of the arrays are returned as *returnColumnSizes array.
 * Note: Both returned array and *columnSizes array must be malloced, assume caller calls free().
 */
int **levelOrder(struct TreeNode *root, int *returnSize, int **returnColumnSizes)
{
    *returnSize = 0;

    int **result = (int **)malloc(sizeof(int *) * ARRAY_SIZE);
    *returnColumnSizes = (int *)calloc(ARRAY_SIZE, sizeof(int));

    if (root == NULL)
    {
        return result;
    }

    result[0] = (int *)malloc(sizeof(int) * ARRAY_SIZE);
    helper(root, 0, result, *returnColumnSizes, returnSize);
    *returnSize += 1;
    return result;
}

int main(int argc, char const *argv[])
{
    struct TreeNode *rootRightRight = (struct TreeNode *)malloc(sizeof(struct TreeNode));
    rootRightRight->val = 7;
    rootRightRight->left = NULL;
    rootRightRight->right = NULL;

    struct TreeNode *rootRightLeft = (struct TreeNode *)malloc(sizeof(struct TreeNode));
    rootRightLeft->val = 15;
    rootRightLeft->left = NULL;
    rootRightLeft->right = NULL;

    struct TreeNode *rootRight = (struct TreeNode *)malloc(sizeof(struct TreeNode));
    rootRight->val = 20;
    rootRight->left = rootRightLeft;
    rootRight->right = rootRightRight;

    struct TreeNode *rootLeft = (struct TreeNode *)malloc(sizeof(struct TreeNode));
    rootLeft->val = 9;
    rootLeft->left = NULL;
    rootLeft->right = NULL;

    struct TreeNode *root = (struct TreeNode *)malloc(sizeof(struct TreeNode));
    root->val = 3;
    root->left = rootLeft;
    root->right = rootRight;

    int returnSize = 0;
    int *returnColumnSizes = NULL;
    int **result = levelOrder(root, &returnSize, &returnColumnSizes);

    for (size_t i = 0; i < returnSize; i++)
    {
        for (size_t j = 0; j < returnColumnSizes[i]; j++)
        {
            printf("%d ", result[i][j]);
        }
        printf("\n");
    }

    return 0;
}
