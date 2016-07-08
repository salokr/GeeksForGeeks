/* 
 * File:   DeleteLinkedList.c
 * Author: ashutosh
 *
 * Created on July 9, 2016, 1:12 AM
 */

#include <stdio.h>
#include <stdlib.h>

struct Node
{
   int data;
   struct Node* next;
};
void addnode(int key,struct Node **head)
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
void printnodes(struct Node *head)
{
    while(head!=NULL)
    {
        printf("%d\n",head->data);
        head=head->next;
    }
}
int main1(int argc, char** argv)
{
    struct Node *head=NULL,*temp;
    int i;
    for(i=0;i<10;i++)
        addnode(random()%100,&head);
    printnodes(head);
    while(head!=NULL)
    {
        temp=head;
        free(temp);
        head=head->next;
    }
    printnodes(head);
    return (EXIT_SUCCESS);
}

