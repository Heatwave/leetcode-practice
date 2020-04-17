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

// gcc 279.perfect-squares-recursion.c

#include <stdio.h>
#include <stdlib.h>
#include <math.h>

#define MIN(a, b) ((a) < (b) ? (a) : (b))

#define SIZE 1024

int intCompar(const void *a, const void *b)
{
    return (*(int *)a - *(int *)b);
}

int findMinNum(int n)
{
    int squareNums[SIZE];
    int tmp = (int)sqrt((double)n);
    int realSize = tmp + 1;
    for (int i = 1; i <= realSize; ++i)
    {
        squareNums[i - 1] = i * i;
    }

    int *isNInNums = bsearch(&n, squareNums, realSize, sizeof(int), intCompar);
    if (isNInNums != NULL)
    {
        return 1;
    }
    int minNum = 65535;

    for (int i = 0; i < realSize; ++i)
    {
        int square = squareNums[i];
        if (n < square)
            break;
        int newNum = findMinNum(n - square) + 1;
        minNum = MIN(newNum, minNum);
    }

    return minNum;
}

int numSquares(int n)
{
    return findMinNum(n);
}

int main()
{
    int res = numSquares(17);
    printf("res: %d\n", res);
    return 0;
}
