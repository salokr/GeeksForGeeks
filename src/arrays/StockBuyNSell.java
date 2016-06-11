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
public class StockBuyNSell 
{
    public static void findMax(int a[])
    {
        int start=0,end=0,n=a.length,profit=0;
        for(int i=1;i<n;i++)
        {
            if(a[i]<a[i-1])
            {
                end=i-1;
                if(a[i-1]-a[start]>0)
                {
                System.out.print("("+start+" "+end+") ");
                profit+=a[end]-a[start];
                }
                start=i;
            }
        }
        if(start>end)
        {
            if(a[a.length-1]-a[start]>0)
            {
                System.out.print("("+start+" "+(a.length-1)+") ");
                profit+=a[a.length-1]-a[start];
            }
        }
        if(profit==0)
            System.out.print("No Profit");
    }
    public static void main(String[] arsg)
    {
        Scanner sc=new Scanner(System.in);
        int t=sc.nextInt();
        while(t>0)
        {
            int n=sc.nextInt();
            int a[]=new int[n];
            for(int i=0;i<n;i++)
                a[i]=sc.nextInt();
            findMax(a);
            System.out.println();
            t--;
        }
    }
}


/*
int p_xor=a[0];
        for(int i=1;i<a.length;i++)
        {
            int xor=p_xor^a[i];
            if(xor=p_xor||xor==0)
            {
                System.out.print(a[i]+" ");
            }
            else
            p_xor=xor;
        }
        System.out.println();
*/