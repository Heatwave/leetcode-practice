#include <stdio.h>
#include <stdlib.h>

#define Error(Str) FatalError(Str)
#define FatalError(Str) fprintf(stderr, "%s\n", Str), exit(1)

#define ElementType struct TreeNode *
/**
 * Definition for a binary tree node.
 */
struct TreeNode
{
    int val;
    struct TreeNode *left;
    struct TreeNode *right;
};

struct Node;
typedef struct Node *PtrToNode;
typedef PtrToNode Stack;

struct Node
{
    ElementType element;
    PtrToNode next;
};

int isEmpty(Stack s)
{
    return s->next == NULL;
}

void push(ElementType x, Stack s)
{
    PtrToNode newCell;

    newCell = malloc(sizeof(struct Node));
    if (newCell == NULL)
        Error("Must use createStack first");
    else
    {
        newCell->element = x;
        newCell->next = s->next;
        s->next = newCell;
    }
}

void pop(Stack s)
{
    PtrToNode FirstCell;

    if (isEmpty(s))
        Error("Empty Stack");
    else
    {
        FirstCell = s->next;
        s->next = s->next->next;
        free(FirstCell);
    }
}

void makeEmpty(Stack s)
{
    if (s == NULL)
        Error("Must use createStack first");
    else
        while (!isEmpty(s))
            pop(s);
}

Stack createStack()
{
    Stack s;

    s = malloc(sizeof(struct Node));
    if (s == NULL)
        FatalError("Out of Memory!!!");
    s->next = NULL;
    makeEmpty(s);
    return s;
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

    Stack output = createStack();

    struct TreeNode *node = root;
    while (node != NULL)
    {
        if (node->right == NULL)
        {
            push(node, output);
            node = node->left;
        }
        else
        {
            struct TreeNode *predecessor = node->right;
            while ((predecessor->left != NULL) && (predecessor->left != node))
                predecessor = predecessor->left;

            if (predecessor->left == NULL)
            {
                push(node, output);
                predecessor->left = node;
                node = node->right;
            }
            else
            {
                predecessor->left = NULL;
                node = node->left;
            }
        }
    }

    while (!isEmpty(output))
    {
        node = output->next->element;
        pop(output);
        result[(*returnSize)++] = node->val;
    }

    free(output);

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

    int *result = postorderTraversal(root, &resultSize);

    printArr(result, resultSize);

    free(result);
    free(rootRightLeftLeft);
    free(rootRightLeftRight);
    free(rootRightLeft);
    free(rootRight);
    free(rootLeft);
    free(root);
}
