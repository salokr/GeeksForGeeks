/* 
 * File:   IntersectionPoint.c
 * Author: ashutosh
 *
 * Created on July 9, 2016, 3:51 PM
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
void push_Nodes(int key,struct Node **head)
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
void print_(struct Node *head)
{
    while(head!=NULL)
    {
        printf("%d\n",head->data);
        head=head->next;
    }
}
int _getCount(struct Node* head)
{
    int count=0;
    while(head!=NULL)
    {
        count++;
        head=head->next;
    }
    return count;
}
int getIntersectionPoint(int diff,struct Node* smaller,struct Node* greater)
{
    while(diff>0)
    {
        diff--;
        /*if(greater==NULL)
            return -1;*/
        greater=greater->next;
    }
    while(smaller!=NULL&&greater!=NULL)
    {
        if(smaller==greater)
            return smaller->data;
        smaller=smaller->next;
        greater=greater->next;
    }
    return -1;
}
int intersectPoint(struct Node* head1, struct Node* head2)
{
    int l1=_getCount(head1);
    int l2=_getCount(head2);
    int result;
    if(l2>l1)
        result=getIntersectionPoint(l2-l1,head1,head2);
    else 
        result=getIntersectionPoint(l1-l2,head2,head1);
    return result;
}
int main(int argc, char** argv)
{
  struct Node* newNode;
  struct Node* head1 =
            (struct Node*) malloc(sizeof(struct Node));
  head1->data  = 10;
 
  struct Node* head2 =
            (struct Node*) malloc(sizeof(struct Node));
  head2->data  = 3;
 
  newNode = (struct Node*) malloc (sizeof(struct Node));
  newNode->data = 6;
  head2->next = newNode;
 
  newNode = (struct Node*) malloc (sizeof(struct Node));
  newNode->data = 9;
  head2->next->next = newNode;
 
  newNode = (struct Node*) malloc (sizeof(struct Node));
  newNode->data = 15;
  head1->next = newNode;
  head2->next->next->next  = newNode;
 
  newNode = (struct Node*) malloc (sizeof(struct Node));
  newNode->data = 30;
  head1->next->next= newNode;
 
  head1->next->next->next = NULL;
  printf("Result=%d\n",intersectPoint(head1,head2));
    return (EXIT_SUCCESS);
}

