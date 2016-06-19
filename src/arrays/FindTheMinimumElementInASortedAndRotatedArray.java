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
Find the minimum element in a sorted and rotated array
A sorted array is rotated at some unknown point, find the minimum element in it.

Following solution assumes that all elements are distinct.

Examples

Input: {5, 6, 1, 2, 3, 4}
Output: 1

Input: {1, 2, 3, 4}
Output: 1

Input: {2, 1}
Output: 1
*/
public class FindTheMinimumElementInASortedAndRotatedArray 
{
    public static int findMinimum(int a[],int beg,int end)
    {
        if(beg>end)
            return a[0];
        int mid=(beg+end)/2;
        if(beg==end)
            return a[beg];
        if(mid+1<=end&&a[mid]>a[mid+1])
            return a[mid+1];
        if(mid-1>=beg&&a[mid]<a[mid-1])
            return a[mid];
        else if(a[mid]<a[end])
            return findMinimum(a,beg,mid-1);
            else return findMinimum(a,mid+1,end);
    }
    public static void main(String[] args)
    {
        int arr1[] =  {5, 6, 1, 2, 3, 4};
        int arr2[] =  {1, 2, 3, 4};
        int arr3[] =  {1};
        int arr4[] =  {1, 2};
        int arr5[] =  {2, 1};
        int arr6[] =  {5, 6, 7, 1, 2, 3, 4};
        int arr7[] =  {1, 2, 3, 4, 5, 6, 7};
        int arr8[] =  {2, 3, 4, 5, 6, 7, 8, 1};
        int arr9[] =  {3, 4, 5, 1, 2};
        System.out.println(findMinimum(arr1, 0,arr1.length-1));
        System.out.println(findMinimum(arr2, 0,arr2.length-1));
        System.out.println(findMinimum(arr3, 0,arr3.length-1));
        System.out.println(findMinimum(arr4, 0,arr4.length-1));
        System.out.println(findMinimum(arr5, 0,arr5.length-1));
        System.out.println(findMinimum(arr6, 0,arr6.length-1));
        System.out.println(findMinimum(arr7, 0,arr7.length-1));
        System.out.println(findMinimum(arr8, 0,arr8.length-1));
        System.out.println(findMinimum(arr9, 0,arr9.length-1));
        
        
    }
}
