/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package arrays;

import java.util.Scanner;

/**
 *
 * @author ashutosh
 */
public class MaxDiffSuchThatGreaterOnRight 
{
    public static void findMaxDiff(int a[])
    {
        int maxdiff=Integer.MIN_VALUE;
        int max=a[a.length-1];
        for(int i=a.length-1;i>=0;i--)
        {
            if(a[i]>max)
                max=a[i];
            else
            {
                int diff=max-a[i];
                if(maxdiff<diff)
                    maxdiff=diff;
            }
        }
        System.out.println(">"+maxdiff+"<");
    }
    public static void main(String[] args)
    {
        Scanner sc=new Scanner(System.in);
        int t=sc.nextInt();
        while(t>0)
        {
            int n=sc.nextInt();
            int a[]=new int[n];
            for(int i=0;i<a.length;i++)
                a[i]=sc.nextInt();
            findMaxDiff(a);
            t--;
        }
    }
}
