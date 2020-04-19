// gcc contest/2020-spring/chuan-di-xin-xi.c queue.c

#include <stdio.h>
#include <stdlib.h>

#include "../../queue.h"

int numWays(int n, int **relation, int relationSize, int *relationColSize, int k)
{
    int nextMapping[n][99];
    int nextMappingColSize[n];
    for (int i = 0; i < n; ++i)
    {
        nextMappingColSize[i] = 0;
    }

    for (int i = 0; i < relationSize; ++i)
    {
        int firstNum = relation[i][0];
        int secondNum = relation[i][1];
        nextMapping[firstNum][nextMappingColSize[firstNum]] = secondNum;
        nextMappingColSize[firstNum] += 1;
    }

    Queue *q = queueCreate();
    int *tmp = (int *)malloc(sizeof(int));
    *tmp = 0;
    queueEnqueue(q, tmp);

    int level = 0;
    while (level++ <= k)
    {
        int *front;

        if (level == k + 1)
        {
            int res = 0;

            while (!queueIsEmpty(q))
            {
                front = queueFront(q);
                if (*front == n - 1)
                {
                    res += 1;
                }
                queueDequeue(q);
            }
            return res;
        }

        size_t qSize = queueSize(q);
        while (qSize-- > 0)
        {
            front = queueFront(q);
            for (int i = 0; i < nextMappingColSize[*front]; ++i)
            {
                tmp = (int *)malloc(sizeof(int));
                *tmp = nextMapping[*front][i];
                queueEnqueue(q, tmp);
            }
            queueDequeue(q);
        }
    }

    return 0;
}

int main()
{
    const int n = 5;
    const int k = 3;

    const int relationSize = 7;
    const int colSize = 2;
    int relation[][colSize] = {
        {0, 2},
        {2, 1},
        {3, 4},
        {2, 3},
        {1, 4},
        {2, 0},
        {0, 4}};

    // const int n = 3;
    // const int k = 2;

    // const int relationSize = 2;
    // const int colSize = 2;
    // int relation[][colSize] = {
    //     {0, 2},
    //     {2, 1},
    // };

    int *relationColSize = (int *)malloc(sizeof(int) * relationSize);
    for (int i = 0; i < relationSize; i++)
        relationColSize[i] = colSize;

    int **p = (int **)malloc(sizeof(int *) * relationSize);
    for (int i = 0; i < relationSize; ++i)
    {
        *(p + i) = relation[i];
    }

    int res = numWays(n, p, relationSize, relationColSize, k);
    printf("res: %d\n", res);
    return 0;
}
