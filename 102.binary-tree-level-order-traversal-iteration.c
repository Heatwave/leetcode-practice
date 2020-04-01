#include <stdlib.h>
#include <stdio.h>

struct TreeNode
{
    int val;
    struct TreeNode *left;
    struct TreeNode *right;
};

#define ElementType struct TreeNode *
#define ARRAY_SIZE 999

struct List
{
    ElementType val;
    struct List *next;
};
typedef struct List List;

List *newList(ElementType val)
{
    List *list = (List *)malloc(sizeof(List));
    list->val = val;
    list->next = NULL;
    return list;
}

List *addToList(List *list, ElementType val)
{
    if (list == NULL)
    {
        return newList(val);
    }

    List *p = list;
    while (p->next != NULL)
    {
        p = p->next;
    }
    p->next = newList(val);
    return list;
}

List *popFromList(List *list)
{
    List *newHead = list->next;
    free(list);
    return newHead;
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
    *returnColumnSizes = (int *)malloc(sizeof(int) * ARRAY_SIZE);

    if (root == NULL)
    {
        return (int **)malloc(sizeof(int));
    }

    struct TreeNode *p = root;
    List *list = newList(root);
    while (list != NULL)
    {
        result[(*returnSize)] = (int *)malloc(sizeof(int) * ARRAY_SIZE);
        (*returnColumnSizes)[(*returnSize)] = 0;

        List *newLevelList = NULL;

        while (list != NULL)
        {
            p = list->val;
            result[(*returnSize)][((*returnColumnSizes)[(*returnSize)])++] = p->val;
            list = popFromList(list);

            if (p->left != NULL)
            {
                newLevelList = addToList(newLevelList, p->left);
            }

            if (p->right != NULL)
            {
                newLevelList = addToList(newLevelList, p->right);
            }
        }

        list = newLevelList;
        (*returnSize)++;
    }
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

    List *list = newList(root);

    int returnSize = 0;
    int *returnColumnSizes = (int *)malloc(sizeof(int) * ARRAY_SIZE);
    int **result = levelOrder(root, &returnSize, &returnColumnSizes);

    for (size_t i = 0; i < returnSize; i++)
    {
        for (size_t j = 0; j < returnColumnSizes[i]; j++)
        {
            printf("%d ", result[i][j]);
        }
        printf("\n");
    }
    printf("\n");

    return 0;
}
