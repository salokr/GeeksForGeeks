#include<stdio.h>
#include<stdlib.h>
struct Node
{
int data;
struct Node* next;
};
void add(int x,struct Node **head)
{
	struct Node *newnode=(struct Node*)malloc(sizeof(struct node)),*start;
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
struct Node* reArrangeWave(struct Node* head)
{
	struct Node *start,*left,*right;
	if(head==NULL||head->next==NULL)
		return head;
	left=head;
	while(left!=NULL&&left->next!=NULL)
	{
		start=left->next;
		struct Node *largest=start;
		right=start->next;
		if(largest->data<left->data)
			largest=left;
		if(right!=NULL&&largest->data<right->data)
			largest=right;
		if(largest!=start)
		{
			int temp=largest->data;
			largest->data=start->data;
			start->data=temp;
		}
		left=right;
	}
	return head;
}
int main()
{
	int t,a[5];
	struct Node *head=NULL;
	a[0]=1;a[1]=2;a[2]=3;a[3]=4;a[4]=10;
	for(t=0;t<4;t++)
		add(a[t],&head);
	printList(head);
	printf("\n");
	printList(reArrangeWave(head));
	return 0;	
}

/*
60
6592 7791 156 4676 8610 2634 1343 4933 7346 2881 9696 5678 3526 6533 911 9260 3256 8361 6724 3177 6778 9655 5297 465 2026 5268 789 9939 134 4805 3443 2410 449 2530 7170 3485 503 3465 3206 4164 5725 3654 1727 1996 1596 801 2944 9532 240 7289 8770 6857 2460 8384 1210 6455 2768 4871 1337 3985



Its Correct output is:
6592 7791 156 8610 2634 4676 1343 7346 2881 9696 4933 5678 3526 6533 911 9260 3256 8361 3177 6778 6724 9655 465 5297 2026 5268 789 9939 134 4805 2410 3443 449 7170 2530 3485 503 3465 3206 5725 3654 4164 1727 1996 801 2944 1596 9532 240 8770 6857 7289 2460 8384 1210 6455 2768 4871 1337 3985

And Your Output is:
6592 7791 156 8610 2634 4676 1343 7346 4933 9696 2881 5678 3526 6533 911 9260 3256 8361 6724 6778 3177 9655 465 5297 2026 5268 789 9939 134 4805 2410 3443 449 7170 2530 3485 503 3465 3206 5725 3654 4164 1727 1996 1596 2944 801 9532 240 8770 6857 7289 2460 8384 1210 6455 2768 4871 1337 3985
	
*/