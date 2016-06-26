package arrays;


import java.util.Scanner;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author ashutosh
 */
/*
Implement two stacks in an array
Create a data structure twoStacks that represents two stacks. 
Implementation of twoStacks should use only one array, i.e., 
both stacks should use the same array for storing elements. 
Following functions must be supported by twoStacks.
push1(int x) –> pushes x to first stack
push2(int x) –> pushes x to second stack
pop1() –> pops an element from first stack and return the popped element
pop2() –> pops an element from second stack and return the popped element
Implementation of twoStack should be space efficient.
*/
public class ImplementTwoStacksInAnArray 
{
    public static void main(String[] args)
    {
        int a[]=new int[10];
        TwoStacks ts=new TwoStacks(a);
        int choice;
        Scanner sc=new Scanner(System.in);
        while(true)
        {
            System.out.println("1.Push To Stack 1");
            System.out.println("2.Push To Stack 2");
            System.out.println("3.Pop From Stack 1");
            System.out.println("4.Pop From Stack 2");
            System.out.println("0.Exit");
            choice=Integer.parseInt(sc.nextLine());
            switch(choice)
            {
                case 1:
                    System.out.println("Enter Value ");
                    ts.push1(Integer.parseInt(sc.nextLine()));
                    break;
                case 2:
                    System.out.println("Enter Value ");
                    ts.push2(Integer.parseInt(sc.nextLine()));
                break;
                case 3:
                    System.out.println("Popped Item : "+ts.pop1());
                break;
                case 4:
                    System.out.println("Popped Item : "+ts.pop2());
                break;
                case 0:
                    System.exit(0);
                break;
            }
        }
    }
}
class TwoStacks
{
    int top1,top2;
    int a[];
    public TwoStacks(int a[])
    {
        this.a=a;
        top1=-1;
        top2=a.length;
    }
    public int pop1()
    {
        if(top1==-1)
        {
            System.err.println("Stack 1 is Empty");
            return Integer.MIN_VALUE;
        }
        return a[top1--];
    }
    public int pop2()
    {
        if(top2==a.length)
        {
            System.err.println("Stack 2 is Empty");
            return Integer.MIN_VALUE;
        }
        return a[top2++];
    }
    public void push1(int x)
    {
        if(top1+1==top2)
        {
            System.err.println("Stack 1 is Full");
            return;
        }
        a[++top1]=x;
    }
    public void push2(int x)
    {
        if(top2-1==top1)
        {
            System.err.println("Stack 2 is Full");
            return;
        }
        a[--top2]=x;
    }
}
