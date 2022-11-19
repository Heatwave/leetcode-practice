/**
752. Open the Lock
You have a lock in front of you with 4 circular wheels. Each wheel has 10 slots: '0', '1', '2', '3', '4', '5', '6', '7', '8', '9'. The wheels can rotate freely and wrap around: for example we can turn '9' to be '0', or '0' to be '9'. Each move consists of turning one wheel one slot.

The lock initially starts at '0000', a string representing the state of the 4 wheels.

You are given a list of deadends dead ends, meaning if the lock displays any of these codes, the wheels of the lock will stop turning and you will be unable to open it.

Given a target representing the value of the wheels that will unlock the lock, return the minimum total number of turns required to open the lock, or -1 if it is impossible.

Example 1:
Input: deadends = ["0201","0101","0102","1212","2002"], target = "0202"
Output: 6
Explanation:
A sequence of valid moves would be "0000" -> "1000" -> "1100" -> "1200" -> "1201" -> "1202" -> "0202".
Note that a sequence like "0000" -> "0001" -> "0002" -> "0102" -> "0202" would be invalid,
because the wheels of the lock become stuck after the display becomes the dead end "0102".
Example 2:
Input: deadends = ["8888"], target = "0009"
Output: 1
Explanation:
We can turn the last wheel in reverse to move from "0000" -> "0009".
Example 3:
Input: deadends = ["8887","8889","8878","8898","8788","8988","7888","9888"], target = "8888"
Output: -1
Explanation:
We can't reach the target without getting stuck.
Example 4:
Input: deadends = ["0000"], target = "8888"
Output: -1
Note:
The length of deadends will be in the range [1, 500].
target will not be in the list deadends.
Every string in deadends and the string target will be a string of 4 digits from the 10,000 possibilities '0000' to '9999'.
*/

// gcc 752.open-the-lock.c hashtable.c queue.c

#include <stdio.h>
#include <stdlib.h>
#include <string.h>

#include "hashtable.h"
#include "queue.h"

int deadendsCompare(const void *a, const void *b)
{
    return strcmp(*((char **)a), *((char **)b));
}

int findInCharArray(char **array, int arraySize, char *string)
{
    int *res = bsearch(&string, array, arraySize, sizeof(array[0]), deadendsCompare);
    return res != NULL;
}

char *rollingLock(char *str, int pos, int roll)
{
    char *tmp = (char *)malloc(sizeof(char) * 5);
    strcpy(tmp, "");
    if (pos > 0)
        strncat(tmp, str, pos);
    char c;
    c = str[pos] + roll;
    if (c > '9')
        c = '0';
    if (c < '0')
        c = '9';
    char s[2];
    sprintf(s, "%c", c);
    strncat(tmp, s, 1);
    if (pos < 3)
        strncat(tmp, str + pos + 1, 3 - pos);

    return tmp;
}

int openLock(char **deadends, int deadendsSize, char *target)
{
    qsort(deadends, deadendsSize, sizeof(deadends[0]), deadendsCompare);

    if (findInCharArray(deadends, deadendsSize, "0000"))
        return -1;

    int steps = 0;

    char *start = (char *)malloc(sizeof(char *) * 5);
    strcpy(start, target);

    Queue *q = queueCreate();
    queueEnqueue(q, start);

    void **hashTable = hashTableCreate();

    while (!queueIsEmpty(q))
    {
        size_t size = queueSize(q);

        while (size-- > 0)
        {
            char *str = (char *)queueFront(q);

            if (strcmp(str, "0000") == 0)
                return steps;

            char *tmp;
            for (int i = 0; i < 4; i++)
            {
                for (int j = -1; j <= 1; j += 2)
                {
                    tmp = rollingLock(str, i, j);
                    if (lookup(hashTable, 0, tmp, NULL) == NULL && !findInCharArray(deadends, deadendsSize, tmp))
                    {
                        queueEnqueue(q, tmp);
                        lookup(hashTable, 1, tmp, tmp);
                    }
                    else
                        free(tmp);
                }
            }

            free(str);
            queueDequeue(q);
        }
        steps++;
    }

    return -1;
}

int main(int argc, char const *argv[])
{
    const int deadendsSize = 8;
    char *deadends[deadendsSize] = {"8887", "8889", "8878", "8898", "8788", "8988", "7888", "9888"};
    char *target = "5555";

    int res = openLock(deadends, deadendsSize, target);
    printf("steps: %d\n", res);

    return 0;
}
