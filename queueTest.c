#include <string.h>
#include <assert.h>

#include "queue.h"

int main()
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

    free(front);
    dequeueRes = queueDequeue(q);
    assert(dequeueRes == true);

    front = (int *)queueFront(q);
    assert(*front == 2);

    assert(!queueIsEmpty(q));
    size_t size = queueSize(q);
    assert(size == 4);

    for (size_t i = 0; i < size; i++)
    {
        front = queueFront(q);
        free(front);
        queueDequeue(q);
    }

    queueFree(q);

    Queue *sq = queueCreate();

    char *str = "ok";
    char *t = (char *)malloc(sizeof(char *));
    sprintf(t, "%s", str);

    enqueueRes = queueEnqueue(sq, t);
    assert(enqueueRes == true);

    char *s = (char *)queueFront(sq);
    assert(strcmp(s, str) == 0);

    free(s);

    queueFree(sq);

    return 0;
}
