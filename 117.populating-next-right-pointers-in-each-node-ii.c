#include <stdlib.h>
#include <stdio.h>
#include <string.h>

struct Node
{
    int val;
    struct Node *left;
    struct Node *right;
    struct Node *next;
};

struct Node *connect(struct Node *root)
{
    if (root == NULL)
        return root;

    if (root->left == NULL && root->right == NULL)
        return root;

    if (root->left != NULL)
        root->left->next = root->right;

    struct Node *next = root->next;

    while (next != NULL)
    {
        if (next->left != NULL)
        {
            if (root->left != NULL && root->left->next == NULL)
                root->left->next = next->left;
            if (root->right != NULL && root->right->next == NULL)
                root->right->next = next->left;
        }

        if (next->right != NULL)
        {
            if (root->left != NULL && root->left->next == NULL)
                root->left->next = next->right;
            if (root->right != NULL && root->right->next == NULL)
                root->right->next = next->right;
        }
        next = next->next;
    }

    connect(root->right);
    connect(root->left);

    return root;
}

void traversal(struct Node *root)
{
    printf("%d next is %d\n", root->val, root->next == NULL ? 0 : root->next->val);
    if (root->left != NULL)
    {
        traversal(root->left);
    }

    if (root->right != NULL)
    {
        traversal(root->right);
    }
}

int main(int argc, char const *argv[])
{
    struct Node *rootLeftLeft = (struct Node *)malloc(sizeof(struct Node));
    rootLeftLeft->val = 4;
    rootLeftLeft->left = rootLeftLeft->right = rootLeftLeft->next = NULL;

    struct Node *rootLeftRight = (struct Node *)malloc(sizeof(struct Node));
    rootLeftRight->val = 5;
    rootLeftRight->left = rootLeftRight->right = rootLeftRight->next = NULL;

    struct Node *rootRightRight = (struct Node *)malloc(sizeof(struct Node));
    rootRightRight->val = 7;
    rootRightRight->left = rootRightRight->right = rootRightRight->next = NULL;

    struct Node *rootLeft = (struct Node *)malloc(sizeof(struct Node));
    rootLeft->val = 2;
    rootLeft->left = rootLeftLeft;
    rootLeft->right = rootLeftRight;
    rootLeft->next = NULL;

    struct Node *rootRight = (struct Node *)malloc(sizeof(struct Node));
    rootRight->val = 3;
    rootRight->left = NULL;
    rootRight->right = rootRightRight;
    rootRight->next = NULL;

    struct Node *root = (struct Node *)malloc(sizeof(struct Node));
    root->val = 1;
    root->left = rootLeft;
    root->right = rootRight;
    root->next = NULL;

    root = connect(root);

    traversal(root);

    return 0;
}
