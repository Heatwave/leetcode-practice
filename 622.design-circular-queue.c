#include <stdio.h>
#include <stdlib.h>

#define bool int
#define true 1
#define false 0

typedef struct
{
    int *data;
    int head;
    int tail;
    int size;
    int capacity;
} MyCircularQueue;

MyCircularQueue *myCircularQueueCreate(int k);
bool myCircularQueueEnQueue(MyCircularQueue *obj, int value);
bool myCircularQueueDeQueue(MyCircularQueue *obj);
int myCircularQueueFront(MyCircularQueue *obj);
int myCircularQueueRear(MyCircularQueue *obj);
bool myCircularQueueIsEmpty(MyCircularQueue *obj);
bool myCircularQueueIsFull(MyCircularQueue *obj);
void myCircularQueueFree(MyCircularQueue *obj);

/** Initialize your data structure here. Set the size of the queue to be k. */

MyCircularQueue *myCircularQueueCreate(int k)
{
    MyCircularQueue *obj = (MyCircularQueue *)malloc(sizeof(MyCircularQueue));
    obj->data = (int *)malloc(sizeof(int) * k);
    obj->capacity = k;
    obj->size = 0;
    obj->head = obj->tail = 0;
    return obj;
}

/** Insert an element into the circular queue. Return true if the operation is successful. */
bool myCircularQueueEnQueue(MyCircularQueue *obj, int value)
{
    if (myCircularQueueIsFull(obj))
        return false;

    if (obj->size == 0)
        obj->data[obj->tail] = value;
    else
    {
        obj->tail += 1;
        if (obj->tail >= obj->capacity)
            obj->tail = 0;
        obj->data[obj->tail] = value;
    }

    obj->size += 1;

    return true;
}

/** Delete an element from the circular queue. Return true if the operation is successful. */
bool myCircularQueueDeQueue(MyCircularQueue *obj)
{
    if (myCircularQueueIsEmpty(obj))
        return false;

    if (obj->size == 1)
        myCircularQueueFree(obj);
    else
    {
        obj->head += 1;
        if (obj->head > obj->capacity)
            obj->head = 0;
        obj->size -= 1;
    }

    return true;
}

/** Get the front item from the queue. */
int myCircularQueueFront(MyCircularQueue *obj)
{
    if (myCircularQueueIsEmpty(obj))
        return -1;
    return obj->data[obj->head];
}

/** Get the last item from the queue. */
int myCircularQueueRear(MyCircularQueue *obj)
{
    if (myCircularQueueIsEmpty(obj))
        return -1;
    return obj->data[obj->tail];
}

/** Checks whether the circular queue is empty or not. */
bool myCircularQueueIsEmpty(MyCircularQueue *obj)
{
    return obj->size == 0;
}

/** Checks whether the circular queue is full or not. */
bool myCircularQueueIsFull(MyCircularQueue *obj)
{
    return obj->size == obj->capacity;
}

void myCircularQueueFree(MyCircularQueue *obj)
{
    obj->size = 0;
    obj->head = obj->tail = 0;
}

/**
 * Your MyCircularQueue struct will be instantiated and called as such:
 * MyCircularQueue* obj = myCircularQueueCreate(k);
 * bool param_1 = myCircularQueueEnQueue(obj, value);
 
 * bool param_2 = myCircularQueueDeQueue(obj);
 
 * int param_3 = myCircularQueueFront(obj);
 
 * int param_4 = myCircularQueueRear(obj);
 
 * bool param_5 = myCircularQueueIsEmpty(obj);
 
 * bool param_6 = myCircularQueueIsFull(obj);
 
 * myCircularQueueFree(obj);
*/
int main(int argc, char const *argv[])
{
    int k = 5;
    MyCircularQueue *obj = myCircularQueueCreate(k);
    int isEmpty = myCircularQueueIsEmpty(obj);
    int isFull = myCircularQueueIsFull(obj);
    printf("isEmpty: %d isFull: %d\n", isEmpty, isFull);

    int enqueueRes, dequeueRes;

    for (int i = 1; i <= k; i++)
    {
        enqueueRes = myCircularQueueEnQueue(obj, i);
        printf("enqueueRes: %d\n", enqueueRes);
        if (enqueueRes != 1)
            exit(-1);
    }

    int front = myCircularQueueFront(obj);
    printf("front: %d\n", front);

    int rear = myCircularQueueRear(obj);
    printf("rear: %d\n", rear);

    isEmpty = myCircularQueueIsEmpty(obj);
    isFull = myCircularQueueIsFull(obj);
    printf("isEmpty: %d isFull: %d\n", isEmpty, isFull);

    for (int i = 1; i <= k; i++)
    {
        dequeueRes = myCircularQueueDeQueue(obj);
        printf("dequeueRes: %d size: %d\n", dequeueRes, obj->size);
        if (dequeueRes != 1)
            exit(-1);
    }
    isEmpty = myCircularQueueIsEmpty(obj);
    isFull = myCircularQueueIsFull(obj);
    printf("isEmpty: %d isFull: %d\n", isEmpty, isFull);

    front = myCircularQueueFront(obj);
    printf("front: %d\n", front);

    rear = myCircularQueueRear(obj);
    printf("rear: %d\n", rear);

    myCircularQueueFree(obj);

    enqueueRes = myCircularQueueEnQueue(obj, 81);
    dequeueRes = myCircularQueueDeQueue(obj);
    enqueueRes = myCircularQueueEnQueue(obj, 69);
    enqueueRes = myCircularQueueEnQueue(obj, 92);
    dequeueRes = myCircularQueueDeQueue(obj);
    enqueueRes = myCircularQueueEnQueue(obj, 12);

    front = myCircularQueueFront(obj);
    printf("front: %d\n", front);

    rear = myCircularQueueRear(obj);
    printf("rear: %d\n", rear);

    for (int i = 0; i < k; i++)
    {
        printf("%d ", obj->data[i]);
    }
    printf("\n");

    return 0;
}
