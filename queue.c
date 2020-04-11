#ifndef QUEUE_H
#define QUEUE_H

#include <stdlib.h>
#include <stdio.h>

#define bool int
#define true 1
#define false 0

typedef struct Node Node;

struct Node
{
    void *data;
    Node *next;
};

typedef struct Queue
{
    Node *head;
    Node *tail;
    size_t size;
} Queue;

Queue *queueCreate();
bool queueEnqueue(Queue *q, void *item);
bool queueDequeue(Queue *q);
void *queueFront(Queue *q);
void *queueRear(Queue *q);
bool queueIsEmpty(Queue *q);
void queueFree(Queue *q);

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

int main(int argc, char const *argv[])
{
    Queue *q = queueCreate();
    printf("isEmpty: %d size: %zu\n", queueIsEmpty(q), q->size);

    int enqueueRes, dequeueRes;

    for (int i = 1; i <= 5; i++)
    {
        int *j = (int *)malloc(sizeof(int));
        *j = i;
        enqueueRes = queueEnqueue(q, j);
        printf("enqueueRes: %d\n", enqueueRes);
        if (enqueueRes == false)
            exit(-1);
    }

    int *front = (int *)queueFront(q);
    printf("front: %d\n", *front);

    int *rear = (int *)queueRear(q);
    printf("rear: %d\n", *rear);

    printf("isEmpty: %d size: %zu\n", queueIsEmpty(q), q->size);

    dequeueRes = queueDequeue(q);
    printf("dequeueRes: %d\n", dequeueRes);

    front = (int *)queueFront(q);
    printf("front: %d\n", *front);

    printf("isEmpty: %d size: %zu\n", queueIsEmpty(q), q->size);

    queueFree(q);
    printf("q free\n");

    Queue *sq = queueCreate();

    char *t = (char *)malloc(sizeof(char *));
    sprintf(t, "ok");

    enqueueRes = queueEnqueue(sq, t);

    char *s = (char *)queueFront(sq);
    printf("%s\n", s);

    queueFree(q);

    return 0;
}

#endif
