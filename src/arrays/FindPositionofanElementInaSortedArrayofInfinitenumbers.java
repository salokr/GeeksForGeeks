/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package arrays;
import java.util.Arrays;
/**
 *
 * @author ashutosh
 */
/*

Find position of an element in a sorted array of infinite numbers
Suppose you have a sorted array of infinite numbers, how would you search an element in the array?

Source: Amazon Interview Experience.

Since array is sorted, the first thing clicks into mind is binary search,
but the problem here is that we don’t know size of array.
If the array is infinite, that means we don’t have proper bounds to apply binary search.
So in order to find position of key, first we find bounds and then apply binary search algorithm.
*/
public class FindPositionofanElementInaSortedArrayofInfinitenumbers 
{
    public static void findElement(int a[],int key)
    {
        /*FIND A WAY IF EXIST*/
    }
    public static void findElementA2(int a[],int key)
    {
        //Second approach is to find first element greater than key the do Bounded Binary Search
        int l=0,h=1;
        int val=a[0];
        while(val<key)
        {
            l=h;
            h=2*h;
            val=a[h];
        }
        System.out.println(Util.binarySearch(a, 0, h, key));
    }
    public static void main(String[] args)
    {
        int arr[]=new int[1000];
        for(int i=1;i<=arr.length;i++)
            arr[i-1]=i*10;System.out.println(Arrays.toString(arr));
        for(int i=10;i<100;i+=10)
            findElement(arr, i);
        findElementA2(arr,1000);
    }
}
