#include<stdio.h>
int call(int x)
{
	int a=4*x;
	return a;
}
int main()
{
	int x=call(4);
	printf("  %d",x);
	return 0;
}