/**
200. Number of Islands
Given a 2d grid map of '1's (land) and '0's (water), count the number of islands. An island is surrounded by water and is formed by connecting adjacent lands horizontally or vertically. You may assume all four edges of the grid are all surrounded by water.

Example 1:

Input:
11110
11010
11000
00000

Output: 1
Example 2:

Input:
11000
11000
00100
00011

Output: 3
 */

// gcc 200.number-of-islands-bfs.c queue.c

#include <stdio.h>
#include <stdlib.h>
#include <string.h>

#include "queue.h"

typedef struct Point
{
    int i;
    int j;
} Point;

void bfs(char **grid, int i, int j, int gridSize, int ColSize)
{
    Queue *q = queueCreate();
    Point *p = (Point *)malloc(sizeof(Point));
    p->i = i;
    p->j = j;
    queueEnqueue(q, (void *)p);

    while (!queueIsEmpty(q))
    {
        p = queueFront(q);
        i = p->i;
        j = p->j;

        if (grid[i][j] == '0')
        {
            free(p);
            queueDequeue(q);
            continue;
        }

        grid[i][j] = '0';

        Point *temp;

        if (i + 1 >= 0 && i + 1 < gridSize && grid[i + 1][j] == '1')
        {
            temp = (Point *)malloc(sizeof(Point));
            temp->i = i + 1;
            temp->j = j;
            queueEnqueue(q, temp);
        }

        if (i - 1 >= 0 && i - 1 < gridSize && grid[i - 1][j] == '1')
        {
            temp = (Point *)malloc(sizeof(Point));
            temp->i = i - 1;
            temp->j = j;
            queueEnqueue(q, temp);
        }

        if (j + 1 >= 0 && j + 1 < ColSize && grid[i][j + 1] == '1')
        {
            temp = (Point *)malloc(sizeof(Point));
            temp->i = i;
            temp->j = j + 1;
            queueEnqueue(q, temp);
        }

        if (j - 1 >= 0 && j - 1 < ColSize && grid[i][j - 1] == '1')
        {
            temp = (Point *)malloc(sizeof(Point));
            temp->i = i;
            temp->j = j - 1;
            queueEnqueue(q, temp);
        }

        free(p);
        queueDequeue(q);
    }
}

int numIslands(char **grid, int gridSize, int *gridColSize)
{
    int result = 0;

    for (size_t i = 0; i < gridSize; i++)
    {
        for (size_t j = 0; j < gridColSize[i]; j++)
        {
            if (grid[i][j] == '1')
            {
                result++;
                bfs(grid, i, j, gridSize, gridColSize[i]);
            }
        }
    }

    return result;
}

int main(int argc, char const *argv[])
{
    const int gridSize = 3;
    const int colSize = 3;
    // char grid[][colSize] = {'1', '0', '0', '1', '1', '1', '0', '1', '1', '0', '0', '0',
    //                         '1', '0', '0', '1', '0', '0', '0', '0', '0', '0', '0', '1',
    //                         '0', '1', '0', '0', '0', '1', '0', '1', '0', '1', '1', '0'};
    char grid[][colSize] = {'0', '1', '0',
                            '1', '0', '1',
                            '0', '1', '0'};

    char *p[colSize];
    for (int i = 0; i < gridSize; i++)
        p[i] = grid[i];

    int *gridColSize = (int *)malloc(sizeof(int) * gridSize);
    for (int i = 0; i < gridSize; i++)
        gridColSize[i] = colSize;

    for (int i = 0; i < gridSize; i++)
    {
        for (int j = 0; j < colSize; j++)
        {
            printf("%c", grid[i][j]);
        }
        printf("\n");
    }
    int result = numIslands(p, gridSize, gridColSize);
    printf("result: %d\n", result);
    return 0;
}
