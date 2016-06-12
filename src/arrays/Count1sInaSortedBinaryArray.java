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
/*
Given a binary array sorted in non-increasing order, count the number of 1’s in it.
Examples:
Input: arr[] = {1, 1, 0, 0, 0, 0, 0}
Output: 2

Input: arr[] = {1, 1, 1, 1, 1, 1, 1}
Output: 7

Input: arr[] = {0, 0, 0, 0, 0, 0, 0}
Output: 0

*/
public class Count1sInaSortedBinaryArray 
{
    public static int firstOne(int a[],int beg,int end)
    {
        if(beg>end)
            return -1;
        if(a[beg]==0)
            return -1;
        if(a[end]==1)
            return end;
        int mid=(beg+end)/2;
        if(a[mid]==1&&a[mid+1]==0)
            return  mid;
        else if(a[mid]==1)
            return firstOne(a, mid+1, end);
        return firstOne(a, beg, mid-1);
    }
    public static void main(String[] args)
    {
        int arr[] = {1, 1, 0, 0, 0, 0, 0};
        System.out.println(firstOne(arr, 0,arr.length-1)+1);
        int arr2[] = {1, 1, 1, 1, 1, 1, 1};
        int arr3[] = {0, 0, 0, 0, 0, 0, 0};
        System.out.println(firstOne(arr2, 0, arr2.length-1)+1);
        System.out.println(firstOne(arr3, 0, arr3.length-1)+1);
    }
}
