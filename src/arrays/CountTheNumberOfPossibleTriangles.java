/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package arrays;

import java.util.Arrays;
import java.util.Scanner;

/**
 *
 * @author ashutosh
 */
public class CountTheNumberOfPossibleTriangles 
{
    public static void countTriangles(int a[])
    {
        Arrays.sort(a);
        int count=0;
        for(int i=0;i<a.length;i++)
        {
            int current=a[i];
            for(int j=i+1;j<a.length;j++)
            {
                int left=a[j],k;
                for(k=a.length-1;k>j;k--)
                {
                    int right=a[k];
                    if(current+left>right)
                        break;
                }
                count+=(k-j);
            }
        }
        System.out.println(count);
    }
    public static void main(String[] args)
    {
        Scanner sc=new Scanner(System.in);
        int t=sc.nextInt();
        while(t>0)
        {
            int n=sc.nextInt();
            int a[]=new int[n];
            for(int i=0;i<n;i++)
            {
                a[i]=sc.nextInt();
            }
            countTriangles(a);
            t--;
        }
    }
}
