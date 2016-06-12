package algorithms;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author ashutosh
 * Find Min Length un-sorted subarray sorting which makes the array sorted 
 */
public class MinLenToSort 
{
    public static void main(String args[])
    {
        int a[]={10,12,20,30,25,40,32,31,35,50,60};
        findMinUnsortedArray(a);
    }
    public static int findMinInRange(int a[],int beg,int end)
    {
        int min=Integer.MAX_VALUE;
        for(int i=beg;i<=end;i++)
            if(a[i]<min)
                min=a[i];
        return min;
    }
    public static int findMaxInRange(int a[],int beg,int end)
    {
        int max=Integer.MIN_VALUE;
        for(int i=beg;i<=end;i++)
            if(a[i]>max)
                max=a[i];
        return max;
    }
    public static void findMinUnsortedArray(int a[])
    {
        //Step 1:- Find Candidate Subarray i.e. first index from left violating sorting property
        int left=-1;
        for(int i=0;i<a.length-1;i++)
            if(a[i]>a[i+1])
            {
                left=i;
                break;
            }
        int right=-1;
        System.out.println(left);
        for(int i=a.length-1;i>0;i--)
            if(a[i]<a[i-1])
            {
                right=i;
                break;
            }
        System.out.println(right);
        int min=findMinInRange(a, left, right);
        int max=findMaxInRange(a, left,right);
        System.out.println(min+" "+max);
        for(int i=left-1;i>=0;i--)
            if(a[i]>=min)
                left--;
        for(int i=right+1;i<a.length;i++)
            if(a[i]<=max)
                right++;
        System.out.println("Indices Are From Left "+left + " From Right "+right);
    }
}
