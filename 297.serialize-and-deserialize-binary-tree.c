#include <stdio.h>
#include <stdlib.h>
#include <string.h>

/**
 * Definition for a binary tree node.
 */
struct TreeNode
{
    int val;
    struct TreeNode *left;
    struct TreeNode *right;
};

#define INIT_SIZE 999
#define GROW_MULTI 2

typedef struct string
{
    char *str;
    size_t length;
    size_t capacity;
} string;

string *stringCreate()
{
    string *s = (string *)malloc(sizeof(string));
    if (s == NULL)
        return NULL;
    s->capacity = INIT_SIZE;
    s->str = (char *)malloc(sizeof(char) * s->capacity);
    if (s->str == NULL)
        return NULL;
    s->str[0] = '\0';
    s->length = 0;
    return s;
}

void stringAppend(string *s, const char *new)
{
    if (s->length + strlen(new) + 1 > s->capacity)
    {
        char *news = (char *)realloc(s->str, sizeof(char) * (s->capacity * GROW_MULTI));
        if (news == NULL)
            return;
        s->str = news;
        s->capacity *= GROW_MULTI;
    }
    strcat(s->str, new);
    s->length = strlen(s->str);
}

string *serializeHelper(struct TreeNode *root, string *str)
{
    if (root == NULL)
    {
        stringAppend(str, "n ");
        return str;
    }
    char temp[99];
    sprintf(temp, "%d ", root->val);
    stringAppend(str, temp);
    str = serializeHelper(root->left, str);
    str = serializeHelper(root->right, str);
    return str;
}

/** Encodes a tree to a single string. */
char *serialize(struct TreeNode *root)
{
    if (root == NULL)
        return "";

    string *s = stringCreate();
    s = serializeHelper(root, s);
    return s->str;
}

struct TreeNode *deserializeHelper(char **data)
{
    if ((*data)[0] == 'n')
        return NULL;

    int val = atoi(*data);
    struct TreeNode *root = (struct TreeNode *)malloc(sizeof(struct TreeNode));
    root->val = val;

    *data = strchr(*data, ' ') + 1;
    root->left = deserializeHelper(data);

    *data = strchr(*data, ' ') + 1;
    root->right = deserializeHelper(data);

    return root;
}

/** Decodes your encoded data to tree. */
struct TreeNode *deserialize(char *data)
{
    if (strlen(data) == 0)
        return NULL;

    return deserializeHelper(&data);
}

// Your functions will be called as such:
// char* data = serialize(root);
// deserialize(data);

int main(int argc, char const *argv[])
{
    // string *s = stringCreate();
    // printf("%zu\n", strlen(s->str));
    // printf("%d\n", s->length);

    // printf("%s length: %d capacity: %d\n", s->str, s->length, s->capacity);

    // stringAppend(s, "a");
    // printf("%s length: %d capacity: %d\n", s->str, s->length, s->capacity);

    // stringAppend(s, "bcdefg");
    // printf("%s length: %d capacity: %d\n", s->str, s->length, s->capacity);

    // stringAppend(s, "hijklmnopqrstuvwxyz");
    // printf("%s length: %d capacity: %d\n", s->str, s->length, s->capacity);
    struct TreeNode *rootRightLeft = (struct TreeNode *)malloc(sizeof(struct TreeNode));
    rootRightLeft->val = 4;
    rootRightLeft->left = rootRightLeft->right = NULL;

    struct TreeNode *rootRightRight = (struct TreeNode *)malloc(sizeof(struct TreeNode));
    rootRightRight->val = 5;
    rootRightRight->left = rootRightRight->right = NULL;

    struct TreeNode *rootLeft = (struct TreeNode *)malloc(sizeof(struct TreeNode));
    rootLeft->val = 2;
    rootLeft->left = NULL;
    rootLeft->right = NULL;

    struct TreeNode *rootRight = (struct TreeNode *)malloc(sizeof(struct TreeNode));
    rootRight->val = 3;
    rootRight->left = rootRightLeft;
    rootRight->right = rootRightRight;

    struct TreeNode *root = (struct TreeNode *)malloc(sizeof(struct TreeNode));
    root->val = 1;
    root->left = rootLeft;
    root->right = rootRight;

    char *data = serialize(root);
    root = deserialize(data);
    printf("%d %d %d\n", root->val, root->left->val, root->right->val);
    printf("%d %d %d\n", root->val, root->right->left->val, root->right->right->val);
    return 0;
}
