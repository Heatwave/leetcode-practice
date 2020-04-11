#include <stdio.h>
#include <stdlib.h>
#include <string.h>

#define bool int
#define true 1
#define false 0

typedef struct Node Node;

struct Node
{
    void *data;
    Node *next;
};

typedef struct Queue
{
    Node *head;
    Node *tail;
    size_t size;
} Queue;

Queue *queueCreate();
bool queueEnqueue(Queue *q, void *item);
bool queueDequeue(Queue *q);
void *queueFront(Queue *q);
void *queueRear(Queue *q);
bool queueIsEmpty(Queue *q);
void queueFree(Queue *q);

Queue *queueCreate()
{
    Queue *q = (Queue *)malloc(sizeof(Queue));
    if (q == NULL)
        return NULL;

    q->head = q->tail = NULL;
    q->size = 0;
    return q;
}

bool queueEnqueue(Queue *q, void *item)
{
    Node *newnode = (Node *)malloc(sizeof(Node));
    if (newnode == NULL)
        return false;
    newnode->data = item;
    newnode->next = NULL;

    if (q->tail == NULL)
        q->tail = newnode;
    else
    {
        q->tail->next = newnode;
        q->tail = q->tail->next;
    }

    if (q->head == NULL)
        q->head = q->tail;

    q->size += 1;
    return true;
}

bool queueDequeue(Queue *q)
{
    if (queueIsEmpty(q))
        return false;
    Node *node = q->head;
    q->head = q->head->next;
    if (q->head == NULL)
        q->tail = NULL;

    free(node->data);
    free(node);
    q->size -= 1;
    return true;
}

void *queueFront(Queue *q)
{
    if (queueIsEmpty(q))
        return NULL;
    return q->head->data;
}

void *queueRear(Queue *q)
{
    if (queueIsEmpty(q))
        return NULL;
    return q->tail->data;
}

bool queueIsEmpty(Queue *q)
{
    return q->size == 0;
}

void queueFree(Queue *q)
{
    while (!queueIsEmpty(q))
        queueDequeue(q);
    free(q);
}

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
