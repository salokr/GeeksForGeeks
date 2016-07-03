package arrays;

import java.util.*;

public class NextGreaterElement
{
    public static void findNGE(int a[])//starting from left going to right doesn't requires extra space except stack
    {
        Stack<Integer> stk=new Stack<>();
        stk.push(a[0]);
        for(int i=1;i<a.length;i++)
        {
            int curr=a[i];
            if(!stk.isEmpty())
            {
                int prev=stk.pop();
                while(prev<curr)
                {
                    System.out.println("For "+prev +" NGE is "+curr);
                    if(stk.isEmpty())
                        break;
                    prev=stk.pop();
                }
                if(prev>=curr)
                    stk.push(prev);
            }
            stk.push(curr);
        }
        while(!stk.isEmpty())
            System.out.println("For "+stk.pop()+ " NGE is -1");
    }
    public static void main(String[] args)
    {
        int arr[]= {11, 13, 21, 3};
        int a[]={10,10,20};
        findNGE(arr);
        myNGE(arr);
        findNGE(a);
        myNGE(a);
    }
    public static void myNGE(int a[])
    {
        Stack<Integer> stk=new Stack<>();
        int answers[]=new int[a.length];
        answers[a.length-1]=-1;//last will get -1
        for(int i=a.length-1;i>=0;i--)
        {
            while(!stk.isEmpty()&&stk.peek()<a[i])
                stk.pop();
            if(!stk.isEmpty())
                answers[i]=stk.peek();
            else answers[i]=-1;
            stk.push(a[i]);
        }
        System.out.println("Using Approach Two : "+Arrays.toString(answers));
    }
}