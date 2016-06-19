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
Find a peak element
Given an array of integers. Find a peak element in it. An array element is peak if it is NOT smaller than its neighbors. For corner elements, we need to consider only one neighbor. For example, for input array {5, 10, 20, 15}, 20 is the only peak element. For input array {10, 20, 15, 2, 23, 90, 67}, there are two peak elements: 20 and 90. Note that we need to return any one peak element.

Following corner cases give better idea about the problem.
1) If input array is sorted in strictly increasing order, the last element is always a peak element. For example, 50 is peak element in {10, 20, 30, 40, 50}.
2) If input array is sorted in strictly decreasing order, the first element is always a peak element. 100 is the peak element in {100, 80, 60, 50, 20}.
3) If all elements of input array are same, every element is a peak element.

It is clear from above examples that there is always a peak element in input array in any input array.

A simple solution is to do a linear scan of array and as soon as we find a peak element, we return it. The worst case time complexity of this method would be O(n).

*/
public class PeakElement 
{
    public static int getPeakElement(int a[],int beg,int end)
    {
        int mid=(beg+end)/2;
        if(mid==0)
            return a[mid];
        if(mid==a.length-1)
            return a[end];
        if(a[mid]>a[mid-1]&&a[mid]>a[mid+1])
            return a[mid];
        else if(a[mid]<a[mid-1])
            return getPeakElement(a, beg, mid-1);
        else return getPeakElement(a, mid+1, end);
    }
    public static void main(String[] args)
    {
        
    int arr[] = {1, 3, 20, 4, 1, 0};
        System.out.println(getPeakElement(arr, 0,arr.length-1));
    }
}
