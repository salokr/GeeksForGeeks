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
public class MaximumSumPath 
{
    public static void findMaxPath(int a[],int b[])
    {
        int n1=a.length,n2=b.length;
        int result=0,i=0,j=0,sum1=0,sum2=0;
        while(i<n1&&j<n2)
        {
            if(a[i]<b[j])
            sum1+=a[i++];
            else if(a[i]>b[j])
            sum2+=b[j++];
            else
            {
                result+=sum1>sum2?sum1:sum2;
                sum1=sum2=0;
                while(i<n1&&j<n2&&a[i]==b[j])
                {
                    result+=a[i];
                    i++;j++;
                }
            }
        }
        while(i<n1)
        sum1+=a[i++];
        while(j<n2)
        sum2+=b[j++];
        result+=sum1>sum2?sum1:sum2;
        System.out.println(result);
    }
    public static void main(String[] args)
    {
        Scanner sc=new Scanner(System.in);
        int t=sc.nextInt();
        while(t>0)
        {
            int n1=sc.nextInt();
            int n2=sc.nextInt();
            int a[]=new int[n1];
            int b[]=new int[n2];
            for(int i=0;i<n1;i++)
                a[i]=sc.nextInt();
            for(int i=0;i<n2;i++)
                b[i]=sc.nextInt();
            findMaxPath(a, b);
            t--;
        }
    }
}
