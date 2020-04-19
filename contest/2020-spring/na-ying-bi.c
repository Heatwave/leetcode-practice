// gcc contest/2020-spring/na-ying-bi.c

#include <stdlib.h>
#include <stdio.h>

int minCount(int *coins, int coinsSize)
{
    int sum = 0;
    for (int i = 0; i < coinsSize; ++i)
    {
        if (coins[i] % 2 == 0)
        {
            sum += coins[i] / 2;
        }
        else
        {
            sum += coins[i] / 2 + 1;
        }
    }
    return sum;
}

int main()
{
    const int size = 3;
    int coins[size] = {2, 3, 10};
    int res = minCount(coins, size);
    printf("res: %d\n", res);
    return 0;
}
