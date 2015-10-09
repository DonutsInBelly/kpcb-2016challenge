#include <stdio.h>
#include <stdlib.h>

#ifndef TABLE_H
#define TABLE_H

typedef struct node
{
  //
  void * data;
  struct node * next;
  struct node * prev;
} node;

typedef struct list
{
  //
  struct node * head;
  struct node * tail;
  int size;
}

typedef struct table
{
  struct list * hashTable;
} table;

struct node * spawnNode();
struct list * spawnList();
struct table * spawnTable(int size);
boolean magic(int key);

#endif
