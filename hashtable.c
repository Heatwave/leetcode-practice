#include <assert.h>

#include "hashtable.h"

enum
{
    MULTIPLIER = 31
};

// hash: compute hash value of string
static unsigned int hash(char *str)
{
    unsigned int h;
    unsigned char *p;
    h = 0;
    for (p = (unsigned char *)str; *p != '\0'; p++)
        h = MULTIPLIER * h + *p;
    return h % NHASH;
}

void **hashTableCreate()
{
    void **table = (void **)malloc(sizeof(void *) * NHASH);
    memset(table, 0, sizeof(void *) * NHASH);
    return table;
}

void *lookup(void **table, int replace, char *key, void *data)
{
    int hashValue = hash(key);

    void *t = table[hashValue];
    if (replace)
    {
        table[hashValue] = data;
        t = table[hashValue];
    }
    return t;
}

static void test()
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
}
