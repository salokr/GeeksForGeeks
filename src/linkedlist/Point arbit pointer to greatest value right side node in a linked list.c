#include<stdio.h>
#include<stdlib.h>
struct Node
{
    int data;
    struct Node* next, *arbit;
};

void add(int x,struct Node **head)
{
	struct Node *newnode=(struct Node*)malloc(sizeof(struct Node*)),*start;
	newnode->data=x;
	newnode->next=NULL;
	newnode->arbit=NULL;
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
void printNextArbitPointers(struct Node *node)
{
    printf("Node\tNext Pointer\tArbit Pointer\n");
    while (node!=NULL)
    {
        printf("%d\t\t",node->data);
 
        if (node->next)
            printf("%d\t\t",node->next->data);
        else printf("NULL\t\t");
 
        if (node->arbit)
            printf("%d\t\t\n",node->arbit->data);
        else printf("NULL\n");
 
        //printf("%d",endl);
        node = node->next;
    }
}

struct Node* nextGreater(struct Node *current)
{
	if(current==NULL||current->next==NULL)
		return current;
	struct Node* largest=nextGreater(current->next);
	current->arbit=largest;
	if(largest!=NULL&&current->data<largest->data)
		return largest;
	return current;
}
struct Node* populateArbit(struct Node *head)
{
	
	nextGreater(head);
	return head;
}
int main()
{
    struct  Node *head = NULL;
    add(5,&head);
	add(10,&head);
	add(20,&head);
	add(3,&head);
	head = populateArbit(head);
 
    printf("Resultant Linked List is: \n");
    printNextArbitPointers(head);
 
    return 0;
}