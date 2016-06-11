/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package arrays;

/**
 *
 * @author ashutosh
 */
public class Util 
{
    public static int getSum(int a[])
    {
        int sum=a[0];
        for(int i=1;i<a.length;i++)
            sum+=a[i];
        return sum;
    }
    public static int getMin(int a[])
    {
        int min=Integer.MAX_VALUE;
        for(int i=0;i<a.length;i++)
            if(a[i]<min)
                min=a[i];
        return min;
    }
    public static int getMax(int a[])
    {
        int max=Integer.MIN_VALUE;
        for(int i=0;i<a.length;i++)
            if(a[i]>max)
                max=a[i];
        return max;
    }
    public static int getMaxIndexInRange(int a[],int left,int right)
    {
        int max=left;
        for(int i=left+1;i<=right;i++)
            if(a[i]>a[max])
                max=i;
        return max;
    }
    public static int getMinInRange(int a[],int left,int right)
    {
        int min=Integer.MAX_VALUE;
        for(int i=left;i<=right;i++)
            if(a[i]<min)
                min=a[i];
        return min;
    }
    public static void printArray(int a[])
    {
        for(int i=0;i<a.length;i++)
            System.out.print(a[i]+" ");
        System.out.println();
    }
    public static int getMax(int a,int b)
    {
        return (a>b?a:b);
    }
    public static int getMin(int a,int b)
    {
        return (a<b?a:b);
    }
    public static void printArray(int a[],int left,int right)
    {
        for(int i=left;i<=right;i++)
            System.out.print(a[i]+" ");
        System.out.println();
    }
    public static boolean binarySearch(int a[],int beg,int end,int key)
    {
        if(beg>end)
            return false;
        int mid=(beg+end)/2;
        if(a[mid]==key)
            return true;
        else if(a[mid]>key)
            return binarySearch(a, beg, mid-1, key);
        return binarySearch(a, mid+1, end, key);
    }
}
