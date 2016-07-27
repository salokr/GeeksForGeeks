#include<stdio.h>
#include<stdlib.h>
struct Node
{
int data;
struct Node* next;
};
void add(int x,struct Node **head)
{
	struct Node *newnode=(struct Node*)malloc(sizeof(struct Node*)),*start;
	newnode->data=x;
	newnode->next=NULL;
	if(*head==NULL)
	{
		*head=newnode;
		return;
	}
	start=*head;
	while(start->next!=NULL)
		start=start->next;
	start->next=newnode;
}
void printList(struct Node* current)
{
	if(current==NULL)
		return;
	printf("%d ",current->data);
	printList(current->next);
}
int addWithCarry(struct Node* current)
{
	if(current==NULL)
		return 1;
	int sum=current->data+addWithCarry(current->next);
	current->data=sum%10;
	return sum/10;
}
struct Node* add1(struct Node* head)
{
	int result=addWithCarry(head);
	if(result)
	{
		struct Node *newnode=(struct Node*)malloc(sizeof(struct Node*));
		newnode->data=result;
		newnode->next=head;
		head=newnode;
	}
	return head;
}
int main()
{
	int a[]={9,9,9},i;
	struct Node *start=NULL;
	for(i=0;i<3;i++)
	{
		add(a[i],&start);
	}
	printList(add1(start));
	return 0;
}