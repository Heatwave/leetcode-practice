#include <stdlib.h>
#include <stdio.h>

// Definition for singly-linked list.
struct ListNode
{
    int val;
    struct ListNode *next;
};

struct ListNode *middleNode(struct ListNode *head)
{
    int length = 0;
    struct ListNode *p = head;
    while (p != NULL)
    {
        length++;
        p = p->next;
    }

    int mid = length / 2 + 1;
    for (size_t i = 1; i < mid; i++)
    {
        head = head->next;
    }

    return head;
}

int main(int argc, char const *argv[])
{
    struct ListNode *list = malloc(sizeof(struct ListNode));
    struct ListNode *p = list;
    int length = 5;

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
