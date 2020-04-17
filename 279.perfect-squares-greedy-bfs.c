/**
279. Perfect Squares
Given a positive integer n, find the least number of perfect square numbers (for example, 1, 4, 9, 16, ...) which head to n.

Example 1:

Input: n = 12
Output: 3 
Explanation: 12 = 4 + 4 + 4.
Example 2:

Input: n = 13
Output: 2
Explanation: 13 = 4 + 9.
 */

// gcc 279.perfect-squares-greedy-bfs.c queue.c

#include <stdio.h>
#include <stdlib.h>
#include <string.h>

#include "queue.h"

#define SET_ARRAY_SIZE 65535
#define SIZE 1024

int numSquares(int n)
{
    int squareNums[SIZE];
    int squareNumsLength = 0;

    int setArray[SET_ARRAY_SIZE];
    memset(setArray, 0, sizeof(setArray[0]) * SET_ARRAY_SIZE);

    int num = 1;
    for (int i = 1; num <= n; ++i, ++squareNumsLength)
    {
        num = i * i;
        if (num == n)
            return 1;
        squareNums[squareNumsLength] = num;
    }

    --squareNumsLength;

    Queue *q = queueCreate();
    int *tmp = (int *)malloc(sizeof(int));
    *tmp = n;
    queueEnqueue(q, tmp);

    int count = 0;

    while (!queueIsEmpty(q))
    {
        ++count;
        size_t levelCount = queueSize(q);
        while (levelCount-- > 0)
        {
            int *head = queueFront(q);
            for (int i = 0; i < squareNumsLength; ++i)
            {
                int square = squareNums[i];
                if (*head == square)
                    return count;

                if (*head < square)
                    break;

                tmp = (int *)malloc(sizeof(int));
                *tmp = *head - square;
                if (setArray[*tmp] == 0)
                {
                    queueEnqueue(q, tmp);
                    setArray[*tmp] = 1;
                }
            }
            free(head);
            queueDequeue(q);
        }
    }

    return count;
}

int main()
{
    int res = numSquares(6255);
    printf("res: %d\n", res);
    return 0;
}
