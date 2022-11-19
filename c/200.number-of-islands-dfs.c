#include <stdio.h>
#include <stdlib.h>
#include <string.h>

void dfs(char **grid, int i, int j, int gridSize, int ColSize)
{
    if (i < 0 || j < 0 || i >= gridSize || j >= ColSize)
        return;
    if (grid[i][j] == '0')
        return;
    grid[i][j] = '0';
    dfs(grid, i + 1, j, gridSize, ColSize);
    dfs(grid, i - 1, j, gridSize, ColSize);
    dfs(grid, i, j + 1, gridSize, ColSize);
    dfs(grid, i, j - 1, gridSize, ColSize);
}

int numIslands(char **grid, int gridSize, int *gridColSize)
{
    int result = 0;

    for (size_t i = 0; i < gridSize; i++)
    {
        for (size_t j = 0; j < gridColSize[i]; j++)
        {
            if (grid[i][j] != '0')
            {
                result++;
                dfs(grid, i, j, gridSize, gridColSize[i]);
            }
        }
    }

    return result;
}

int main(int argc, char const *argv[])
{
    int gridSize = 3, colSize = 12;
    char grid[][12] = {'1', '0', '0', '1', '1', '1', '0', '1', '1', '0', '0', '0',
                       '1', '0', '0', '1', '0', '0', '0', '0', '0', '0', '0', '1',
                       '0', '1', '0', '0', '0', '1', '0', '1', '0', '1', '1', '0'};

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
