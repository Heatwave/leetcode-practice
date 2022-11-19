#include <stdlib.h>
#include <stdio.h>

// Definition for singly-linked list.
struct ListNode
{
    int val;
    struct ListNode *next;
};

struct ListNode *mid = NULL;
int length = 0;

struct ListNode *middleNodeCount(struct ListNode *head, int count)
{
    if (head->next == NULL)
    {
        length = count + 1;
        if ((count + 1) == (length / 2 + 1))
            mid = head;
        return head;
    }
    middleNodeCount(head->next, ++count);
    int midNumber = length / 2 + 1;
    if (count == midNumber)
        mid = head;
    return head;
}

struct ListNode *middleNode(struct ListNode *head)
{
    int count = 0;
    middleNodeCount(head, count);
    return mid;
}

int main(int argc, char const *argv[])
{
    struct ListNode *list = malloc(sizeof(struct ListNode));
    struct ListNode *p = list;
    int length = 3;

    for (size_t i = 1; i < length + 1; i++)
    {
        p->val = i;
        if (i == length)
            break;
        p->next = malloc(sizeof(struct ListNode));
        p = p->next;
    }
    p->next = NULL;

    list = middleNode(list);

    struct ListNode *prev;
    while (list != NULL)
    {
        prev = list;
        printf("%d ", list->val);
        list = list->next;
        free(prev);
    }

    return 0;
}
