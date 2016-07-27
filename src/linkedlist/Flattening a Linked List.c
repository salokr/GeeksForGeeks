#include<stdio.h>
#include<stdlib.h>
struct node
{
	int data;
	struct node *next;
	struct node *bottom;
};
struct node* merge(struct node* list1,struct node* list2)
{
	struct node *start1,*start2,*temp=NULL,*head=NULL;
	if(list1==NULL)
		return list2;
	if(list2==NULL)
		return list1;
	start1=list1;start2=list2;
	while(1)
	{
		if(start1->data<start2->data)
		{
			if(temp)
			{
				temp->next=start1;
				temp=temp->next;
			}
			else
			{
				temp=head=start1;
			}
			start1=start1->bottom;
		}
		else
		{
			if(temp)
			{
				temp->next=start2;
				temp=temp->next;
			}
			else
			{
				temp=head=start2;
			}
			start2=start2->bottom;
		}
		if(!start1)
		{
			temp->next=start2;
			break;
		}
		if(!start2)
		{
			temp->next=start1;
			break;
		}
	}
	return head;
}
struct node* flatten(struct node* root)
{
	if(!root||!root->next)
		return root;
	struct node *tempnext=root->next->next;
	root=merge(root,root->next);
	root->next=flatten(tempnext);
	return root;
}
struct node* addDown(int data)
{
	struct node* down=(struct node*)malloc(sizeof(struct node*));
	down->next=NULL;
	down->bottom=NULL;
	return down;
}
int main()
{
	struct node *root=NULL;
	
	return 0;
}