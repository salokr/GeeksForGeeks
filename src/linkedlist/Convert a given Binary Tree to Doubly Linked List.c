#include<stdio.h>
#include<stdlib.h>

struct Node
{
    int data;
	// left is used as previous and right is used
    // as next in DLL
    struct Node *left, *right;
}; 
struct Node *myprev=NULL;
void Util(struct Node *root,struct Node **head_ref)
{
    if(root==NULL)
		return;
	Util(root->left,head_ref);
	if(myprev==NULL)
	{
		*head_ref=root;
	}
	else
	{
		root->left=myprev;
		myprev->right=root;
	}
	
	myprev=root;
	Util(root->right,head_ref);
}
void BToDLL(struct Node *root,struct Node **head_ref)
{
Util(root,head_ref);
myprev=NULL;
}

struct Node* newNode(int data)
{
    struct Node* new_node = (struct Node*) malloc(sizeof(struct Node*));
    new_node->data = data;
    new_node->left = NULL;new_node->right = NULL;
    return (new_node);
}
 
/* Function to print nodes in a given doubly linked list */
void printList(struct Node *node)
{
    while (node!=NULL)
    {
        printf("%d ",node->data);
        node = node->right;
    }
}
 
/* Driver program to test above functions*/
int main()
{
    // Let us create the tree shown in above diagram
    struct Node *root = newNode(10);
    root->left        = newNode(12);
    root->right       = newNode(15);
    root->left->left  = newNode(25);
    root->left->right = newNode(30);
    root->right->left = newNode(36);
 
    // Convert to DLL
    struct Node *head = NULL;
    BToDLL(root, &head);
 	// Print the converted list
    //printList(head);
	return 0;
}