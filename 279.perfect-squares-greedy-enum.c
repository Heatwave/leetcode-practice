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

// gcc 279.perfect-squares-greedy-enum.c hashtable.c

#include <stdio.h>
#include <stdlib.h>

#include "hashtable.h"

#define SIZE 1024

int isDividedBy(void **hashTable, int *squareNums, int squareNumsLength, int n, int count)
{
    if (n < 0)
        return 0;

    char key[16];
    sprintf(key, "%d", n);

    if (count == 1)
        return lookup(hashTable, 0, key, NULL) != NULL;

    for (int i = 0; i < squareNumsLength; ++i)
        if (isDividedBy(hashTable, squareNums, squareNumsLength, n - squareNums[i], count - 1))
            return 1;

    return 0;
}

int numSquares(int n)
{
    void **hashTable = hashTableCreate();
    int squareNums[SIZE];
    int squareNumsLength = 0;

    char key[16];

    for (int i = 1; i * i <= n; ++i, ++squareNumsLength)
    {
        int *num = (int *)malloc(sizeof(int));
        *num = i * i;
        sprintf(key, "%d", *num);

        lookup(hashTable, 1, key, num);
        squareNums[squareNumsLength] = *num;
    }

    int count = 1;
    for (; count <= n; ++count)
    {
        if (isDividedBy(hashTable, squareNums, squareNumsLength, n, count))
            return count;
    }

    return count;
}

int main()
{
    int res = numSquares(6255);
    printf("res: %d\n", res);
    return 0;
}
