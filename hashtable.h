#ifndef HASHTABLE_H
#define HASHTABLE_H

#include <stdlib.h>
#include <stdio.h>

#define NHASH 102400

void **hashTableCreate();
void *lookup(void **table, int replace, char *key, void *data);

#endif