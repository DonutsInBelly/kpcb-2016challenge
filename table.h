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
}

typedef struct table
{
  //
} table;

#endif
