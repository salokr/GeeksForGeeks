															/*IDEA IS COPIED FROM GEEKS FOR GEEKS WEBSITE*/

/* program to construct tree using inorder and preorder traversals */
#include<stdio.h>
#include<stdlib.h>
 
/* A binary tree node has data, pointer to left child
   and a pointer to right child */
struct node
{
  char data;
  struct node* left;
  struct node* right;
};
 
/* Prototypes for utility functions */
/* Recursive function to construct binary of size len from
   Inorder traversal in[] and Preorder traversal pre[].  Initial values
   of inStrt and inEnd should be 0 and len -1.  The function doesn't
   do any error checking for cases where inorder and preorder
   do not form a tree */

/* UTILITY FUNCTIONS */
/* Function to find index of value in arr[start...end]
   The function assumes that value is present in in[] */
int search(char arr[], int strt, int end, char value)
{
  int i;
  for(i = strt; i <= end; i++)
  {
    if(arr[i] == value)
	{
      return i;
	  break;
  	}
  }
  return i;
}
 
/* Helper function that allocates a new node with the
   given data and NULL left and right pointers. */
struct node* newNode(char data)
{
  struct node* node = (struct node*)malloc(sizeof(struct node));
  node->data = data;
  node->left = NULL;
  node->right = NULL;
 
  return(node);
}
 
/* This funtcion is here just to test buildTree() */
void printInorder(struct node* node)
{
  if (node == NULL)
     return;
 
  /* first recur on left child */
  printInorder(node->left);
 
  /* then print the data of node */
  printf("%c ", node->data);
 
  /* now recur on right child */
  printInorder(node->right);
}
int preindex=0;
struct node *buildTree(char* in,char* pre,int start,int end)
{
	if(start>end)
		return NULL;
	struct node* current=newNode(pre[preindex++]);
	if(start==end)
		return current;
	int index=search(in,start,end,current->data);
	current->left=buildTree(in,pre,start,index-1);
	current->right=buildTree(in,pre,index+1,end);
	return current;
}
 
 
/* Driver program to test above functions */
int main()
{
  char in[] = {'D', 'B', 'E', 'A', 'F', 'C'};
  char pre[] = {'A', 'B', 'D', 'E', 'C', 'F'};
  int len = sizeof(in)/sizeof(in[0]);
  struct node *root = buildTree(in, pre, 0, len - 1);
 
  /* Let us test the built tree by printing Insorder traversal */
  printf("Inorder traversal of the constructed tree is \n");
  printInorder(root);
  getchar();
  return 0;
}