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
    struct ListNode *slow = head, *fast = head;
    while (fast != NULL && fast->next != NULL)
    {
        slow = slow->next;
        fast = fast->next->next;
    }
    return slow;
}

int main(int argc, char const *argv[])
{
    struct ListNode *list = malloc(sizeof(struct ListNode));
    struct ListNode *p = list;
    int length = 7;

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
