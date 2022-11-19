#include <stdio.h>
#include <stdlib.h>
#include <math.h>

void deciToBin(int);
int getNumberLength(int, int *);

int main()
{
    int *numbers = (int *)malloc(sizeof(int) * 9);
    int numLength = getNumberLength(9669, numbers);
    printf("%d\n", numLength);

    int result = 0;
    int changed = 0;

    for (int i = numLength - 1; i >= 0; i--)
    {
        printf("%d\n", numbers[i]);
        if (changed == 0 && numbers[i] == 6)
        {
            changed = 1;
            numbers[i] = 9;
        }
        double multi = pow(10, i);
        if (multi == 0)
            multi = 1;
        result += numbers[i] * multi;
    }

    printf("%d\n", result);

    return 0;
}

int getNumberLength(int num, int *numbers)
{
    int temp = num;
    int i = 10;
    int length = 0;

    while (temp > 0)
    {
        numbers[length++] = temp % i;
        temp = temp / i;
    }

    return length;
}

void deciToBin(int num)
{
    if (num == 0)
        return;

    deciToBin(num / 2);

    printf("%d", num % 2);
}