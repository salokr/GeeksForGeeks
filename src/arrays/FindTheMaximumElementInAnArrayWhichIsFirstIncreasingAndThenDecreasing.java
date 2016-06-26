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
Find the maximum element in an array which is first increasing and then decreasing
Given an array of integers which is initially increasing and then decreasing, find the maximum value in the array.

Input: arr[] = {8, 10, 20, 80, 100, 200, 400, 500, 3, 2, 1}
Output: 500

Input: arr[] = {1, 3, 50, 10, 9, 7, 6}
Output: 50

Corner case (No decreasing part)
Input: arr[] = {10, 20, 30, 40, 50}
Output: 50

Corner case (No increasing part)
Input: arr[] = {120, 100, 80, 20, 0}
Output: 120
*/
public class FindTheMaximumElementInAnArrayWhichIsFirstIncreasingAndThenDecreasing 
{
//I THINK A SIMPLE BINARY SEARCH WILL DO THE WORK
    public static int getValue(int a[],int beg,int end)
    {
        if(beg>end)
            return -1;
        if(beg==end)
            return a[beg];
        int mid=(beg+end)/2;
        if(mid-1>beg&&mid+1<=end&&a[mid]>a[mid-1]&&a[mid]>a[mid+1])
            return a[mid];
        else if(a[mid]>a[mid-1])//still increasing 
            return getValue(a, mid+1, end);
        else return getValue(a, beg, mid-1);
    }
    public static void main(String[] args)
    {
        int  arr[] = {8, 10, 20, 80, 100, 200, 400, 500, 3, 2, 1};
        System.out.println(getValue(arr, 0, arr.length-1));
        int arr2[] = {1, 3, 50, 10, 9, 7, 6};
        System.out.println(getValue(arr2, 0, arr2.length-1));
        int  arr3[] = {10, 20, 30, 40, 50};
        System.out.println(getValue(arr3, 0, arr3.length-1));
        int arr4[] = {120, 100};
        System.out.println(getValue(arr4, 0, arr4.length-1));
    }
}
