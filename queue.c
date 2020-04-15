#include <stdlib.h>
#include <stdio.h>
#include <string.h>
#include <assert.h>

#include "queue.h"

Queue *queueCreate()
{
    Queue *q = (Queue *)malloc(sizeof(Queue));
    if (q == NULL)
        return NULL;

    q->head = q->tail = NULL;
    q->size = 0;
    return q;
}

bool queueEnqueue(Queue *q, void *item)
{
    Node *newnode = (Node *)malloc(sizeof(Node));
    if (newnode == NULL)
        return false;
    newnode->data = item;
    newnode->next = NULL;

    if (q->tail == NULL)
        q->tail = newnode;
    else
    {
        q->tail->next = newnode;
        q->tail = q->tail->next;
    }

    if (q->head == NULL)
        q->head = q->tail;

    q->size += 1;
    return true;
}

bool queueDequeue(Queue *q)
{
    if (queueIsEmpty(q))
        return false;
    Node *node = q->head;
    q->head = q->head->next;
    if (q->head == NULL)
        q->tail = NULL;

    free(node->data);
    free(node);
    q->size -= 1;
    return true;
}

void *queueFront(Queue *q)
{
    if (queueIsEmpty(q))
        return NULL;
    return q->head->data;
}

void *queueRear(Queue *q)
{
    if (queueIsEmpty(q))
        return NULL;
    return q->tail->data;
}

bool queueIsEmpty(Queue *q)
{
    return q->size == 0;
}

void queueFree(Queue *q)
{
    while (!queueIsEmpty(q))
        queueDequeue(q);
    free(q);
}

size_t queueSize(Queue *q)
{
    return q->size;
}

void queueTest()
{
    Queue *q = queueCreate();
    assert(queueIsEmpty(q));
    assert(queueSize(q) == 0);

    int enqueueRes, dequeueRes;

    for (int i = 1; i <= 5; i++)
    {
        int *j = (int *)malloc(sizeof(int));
        *j = i;
        enqueueRes = queueEnqueue(q, j);
        assert(enqueueRes == true);
    }

    int *front = (int *)queueFront(q);
    assert(*front == 1);

    int *rear = (int *)queueRear(q);
    assert(*rear == 5);

    assert(!queueIsEmpty(q));
    assert(queueSize(q) == 5);

    dequeueRes = queueDequeue(q);
    assert(dequeueRes == true);

    front = (int *)queueFront(q);
    assert(*front == 2);

    assert(!queueIsEmpty(q));
    assert(queueSize(q) == 4);

    queueFree(q);

    Queue *sq = queueCreate();

    char *str = "ok";
    char *t = (char *)malloc(sizeof(char *));
    sprintf(t, "%s", str);

    enqueueRes = queueEnqueue(sq, t);
    assert(enqueueRes == true);

    char *s = (char *)queueFront(sq);
    assert(strcmp(s, str) == 0);

    queueFree(sq);
}
