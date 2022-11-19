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
