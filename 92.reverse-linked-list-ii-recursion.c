#include <stdlib.h>
#include <stdio.h>

// Definition for singly-linked list.
struct ListNode
{
    int val;
    struct ListNode *next;
};

struct ListNode *successor = NULL;

struct ListNode *reverseN(struct ListNode *head, int n)
{
    if (n == 1)
    {
        successor = head->next;
        return head;
    }
    struct ListNode *last = reverseN(head->next, n - 1);

    head->next->next = head;
    head->next = successor;
    return last;
}

struct ListNode *reverseBetween(struct ListNode *head, int m, int n)
{
    if (m == 1)
    {
        return reverseN(head, n);
    }
    head->next = reverseBetween(head->next, m - 1, n - 1);
    return head;
}

int main(int argc, char const *argv[])
{
    struct ListNode *list = malloc(sizeof(struct ListNode));
    struct ListNode *p = list;

    for (size_t i = 1; i < 6; i++)
    {
        p->val = i;
        if (i == 5)
            break;
        p->next = malloc(sizeof(struct ListNode));
        p = p->next;
    }
    p->next = NULL;

    list = reverseBetween(list, 2, 4);

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
