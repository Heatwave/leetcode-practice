#include <stdlib.h>
#include <stdio.h>

// Definition for singly-linked list.
struct ListNode
{
    int val;
    struct ListNode *next;
};

struct ListNode *reverseBetween(struct ListNode *head, int m, int n)
{
    if (m == n)
        return head;

    struct ListNode *prev = NULL, *next = NULL, *p = head;
    // left is the m point left point, right is the m point
    // left->next should be the n point, right->next should be the n->next point
    struct ListNode *left = NULL, *right = NULL;
    int count = 1;

    while (p != NULL && count <= n)
    {
        next = p->next;

        if (count == m)
        {
            left = prev;
            right = p;
        }

        if (count >= m)
            p->next = prev;

        if (count == n)
        {
            if (left != NULL)
                left->next = p;
            right->next = next;

            // if reverse from the original head, the new head should locate on the n point
            // otherwise the head should be the original head
            if (m == 1)
                head = p;
        }

        prev = p;
        p = next;
        count++;
    }
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

    list = reverseBetween(list, 1, 1);

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
