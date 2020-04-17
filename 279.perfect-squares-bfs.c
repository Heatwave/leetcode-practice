/**
279. Perfect Squares
Given a positive integer n, find the least number of perfect square numbers (for example, 1, 4, 9, 16, ...) which sum to n.

Example 1:

Input: n = 12
Output: 3 
Explanation: 12 = 4 + 4 + 4.
Example 2:

Input: n = 13
Output: 2
Explanation: 13 = 4 + 9.
 */

// gcc 279.perfect-squares-bfs.c queue.c hashtable.c

#include <stdio.h>
#include <stdlib.h>

#include "queue.h"
#include "hashtable.h"

#define SIZE 1024

int numSquares(int n)
{
    Queue *q = queueCreate();

    int maxPos = 1;

    for (; maxPos < 1024; maxPos++)
    {
        int *num = (int *)malloc(sizeof(int));
        *num = maxPos * maxPos;

        if (*num == n)
            return 1;

        if (*num > n)
        {
            --maxPos;
            break;
        }
        queueEnqueue(q, num);
    }

    int count = 0;
    void **hashTable = hashTableCreate();

    while (!queueIsEmpty(q))
    {
        ++count;
        size_t levelCount = queueSize(q);
        while (levelCount-- > 0)
        {
            int *sum = queueFront(q);
            if (*sum == n)
                return count;

            for (int i = 1; i * i + *sum <= n; i++)
            {
                int *num = (int *)malloc(sizeof(int));
                *num = *sum + i * i;

                if (*num == n)
                {
                    queueFree(q);
                    return count + 1;
                }

                char *key = (char *)malloc(sizeof(char) * 16);
                sprintf(key, "%d", *num);

                if (lookup(hashTable, 0, key, NULL) == NULL)
                {
                    queueEnqueue(q, num);
                    lookup(hashTable, 1, key, num);
                }

                free(key);
            }

            free(sum);
            queueDequeue(q);
        }
    }

    return count;
}

int main()
{
    int res = numSquares(12);
    printf("res: %d\n", res);
    return 0;
}
