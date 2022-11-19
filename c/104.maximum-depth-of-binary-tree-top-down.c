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

#define MAX(a, b) ((a) > (b) ? (a) : (b))

void maxDepthHelper(struct TreeNode *root, int level, int *depth)
{
    if (root == NULL)
    {
        return;
    }
    *depth = MAX(level, *depth);
    maxDepthHelper(root->left, level + 1, depth);
    maxDepthHelper(root->right, level + 1, depth);
}

int maxDepth(struct TreeNode *root)
{
    int depth = 0;

    if (root == NULL)
        return depth;

    maxDepthHelper(root, 0, &depth);
    return depth + 1;
}

int main(int argc, char const *argv[])
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

    int depth = maxDepth(root);
    printf("%d\n", depth);
    return 0;
}
