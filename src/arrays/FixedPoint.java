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
/*
Find a Fixed Point in a given array
Given an array of n distinct integers sorted in ascending order, write a function that returns a 
Fixed Point in the array, if there is any Fixed Point present in array, else returns -1. 
Fixed Point in an array is an index i such that arr[i] is equal to i. 
Note that integers in array can be negative.

Examples:

  Input: arr[] = {-10, -5, 0, 3, 7}
  Output: 3  // arr[3] == 3 

  Input: arr[] = {0, 2, 5, 8, 17}
  Output: 0  // arr[0] == 0 


  Input: arr[] = {-10, -5, 3, 4, 7, 9}
  Output: -1  // No Fixed Point
*/


/*
VERY SIMPLE PROBLEM THE POINT TO NOTE HERE IS THAT SUPPOSE IF MID < A[MID] THEN SURELY THE VALUE IS IN LEFT SUBARRAY WHY? SEE SINCE NUMBERS
ARE DISTINCT POSSIBLE VALUES IN ARRAY AT RHS WILL BE GREATER THAN MID ALWAYS SINCE ARRAY IS SORTED AND IS HAVING DISTINCT ELEMENTS ONLY
SO IT IS GOOD TO SEARCH LEFT SIDE. SIMILAR REASONING CAN BE DONE FOR LEFT SIDE OF ARRAY.
*/
public class FixedPoint 
{
    public static int getFixedPoint(int a[],int beg,int end)
    {
        if(beg>end)
            return -1;
        int mid=(beg+end)/2;
        if(a[mid]==mid)
            return a[mid];
        else if(a[mid]>mid)
            return getFixedPoint(a, beg, mid-1);
        else return getFixedPoint(a, mid+1, end);
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
                a[i]=sc.nextInt();
            byLinearSearch(a);
            t--;
        }
    }
    public static void byLinearSearch(int a[])
    {
        boolean found=false;
            for(int i=0;i<a.length;i++)
            {
                if(a[i]==i+1){
                    System.out.print(a[i]+" ");found=true;}
            }
            if(!found)
            System.out.println("Not Found");
    }
}
