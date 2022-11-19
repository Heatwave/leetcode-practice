/**
130. Surrounded Regions
Given a 2D board containing 'X' and 'O' (the letter O), capture all regions surrounded by 'X'.

A region is captured by flipping all 'O's into 'X's in that surrounded region.

Example:

X X X X
X O O X
X X O X
X O X X
After running your function, the board should be:

X X X X
X X X X
X X X X
X O X X
Explanation:

Surrounded regions shouldn’t be on the border, which means that any 'O' on the border of the board are not flipped to 'X'. Any 'O' that is not on the border and it is not connected to an 'O' on the border will be flipped to 'X'. Two cells are connected if they are adjacent cells connected horizontally or vertically.
 */

#include <stdio.h>
#include <stdlib.h>
#include <string.h>

#define SIZE 65535

int find(int i, int *parent)
{
    return parent[i] == i ? i : (parent[i] = find(parent[i], parent));
}

void merge(int i, int j, int *parent, int *rank)
{
    int iParent = find(i, parent);
    int jParent = find(j, parent);
    if (rank[iParent] < rank[jParent])
        parent[iParent] = jParent;
    else if (rank[iParent] > rank[jParent])
        parent[jParent] = iParent;
    else
    {
        parent[iParent] = jParent;
        rank[jParent]++;
    }
}

void solve(char **board, int boardSize, int *boardColSize)
{
    if (boardSize == 0)
        return;

    int colSize = boardColSize[0];

    int parent[SIZE];
    int rank[SIZE];

    int ancestor = boardSize * colSize;
    parent[ancestor] = ancestor;
    rank[ancestor] = ancestor;
    int i = 0, j = 0;

    for (i = 0; i < boardSize; i++)
    {
        for (j = 0; j < colSize; j++)
        {
            int pos = i * colSize + j;

            if (board[i][j] == 'O')
            {
                if (i == 0 || i == boardSize - 1 || j == 0 || j == colSize - 1)
                    parent[pos] = ancestor;
                else
                    parent[pos] = pos;
            }
            else
                parent[pos] = -1;
            rank[pos] = 0;
        }
    }

    for (i = 0; i < boardSize; i++)
    {
        for (j = 0; j < colSize; j++)
        {
            if (board[i][j] == 'O')
            {
                if (i - 1 > 0 && board[i - 1][j] == 'O')
                    merge((i - 1) * colSize + j, i * colSize + j, parent, rank);
                if (i + 1 < boardSize && board[i + 1][j] == 'O')
                    merge((i + 1) * colSize + j, i * colSize + j, parent, rank);
                if (j - 1 > 0 && board[i][j - 1] == 'O')
                    merge(i * colSize + j - 1, i * colSize + j, parent, rank);
                if (j + 1 < colSize && board[i][j + 1] == 'O')
                    merge(i * colSize + j + 1, i * colSize + j, parent, rank);
            }
        }
    }

    for (i = 0; i < boardSize; i++)
    {
        for (j = 0; j < colSize; j++)
        {
            if (board[i][j] == 'O')
            {
                if (find(i * colSize + j, parent) != find(ancestor, parent))
                {
                    board[i][j] = 'X';
                }
            }
        }
    }
}

void printBoard(char **board, int size, int colSize)
{
    for (int i = 0; i < size; i++)
    {
        for (int j = 0; j < colSize; j++)
        {
            printf("%c", board[i][j]);
        }
        printf("\n");
    }
}

int main(int argc, char const *argv[])
{
    const int boardSize = 4;
    const int colSize = 6;
    char board[][colSize] = {'X', 'O', 'X', 'O', 'X', 'O',
                             'O', 'X', 'O', 'X', 'O', 'X',
                             'X', 'O', 'X', 'O', 'X', 'O',
                             'O', 'X', 'O', 'X', 'O', 'X'};

    char *p[colSize];
    for (int i = 0; i < boardSize; i++)
        p[i] = board[i];

    int *boardColSize = (int *)malloc(sizeof(int) * boardSize);
    for (int i = 0; i < boardSize; i++)
        boardColSize[i] = colSize;

    printBoard(p, boardSize, colSize);

    solve(p, boardSize, boardColSize);

    printf("solved: \n");

    printBoard(p, boardSize, colSize);
    return 0;
}
