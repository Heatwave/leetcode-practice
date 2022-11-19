#include <stdlib.h>
#include <stdio.h>

#define bool int

/**
 * Definition for a binary tree node.
 */
struct TreeNode
{
    int val;
    struct TreeNode *left;
    struct TreeNode *right;
};

void traversalTree(struct TreeNode *node, int temp, int sum, int *matched)
{
    if (*matched == 1)
        return;

    temp += node->val;
    if (node->left == NULL && node->right == NULL && temp == sum)
    {
        *matched = 1;
        return;
    }

    if (node->left != NULL)
    {
        traversalTree(node->left, temp, sum, matched);
    }

    if (node->right != NULL)
    {
        traversalTree(node->right, temp, sum, matched);
    }
}

bool hasPathSum(struct TreeNode *root, int sum)
{
    int matched = 0;
    if (root == NULL)
        return 0;

    traversalTree(root, 0, sum, &matched);

    return matched;
}

int main(int argc, char const *argv[])
{
    // [5,4,4,1,null,null,1,2,null,null,3]
    struct TreeNode *rootRightRightLeft = (struct TreeNode *)malloc(sizeof(struct TreeNode));
    rootRightRightLeft->val = 3;
    rootRightRightLeft->left = rootRightRightLeft->right = NULL;

    struct TreeNode *rootRightRight = (struct TreeNode *)malloc(sizeof(struct TreeNode));
    rootRightRight->val = 1;
    rootRightRight->left = NULL;
    rootRightRight->right = rootRightRightLeft;

    struct TreeNode *rootLeftLeftLeft = (struct TreeNode *)malloc(sizeof(struct TreeNode));
    rootLeftLeftLeft->val = 2;
    rootLeftLeftLeft->left = rootLeftLeftLeft->right = NULL;

    struct TreeNode *rootLeftLeft = (struct TreeNode *)malloc(sizeof(struct TreeNode));
    rootLeftLeft->val = 1;
    rootLeftLeft->left = rootLeftLeftLeft;
    rootLeftLeft->right = NULL;

    struct TreeNode *rootRight = (struct TreeNode *)malloc(sizeof(struct TreeNode));
    rootRight->val = 4;
    rootRight->left = NULL;
    rootRight->right = rootRightRight;

    struct TreeNode *rootLeft = (struct TreeNode *)malloc(sizeof(struct TreeNode));
    rootLeft->val = 4;
    rootLeft->left = rootLeftLeft;
    rootLeft->right = NULL;

    struct TreeNode *root = (struct TreeNode *)malloc(sizeof(struct TreeNode));
    root->val = 1;
    root->left = rootLeft;
    root->right = rootRight;

    int result = hasPathSum(root, 13);

    printf("result: %d\n", result);

    return 0;
}
