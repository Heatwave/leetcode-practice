#include <assert.h>

#include "hashtable.h"

int main()
{
    void **table = hashTableCreate();
    int *i = (int *)malloc(sizeof(int));
    *i = 2;
    char *key = "ok";
    lookup(table, 1, key, (void *)i);
    int *j = lookup(table, 0, key, NULL);
    assert(*j == *i);

    int *k = (int *)malloc(sizeof(int));
    *k = 3;
    lookup(table, 1, "ok", (void *)k);
    j = lookup(table, 0, "ok", NULL);
    assert(*j == *k);

    return 0;
}
