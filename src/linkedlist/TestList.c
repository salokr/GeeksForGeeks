#include<stdio.h>
#include<stdlib.h>
struct node
{
	int data;
	struct node* next;
};
struct node* getNode(int data)
{
	struct node* newnode=(struct node*)malloc(sizeof(struct node));
	newnode->data=data;
	newnode->next=NULL;
	return newnode;
}
void printList(struct node* current)
{
	if(current==NULL)
		return;
	printf("%d ",current->data);
	printList(current->next);
}
int main()
{
	struct node* head=getNode(10);
	head->next=getNode(20);
	head->next->next=getNode(30);
	printList(head);
	return 0;
}