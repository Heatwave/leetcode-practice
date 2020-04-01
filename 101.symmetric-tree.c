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

int isChildSymmetric(struct TreeNode *left, struct TreeNode *right)
{
    if (left == NULL && right == NULL)
        return 1;
    if (left == NULL || right == NULL)
        return 0;
    int outerIsSymmetric = isChildSymmetric(left->left, right->right);
    int innerIsSymmetric = isChildSymmetric(left->right, right->left);
    if (outerIsSymmetric && innerIsSymmetric && (left->val == right->val))
        return 1;
    return 0;
}

int isSymmetric(struct TreeNode *root)
{
    if (root == NULL)
        return 1;
    return isChildSymmetric(root->left, root->right);
}

int main(int argc, char const *argv[])
{
    // [5,4,4,1,null,null,1,2,null,null,2]
    struct TreeNode *rootRightRightLeft = (struct TreeNode *)malloc(sizeof(struct TreeNode));
    rootRightRightLeft->val = 2;
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
    root->val = 5;
    root->left = rootLeft;
    root->right = rootRight;

    int result = isSymmetric(root);
    printf("%d\n", result);
    return 0;
}
