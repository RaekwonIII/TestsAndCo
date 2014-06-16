/*
 * CodilityTest3.c
 *
 *  Created on: 23/mar/2014
 *      Author: Massimo
 */


#include <stdio.h>
#include <stdlib.h>


struct IntList {
        int value;
        struct IntList * next;
    };

int solution(struct IntList * L, int M) {
    // write your code in C90

    int retval = -1;
    IntList * current = L;



    int len = 0, i;
    struct IntList * temp = L;

    // 1) count the number of nodes in Linked List
    while (temp != NULL)
    {
        temp = temp->next;
        len++;
    }

    if (len < M)
        return retval;

    temp = L;

    // 2) get the (m-len+1)th node from the begining
    for (i = 1; i < len-M+1; i++)
       temp = temp->next;
    retval = temp->value;

    return retval;
}

void push(struct IntList * head, int val) {
    struct IntList * current = head;
    while (current->next != NULL) {
        current = current->next;
    }

    /* now we can add a new variable */
    current->next = malloc(sizeof(struct IntList));
    current->next->value = val;
    current->next->next = NULL;
}
int main()
{
    IntList * L = NULL;

    L = malloc(sizeof(struct IntList));
    L->value = 1;

    push(L,2);
    push(L,3);
    push(L,4);




    printf("Hello world!\n");
    return 0;
}
