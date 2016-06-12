/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package algorithms;

import java.util.ArrayList;

/**
 *
 * @author ashutosh
 * Find K closest elements to a given value in a sorted array
 */
public class FindkClosestElements 
{
    public static void main(String[] args)
    {
        int a[]={12,16,22,30,35,39,42,45,48,50,53,55,56};
        int k=4,x=10;
        withLinearSearch(a, k, x);
        withBinarySearch(a, k, x);
    }
    public static int getCrossPointBinarySearch(int a[],int beg,int end,int key)
    {
        //case when key is smallest then all elements
        if(a[beg]>=key)
            return beg;
        if(a[end]<key)
            return end;
        int mid=(beg+end)/2;
        if(a[mid]==key&&a[mid+1]>key)
            return mid;
        if(a[mid]<key)
            return getCrossPointBinarySearch(a, mid+1,end, key);
        else
            return getCrossPointBinarySearch(a, beg,mid-1, key);
    }
    public static void withBinarySearch(int a[],int k , int x)
    {
        /*FIND CROSSOVER POINT i.e. first element which is greater than x*/
        int cross=getCrossPointBinarySearch(a, 0, a.length-1, x);
        System.out.println("Cross "+cross);
        int l=cross,r=l+1,count=0;
        while(l>=0&&r<a.length&&count<k)
        {
            if(x==a[l])
            {
                l--;
                continue;
            }
            else if(x==a[r])
            {
                r++;
                continue;
            }
            else if(x-a[l]<a[r]-x)
                System.out.print(a[l--]+",");
            else
                System.out.print(a[r++]+",");
            count++;
        }
        //System.out.println();
        while(l>=0&&count<k)
        {
            System.out.print(a[l--]+",");
            k--;
        }
        while(r<a.length&&count<k)
        {
            System.out.print(a[r++]+",");
            k--;
        }
        System.out.println("");
    }
    public static void withLinearSearch(int a[],int k,int x)
    {
        //O(n) approach
        int cross;
        if(a[0]>x)
            cross=0;
        else if(a[a.length-1]<=x)
            cross=a.length-1;
        else{
            for(cross=0;cross<a.length;cross++)
                if(a[cross]>x)
                    break;
        cross--;
        }
        System.out.println("Cross "+cross);
        //first index at which we have element <= than k is cross
        int l=cross,r=l+1,count=0;
        while(l>=0&&r<a.length&&count<k)
        {
            if(x==a[l])
            {
                l--;
                continue;
            }
            else if(x==a[r])
            {
                r++;
                continue;
            }
            else if(x-a[l]<a[r]-x)
                System.out.print(a[l--]+",");
            else
                System.out.print(a[r++]+",");
            count++;
        }
        //System.out.print();
        while(l>=0&&count<k)
        {
            System.out.print(a[l--]+",");
            k--;
        }
        while(r<a.length&&count<k)
        {
            System.out.print(a[r++]+",");
            k--;
        }
        System.out.println("");
    }
    
}
