#include <stdio.h>
#include <stdlib.h>

struct node * spawnNode()
{
  struct node * theNode = malloc(sizeof(struct node));
  theNode->next = NULL;
  theNode->prev = NULL;
  return theNode;
}

struct list * spawnList()
{
  struct list * theList = malloc(sizeof(struct node));
  theList->head = NULL;
  theList->tail = NULL;
  theList->size = 0;
  return theList;
}

struct table * spawnTable(int size)
{
  struct table * theTable = malloc(sizeof(struct table));
  theTable->hashTable = malloc(sizeof(struct list)*size);
  //
}

int main(int argc, char * argv[])
{
}
