#include<stdio.h>
#include<stdlib.h>

struct stack {
	int top;
	int capacity;
	int *A;
};

struct twoStack {
	struct stack *elementStack;
	struct stack *minStack;
};


struct stack * createStack (int max_size){
	struct stack *s=(struct stack *)malloc(sizeof(struct stack));
	if(!s){
		printf("stack is not created\n");
		return NULL;
	}
	s->top=-1;
	s->capacity=max_size;
	s->A=(int *)malloc(sizeof(int)*max_size);
	return s;
}

int IsEmpty(struct stack *S){
	if(S->top==-1)
	return 1;
	else return 0;
}

int IsFull(struct stack *S){
	if(S->top==S->capacity-1)
		return 1;
	else return 0;
}

void push(struct stack *S , int data){
	if(IsFull(S)){
		printf("stack is full\n");
			return ;
	}
	S->top=S->top+1;
	S->A[S->top]=data;
}

int  pop(struct stack *S){
	if(IsEmpty(S)){
		printf("stack is empty\n");
		return -1;
	}
	int x=S->A[S->top];
		S->top=S->top-1;
	return x;	
}

int top(struct stack *S){
	if(IsEmpty(S)){
		printf("stack is empty so no top element\n");
		exit(0);
	}
	return S->A[S->top] ;
}

void display(struct stack *S){
	int i;
	if(IsEmpty(S)){
		printf("printing satck is empty\n");
		return ;
	}
	for(i=0;i<=S->top;i++){
		printf(" %d ",S->A[i]);
	}
}

struct twoStack * createTwoStack (int max_size){
	struct twoStack *temp=(struct twoStack *)malloc(sizeof(struct twoStack));
	if(!temp){
		printf("memory not crested for twoStack\n");
		exit(0);
	}
	temp->elementStack=createStack(max_size);
	temp->minStack=createStack(max_size);	
        return temp;
}

void newPush(struct twoStack *s,int val){ 
		//printf("%d",s->elementStack->top);
		push(s->elementStack,val);
		if(IsEmpty(s->minStack) || top(s->minStack) >= val){
			push(s->minStack , val);
		}
}

int newPop(struct twoStack *s){
	int x;
	if(IsEmpty(s->elementStack)){
		printf("stack is empty\n");
		return-1;
	}
	x=top(s->elementStack);
	if(top(s->minStack)==pop(s->elementStack))
		pop(s->minStack);
	return x;
}

int getmin(struct twoStack *s){
	return top(s->minStack);
}


int main___(){
	
	int ch , no ;
	struct twoStack *q = createTwoStack(8);
	      printf("\n 1 - Push");
   	      printf("\n 2 - Pop");
	      printf("\n 3 - GetMin");
	      printf("\n 4 - Dipslay");
    	      printf("\n 5 - EXIT");

while (1)
    {
        printf("\n Enter choice : ");
        scanf("%d", &ch);
 
        switch (ch)
        {
        case 1:
            printf("Enter data : ");
            scanf("%d", &no);
            newPush(q, no);
            break;
        case 2:
            printf("\nDeleted item %d \n",newPop(q));
            break;
        
        case 3:
            printf("\nThe top of stack %d \n",getmin(q));
            break;
	
        case 4:
            display(q->elementStack);
            break;
       
        case 5:
            exit(0);
            break;
        default :
            printf(" Wrong choice, Please enter correct choice  ");
            break;
        }
    }
}

























	


