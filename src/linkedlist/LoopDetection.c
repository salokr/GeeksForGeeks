/* 
 * File:   LoopDetection.c
 * Author: ashutosh
 *
 * Created on July 9, 2016, 2:10 AM
 */

#include <stdio.h>
#include <stdlib.h>

/*
 * 
 */
struct node
{
   int data;
   struct node* next;
};
void pushnodes(int key,struct node **head)
{
    struct node *temp=(struct node*)malloc(sizeof(struct node)),*start=*head;
    temp->data=key;
    temp->next=NULL;
    if(*head==NULL)
    {
        *head=temp;
        return;
    }
    while(start->next!=NULL)
    {
        start=start->next;
    }
    start->next=temp;
}
void print(struct node *head)
{
    while(head!=NULL)
    {
        printf("%d\n",head->data);
        head=head->next;
    }
}
int detectloop(struct node *list)
{
    struct node *slow=list,*fast=list;
    while(fast!=NULL&&fast->next!=NULL)
    {
        slow=slow->next;
        fast=fast->next->next;
        if(slow==fast)
            return 1;
    }
    return 0;
}
int main(int argc, char** argv) {

    struct node *head=NULL;
    int i;
    for(i=0;i<4;i++)
        pushnodes(i+1,&head);
    head->next->next->next->next = head;
    printf("%d\n",detectloop(head));
    return (EXIT_SUCCESS);
}

