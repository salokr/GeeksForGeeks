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
    if(list1==NULL)
		return list2;
	if(list2==NULL)
		return list1;
	struct node *list=NULL;
	if(list1->data<list2->data)
	{
		list=list1;
		list->bottom=merge(list1->bottom,list2);
	}
	else
	{
		list=list2;
		list->bottom=merge(list1,list2->bottom);
	}
	return list;
}
struct node* flatten(struct node* root)
{
	if(root==NULL||root->next==NULL)
		return root;
	return merge(root,flatten(root->next));
}
struct node* getNode(int data)
{
	struct node* bottom=(struct node*)malloc(sizeof(struct node*));
	bottom->next=NULL;
	bottom->bottom=NULL;
	return bottom;
}
void printList(struct node * list)
{
	while(list!=NULL)
	{
		printf("%d ",list->data);
		//getchar();
		list=list->next;
	}
}
int main()
{
	struct node *root=NULL;
	
	root=getNode(5);
	root->bottom=getNode(7);
	
	root->next=getNode(10);
	root->next->bottom=getNode(20);

	root=flatten(root);
	printList(root);
	return 0;
}