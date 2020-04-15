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
size_t queueSize(Queue *q);

#endif