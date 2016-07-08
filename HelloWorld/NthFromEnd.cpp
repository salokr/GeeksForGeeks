/* 
 * File:   NthFromEnd.cpp
 * Author: ashutosh
 *
 * Created on July 9, 2016, 12:18 AM
 */

#include <cstdlib>
#include<stdio.h>

using namespace std;

/*
 * 
 */
struct Node
{
   int data;
   struct Node* next;
};
int getNthFromLast(struct Node *head, int n)
{
    static int i=0;
    if(head==NULL)
        return -1;//remember when there are multiple test cases this will not work properly, need to reinitialize it every time either use global variable 
    int result=getNthFromLast(head->next,n);
    i++;
    if(i==n)
        return head->data;
    return result;
    
}
void addNode(int key,struct Node **head)
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
void printNodes(struct Node *head)
{
    while(head!=NULL)
    {
        printf("%d\n",head->data);
        head=head->next;
    }
}
int main_(int argc, char** argv) 
{
    int a[]={404 ,652 ,755 ,400 ,933 ,61 ,677 ,369 ,740 ,13 ,227 ,587 ,95 ,540 ,796, 571 ,435 ,379 ,468, 602, 98 ,903, 318 ,493 ,653, 757 ,302 ,281, 287, 442, 866, 690, 445 ,620, 441 ,730, 32 ,118 ,98 ,772 ,482 ,676, 710 ,928 ,568 ,857 ,498 ,354 ,587 ,966, 307, 684, 220, 625 ,529 ,872 ,733 ,830 ,504 ,20 ,271 ,369 ,709 ,716, 341 ,150, 797 ,724 ,619, 246 ,847 ,452 ,922 ,556 ,380 ,489 ,765 ,229 ,842 ,351 ,194 ,501 ,35 ,765 ,125};
    struct Node* head=NULL;
    int i;
   
      
    for(i=0;i<85;i++)
        addNode(a[i],&head);
    printNodes(head);
    int result=getNthFromLast(head,20);
    printf("\nresult= %d",result);
    return 0;
}

