#include <stdlib.h>
#include <stdio.h>
#include <string.h>
#include <assert.h>

#include "queue.h"

struct Node
{
    void *data;
    Node *next;
};

struct Queue
{
    Node *head;
    Node *tail;
    size_t size;
};

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
