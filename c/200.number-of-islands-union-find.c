#include <stdio.h>
#include <stdlib.h>
#include <string.h>

#define SIZE 65536

int find(int i, int *parent)
{
    return parent[i] == i ? i : (parent[i] = find(parent[i], parent));
}

void merge(int i, int j, int *parent, int *rank, int *result)
{
    int iParent = find(i, parent);
    int jParent = find(j, parent);
    if (iParent != jParent)
    {
        if (rank[iParent] > rank[jParent])
            parent[jParent] = iParent;
        else if (rank[iParent] < rank[jParent])
            parent[iParent] = jParent;
        else
        {
            parent[jParent] = iParent;
            rank[iParent] += 1;
        }
        (*result) -= 1;
    }
}

int numIslands(char **grid, int gridSize, int *gridColSize)
{
    int result = 0;

    if (gridSize == 0)
        return result;

    int colSize = gridColSize[0];

    int parent[SIZE];
    int rank[SIZE];
    int count = 0;

    // init union-find-set data structure
    for (int i = 0; i < gridSize; i++)
    {
        for (int j = 0; j < colSize; j++)
        {
            if (grid[i][j] == '1')
            {
                parent[count] = i * colSize + j;
                result += 1;
            }
            else
            {
                parent[count] = -1;
            }
            rank[count++] = 0;
        }
    }

    for (int i = 0; i < gridSize; i++)
    {
        for (int j = 0; j < colSize; j++)
        {
            if (grid[i][j] == '1')
            {
                grid[i][j] = '0';
                if (i - 1 > 0 && grid[i - 1][j] == '1')
                    merge(i * colSize + j, (i - 1) * colSize + j, parent, rank, &result);
                if (i + 1 < gridSize && grid[i + 1][j] == '1')
                    merge(i * colSize + j, (i + 1) * colSize + j, parent, rank, &result);
                if (j - 1 > 0 && grid[i][j] == '1')
                    merge(i * colSize + j, i * colSize + j - 1, parent, rank, &result);
                if (j + 1 < colSize && grid[i][j + 1] == '1')
                    merge(i * colSize + j, i * colSize + j + 1, parent, rank, &result);
            }
        }
    }

    return result;
}

int main(int argc, char const *argv[])
{
    const int gridSize = 3;
    const int colSize = 3;
    char grid[][colSize] = {'0', '1', '1',
                            '1', '0', '1',
                            '1', '1', '0'};

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
