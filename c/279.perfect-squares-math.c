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

// gcc 279.perfect-squares-math.c

#include <stdio.h>
#include <stdlib.h>
#include <math.h>

#define SIZE 1024

int isSquare(int n)
{
    int tmp = (int)sqrt((double)n);
    return n == tmp * tmp;
}

int numSquares(int n)
{
    // four-square and three-square theorems.
    while (n % 4 == 0)
        n /= 4;
    if (n % 8 == 7)
        return 4;

    if (isSquare(n))
        return 1;

    // enumeration to check if the number can be decomposed into sum of two squares.
    for (int i = 1; i * i <= n; ++i)
    {
        if (isSquare(n - i * i))
            return 2;
    }

    // bottom case of three-square theorem.
    return 3;
}

int main()
{
    int res = numSquares(29);
    printf("res: %d\n", res);
    return 0;
}
