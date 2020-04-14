#include <stdio.h>
#include <stdlib.h>
#include <string.h>

void dfs(char **board, int i, int j, int boardSize, int ColSize)
{
    board[i][j] = 'M';

    if (i + 1 < boardSize && board[i + 1][j] == 'O')
        dfs(board, i + 1, j, boardSize, ColSize);
    if (i - 1 >= 0 && board[i - 1][j] == 'O')
        dfs(board, i - 1, j, boardSize, ColSize);
    if (j + 1 < ColSize && board[i][j + 1] == 'O')
        dfs(board, i, j + 1, boardSize, ColSize);
    if (j - 1 >= 0 && board[i][j - 1] == 'O')
        dfs(board, i, j - 1, boardSize, ColSize);
}

void solve(char **board, int boardSize, int *boardColSize)
{
    if (boardSize == 0)
        return;

    int colSize = boardColSize[0];

    size_t i = 0, j = 0;
    do
    {
        if (board[i][j] == 'O')
            dfs(board, i, j, boardSize, colSize);

        if (i < boardSize - 1 && j == 0)
            i += 1;
        else if (i == boardSize - 1 && j < colSize - 1)
            j += 1;
        else if (j == colSize - 1 && i >= 1)
            i -= 1;
        else if (i == 0 && j >= 1)
            j -= 1;
    } while (i != 0 || j != 0);

    for (i = 0; i < boardSize; i++)
    {
        for (j = 0; j < boardColSize[i]; j++)
        {
            if (board[i][j] == 'O')
                board[i][j] = 'X';
            if (board[i][j] == 'M')
                board[i][j] = 'O';
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
    const int colSize = 4;
    char board[][colSize] = {'X', 'X', 'X', 'X',
                             'X', 'O', 'O', 'X',
                             'X', 'X', 'O', 'X',
                             'X', 'O', 'X', 'X'};

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
