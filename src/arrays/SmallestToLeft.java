/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package arrays;

import java.util.Scanner;
import java.util.Stack;

/**
 *
 * @author ashutosh
 */
public class SmallestToLeft 
{
    public static void printSmallest(int a[])
    {
        Stack<Integer> stack=new Stack<>();
        for(int i=0,n=a.length;i<n;i++)
        {
            int last=Integer.MAX_VALUE;
            if(i>0&&a[i]>a[i-1])
                stack.push(a[i-1]);
            while(!stack.isEmpty()&&stack.peek()>=a[i])
                last=stack.pop();
            if(stack.isEmpty()&&a[i]<last)
            {
                System.out.print("-1 ");
                stack.push(a[i]);
            }
            else
            {
                if(!stack.isEmpty())
                System.out.print(stack.peek()+" ");
                else
                    System.out.println("-1 ");
            }
        }
    }
    //-1 2061 4271 2061 2500 2500 -1 66 66 66 1400 -1 38 1797 1797 2334 2334 2386 2386 2690 2690 4982 38 1185 3492 6214 3492 3814 3814 7340 38 930 5753 930 2190 2190 5630 2190 38 762 762 6072 8697 762 4221 762 1660 1660 1776 38 310 310 2424 5509 310 2269 2269 5380 6083 2269 2720 2720 4309 2720 3188 2720 3080 -1 38 38 5932 38 176 982 982 176 371 6663

    public static void main(String[] args)
    {
        Scanner sc=new Scanner(System.in);
        int t=sc.nextInt();
        while(t>0)
        {
            int n=sc.nextInt();
            int a[]=new int[n];
            for(int i=0;i<n;i++)
                a[i]=sc.nextInt();
            printSmallest(a);
            System.out.println();
            t--;
        }
    }
}
