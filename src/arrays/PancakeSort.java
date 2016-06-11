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
                                                                    TASK DESCRIPTION
Pancake sorting
Given an an unsorted array, sort the given array. You are allowed to do only following operation on array.

flip(arr, i): Reverse array from 0 to i 
Unlike a traditional sorting algorithm, which attempts to sort with the fewest comparisons possible, 
the goal is to sort the sequence in as few reversals as possible.

The idea is to do something similar to Selection Sort. We one by one place maximum element at 
the end and reduce the size of current array by one.

Following are the detailed steps. Let given array be arr[] and size of array be n.
1) Start from current size equal to n and reduce current size by one while it’s greater than 1.
Let the current size be curr_size. Do following for every curr_size
……a) Find index of the maximum element in arr[0..curr_szie-1]. Let the index be ‘mi’
……b) Call flip(arr, mi)
……c) Call flip(arr, curr_size-1)

See following video for visualization of the above algorithm.

http://www.youtube.com/embed/kk-_DDgoXfk
*/

public class PancakeSort 
{
    public static void flip(int a[],int tillhere)
    {
        int l=0,r=tillhere;
        while(l<r)
        {
            int temp=a[l];
            a[l]=a[r];
            a[r]=temp;
            l++;r--;
        }
    }
    public static void doPancakeSort(int a[])
    {
        int  n=a.length;
        for(int i=0;i<n;i++)
        {
            int max=Util.getMaxIndexInRange(a, 0, n-i-1);
            flip(a,max);
            flip(a,n-i-1);
        }
    }
    public static void main(String[] args)
    {
        int arr[] = {23, 10, 20, 11, 12, 6, 7};
        doPancakeSort(arr);
        Util.printArray(arr);
    }
}
