#include <stdio.h>

/**
 * Definition for singly-linked list.
 */
struct ListNode
{
    int val;
    struct ListNode *next;
};

struct ListNode *reverse(struct ListNode *prev, struct ListNode *listp)
{
    if (listp == NULL)
        return prev;
    struct ListNode *next = listp->next;
    listp->next = prev;
    return reverse(listp, next);
}

struct ListNode *reverseList(struct ListNode *head)
{
    return reverse(NULL, head);
}
