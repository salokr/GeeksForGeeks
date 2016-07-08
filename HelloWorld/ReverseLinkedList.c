/* 
 * File:   ReverseLinkedList.c
 * Author: ashutosh
 *
 * Created on July 9, 2016, 1:50 AM
 */

#include <stdio.h>
#include <stdlib.h>

/*
 * 
 */
#include <stdio.h>
#include <stdlib.h>

struct Node
{
   int data;
   struct Node* next;
};
void addNodes(int key,struct Node **head)
{
    struct Node *temp=(struct Node*)malloc(sizeof(struct Node)),*start=*head;
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
void printNode(struct Node *head)
{
    while(head!=NULL)
    {
        printf("%d\n",head->data);
        head=head->next;
    }
}
struct Node* reverse(struct Node *head)
{
    struct Node *current=head,*prev=NULL,*nextnode;
    if(head==NULL)
        return NULL;
    while(current!=NULL)
    {
        nextnode=current->next;
        current->next=prev;
        prev=current;
        current=nextnode;
    }
    return prev;
} 
int main(int argc, char** argv)
{
    struct Node *head=NULL;
    int i;
    for(i=0;i<10;i++)
        addNodes(i+1,&head);
    printNode(head);
    printNode(reverse(head));
    return (EXIT_SUCCESS);
}

