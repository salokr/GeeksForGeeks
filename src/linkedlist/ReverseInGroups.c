/* 
 * File:   ReverseInGroups.c
 * Author: ashutosh
 *
 * Created on July 10, 2016, 1:40 AM
 */

#include <stdio.h>
#include <stdlib.h>

/*
 * 
 */
struct Node
{
   int data;
   struct Node* next;
};
void push__Nodes(int key,struct Node **head)
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
void print__(struct Node *head)
{
    while(head!=NULL)
    {
        printf("%d ",head->data);
        head=head->next;
    }
    printf("\n");
}
struct Node *reverse (struct Node *head, int k)
{ 
    struct Node *end=head,*start=head,*prev=NULL,*next=NULL;
    int num=k;
    while(start!=NULL&&k>0)
    {
        k--;
        next=start->next;
        start->next=prev;
        prev=start;
        start=next;
    }
    if(next!=NULL)
        end->next=reverse(next,num);
    return prev;
}
int main(int argc, char** argv) 
{
    struct Node *head=NULL;
    int i;
    for(i=0;i<5;i++)
        push__Nodes(i+1,&head);
    print__(head);
    struct Node *result=reverse(head,3);
    print__(result);
    return (EXIT_SUCCESS);
}

