#include<stdio.h>
#include<stdlib.h>
struct node
{
	int data;
	struct node *left,*right;
};
struct qnode
{
	struct node* data;
	struct qnode *next;
};
struct qnode *front=NULL,*rear=NULL;
void enqueue(struct node* data)
{
	struct qnode* newqnode=(struct qnode*)malloc(sizeof(struct qnode));
	newqnode->data=data;
	newqnode->next=NULL;
	if(rear==NULL)
	{
		front=rear=newqnode;
		return;
	}
	rear->next=newqnode;
	rear=newqnode;
}
struct qnode* dequeue()
{
	struct qnode* toreturn;
	if(front==NULL)
		return NULL;	
	toreturn =front;	
	if(front==rear)
	{
		front=rear=NULL;
	}	
	else
		front=front->next;	
	return toreturn;
}
int isEmpty()
{
	if(front==NULL&&rear==NULL)
		return 1;
	return 0;
}
struct node* newNode(int data)
{
	struct node* newnode=(struct node*)malloc(sizeof(struct node));
	newnode->left=newnode->right=NULL;
	newnode->data=data;
	return newnode;
}
void doLevelOrderTraversal(struct node* root)
{
	struct node *temp=NULL;
	if(root==NULL)
		return;
	enqueue(root);
	while(!isEmpty())
	{
		struct qnode* deq=dequeue();
		if(deq==NULL)
		{
			printf("NULL HERE");
			return;
		}
		temp=deq->data;
		printf("%d ",temp->data);
		if(temp->left!=NULL)
			enqueue(temp->left);
		if(temp->right!=NULL)
			enqueue(temp->right);
	}
}
int main()
{
	struct node *root = newNode(1);
	root->left        = newNode(2);
	root->right       = newNode(3);
	root->left->left  = newNode(4);
	root->left->right = newNode(5);
	doLevelOrderTraversal(root);
	return 0;
}
